package com.weixinFPR.FinanceInfo.webData.Crawlers

import com.weixinFPR.DTO.FinanceProduct
import org.jsoup.Jsoup

import scala.util.Try

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
class LUWebCrawler extends WebCrawler {
  override def getProductList(url: String): List[FinanceProduct] = {

    val doc =  Jsoup.connect(url).timeout(5000).get()


    val test = doc.select("li.product-list.clearfix")

    val products = (0 until test.size ).map{ i =>
      val tmp = test.get(i)
      val name = tmp.select("dt > a").get(0).text
      val detailUrl= tmp.select("dt > a").get(0).attr("href")
      val rate = tmp.select("li.interest-rate > p").get(0).text
      val period = Try(tmp.select("li.invest-period > p").get(0).text)
      val investFrom =tmp.select("div.product-amount > p > em").get(0).text

      new FinanceProduct(name,rate.replace("%","").toDouble,if(period.isSuccess)period.get else "No value" ,investFrom.replace(",","").toDouble,detailUrl)
    }

    products.toList

  }
}
