package com.perched.peacock.parking.api.mongo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.perched.peacock.parking.api.encryption.service.EncryptionService;
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
}
