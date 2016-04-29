package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.net.URL

import com.weixinFPR.DTO.FinanceProduct

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
trait WebCrawler {

  def getProductList(url:String):List[FinanceProduct]

}
