fun main()
{
    var a1 = ArrayList<String>()

    a1.add("Android")
    a1.add("Java")
    a1.add("Php")
    a1.add("dart")
    a1.add("Android")

   // println(a1)//Array Format
    //Interface - Iterator

    var a2 = ArrayList<String>()

    a2.add("kotlin")
    a2.add("dart")

   /* a1.addAll(a2)

    a1.remove("Php")
    a1.removeAt(0)*/
    //a1.retainAll(a2)

    var i:Iterator<String> = a1.iterator()

    while (i.hasNext())
    {
          println(i.next())
    }


}