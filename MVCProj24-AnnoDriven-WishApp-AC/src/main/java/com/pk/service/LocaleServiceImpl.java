package com.pk.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

@Service("locl")
public class LocaleServiceImpl implements LocaleService {

	@Override
	public Locale[] getAllLocale() {
		return Locale.getAvailableLocales();
	}

}
