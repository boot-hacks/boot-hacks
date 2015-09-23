package io.pivotal.boothacks;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link HelloMessageTransfomer}.
 */
public class HelloMessageTransfomerTests {

	private HelloMessageTransfomer transformer;

	@Before
	public void setup() {
		BootHacksProperties properties = new BootHacksProperties();
		properties.setPrefix("Hello");
		properties.setSuffix("There");
		this.transformer = new HelloMessageTransfomer(properties);
	}

	@Test
	public void transform_shouldAddPrefix() {
		assertThat(transformer.transform("Pivotal", Locale.US))
				.isEqualTo("Hello Pivotal There");
	}

}
