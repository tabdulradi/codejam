package com.abdulradi.codejam.contest2015.round0.pancakes

import scala.io.Source._

object Pancakes {

  def main(args: Array[String]) {
    stdin.getLines.drop(1).grouped(2).zipWithIndex.foreach {
      case ((entry: Seq[String], i: Int)) =>
        println("Case #%d: %s".format( i+1, solveCase(entry.last.split(" ").map(_.toInt))))
    }
  }

  def solveCase(plates: Seq[Int], time: Int = 0): Int =
    if (allPlatesEmpty(plates))
      time
    else
      solveCase(decide(plates), time + 1)

  def allPlatesEmpty(plates: Seq[Int]): Boolean =
    plates.sum == 0

  def decide(implicit plates: Seq[Int]): Seq[Int] =
    if (isSpecial) movePancakes else letThemEat

  def letThemEat(implicit plates: Seq[Int]): Seq[Int] =
    plates.map(p => max(0, p - 1))

  def isSpecial(implicit plates: Seq[Int]): Boolean =
    ???

  def movePanCakes(implicit plates: Seq[Int]): Seq[Int] =
    ??? // Find largest dish and divide it by 2

}
