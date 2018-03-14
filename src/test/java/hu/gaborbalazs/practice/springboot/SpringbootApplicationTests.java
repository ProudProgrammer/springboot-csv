package hu.gaborbalazs.practice.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringbootApplicationTests {

	private TestRestTemplate restTemplate;
	
	@Before
	public void init() {
		restTemplate = new TestRestTemplate();
	}
	
	@Test
	public void testEcho() {
		String body = restTemplate.getForObject("http://localhost:8080/echo", String.class);
		assertThat(body).isEqualTo("Hello World");
	}

}
