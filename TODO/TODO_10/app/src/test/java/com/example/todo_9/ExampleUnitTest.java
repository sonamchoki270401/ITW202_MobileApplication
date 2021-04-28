package com.example.todo_9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runner.RunWith;
import androidx.test.filters.SmallTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new calculator();
    }

    @Test
    public void addTwoNumber() {
        double result = mCalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNegatives (){
        double result = mCalculator.add(-1d,2d);
        assertThat(result, is(equalTo((1d))));
    }
    @Test
    public void addTwoNumberForFloats(){
        double result = mCalculator.add(1.111f, 1.111d);
        assertThat(result, is(closeTo(2.222, 0.01)));
    }
    @Test
    public void subTwoNumbers(){
        double result = mCalculator.sub(2d,1d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void subWorksWithNegatives(){
        double result = mCalculator.sub(1d,2d);
        assertThat(result, is(equalTo(-1d)));
    }
    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.mul(1d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(1d,0d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbersExact(){
        double result = mCalculator.div(10d,5d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumberWithNotExact(){
        double result = mCalculator.div(10d,4d);
        assertThat(result,is(closeTo(2,0.5)));
    }

    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(2d, 0d);
        assertThat(result,is(equalTo(Double.POSITIVE_INFINITY)));
    }
}
