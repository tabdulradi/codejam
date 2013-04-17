package com.abdulradi.codejam.contest2013.round0.fairAndSquare

import scala.io.Source._

object FairAndSquare {
  def main(args: Array[String]) {
    stdin.getLines.zipWithIndex.drop(1).foreach{ 
      case ((l: String, i: Int)) =>
        println("Case #%d: %s".format( i, getFairAndSquareCount(l)))
    }
  }

  def getFairAndSquareCount(l: String): Int = {
    val ab = l.split(' ').map(_.toLong)
    getFairAndSquareCount(ab(0), ab(1))
  }

  def getFairAndSquareCount(a: Long, b: Long): Int =
    getFairAndRootCount(Math.sqrt(a).ceil.toLong, Math.sqrt(b).floor.toLong)

  def getFairAndRootCount(a: Long, b: Long): Int =
    (a to b).count(fairAndRoot)

  def fairAndRoot(n: Long): Boolean = fair(n) && fair(n * n)

  def fair(n: Long): Boolean = fair(n.toString.toList)

  def fair(n: List[Any]): Boolean = n match {
    case head :: Nil => true
    case head :: tail if head == tail.last => fair(tail.init)
    case Nil => true // Shouldn't match anyway
    case _ => false
  }
}

