package rs.ac.ni.pmf.web.demospringboot2022.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerMockMvcTest
{
	@Autowired
	private MockMvc _mockMvc;

	@Test
	void shouldGreet() throws Exception
	{
		final RequestBuilder request = MockMvcRequestBuilders
			.get("/greetings")
			.accept(MediaType.APPLICATION_JSON);

		_mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json("{\"content\":\"Hello World!\", \"id\":1}"));
	}
}
