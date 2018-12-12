package com.nongshanie.generator.utils;

import org.springframework.context.ApplicationContext;

public class SpringContextUtils {
	private static ApplicationContext applicationContext = null;

	public synchronized static void setApplicationContext(ApplicationContext applicationContext) {
		if (SpringContextUtils.applicationContext == null) {
			SpringContextUtils.applicationContext = applicationContext;
		}
	}

	//获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	//通过name获取 Bean
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);

	}

	//通过class获取Bean
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}

	//通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
	}
	
	//通过param name获取对于的value
	public static String getParamValue(String param) {
        return getApplicationContext().getEnvironment().getProperty(param);
	}
	
}
