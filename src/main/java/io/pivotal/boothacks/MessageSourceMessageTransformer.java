package io.pivotal.boothacks;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MessageSourceMessageTransformer implements MessageTransformer {

	private final MessageSource messageSource;

	@Autowired
	public MessageSourceMessageTransformer(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String transform(String message, Locale locale) {
		return this.messageSource.getMessage("hello", new Object[] {message}, locale);
	}

}
