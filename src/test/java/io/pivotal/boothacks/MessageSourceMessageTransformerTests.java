package io.pivotal.boothacks;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

/**
 * Tests for {@link MessageSourceMessageTransformer}.
 */
public class MessageSourceMessageTransformerTests {

	@Mock
	private MessageSource messageSource;

	private MessageSourceMessageTransformer transformer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.transformer = new MessageSourceMessageTransformer(messageSource);
	}

	@Test
	public void transform_shouldDelegateToMessageSource() throws Exception {
		given(messageSource.getMessage("hello", new Object[]{"Pivotal"},
				Locale.US)).willReturn("Hello Pivotal");
		String transformed = transformer.transform("Pivotal", Locale.US);
		assertThat(transformed).isEqualTo("Hello Pivotal");
	}

}
