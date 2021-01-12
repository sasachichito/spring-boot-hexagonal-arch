package com.github.sasachichito.demo.application.service;

import com.github.sasachichito.demo.domain.model.user.User;
import com.github.sasachichito.demo.domain.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public User create(User user) {
    this.userRepository.addUser(user);
    return user;
  }
}
