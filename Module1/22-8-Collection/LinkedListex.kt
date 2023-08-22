import java.util.*
import kotlin.collections.ArrayList

fun main()
{
    var a1 = LinkedList<String>()

    a1.add("Android")
    a1.add("Java")
    a1.add("Php")
    a1.add("dart")
    a1.addFirst("Flutter")
    a1.addLast("Testing")

    var i:Iterator<String> = a1.iterator()

    while (i.hasNext())
    {
          println(i.next())
    }


}