package com.mycompany.myapp.web.rest.custom.moduleService;

import com.mycompany.myapp.web.rest.custom.modulePojo.FullUserPojo;

import java.util.List;

public interface UserService {

    Iterable<FullUserPojo> getAllUsers();

    FullUserPojo getUserById(Integer userId);

    void saveUser(FullUserPojo user);

    void deleteUser(Integer userId);

    Iterable<FullUserPojo> getUserByParams(String username, String password);

    Iterable<FullUserPojo> getUserByParam(String nameParam, String param);

    boolean userIsExistsByParam(String nameParam, String param);
}
