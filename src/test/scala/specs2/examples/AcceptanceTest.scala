package specs2.examples
import org.specs2._
import org.junit.runner._
import org.specs2.matcher.DataTables
import org.specs2.runner._
import org.specs2.specification._
import _root_.com.ning.http.client.RequestBuilder
import _root_.com.ning.http.client.Response
import dispatch._
import org.junit.Assert._
import org.json4s._
import org.json4s.native.JsonMethods._

@RunWith(classOf[JUnitRunner])
class AcceptanceTest extends Specification with DataTables{
  val serverAddressHttp = "http://google.com/"
  
  def is =
    "Some first sentence"  ! e1 ^
  "and there some second sentence " ! e2 ^
  "third sentence" ! e3 ^
  "and somethin" ! e4  
  
  def e1 =
    "uri"   | "method" | "status" |                                
  serverAddressHttp + "api/v2"    !!  "GET"  !!  401  |         
  serverAddressHttp + "bar"    !!  "GET"  !!  404  |
  serverAddressHttp + "questions"    !!  "GET"  !!  200  |         
  serverAddressHttp + "ui/"    !!  "GET"  !!  200  |> {
    (uri, method, status) =>  {
      getResponse(uri,method) getStatusCode() mustEqual status
      //must contain 
      
      //val JString(answerName) = (entry\"answers" \"answer") (0) \ "name"
    }
  }
  
  def e2 = true

  def e3 =
    true  

  
  def e4 = 
  {
    true
  }
  
  def getResponse(uri:String, methodName:String, parameters: Map[String, String] = Map.empty[String, String], body :String = "") : Response = { 

    val finalMap = Map.empty
    var rb = new RequestBuilder()
    val contentType = Map("Content-Type" -> "application/x-www-form-urlencoded")
    
    val request = methodName match {
      case "GET" => (url(uri).GET <<? finalMap <:< contentType)
      case "POST" => (
          (url(uri).POST << parameters) <:< contentType)
      case "PUT" => {
          rb.setMethod("PUT")
          rb.setBody(body)
          rb.setHeader("Content-Type", "application/json")
          rb.setUrl(uri)
          rb
        }

    }
    Http(request)()
  }
  
}
