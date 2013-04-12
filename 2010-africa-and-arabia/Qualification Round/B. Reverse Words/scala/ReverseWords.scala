package com.abdulradi.codejam.contest2010AfricaAndArabia.round0.reverseWords

import scala.io.Source._

object ReverseWords {
  def main(args: Array[String]) {
    stdin.getLines.drop(1).map {
      _.split(' ').reverse.mkString(" ")
    }.zipWithIndex.map { t => 
      "Case #%d: %s".format(t._2 + 1, t._1)
    }.foreach(println)
  }
}
