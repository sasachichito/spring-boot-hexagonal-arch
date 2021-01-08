package com.github.sasachichito.demo.domain.model.user;

public interface UserRepository {
    int nextUserId();
    void addUser(User user);
}
