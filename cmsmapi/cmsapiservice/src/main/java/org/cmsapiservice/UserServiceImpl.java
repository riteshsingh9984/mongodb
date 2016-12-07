package org.cmsapiservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.models.User;

import mongo.cmsrepository.UserRepository;

@Service("userService")
@ComponentScan("mongo.cmsrepository")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

}
