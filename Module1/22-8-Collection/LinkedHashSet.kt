fun main()
{

    var a2 = LinkedHashSet<Char>()



        a2.add('b')
        a2.add('c')
        a2.add('a')
        a2.add('d')
        a2.add('p')
        a2.add('q')
        a2.add('d')

        var i:Iterator<Char> = a2.iterator()

        while (i.hasNext())
        {
            println(i.next())
        }

    }

