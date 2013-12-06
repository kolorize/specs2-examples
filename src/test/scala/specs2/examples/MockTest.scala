package com.viacom.funnel.steps

import org.junit._
import Assert._
import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner
import org.json4s._
import org.specs2.mock._


@RunWith(classOf[JUnitRunner])
class MockTest extends Specification {


  override def  is = s2"""
  A java list can be mocked
    You can make it return a stubbed value          ${c().stub}
    You can verify that a method was called         ${c().verify}
    You can verify that a method was not called     ${c().verify2}
  """
  
  case class c() extends Mockito {
    val m = mock[java.util.List[String]] // a concrete class would be mocked with: mock[new java.util.LinkedList[String]]
    def stub = {
      m.get(0) returns "one"             // stub a method call with a return value
      m.get(0) must_== "one"             // call the method
    }
    def verify = {
      m.get(0) returns "one"             // stub a method call with a return value
      m.get(0)                           // call the method
      there was one(m).get(0)            // verify that the call happened
    }
    def verify2 = there was no(m).get(0) // verify that the call never happened
  }
}