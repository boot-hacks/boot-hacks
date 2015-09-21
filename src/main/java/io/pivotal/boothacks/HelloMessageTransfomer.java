package io.pivotal.boothacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageTransfomer implements MessageTransformer {
	
	private final String prefix;

	@Autowired
	public HelloMessageTransfomer(@Value("${boothacks.prefix:Hello}") String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String transform(String message) {
		return String.format("%s %s", this.prefix, message);
	}

}
