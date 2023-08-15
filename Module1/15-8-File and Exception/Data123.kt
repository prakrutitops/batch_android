import java.io.FileOutputStream

fun main()
{

    println("Enter Your Firstname")
    var fname = readLine()

    println("Enter Your Lastname")
    var lname = readLine()

    println("Enter Your Email")
    var email = readLine()

    println("Enter Your Password")
    var pass = readLine()

    println("Enter Your Confirm Password")
    var cpass = readLine()


    var n = "\n Your Firstname is :"
    var l = "\n Your Lastname is :"
    var e = "\n Your Email is :"
    var p = "\n Your Password is :"
    var c = "\n Your Confirm Password is :"

    if(pass.equals(cpass))
    {
        var fout = FileOutputStream("E://detail.txt")
        fout.write(n.toByteArray())
        fout.write(fname!!.toByteArray())
        fout.write(l.toByteArray())
        fout.write(lname!!.toByteArray())
        fout.write(e.toByteArray())
        fout.write(email!!.toByteArray())
        fout.write(p.toByteArray())
        fout.write(pass!!.toByteArray())
        fout.write(c.toByteArray())
        fout.write(cpass!!.toByteArray())
        print("Success")
    }
    else
    {
        println("\n password and confirm password are not same")
    }


}