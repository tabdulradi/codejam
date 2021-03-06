package com.abdulradi.codejam.contest2013.round0.fairAndSquare

import scala.io.Source._
import scala.annotation.tailrec

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

  def fair(n: Long): Boolean = fair(n, len(n))
  
  @tailrec
  def fair(n: Long, l: Int): Boolean = {
    lazy val head = (n / Math.pow(10, l - 1)).toLong
    lazy val last = (n % 10).toLong
    lazy val center = (n % Math.pow(10, l - 1) / 10).toLong
    if (l <= 1) true
    else if (l == 2) head == last
    else 
      if (head == last) fair(center, l - 2)
      else false
  }

  @tailrec  
  def len(n: Long, i: Int = 1): Int = 
    if (n < 10) i 
    else len(n / 10, i + 1)

/* Old Implementation, Converts a number to a string of Chars,
 * Which is inficcent from very big numbers 
  def fair(n: Long): Boolean = fair(n.toString.toList)

  def fair(n: List[Any]): Boolean = n match {
    case head :: Nil => true
    case head :: tail if head == tail.last => fair(tail.init)
    case Nil => true // Shouldn't match anyway
    case _ => false
  }
*/
}

