package com.weixinFPR.FinanceInfo.webData.Crawlers

/**
 * Created by Zhoupeiwen on 2016/4/30.
 */
object TestJD extends App{

  val jdCrawler = new JDWebCrawler
  val products = jdCrawler.getProductList("http://bill.jr.jd.com/buy/list.htm")
  products.foreach(println)

}
