interface P1
{
    fun p()
    {
        println("p accessed")
    }
}
interface Q1
{
    fun q()
    {
        println("q accessed")
    }
}
class R1 : P1,Q1
{

}
fun main()
{
    var r1 = R1()
    r1.p()
    r1.q()
}