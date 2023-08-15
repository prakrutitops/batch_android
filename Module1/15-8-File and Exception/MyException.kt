import java.lang.Exception

class MyException : Exception()
{
    fun printexception()
    {
        println("exception occured")
    }
}
fun main()
{
    var m1 = MyException()
    m1.printexception()
}