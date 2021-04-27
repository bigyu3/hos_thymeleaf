package com.gty.hos;

import com.gty.hos.mapper.PatientMapper;
import com.gty.hos.mapper.UserMapper;
import com.gty.hos.pojo.Patient;
import com.gty.hos.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HosMainApplicationTests {
    @Autowired
    private PatientMapper patientMapper;
    @Test
    void contextLoads() {


    }


    @Test
    public void testSelect() {
        List<Patient>  all = patientMapper.findAll();

        System.out.println("all = " + all);
    }
}
