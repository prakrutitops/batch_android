class Student //class
{
    //variables
   var id = 0
   var name= ""
}
fun main()
{
    var s1 = Student()//object
    s1.id=101//assign value
    s1.name="a"

    var s2 = Student()//object2
    s2.id=102
    s2.name="b"

    println("Your Details ${s1.id} and ${s1.name}")//value print
    println("Your Details ${s2.id} and ${s2.name}")

}