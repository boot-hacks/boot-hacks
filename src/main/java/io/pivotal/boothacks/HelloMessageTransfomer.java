package io.pivotal.boothacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageTransfomer implements MessageTransformer {

	private final String prefix;

	private final String suffix;

	@Autowired
	public HelloMessageTransfomer(@Value("${boothacks.prefix:Hello}") String prefix,
			@Value("${boothacks.suffix:you look nice}") String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}

	@Override
	public String transform(String message) {
		return String.format("%s %s %s", this.prefix, message, this.suffix);
	}

}
