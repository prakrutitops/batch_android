package tops.tech.roomdbex.Dao

import android.app.Person
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tops.tech.roomdbex.Entity.User

@Dao
interface Daoclass
{
    @Insert
    fun addata(person: User?)

    @Query("select * from users")
    fun viewdata():MutableList<User>


}