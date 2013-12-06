  
package com.viacom.funnel.steps

import org.specs2.specification.Grouped

import org.specs2.Specification
// import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner
import org.specs2.specification.script.GWT


@RunWith(classOf[JUnitRunner])
class ExampleGroupsTest extends Specification with Examples {
  def is = s2"""
  first example in first group                                        ${g1.e1}
  second example in first group                                       ${g1.e2}

  first example in second group                                       ${g2.e1}
  second example in second group                                      ${g2.e2}
  third example in second group, not yet implemented                  ${g2.e3}
  """
}

trait Examples extends Grouped  {
  // group of examples with no description
  new g1 {
    e1 := true
    e2 := true
  }
   //group of examples with a description for the group
  "second group of examples" - new g2 {
    e1 := true
    e2 := true
  } 
  
  def e1 = true
  def e2 = true  
}
