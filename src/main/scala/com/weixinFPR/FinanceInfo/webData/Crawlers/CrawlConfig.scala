package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.URL

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait CrawlConfig {

  val c_rootUrl:String

  val c_rootCss:String

  val c_nameCss:String

  val c_periodCss:String

  val c_rateCss:String

  val c_investFromCss:String

  val c_detailUrl:String


}

trait LUCrawlConfig extends CrawlConfig{
  override val c_rootUrl:String = "https://list.lu.com/list/dingqi"
  override val c_rootCss: String = "li.product-list.clearfix"
  override val c_investFromCss: String = "div.product-amount > p > em"
  override val c_nameCss: String = "dt > a"
  override val c_periodCss: String = "li.invest-period > p"
  override val c_rateCss: String = "li.interest-rate > p"
  override val c_detailUrl: String  = "dt > a"
}

trait JDCrawConfig extends CrawlConfig{
  override val c_rootUrl: String = "http://bill.jr.jd.com/buy/list.htm"
  override val c_periodCss: String = "b.bill-normal"
  override val c_rootCss: String = "div.bill-info"
  override val c_rateCss: String = "b.income-precent"
  override val c_detailUrl: String = ""
  override val c_investFromCss: String = ""
  override val c_nameCss: String = "h3.bill-goods-name"

}