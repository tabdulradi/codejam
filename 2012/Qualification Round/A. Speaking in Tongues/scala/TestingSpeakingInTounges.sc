import com.abdulradi.codejam.contest2012.round0.speakingInTongues._
object TestingSpeakingInTounges {
  val translator = Translator(
      ("q", "z"),
      ("a zoo", "y qee"),
      ("our language is impossible to understand", "ejp mysljylc kd kxveddknmc re jsicpdrysi"),
      ("there are twenty six factorial possibilities", "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd"),
      ("so it is okay if you want to just give up", "de kr kd eoya kw aej tysr re ujdr lkgc jv")
    )                                             //> translator  : com.abdulradi.codejam.contest2012.round0.speakingInTongues.Tra
                                                  //| nslator = com.abdulradi.codejam.contest2012.round0.speakingInTongues.Transla
                                                  //| tor@5464ea66
  translator.translate("y qee de kr kd eoya kw aej tysr re ujdr lkgc jv ejp mysljylc kd kxveddknmc re jsicpdrysi")
                                                  //> res0: String = a zoo so it is okay if you want to just give up our language 
                                                  //| is impossible to understand
  translator.translate("abcdefghijklmnop qrstuvwxyz")
                                                  //> res1: String = yhesocvxduiglbkr ztnwjpfmaq
}