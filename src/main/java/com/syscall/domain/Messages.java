package com.syscall.domain;
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

	private MessageSourceAccessor accessor;
	
	public String get(String code) {
		return accessor.getMessage(code);
	}
}
