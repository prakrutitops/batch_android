package tops.tech.roomdbex.Dao

import android.app.Person
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import tops.tech.roomdbex.Entity.User

@Dao
interface Daoclass
{
    @Insert
    fun addata(person: User?)

    @Query("select * from users")
    fun viewdata():MutableList<User>

    @Update
    fun updatedata(person: User?)

    @Delete
    fun deletedata(person: User?)


}