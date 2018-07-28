/*
 * This file was automatically generated by EvoSuite
 * Sat Jul 28 22:14:16 GMT 2018
 */

package dec2bin;

import org.junit.Test;
import static org.junit.Assert.*;
import dec2bin.Calculator;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Calculator_ESTest extends Calculator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      Integer integer0 = new Integer(0);
      String string0 = calculator0.calculate(integer0);
      assertEquals("Normal spelling:\n\n\nFormatted spelling:\n\n1 ", string0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      Integer integer0 = new Integer((-1));
      String string0 = calculator0.calculate(integer0);
      assertEquals("Normal spelling:\n1\n\nFormatted spelling:\n1 \n1 ", string0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      String string0 = calculator0.calculate((Integer) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      Integer integer0 = new Integer(1943);
      String string0 = calculator0.calculate(integer0);
      assertEquals("Normal spelling:\n11110010111\n\nFormatted spelling:\n   1   1   1   1  0  0  1 0 1 1 1 \n1024-512-256-128-64-32-16-8-4-2-1 ", string0);
  }
}