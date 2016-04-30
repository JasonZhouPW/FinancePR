package com.weixinFPR.FinanceInfo.webData.Crawlers

import com.weixinFPR.DTO.FinanceProduct
import org.jsoup.Jsoup

/**
 * Created by Zhoupeiwen on 2016/4/30.
 */
class JDWebCrawler extends WebCrawler with JDCrawConfig{
  override def getProductList(url: String): List[FinanceProduct] = {
    val doc = Jsoup.connect(url).timeout(5000).get()

    val nodes = doc.select(c_rootCss)
    val products = (0 until nodes.size).map { i =>
      val tmpNode = nodes.get(i)
      val name = tmpNode.select(c_nameCss).text()
      val rate = tmpNode.select(c_rateCss).text
      val period = tmpNode.select(c_periodCss).get(1).text

      val dRate = if (rate.contains("~")) rate.split("~")(0).replace("%","").trim.toDouble else rate.replace("%","").toDouble

      new FinanceProduct(name, dRate, period, 0, "")
    }

    products.toList
  }
}
