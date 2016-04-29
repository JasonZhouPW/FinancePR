package com.weixinFPR.FinanceInfo.webData.Crawlers

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
object TestLu extends App {

  val luCrawler = new LUWebCrawler

  val products = luCrawler.getProductList("https://list.lu.com/list/dingqi")

  products.foreach(println)

}
