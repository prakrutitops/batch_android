class Cal
{
    fun add(a:Int,b:Int):Int
    {
        return a+b
    }
    fun add(a:Int,b:Int,c:Int):Int
    {
        return a*b*c
    }
}
fun main()
{
    var c1 = Cal()
    println(c1.add(5,6))
    println(c1.add(2,3,4))
}