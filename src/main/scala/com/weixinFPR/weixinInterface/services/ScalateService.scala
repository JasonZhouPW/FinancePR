package com.weixinFPR.weixinInterface.services

import java.io.File

import org.fusesource.scalate.TemplateEngine

/**
 * Created by Zhoupeiwen on 2016/5/10.
 */
trait ScalateService {

  def rootDir = new File(".", "src/main/resources/html")
  val engine = new TemplateEngine(Some(rootDir))

  def getHtml(htmlName:String,attr:Map[String,Any]):String = {
    val template = engine.load(engine.source(htmlName,"mustache"))
    engine.layout("",template,attr)
  }
}
