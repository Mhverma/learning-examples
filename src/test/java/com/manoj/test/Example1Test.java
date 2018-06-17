/**
 * 
 */
package com.manoj.test;

import java.util.ArrayList;
import java.util.List;

import com.manoj.learning.A;
import com.manoj.learning.B;
import com.manoj.learning.Example1;

import junit.framework.TestCase;

/**
 * @author Dell
 *
 */
public class Example1Test extends TestCase {

	/**
	 * Test method for
	 * {@link com.manoj.learning.Example1#sortListOfClasses(java.util.List)}.
	 */
	public void testSortListOfClasses() {

		List<Class<?>> input = new ArrayList<Class<?>>();
		input.add(A.class);
		input.add(B.class);

		List<Object> sortedList = Example1.sortListOfClasses(input);
		
		assertTrue(sortedList.indexOf(B.class)< sortedList.indexOf(A.class));

	}

}
