package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.{HttpURLConnection, URL}

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait HtmlParser {
  def getHtml(url:URL):HtmlData = ???
}
