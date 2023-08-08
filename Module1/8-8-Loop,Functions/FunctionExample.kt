//1.With argument with return type

fun add(a:Int,b:Int) :Int
{
    var c=a+b
    return c
}
//2.Without argument with return type
fun add2() :Int
{
    var a= 6
    var b=5
    var c=a+b
    return c
}
//3.Without return type with argument
fun add3(a:Int,b:Int)
{

    var c=a+b
    println(c)
}

//4.Without Argument without return
fun add4()
{
    var a= 6
    var b=5
    var c=a+b
    println(c)
}


fun main()
{

    println(add(6,5))
    println(add2())
    add3(6,5)
    add4()




   /* println(add(5,5))
    println(add(3,2))
    println(add(9,8))*/

}