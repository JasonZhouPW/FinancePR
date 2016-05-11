package com.weixinFPR.FinanceInfo.webData.Crawlers

import java.io.File

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

/**
 * Created by Zhoupeiwen on 2016/4/30.
 */
object TestJD extends App{

//  val jdCrawler = new JDWebCrawler
//  val products = jdCrawler.getProductList("http://bill.jr.jd.com/buy/list.htm")
//  products.foreach(println)


  def rootDir = new File(".", "src/main/resources")
  val engine = new TemplateEngine(Some(rootDir))

  val template = engine.load(engine.source("test.html","mustache"))
  val attr = Map(
    "repo" -> List(
      Map("name" -> "resque"),
      Map("name" -> "hub"),
      Map("name" -> "rip")
    )
  )
  val output = engine.layout("",template,attr)

//  engine.layoutStrategy = new DefaultLayoutStrategy(engine, "mylayout.mustache")
//  val output = engine.layout("sample.mustache")

  println("------------------------")
  println(output)
}
