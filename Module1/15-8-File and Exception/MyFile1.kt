import java.io.FileOutputStream

fun main()
{

    var data ="welcome to tops"
    var fout = FileOutputStream("U://Milan.txt")
    fout.write(data.toByteArray())
    print("Success")



}