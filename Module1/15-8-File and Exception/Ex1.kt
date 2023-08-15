fun main()
{
    try
    {
        //logic
        var data = 10/0
        println(data)
    }
    catch (e:Exception)
    {
        println(e)
    }
    finally
    {
        //finally block will execute compulsory

        println("Executed")
    }


}