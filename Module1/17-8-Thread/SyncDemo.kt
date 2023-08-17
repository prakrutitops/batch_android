class Sender
{
    fun send(msg:String)
    {
        println("Sending $msg")

        Thread.sleep(1000)

        println("$msg Sent")
    }
}

class Threadsend(var sender:Sender,var msg:String) : Thread()
{

    override fun run()
    {
        //Synchronized block
        synchronized(sender)
        {
            sender.send(msg)
        }


        super.run()
    }
}

fun main()
{
    var sender = Sender()

    var t1 = Threadsend(sender,"Hii")
    var t2 = Threadsend(sender,"Byee")

    t1.start()
    t2.start()
}