package com.weixinFPR.weixinInterface.Actors

import akka.actor.Actor
import com.weixinFPR.weixinInterface.services.WeixinService

/**
 * Created by Zhoupeiwen on 2016/4/26.
 */
class WeixinServiceActor extends Actor with WeixinService{

  //create_test
  def actorRefFactory = context

  override def receive: Receive = runRoute(weixinRoute)
}
