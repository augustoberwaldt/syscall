package com.syscall.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class OperadorServiceTest {

    @Autowired
    OperadorService operadorService;

    @Test
    public void testa_se_retorna_todos_operadores(){
        assertThat(operadorService.getAll()).isNotEmpty();

    }
	
}
