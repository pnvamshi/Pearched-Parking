import axios from 'axios';

export default axios.create({
  baseURL: `http://parkingsolutions-env.uxn4bztsdj.us-east-1.elasticbeanstalk.com/`,
  headers: {'Authorization': "bearer " + localStorage.getItem("id_token")}
});
