package com.mycompany.myapp.web.rest.custom.moduleService.impl;

import com.mycompany.myapp.web.rest.custom.moduleDao.UserDAO;
import com.mycompany.myapp.web.rest.custom.moduleDto.FullUserDto;
import com.mycompany.myapp.web.rest.custom.modulePojo.FullUserPojo;
import com.mycompany.myapp.web.rest.custom.moduleService.EntityBeanConverter;
import com.mycompany.myapp.web.rest.custom.moduleService.UserService;
import io.undertow.util.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private EntityBeanConverter converter;

    @Override
    public Iterable<FullUserPojo> getAllUsers() {
        Iterable<FullUserDto> users = userDao.findAll();
        List<FullUserPojo> beanList = converter.convertToBeanList(users, FullUserPojo.class);

        return beanList;
    }

    @Override
    public FullUserPojo getUserById(Integer userId) {
        FullUserDto user = userDao.findOne(userId);
        FullUserPojo bean = converter.convertToBean(user, FullUserPojo.class);

        return bean;
    }

    @Override
    public void saveUser(FullUserPojo user) {
        FullUserDto userEntity = converter.convertToEntity(user, FullUserDto.class);
        userDao.save(userEntity);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.delete(userId);
    }

    @Override
    public Iterable<FullUserPojo> getUserByParams(String username, String password) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FullUserDto> query = builder.createQuery(FullUserDto.class);
        Root<FullUserDto> root = query.from(FullUserDto.class);

        Predicate hasIdentifier = builder.equal(root.get("username"), username);
        Predicate hasPassword = builder.equal(root.get("password"), password);
        query.where(builder.and(hasIdentifier, hasPassword));
        Iterable<FullUserDto> existingUsers = entityManager.createQuery(query.select(root)).getResultList();

        Iterable<FullUserPojo> pojoList = converter.convertToBeanList(existingUsers, FullUserPojo.class);

        return pojoList;
    }

    @Override
    public Iterable<FullUserPojo> getUserByParam(String nameParam, String param) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FullUserDto> query = builder.createQuery(FullUserDto.class);
        Root<FullUserDto> root = query.from(FullUserDto.class);

        Predicate hasIdentifier = builder.equal(root.get(nameParam), param);
        query.where(builder.and(hasIdentifier));
        Iterable<FullUserDto> existingUsers = entityManager.createQuery(query.select(root)).getResultList();

        Iterable<FullUserPojo> pojoList = converter.convertToBeanList(existingUsers, FullUserPojo.class);

        return pojoList;
    }

    @Override
    public boolean userIsExistsByParam(String nameParam, String param) {

        Iterable<FullUserPojo> existedUser = getUserByParam(nameParam, param);
        if (existedUser.iterator().hasNext()) {
            return true;
        }

        return false;
    }
}
