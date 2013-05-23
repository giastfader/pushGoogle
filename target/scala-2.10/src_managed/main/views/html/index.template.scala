
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Message],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(formMessage: Form[Message]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Web app Push Google")/*5.29*/{_display_(Seq[Any](format.raw/*5.30*/("""
	
	"""),_display_(Seq[Any](/*7.3*/form(routes.Application.sendMessage())/*7.41*/{_display_(Seq[Any](format.raw/*7.42*/("""
		
		"""),_display_(Seq[Any](/*9.4*/inputText(formMessage("message")))),format.raw/*9.37*/("""
       
        <input type="submit" value="Send">
        
        """)))})),format.raw/*13.10*/("""
       
""")))})))}
    }
    
    def render(formMessage:Form[Message]): play.api.templates.Html = apply(formMessage)
    
    def f:((Form[Message]) => play.api.templates.Html) = (formMessage) => apply(formMessage)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 23 15:07:16 CEST 2013
                    SOURCE: C:/github/giastfader/pushGoogle/app/views/index.scala.html
                    HASH: ef9bdebf65a01709e4eb23af802dc494588d7b1a
                    MATRIX: 730->1|852->29|882->51|919->54|954->81|992->82|1033->89|1079->127|1117->128|1160->137|1214->170|1320->244
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|41->13
                    -- GENERATED --
                */
            