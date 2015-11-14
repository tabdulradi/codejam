package com.abdulradi.codejam.contest2015.round0.ominousOmino

import scala.io.Source._
import math._

object OminousOmino {

  def main(args: Array[String]) {
    stdin.getLines.zipWithIndex.drop(1).foreach {
      case ((entry: String, i: Int)) =>
        println("Case #%d: %s".format( i, solveCase(entry)))
    }
  }

  def solveCase(input: String): String = {
    val x :: r :: c :: Nil = input.split(" ").map(_.toInt).toList
    if(canLoose(x, r, c)) "RICHARD" else "GABRIEL"
  }

  def canLoose(x: Int, r: Int, c: Int) = {
    lazy val ominoMaxLength = x
    lazy val ominoMaxWidth = ceil(x/2.0)

    lazy val gridLength = max(r, c)
    lazy val gridWidth = min(r, c)

    lazy val ominoCanHaveHole = x >= 7 // Less than 7 can't form a hole

    lazy val ominoCanBeTooTall = ominoMaxLength > gridLength

    lazy val ominoCanBeTooWide = ominoMaxWidth > gridWidth

    lazy val gridNotDivisibleByOminos = (r * c) % x != 0

    lazy val ominoCanLeaveDeadZone = (x > 3) && gridTooTight

    lazy val gridTooTight = (ominoMaxWidth + 1) > gridWidth

    ominoCanHaveHole || ominoCanBeTooTall || ominoCanBeTooWide || gridNotDivisibleByOminos || ominoCanLeaveDeadZone
  }

}
