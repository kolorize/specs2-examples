
package com.viacom.funnel.steps

import org.specs2.specification.BeforeExample

import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AfterTest extends Specification with BeforeExample{
  def before = {}
  
  "this is the first example" in new trees {
    
  }
  
  "this is the first example" in new trees {
    
  }

  trait trees extends After {
    lazy val tree = {}
    def after = {}
  }
  
}