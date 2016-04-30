package com.weixinFPR.FinanceInfo.webData.Crawlers

import com.weixinFPR.DTO.FinanceProduct
import org.jsoup.Jsoup

import scala.util.Try

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
class LUWebCrawler extends WebCrawler with LUCrawlConfig {
  override def getProductList(url: String): List[FinanceProduct] = {

    val doc =  Jsoup.connect(url).timeout(5000).get()


    val test = doc.select(c_rootCss)

    val products = (0 until test.size ).map{ i =>
      val tmp = test.get(i)
      val name = tmp.select(c_nameCss).get(0).text
      val detailUrl= tmp.select(c_detailUrl).get(0).attr("href")
      val rate = tmp.select(c_rateCss).get(0).text
      val period = Try(tmp.select(c_periodCss).get(0).text)
      val investFrom =tmp.select(c_investFromCss).get(0).text

      new FinanceProduct(name,rate.replace("%","").toDouble,if(period.isSuccess)period.get else "No value" ,investFrom.replace(",","").toDouble,detailUrl)
    }

    products.toList

  }
}
