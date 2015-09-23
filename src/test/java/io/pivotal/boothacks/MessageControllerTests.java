package io.pivotal.boothacks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests for {@link MessageController}.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BootHacksApplication.class)
public class MessageControllerTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void get_whenLocalIsEnglish_shouldReturnJsonWithEnglishMessage() throws Exception {
		this.mvc.perform(get("/message").param("message", "Pivotal").locale(Locale.ENGLISH))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"message\": \"Hello Pivotal you look nice\"}"));
	}

	@Test
	public void get_whenLocalIsGerman_shouldReturnJsonWithGermanMessage() throws Exception {
		this.mvc.perform(get("/message").param("message", "Pivotal").locale(Locale.GERMAN))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"message\": \"Hallo Pivotal Sie schön aussehen\"}"));
	}

}
