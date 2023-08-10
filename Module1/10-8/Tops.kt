class Tops
{
    //data members
    var fname=""
    var lname=""
    var email=""
    var mob=""

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
    var t1 = Tops()
    t1.fname="Milan"
    t1.lname="xyz"
    t1.email="milan@gmail.com"
    t1.mob="1111111"



    var t2 = Tops()
    t2.fname="Harshida"
    t2.lname="xyz"
    t2.email="harshida@gmail.com"
    t2.mob="1111111"

    var t3 = Tops()
    t3.fname="Hit"
    t3.lname="xyz"
    t3.email="hit@gmail.com"
    t3.mob="1111111"

    var t4 = Tops()
    t4.fname="Deep"
    t4.lname="xyz"
    t4.email="deep@gmail.com"
    t4.mob="1111111"

    t1.display()
    t2.display()
    t3.display()
    t4.display()

}