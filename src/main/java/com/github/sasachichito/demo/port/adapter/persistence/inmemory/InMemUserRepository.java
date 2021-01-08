package com.github.sasachichito.demo.port.adapter.persistence.inmemory;

import com.github.sasachichito.demo.domain.model.user.User;
import com.github.sasachichito.demo.domain.model.user.UserRepository;
import lombok.Synchronized;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemUserRepository implements UserRepository {

    private Map<Integer, User> userMap = new HashMap<>();
    private int lastNumbered = 0;

    @Synchronized
    @Override
    public int nextUserId() {
        this.lastNumbered++;
        return this.lastNumbered;
    }

    @Override
    public void addUser(User user) {
        this.userMap.put(user.userId(), user);
    }
}
