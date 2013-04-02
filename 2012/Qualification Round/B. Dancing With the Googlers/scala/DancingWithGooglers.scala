package com.abdulradi.codejam.contest2012.round0.dancingWithGooglers

import scala.io.Source._

object DancingWithGooglers {
  def main(args: Array[String]) {
    stdin.getLines.zipWithIndex.drop(1).foreach{ 
      case ((l: String, i: Int)) =>
        println("Case #%d: %s".format( i, maxGooglers(l)))
    }
  }

  def maxGooglers(l: String): Int = {
    val Array(_, s, p, gs @ _*) = l.split(' ').map(_ toInt)
    val min = p * 3 - 2

    gs.partition(_ >= min) match {
      case (gts, lss) => {
        val min2 = (min - 2) max 2
        (lss.count(_ >= min2) min s) + gts.length
      }   
    }
  }

}