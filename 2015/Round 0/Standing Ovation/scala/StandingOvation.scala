package com.abdulradi.codejam.contest2015.round0.standingOvation

import scala.io.Source._

object StandingOvation {

  def main(args: Array[String]) =
    stdin.getLines.drop(1).zipWithIndex.foreach {
      case ((entry: String, i: Int)) =>
        println("Case #%d: %s".format( i+1, solveCase(entry.split(" ").last)))
    }

  def solveCase(input: String): Int =
    input
      .toCharArray
      .map(_.toString.toInt)
      .zipWithIndex
      .foldLeft((0, 0)) {
        case ((audience, invited), (count, shyness)) =>
          val standing = audience + invited
          val required = math.max(shyness - standing, 0)

          ((audience + count), (invited + required))
      }._2
}
