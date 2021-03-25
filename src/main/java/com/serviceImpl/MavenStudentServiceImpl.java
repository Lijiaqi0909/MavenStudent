package com.serviceImpl;

import com.dao.MavenStudentDao;
import com.service.MavenStudentService;
import com.student.MavenStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Li jq
 * @Date 2021/3/24 21:27
 **/
 @Service
public class MavenStudentServiceImpl implements MavenStudentService {
    @Autowired
    private MavenStudentDao studentDao;
    @Override
    public List<MavenStudent> getAll() {

        return studentDao.getAll();
    }

    @Override
    public int insterStudent(MavenStudent student) {
        return studentDao.insterStudent(student);
    }
}
