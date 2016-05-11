package com.weixinFPR.weixinInterface.services

import com.weixinFPR.FinanceInfo.webData.Crawlers.{JDWebCrawler, LUWebCrawler}
import spray.routing.HttpService
import scala.xml.XML._
/**
 * Created by Zhoupeiwen on 2016/4/26.
 */
trait WeixinService extends HttpService with ScalateService{

  val weixinRoute = {
    get {
      pathSingleSlash {
        complete(indexHtml)
      } ~
      path("lulist"){
        complete(luListHtml)
      } ~
      path("jdlist"){
        complete(jdListHtml)
      }

    }
  }

  val indexAttr = Map(
    "title" -> "title",
    "list" -> List(Map("url" -> """/lulist""","site" -> "lu"),
                  Map("url" -> """/jdlist""","site" -> "jd"))
  )

  lazy val indexHtml = loadString(getHtml("index.html",indexAttr))


/*  lazy val index =
    <html>
      <body>
        <h1>hello world!</h1>
        <ul>
          <li><a href="/lulist">lu</a></li>
          <li><a href="/jdlist">jd</a></li>
        </ul>
      </body>
    </html>*/



  lazy val luCrawler = new LUWebCrawler
  val products = luCrawler.getProductList("https://list.lu.com/list/dingqi")

  val luAttr =Map("productList"-> products.map(p => Map("name" -> p.name,
                                                "rate" -> p.rate,
                                                "period" -> p.period,
                                                "investfrom" -> p.investFrom)))
  lazy val luListHtml = loadString(getHtml("productList.html",luAttr))

  /*lazy val lulist =
    <html>
      <body>
        <h1>list from LU</h1>
        <table border ="8">
          <tr><th>name</th><th>rate</th><th>period</th><th>investfrom</th></tr>
          {products.map(_.toHtmlFormat)}
        </table>

      </body>
    </html>
*/
  lazy val jdCrawler = new JDWebCrawler
  val jdProducts = jdCrawler.getProductList("http://bill.jr.jd.com/buy/list.htm")

  val jdAttr =Map("productList"-> jdProducts.map(p => Map("name" -> p.name,
                                      "rate" -> p.rate,
                                      "period" -> p.period,
                                      "investfrom" -> p.investFrom)))
  lazy val jdListHtml = loadString(getHtml("productList.html",jdAttr))


/*
  lazy val jdlist =
    <html>
      <body>
        <h1>list from LU</h1>
        <table border ="8">
          <tr><th>name</th><th>rate</th><th>period</th><th>investfrom</th></tr>
          {jdProducts.map(_.toHtmlFormat)}
        </table>

      </body>
    </html>
*/


}
