package rs.ac.ni.pmf.web.demospringboot2022.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rs.ac.ni.pmf.web.demospringboot2022.model.Greeting;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerRestTemplateTest
{
	@LocalServerPort
	private int _port;

	@Autowired
	private TestRestTemplate _testRestTemplate;

	@Test
	public void shouldGreet()
	{
		final ResponseEntity<Greeting> responseEntity =
			_testRestTemplate.getForEntity("http://localhost:" + _port + "/greetings", Greeting.class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.hasBody()).isTrue();
		assertThat(responseEntity.getBody().getId()).isEqualTo(1);
		assertThat(responseEntity.getBody().getContent()).isEqualTo("Hello World!");
	}
}
