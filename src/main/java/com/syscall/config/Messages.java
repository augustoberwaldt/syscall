package com.syscall.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
@Component
public class Messages {

	@Autowired
	private MessageSource messageSource;

	private static MessageSourceAccessor accessor;

	@PostConstruct
	private void init() {
		accessor = new MessageSourceAccessor(messageSource, Locale.US);
	}
	public static  String get(String code, Locale locale) {
		return accessor.getMessage(code, locale);
	}
}
