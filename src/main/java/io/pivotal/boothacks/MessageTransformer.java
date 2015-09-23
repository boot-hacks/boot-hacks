package io.pivotal.boothacks;

import java.util.Locale;

public interface MessageTransformer {

	String transform(String message, Locale locale);
}
