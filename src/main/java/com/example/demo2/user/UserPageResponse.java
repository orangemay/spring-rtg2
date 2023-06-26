package com.example.demo2.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import com.example.demo2.user.User;

@Getter
@AllArgsConstructor
public class UserPageResponse {
    private long totalCount;
    private int pageNo;
    private int numPerPage;
    private List<User> users;
}
