package io.pivotal.boothacks;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private MessageTransformer messageTransformer;

	@Autowired
	public MessageController(MessageTransformer messageTransformer) {
		this.messageTransformer = messageTransformer;
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public Map<String, String> get(@RequestParam String message, Locale locale) {
		String transformedMessage = this.messageTransformer.transform(message, locale);
		return Collections.singletonMap("message", transformedMessage);
	}

}
