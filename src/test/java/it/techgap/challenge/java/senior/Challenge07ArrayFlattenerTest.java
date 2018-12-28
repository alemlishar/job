package it.techgap.challenge.java.senior;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests IntegerArrayFlattener
 */
public class Challenge07ArrayFlattenerTest {

    Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testNullReturnsNull() throws IllegalArgumentException {
        Assert.assertNull(
                "Testing a null argument",
                Challenge07ArrayFlattener.flatten(null)
        );
    }

    @Test
    public void testEmptyArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing an empty array",
                new Integer[]{},
                Challenge07ArrayFlattener.flatten(new Object[]{})
        );
    }

    @Test
    public void testFlatArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing a flat array",
                expectedArray,
                Challenge07ArrayFlattener.flatten(new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
        );
    }

    @Test
    public void testNestedArray() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing nested array",
                expectedArray,
                Challenge07ArrayFlattener.flatten(new Object[]{1, 2, 3, 4, new Object[]{5, 6, 7, 8}, 9, 10})
        );
    }

    @Test
    public void testMultipleNestedArrays() throws IllegalArgumentException {
        Assert.assertArrayEquals(
                "Testing multiple nested arrays",
                expectedArray,
                Challenge07ArrayFlattener.flatten(new Object[]{1, 2, new Object[]{3, 4, new Object[]{5}, 6, 7}, 8, 9, 10})
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInArray() throws IllegalArgumentException {
    	Challenge07ArrayFlattener.flatten(
                new Object[]{new Object()}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForObjectInNestedArray() throws IllegalArgumentException {
    	Challenge07ArrayFlattener.flatten(
                new Object[]{1, 2, new Object[]{3, new Object()}}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInArray() throws IllegalArgumentException {
    	Challenge07ArrayFlattener.flatten(
                new Object[]{null}
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionForNullInNestedArray() throws IllegalArgumentException {
    	Challenge07ArrayFlattener.flatten(
                new Object[]{1, 2, new Object[]{3, null}}
        );
    }

}