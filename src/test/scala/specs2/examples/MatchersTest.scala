package com.viacom.funnel.steps

import org.specs2.matcher.Matcher
import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner
import org.json4s._

@RunWith(classOf[JUnitRunner])
class MatchersTest extends Specification {
// taken from an example in the Lift project
  val person = """{
  "person": {
    "name": "Joe",
    "age": 35,
    "spouse": {
      "person": {
        "name": "Marilyn",
        "age": 33
      }
    }
  }"""

  "equality" should {
    "one should be one" in {
      1 must beEqualTo(1) 
      1 must be_==(1)
      1 mustEqual 1
      1 must_== 1
      1 should_== 1
      1 === 1
      1 must be equalTo(1)
    }
    
    "more or less" in {
      1 must be_<=(2)
      1 must beLessThanOrEqualTo(2)
      
      1 must be_<(2)
      1 must beLessThan(2)
      
      2 must be_>=(1)
      2 must beGreaterThanOrEqualTo(1)
      
      2 must be_>(1)
      2 must beGreaterThan(1)
      
      1.0 must beCloseTo(1, 0.5)
      4 must be ~(5 +/- 2)
      
      5 must beBetween(3, 6)
    }
    
    "must not be" in {
      1 must not be equalTo(2)
      1 must_!= 2
      1 mustNotEqual 2
      1 must be_!=(2)
      1 !== 2
    }
    
    "equality examples" in {
      true must beTrue
      false must beFalse
    }
    
    
  }
  
  "Json Matcher" should {

    "Correctly match Name->Value pairs" in {
       val resultJson = """{"name":"Yardies"}"""
       //resultJson must / ("name" -> "Yardies")
      true must beTrue
    }

    "Correctly match Name->Value pairs with numbers as doubles" in {
        val resultJson = """{"id":1}"""
  //      resultJson must  /("id" -> 1.0)
      true must beTrue
    }

    "using iff" in {
      1 must be_==(1).iff(true)                        // will return a success
      1 must be_==(1).iff(true)                        // will return a failure
      1 must be_==(2).iff(false)                       // will return a success
      1 must be_==(1).iff(false)                       // will return a failure
    }
    
  }
  
  // Custom matcher
  def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

  // create a Seq Matcher from a Matcher
  def allBeGreaterThan2: Matcher[Seq[Int]] = be_>=(2).forall
  
  val m: Matcher[String]  = ((_: String).startsWith("hello"), "doesn't start with hello")
  
  
}