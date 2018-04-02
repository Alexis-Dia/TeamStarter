package com.mycompany.myapp.web.rest.custom.moduleDao;

import com.mycompany.myapp.web.rest.custom.moduleDto.FullUserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@ComponentScan
@Repository
public interface UserDAO extends CrudRepository<FullUserDto, Integer> {
}
