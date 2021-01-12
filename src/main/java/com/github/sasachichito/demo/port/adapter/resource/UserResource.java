package com.github.sasachichito.demo.port.adapter.resource;

import com.github.sasachichito.demo.application.service.UserService;
import com.github.sasachichito.demo.domain.model.user.User;
import com.github.sasachichito.demo.domain.model.user.UserRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapi.example.api.UsersApi;
import org.openapi.example.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserResource implements UsersApi {

  private final UserService userService;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<UserModel> usersPost(@Valid UserModel userModel) {
    User user =
        new User(
            this.userRepository.nextUserId(),
            userModel.getFirstName(),
            userModel.getLastName(),
            userModel.getMailAddress());

    this.userService.create(user);

    UserModel response = new UserModel();
    response.setUserId(user.userId());
    response.setLastName(user.lastName());
    response.setFirstName(user.firstName());
    response.setMailAddress(user.mailAddress());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
