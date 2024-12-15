package vn.cuahangdientu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.cuahangdientu.entity.User;
import vn.cuahangdientu.repository.UserRepository;
import vn.cuahangdientu.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private  UserRepository userRepository;

	@Override
	public Page<User> searchUsers(String searchTerm, Pageable pageable) {
		return userRepository.findByFullNameContainingOrEmailContaining(searchTerm, searchTerm, pageable);
	}

	@Override
	public User findUserById(Long id) {
		return null;
	}

	@Override
	public Page<User> getUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
		}

	@Override
	public User findById(Integer id) {
		return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}

	
}
