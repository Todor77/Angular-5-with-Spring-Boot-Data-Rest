package de.isys.demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterLowercaseImplementationTest {

	@Test
	public void testTransform() {
		// given
		GreeterLowercaseImplementation greeterLowercaseImplementation = new GreeterLowercaseImplementation();

		// when
		final String transformedName = greeterLowercaseImplementation.transformation("SPRING BOOT");

		// then
		assertThat(transformedName).isEqualTo("spring boot");
	}

}
