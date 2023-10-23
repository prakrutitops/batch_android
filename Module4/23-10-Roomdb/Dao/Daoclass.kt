package tops.tech.roomdbex

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tops.tech.roomdbex.Model.User


@Dao
interface Daoclass
{
    @Insert
    fun addUser(user: User?)


}