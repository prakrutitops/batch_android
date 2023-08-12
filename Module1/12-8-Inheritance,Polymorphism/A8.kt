interface P2
{
    fun p()

}
interface Q2
{
    fun q()

}
class R2 : P2,Q2
{
    override fun p() {

        println("p accessed")
    }

    override fun q()
    {
        println("q accessed")
    }

}
fun main()
{
    var r2 = R2()
    r2.p()
    r2.q()
}