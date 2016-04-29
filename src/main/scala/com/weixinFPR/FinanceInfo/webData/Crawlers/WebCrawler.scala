package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.URL

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait WebCrawler {

  def getProductList(url:URL):Unit

}
