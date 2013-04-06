package com.abdulradi.codejam.contest2012.round0.recycledNumbers

import scala.io.Source._

object RecycledNumbers {
  def main(args: Array[String]) {
    val lines = stdin.getLines
    val perThread = lines.next.toInt / 7 + 1
    lines.zipWithIndex.grouped(perThread).toArray.par.map{ 
      chunk: Seq[(java.lang.String, Int)] =>
        chunk.map {
          case ((l: String, i: Int)) =>
            (i+1, getRecycledNumbers(l))
        }
    }.toArray.sortWith(_(0)._1 < _(0)._1).flatten.foreach(t => println("Case #%d: %s".format(t._1, t._2)))
  }

  def getRecycledNumbers(l: String): Int = {
    val Array(a, b) = l.split(' ').map(_ toInt)
    getRecycledNumbers(a, b)    
  }

  def getRecycledNumbers(a: Int, b: Int): Int = 
    Range(a, b+1).map(getPairsCount(_, b)).sum

  def getPairsCount(n: Int, b: Int): Int =
    if (n < 10) 
      0 
    else {
      val fullRange = Range(n+1, b+1)
      getPairs(shiftLeft(n), n) count fullRange.contains
    }

  def getPairs(m: Int, start: Int): Stream[Int] =
    m #:: {
      val nextM = shiftLeft(m)
      if (nextM == start) Stream.empty else getPairs(nextM, start)
    }

  def shiftLeft(n: Int): Int = shiftLeft(n.toString.toList).mkString.toInt  
  def shiftLeft(n: List[Char]): List[Char] = {
    val newVal = n.tail ++ List(n.head)
    if (newVal.head == '0') shiftLeft(newVal) else newVal
  }

}