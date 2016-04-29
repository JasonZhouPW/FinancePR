package com.weixinFPR.DTO

/**
 * Created by Zhoupeiwen on 2016/4/29.
 */
class FinanceProduct(name:String,
                     rate:Double,
                     period:String,
                     investFrom:Double,
                     detailURl:String) {


  override def toString = s"[name=$name,rate=$rate,period=$period,investFrom=$investFrom,detailURl=$detailURl]"
}
