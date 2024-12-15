package vn.cuahangdientu.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.cuahangdientu.entity.User;

public  interface IUserService {
	Page<User> searchUsers(String searchTerm, Pageable pageable);
	User findUserById(Long id);
	Page<User> getUsers(Pageable pageable);
	User findById(Integer id);
	
}
