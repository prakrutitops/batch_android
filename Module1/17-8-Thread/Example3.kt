class T3 : Runnable
{
    override fun run()
    {
       for(i in 1..10)
       {
           println("Thread T3 :$i")
       }
    }

}
class T4 : Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread T4 :$i")
        }
    }

}
fun main()
{

    var t1 = Thread(T3())
    var t2 = Thread(T4())

    t1.start()
    t2.start()


}