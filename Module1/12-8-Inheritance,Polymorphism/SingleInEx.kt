open class A
{
    fun a1()
    {
        println("A Accessed")
    }
}
class B : A()
{
    fun b1()
    {
        println("B Accessed")
    }
}
fun main()
{

    var b1 = B()

    b1.a1()
    b1.b1()

}