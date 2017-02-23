/**
  * Concatenate 2 lists with tail recursion
  */
object Concat extends App{
  val list1 = List(1,2,3)
  val list2 = List(4,5,6)
  println(concatList(list1,list2))

  def concatList(list1:List[Int], list2:List[Int]):List[Int]={

    def innerConcatList(list1:List[Int], list2:List[Int], list3:List[Int]):List[Int]={
      (list1,list2) match{
          case(Nil,Nil) => list3
          case(headList:+last, Nil) => innerConcatList(headList,Nil, last::list3)
          case (l1:List[Int], headList:+last) => innerConcatList(l1, headList, last::list3)

      }

    }
    innerConcatList(list1,list2, List[Int]())
  }
}

//find armstrong number upto n number (sum of cubes of digits)
