//left to right, top to bottom
fun main()
{

    for(i in 1..5)//row
    {
        for(j in 1..5)//col
        {
            if(j<=i)
            {
                print(j)
            }

        }
        print("\n")
    }


}