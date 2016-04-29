package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.URL

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait CrawlConfig {

  def getRootUrl:String
}

trait LUCrawlConfig extends CrawlConfig{
  override def getRootUrl:String = "https://list.lu.com/list/dingqi"
}

trait JDCrawConfig extends CrawlConfig{
  override def getRootUrl:String = "http://licai.jd.com/"
}