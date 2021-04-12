package com.wysoft.user.service;

import java.net.URI;

import com.wysoft.user.VO.Department;
import com.wysoft.user.VO.ResponseTempleteVO;
import com.wysoft.user.entity.User;
import com.wysoft.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveDeparment method of DepartmentService");
        return userRepository.save(user);
    }

    public ResponseTempleteVO getUserWithfindUserById(Long userId) {
        log.info("Inside findDepartmentById method of DepartmentService");
        ResponseTempleteVO vo = new ResponseTempleteVO();
        User user = userRepository.findUserById(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),  Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
