import java.io.FileOutputStream
import java.io.ObjectOutput
import java.io.ObjectOutputStream

fun main()
{

    var x1 = Xyz(101,"abcd")//data assign
    var fout = FileOutputStream("E://tops.txt")//file create
    var o1 = ObjectOutputStream(fout)//object file
    o1.writeObject(x1)//write data in object
    print("Success")

}