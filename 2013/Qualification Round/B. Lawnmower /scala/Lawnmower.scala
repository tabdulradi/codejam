package com.abdulradi.codejam.contest2013.round0.lawnmower

import scala.io.Source._

object Lawnmower {
  type Row = Array[Int]
  type Lawn = Seq[Row]
  
  def main(args: Array[String]) {
    val lines = stdin.getLines
    val t = lines.next.toInt
    (1 to t).foreach { i =>
      val Array(n, m) = lines.next.split(' ').map(_.toInt)
      val lawn: Lawn = (1 to n).map(_ => lines.next.split(' ').map(_.toInt))
      val msg = if(isValidLawn(lawn, n, m)) "YES" else "NO"
      println("Case #%d: %s".format(i, msg))
    }
  }

  def isValidLawn(l: Lawn, n: Int, m: Int): Boolean = {
    def check(i: Int, j: Int): Boolean = {
      val h = l(i)(j)
      (0 until n).map(l(_)(j) <= h).reduce(_ && _) || 
        (0 until m).map(l(i)(_) <= h).reduce(_ && _)
    }
    if (n == 1 || m ==1) 
        true
    else
        (0 until n).map { i: Int =>
          (0 until m).map { j: Int =>
            check(i, j)
          }.reduce(_ && _)
        }.reduce(_ && _)
  }
}
