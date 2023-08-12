open class A1
{
    fun a1()
    {
        println("A Accessed")
    }
}
open class B1 :A1()
{
    fun b1()
    {
        println("B Accessed")
    }
}
open class C1 : B1()
{
    fun c1()
    {
        println("C Accessed")
    }
}
class D1 :C1()
{
    fun d1()
    {
        println("D Accessed")
    }
}
fun main()
{

    var d1 = D1()

    d1.a1()
    d1.b1()
    d1.c1()
    d1.d1()


}