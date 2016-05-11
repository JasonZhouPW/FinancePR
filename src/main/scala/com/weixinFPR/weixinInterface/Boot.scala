package com.weixinFPR.weixinInterface

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import com.weixinFPR.weixinInterface.Actors.WeixinServiceActor
import spray.can.Http
/**
 * Created by Zhoupeiwen on 2016/4/26.
 */
object Boot extends App{

  //Akka system
  implicit val system = ActorSystem("weixinFPR-spray-can")

  val weixinService = system.actorOf(Props[WeixinServiceActor],"weixin-actor")


//  val sysIp = system.settings.config.getValue("service.host").render.toString

//  val port = system.settings.config.getValue("service.port").render.toInt

  IO(Http) ! Http.Bind(weixinService,"localhost",port=8080)

}
