package com.maoj.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manoj Verma
 *
 */
public class Example1 {
	public static void main(String[] args) {

		List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(D.class);
		list.add(B.class);
		list.add(E.class);
		list.add(A.class);
		list.add(C.class);

		System.out.println(sortListOfClasses(list));

	}

	/**
	 * compare and sort the list of classes and their super classes. If class don't
	 * have any relationship will not be sorted and its position will not change.
	 * 
	 * @param list
	 *            - {list of classes}
	 * @return list - {sorted list of classes in such way the super class index is
	 *         before than sub class index.}
	 */
	public static List<Object> sortListOfClasses(List<Class<?>> list) {

		return list.stream().sorted(new Comparator<Class<?>>() {

			public int compare(Class<?> o1, Class<?> o2) {

				if (o1.equals(o2)) {
					return 0;

				}

				if (o1.isAssignableFrom(o2)) {
					return -1;
				} else {
					if (!o2.isAssignableFrom(o2)) {
						throw new IllegalArgumentException("Class have not relations");
					}
					return 1;
				}

			}
		}).collect(Collectors.toList());

	}
}
