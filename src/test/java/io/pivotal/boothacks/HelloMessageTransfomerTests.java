package io.pivotal.boothacks;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link HelloMessageTransfomer}.
 */
public class HelloMessageTransfomerTests {

	private HelloMessageTransfomer transformer;

	@Before
	public void setup() {
		this.transformer = new HelloMessageTransfomer("Hello", "There");
	}

	@Test
	public void transform_shouldAddPrefix() {
		assertThat(transformer.transform("Pivotal")).isEqualTo("Hello Pivotal There");
	}

}
