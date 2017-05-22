package com.syscall.navegacao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.with;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.events.ElementListener;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Wait
public class NavegacaoTests  extends FluentTest {

	@Value("${local.server.port}")
	int port;

	String getUrl(String file) {
		return "http://localhost:" + port + "/prototypes/" + file + ".html";
	}

	@Test
	public void loginTest() {
		goTo(getUrl("login"));
		assertThat(window().title()).isEqualTo("Syscall - Login");
		$("#email").fill().with("user");
		$("#senha").fill().with("senha");
		$("#entrar").submit();
		assertThat(window().title()).contains("SYSCALL | Home");
	}


	@Test
	public void validaNavegacaoCadastroOperadores() {

		goTo(getUrl("usuarios"));
		assertThat(window().title()).contains("SYSCALL | Operadores");

		$("#usuario_cadastrar").click();
		assertThat(window().title()).contains("SYSCALL | Cadastrar Operador");
	}

	@Test
	public void validaNavegacaoMensagemCadastroOperadores() {

		goTo(getUrl("usuario_cadastrar"));
		assertThat(window().title()).contains("SYSCALL | Cadastrar Operador");

		$("#salvar").submit();
		assertThat($("#sucesso").text()).contains("Sucesso. Dados salvos com successo !");

	}

	@Test
	public void validaNavegacaoMensagemErroCadastroOperadores() {
		goTo(getUrl("usuario_cadastrar_erro"));
		assertThat(window().title()).contains("SYSCALL | Cadastrar Operador");


		$("#salvar").submit();

		assertThat($("#erroCadastro").text()).contains("Erro. Erro a o salvar os dados !");
	}

	@Test
	public void validaNavegacaoBuscaOperadores() {
		goTo(getUrl("usuarios"));

		$("#email").fill().with("teste@gmail.com");

		$("#buscar").submit();

		assertThat($("#busca_sem_resultado").text()).contains("Alerta. Nenhum registro encontrado para essa busca !");
	}

	@Test
	public void validaNavegacaoEditarOperador() {
		goTo(getUrl("usuarios"));

		$("#editar_operador").click();

		assertThat(window().title()).contains("SYSCALL | Editar Operador");

		assertThat($("#nome").value().isEmpty()).isFalse();
	}

	@Test
	public void validaNavegacaoExcluirOperador() {
		goTo(getUrl("usuarios"));
		events().beforeClickOn(new ElementListener() {
			@Override
			public void on(FluentWebElement element, WebDriver driver) {
			 String style = 	el("#modalDelete").attribute("style");
				assertThat(style).hasToString("display: none;");
			}
		});
        $("#deletar_operador").click();

	}

}