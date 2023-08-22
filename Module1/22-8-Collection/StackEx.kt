import MyStack.Companion.pop1
import MyStack.Companion.push1
import java.util.*

class MyStack
{
    //static
    companion object
    {
        //entry
        fun push1(st:Stack<Int>,i:Int)
        {
            st.push(i)

            println(i)
            println(st)
        }

        //exit
        fun pop1(st:Stack<Int>)
        {
            var i:Int = st.pop()

            println(i)
            println(st)
        }
    }

}

fun main()
{

    var st = Stack<Int>()

    push1(st,10)
    push1(st,20)
    push1(st,30)
    push1(st,40)

    try
    {
        pop1(st)
        pop1(st)
        pop1(st)
        pop1(st)
        pop1(st)
        pop1(st)
        pop1(st)
    }
    catch (e:Exception)
    {
            print("No Data")
    }







}