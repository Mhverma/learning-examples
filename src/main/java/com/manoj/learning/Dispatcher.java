package com.manoj.learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manoj Verma
 *
 */

public class Dispatcher {

	List<Method> subClassMethods = new ArrayList<Method>();

	/**
	 * Constructor
	 * 
	 * @param methodName
	 */
	public Dispatcher(String methodName) {
		try {
			Constructor<? extends Dispatcher> constructor = getClass().getDeclaredConstructor();

			for (Method method : constructor.getDeclaringClass().getDeclaredMethods()) {

				if (methodName.equalsIgnoreCase(method.getName())) {
					subClassMethods.add(method);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 *  Dispatch the @param to best matching method (@method name passed in constructor of super class) of subclass.
	 * @param param
	 */
	public void dispatch(Object param) {
		try {

			Method methodWithObjectParam = null;
			boolean isBestMatchFound = false;
			for (Method method : subClassMethods) {

				//get the parameter type of the method
				List<Class<?>> parametersTypes = Arrays.asList(method.getParameterTypes());

				//method with Object @param.
				if (parametersTypes.contains(Object.class)) {
					methodWithObjectParam = method;
				}

				// Considering only one @param here, Best match
				if (parametersTypes.contains(param.getClass())) {
					isBestMatchFound = true;
					method.invoke(this, param);
					break;

				}

			}
			// Best match not found, check for other matching 
			if (!isBestMatchFound && methodWithObjectParam != null) {
				methodWithObjectParam.invoke(this, param);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
