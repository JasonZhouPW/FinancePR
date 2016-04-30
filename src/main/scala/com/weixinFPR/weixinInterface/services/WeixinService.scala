package com.weixinFPR.weixinInterface.services

import com.weixinFPR.FinanceInfo.webData.Crawlers.{JDWebCrawler, LUWebCrawler}
import spray.routing.HttpService

/**
 * Created by Zhoupeiwen on 2016/4/26.
 */
trait WeixinService extends HttpService{

  val weixinRoute = {
    get {
      pathSingleSlash {
        complete(index)
      } ~
      path("lulist"){
        complete(lulist)
      } ~
      path("jdlist"){
        complete(jdlist)
      }

    }
  }


  lazy val index =
    <html>
      <body>
        <h1>hello world!</h1>
        <ul>
          <li><a href="/lulist">lu</a></li>
          <li><a href="/jdlist">jd</a></li>
        </ul>
      </body>
    </html>



  lazy val luCrawler = new LUWebCrawler
  val products = luCrawler.getProductList("https://list.lu.com/list/dingqi")

  lazy val lulist =
    <html>
      <body>
        <h1>list from LU</h1>
        <table border ="8">
          <tr><th>name</th><th>rate</th><th>period</th><th>investfrom</th></tr>
          {products.map(_.toHtmlFormat)}
        </table>

      </body>
    </html>

  lazy val jdCrawler = new JDWebCrawler
  val jdProducts = jdCrawler.getProductList("http://bill.jr.jd.com/buy/list.htm")

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


}
