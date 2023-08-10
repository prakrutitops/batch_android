fun main()
{
    var last = 'E'
    var alphabet = 'A'

    //print(last.toInt())

    for (i in 1..last - 'A' + 1)
    {
        for (j in 1..i)
        {
            print("$alphabet ")
        }
        ++alphabet

        println()
    }
}