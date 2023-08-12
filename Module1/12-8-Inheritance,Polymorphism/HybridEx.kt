open class W
{
    fun w()
    {
        print("w")
    }
}
interface X
{
    fun x()
    {
        print("x")
    }

}
open class Y : W()
{
    fun y()
    {
        print("y")
    }
}
class Z : Y(),X
{
    fun z()
    {
        print("z")
    }
}
fun main()
{
    var z1 = Z()

    z1.w()
    z1.x()
    z1.y()
    z1.z()
}
