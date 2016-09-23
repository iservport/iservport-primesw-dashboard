package com.iservport.dashboard.chart

import scala.beans.BeanProperty

trait GoogleChartWrapper {

  val names: Array[String]

  val cols: Array[ChartColumn]

  val v: Array[Int]

  def getData: ChartData = ChartData(cols,values(v))

  def getType: String

  def values1(qtys: Array[Int]): Array[_ <: Any] = {
    val q:Array[ChartValue] = Array(ChartValue(1),ChartValue(2),ChartValue(3),ChartValue(4),ChartValue(5))//qtys.map(x => ChartValue(x.asInstanceOf[Int]))
    val p = names.map(ChartName(_)).zip(q).flatMap(e => Array(e._1, e._2))
    p
  }

  def values(qtys: Array[Int]): Array[ChartRow] = {
    names.zipWithIndex.map(s => ChartRow(Array(ChartName(s._1), ChartValue(v(s._2)))))
  }

}

case class ChartData(@BeanProperty cols:Array[ChartColumn], @BeanProperty rows:Array[ChartRow])
case class ChartColumn(@BeanProperty id:String, @BeanProperty label:String, @BeanProperty `type`:String = "string")
case class ChartRow(@BeanProperty c:Array[_ <: Any])
case class ChartValue(@BeanProperty v: Int) extends HasValue
case class ChartName(@BeanProperty v: String) extends HasValue
case class ChartTextStyle(@BeanProperty color:String="black", @BeanProperty fontSize: Int = 36)
case class ChartArea
(
  @BeanProperty left:Int=0,
  @BeanProperty top:Int=20,
  @BeanProperty width:String="90%",
  @BeanProperty height:String="90%"
)
case class ChartOptions
(
  @BeanProperty title: String = "",
  @BeanProperty height: String = "200",
  @BeanProperty colors: Array[String] = Array(),
  @BeanProperty legend: String = "right",
  @BeanProperty pieHole: Double = 0.0,
  @BeanProperty fontSize: Int = 11,
  @BeanProperty chartArea: ChartArea = ChartArea(),
  @BeanProperty is3D: Boolean = false,
  animation: Option[Animation] = None
) {
  def getAnimation = animation match {
    case Some(a) => a
    case None => Animation(0)
  }
  val getSliceVisibilityThreshold = 0
  val getPieSliceTextStyle = ChartTextStyle()
}
case class Animation(@BeanProperty duration:Int)
trait HasValue { val v: Any }