package com.weixinFPR.weixinInterface.services

import spray.routing.HttpService

/**
 * Created by Zhoupeiwen on 2016/4/26.
 */
trait WeixinService extends HttpService{

  val weixinRoute = {
    get {
      pathSingleSlash {
        complete(index)
      }
    }
  }




  lazy val index =
    <html>
      <body>
        <h1>hello world!</h1>
      </body>
    </html>

}
