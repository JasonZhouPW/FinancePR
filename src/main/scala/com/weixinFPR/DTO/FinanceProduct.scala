package com.weixinFPR.DTO

import scala.beans.BeanProperty

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
class FinanceProduct(name:String,
                     rate:Double,
                     period:String,
                     investFrom:Double,
                     detailURl:String) {

  def toHtmlFormat = <tr><td>{name}</td><td>{rate}</td><td>{period}</td><td>{investFrom}</td></tr>



  override def toString = s"[name=$this.name,rate=$this.rate,period=$this.period,investFrom=$this.investFrom,detailURl=$this.detailURl]"
}
