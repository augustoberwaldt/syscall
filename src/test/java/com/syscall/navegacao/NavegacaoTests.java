package com.syscall.navegacao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Wait
public class NavegacaoTests  extends FluentTest {

	@Value("${local.server.port}") int port;
	String getUrl(String file) {
		return "http://localhost:"+ port+ "/prototypes/"+ file +".html";
	}

	@Test
	public void loginTest() {
		goTo(getUrl("login"));
		assertThat(window().title()).isEqualTo("Syscall - Login");
	}


	@Test
	public void navega_ate_cadastro_operador() {
		goTo(getUrl("login"));
		assertThat(window().title()).isEqualTo("Syscall - Login");
		$("#email").fill().with("user");
		$("#senha").fill().with("senha");
		$("#entrar").submit();


		assertThat(window().title()).contains("Syscall - Sistema de Gerenciamento Chamados");
		assertThat($("#nav-accordion li .active span")).hasText("Dashboard");


	}




}
