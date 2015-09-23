package io.pivotal.boothacks;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloMessageTransfomer implements MessageTransformer {

	private BootHacksProperties properties;

	@Autowired
	public HelloMessageTransfomer(BootHacksProperties properties) {
		this.properties = properties;
	}

	@Override
	public String transform(String message, Locale locale) {
		return String.format("%s %s %s", this.properties.getPrefix(), message,
				this.properties.getSuffix());
	}

}
