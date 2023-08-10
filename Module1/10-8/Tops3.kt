class Tops3
{
    constructor(fname:String)
    {
        println("Your Firstname is ${fname}")
    }
    constructor(fname:String,lname:String)
    {
        println("Your Firstname is ${fname}")
        println("Your Firstname is ${lname}")
    }

    constructor(fname:String,lname:String,email:String)
    {
        println("Your Firstname is ${fname}")
        println("Your Firstname is ${lname}")
        println("Your Firstname is ${email}")
    }

    constructor(fname:String,lname:String,email:String,mob:String)
    {
        println("Your Firstname is ${fname}")
        println("Your Firstname is ${lname}")
        println("Your Firstname is ${email}")
        println("Your Firstname is ${mob}")
    }


}

fun main()
{
    var t1 = Tops3("Milan")
    var t2 = Tops3("Harshida","xyz")
    var t3 = Tops3("Hit","Xyz","Hit@gmail.com")
    var t4 = Tops3("Deep","xyz","deep@gmail.com","4")


}