fun main()
{
    for(i in 1..5)//row
    {
        for(space in 0..(5-i))
        {
          print(" ")
        }
        for(j in 1..i)
        {
          print(j)
        }
        println()
    }

}