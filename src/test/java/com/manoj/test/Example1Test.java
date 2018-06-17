/**
 * 
 */
package com.manoj.test;

import java.util.ArrayList;
import java.util.List;

import com.maoj.test.A;
import com.maoj.test.B;
import com.maoj.test.Example1;

import junit.framework.TestCase;

/**
 * @author Dell
 *
 */
public class Example1Test extends TestCase {

	/**
	 * Test method for
	 * {@link com.maoj.test.Example1#sortListOfClasses(java.util.List)}.
	 */
	public void testSortListOfClasses() {

		List<Class<?>> input = new ArrayList<Class<?>>();
		input.add(A.class);
		input.add(B.class);

		List<Object> sortedList = Example1.sortListOfClasses(input);
		
		assertTrue(sortedList.indexOf(B.class)< sortedList.indexOf(A.class));

	}

}
