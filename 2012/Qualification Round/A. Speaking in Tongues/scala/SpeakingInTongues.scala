package com.abdulradi.codejam.contest2012.round0.speakingInTongues

import scala.io.Source._

class Translator(val dict: Map[Char, Char]) {
  def apply(s: String): String = s.toCharArray.map(dict).mkString
}

object Translator {
  def apply(vocabulary: (String, String)*) =
    new Translator(extractAndLearn(vocabulary))
  
  def learn(e: String, g: String): Map[Char, Char] = {
    require(e.length == g.length)
    g.toCharArray.zip(e.toCharArray).toMap
  }
  
  def extractAndLearn(vocabulary: Seq[(String, String)]): Map[Char, Char] =
    (learn _ tupled)(vocabulary.foldLeft(("", "")){
      case ((e1: String, g1: String), (e2: String, g2: String)) => (e1 + e2, g1 + g2)
    })
}

object SpeakingInTongues {
  def main(args: Array[String]) {
    val translator = Translator(
      ("a zoo", "y qee"),
      ("our language is impossible to understand", "ejp mysljylc kd kxveddknmc re jsicpdrysi"),
      ("there are twenty six factorial possibilities", "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"),
      ("so it is okay if you want to just give up", "de kr kd eoya kw aej tysr re ujdr lkgc jv"),
      ("q", "z") // the only missing pair
    ) 
    
    stdin.getLines.zipWithIndex.drop(1).foreach{ case ((l: String, i: Int)) =>
      println("Case #%d: %s".format(i, translator(l)))
    }
  }
}