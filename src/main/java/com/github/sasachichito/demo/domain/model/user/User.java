package com.github.sasachichito.demo.domain.model.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import static org.springframework.util.ObjectUtils.isEmpty;

@Accessors(fluent = true)
@EqualsAndHashCode
@Getter
public class User {

    private int userId;
    private String lastName;
    private String firstName;
    private String mailAddress;

    public User(int userId, String lastName, String firstName, String mailAddress) {
        if (isEmpty(lastName) || isEmpty(firstName) || isEmpty(mailAddress)) {
            throw new IllegalArgumentException("空文字は許容しない");
        }

        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        // TODO メールアドレスの形式チェック
        this.mailAddress = mailAddress;
    }

    // ユーザーオブジェクトに関するビジネスロジックは本クラスのメソッドとして記述すること
}
