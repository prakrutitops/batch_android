import java.util.*

fun main()
{
    var v1 = Vector<String>(5)

    v1.add("a")
    v1.add("b")
    v1.add("c")
    v1.add("d")
    v1.add("d")
    v1.add("d")
    v1.add("c")
    v1.add("d")
    v1.add("d")
    v1.add("d")
    v1.add("d")


    println(v1.size)
    println(v1.capacity())
    println(v1.firstElement())
    println(v1.lastElement())

    if(v1.contains("e"))
    {
        print("success")

    }
    else
    {
        print("fail")
    }

}