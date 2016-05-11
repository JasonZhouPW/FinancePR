package com.weixinFPR.DTO

import scala.beans.BeanProperty

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
case class FinanceProduct(name:String,
                     rate:Double,
                     period:String,
                     investFrom:Double,
                     detailURl:String) {

  def toHtmlFormat = <tr><td>{name}</td><td>{rate}</td><td>{period}</td><td>{investFrom}</td></tr>



  override def toString = s"[name=$name,rate=$rate,period=$period,investFrom=$investFrom,detailURl=$detailURl]"
}
