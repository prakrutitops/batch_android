fun main()
{
    var a1 = HashSet<Int>()
    a1.add(1)
    a1.add(10)
    a1.add(8)
    a1.add(6)
    a1.add(2)
    a1.add(4)

    var a2 = HashSet<Char>()
    a2.add('b')
    a2.add('c')
    a2.add('a')
    a2.add('d')
    a2.add('p')
    a2.add('q')


   var i:Iterator<Char> = a2.iterator()

    while (i.hasNext())
    {
        println(i.next())
    }

}