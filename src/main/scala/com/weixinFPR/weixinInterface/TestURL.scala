package com.weixinFPR.weixinInterface

import scala.collection.mutable.ListBuffer

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */
object TestURL extends App{
  import org.jsoup.Jsoup

  val doc =  Jsoup.connect("https://list.lu.com/list/dingqi").get()

  val lb = new ListBuffer[String]
  val test = doc.getElementsByClass("product-info")

  (0 until test.size ).foreach{ i =>
    val tmp = test.get(i)
    lb += tmp.select("dt > a").get(0).text()
  }

  lb.toList.foreach(println)

}
