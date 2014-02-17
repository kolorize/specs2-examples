package specs2.examples

import org.specs2.mutable._
import org.junit.runner._
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UnitTest extends Specification {

  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "12345678901" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in {
      "Hello world" must endWith("world")
    }
  }
  
  "the something somethin" should{
    
    
    "contain 11 characters" in {
      failure("message")
      "Hello world" must have size(11)
    }
  }
 }
