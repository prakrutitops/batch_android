import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var oin = ObjectInputStream(FileInputStream("E://tops.txt"))
    var a:Xyz = oin.readObject() as Xyz
    print("${a.id} and ${a.name}")
    //print(oin.readObject())
}