package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.URL

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait CrawlConfig {

  def getRootUrl:URL
}

trait LUCrawlConfig extends CrawlConfig{
  override def getRootUrl:URL = new URL("http://licai.jd.com/")
}
