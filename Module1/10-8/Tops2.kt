class Tops2(var fname:String,var lname:String,var email:String,var mob:String)
{
    //function for display data
    fun display()
    {
        println("Your Firstname is ${fname}")
        println("Your Firstname is ${lname}")
        println("Your Firstname is ${email}")
        println("Your Firstname is ${mob}")
    }

}

fun main()
{
    var t1 = Tops2("Mialn","xyz","Milan@gmail.com","11")
    var t2 = Tops2("Harshida","xyz","harshida@gmail.com","2")
    var t3 = Tops2("Hit","Xyz","Hit@gmail.com","3")
    var t4 = Tops2("Deep","xyz","deep@gmail.com","4")


    t1.display()
    t2.display()
    t3.display()
    t4.display()

}