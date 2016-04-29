package com.weixinFPR.weixinInterface

import scala.collection.mutable.ListBuffer
import scala.util.Try

/**
 * Created by Zhoupeiwen on 2016/4/28.
 */

case class Product(name:String,rate:String,period:String,investFrom:String,detailUrl:String)
object TestURL extends App{
  import org.jsoup.Jsoup

 /* val doc =  Jsoup.connect("https://list.lu.com/list/dingqi").get()

  val lb = new ListBuffer[Product]
  val test = doc.select("li.product-list.clearfix")

  val products = (0 until test.size ).map{ i =>
    val tmp = test.get(i)
    val name = tmp.select("dt > a").get(0).text
    val detailUrl= tmp.select("dt > a").get(0).attr("href")
    val rate = tmp.select("li.interest-rate > p").get(0).text
    val period = Try(tmp.select("li.invest-period > p").get(0).text)
    val investFrom =tmp.select("div.product-amount > p > em").get(0).text

     new Product(name,rate,if(period.isSuccess)period.get else "No value" ,investFrom,detailUrl)
  }

  products.foreach(println)*/


  val doc =  Jsoup.connect("http://bill.jr.jd.com/buy/list.htm").get()
  val nodes = doc.select("div.bill-info")
  val products = (0 until nodes.size).map{i =>
    val tmpNode = nodes.get(i)
    val name = tmpNode.select("h3.bill-goods-name").text()
    val rate = tmpNode.select("b.income-precent").text
    val period = tmpNode.select("b.bill-normal").get(1).text

    new Product(name,rate,period,"0","")
  }

  products.foreach(println)
}
