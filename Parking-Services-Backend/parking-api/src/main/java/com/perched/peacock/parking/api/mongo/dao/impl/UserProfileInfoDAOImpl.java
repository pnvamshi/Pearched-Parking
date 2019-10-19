package com.perched.peacock.parking.api.mongo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.encryption.service.EncryptionService;
import com.perched.peacock.parking.api.exception.UserAlreadExistException;
import com.perched.peacock.parking.api.mongo.dao.UserProfileInfoDAO;
import com.perched.peacock.parking.api.mongo.model.UserProfileInfo;

/**
 * 
 * @author pnvamshi
 *
 */

@Repository
public class UserProfileInfoDAOImpl implements UserProfileInfoDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	EncryptionService encryptionService;
	
	@Override
	public boolean saveUserProfileInfo(UserProfileInfo userProfileInfo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userProfileInfo.getUserName()));
		if(mongoTemplate.exists(query, UserProfileInfo.class)) {
			throw new UserAlreadExistException("User with username : "+userProfileInfo.getUserName()+" already exist");
		}
		String hashPassword = encryptionService.hashPassword(userProfileInfo.getPassword());
		userProfileInfo.setPassword(hashPassword);
		return mongoTemplate.save(userProfileInfo)!=null;
	}
	
	@Override
	public UserProfileInfo getUserProfileInfo(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		return mongoTemplate.findOne(query, UserProfileInfo.class);
	}
	
	@Override
	public boolean updateUserProfileInfo(UserProfileInfo userProfileInfo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userProfileInfo.getUserName()));
		Update update = new Update();
		String hashPassword = encryptionService.hashPassword(userProfileInfo.getPassword());
		update.set("password", hashPassword);
		update.set("role", userProfileInfo.getRole());
		return mongoTemplate.findAndModify(query, update, UserProfileInfo.class)!=null;
	}
	
	@Override
	public boolean updateUserProfilePassword(String userName, String password) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		Update update = new Update();
		String hashPassword = encryptionService.hashPassword(password);
		update.set("password", hashPassword);
		return mongoTemplate.findAndModify(query, update, UserProfileInfo.class)!=null;
	}
	
	@Override
	public List<String> getUserNames(String role) {
		Query query = new Query();
		query.addCriteria(Criteria.where("role").is(role));
		return mongoTemplate.findDistinct("userName", UserProfileInfo.class, String.class);
	}
}
