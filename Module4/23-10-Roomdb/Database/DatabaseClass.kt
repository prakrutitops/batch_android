package tops.tech.roomdbex

import androidx.room.Database
import androidx.room.RoomDatabase
import tops.tech.roomdbex.Model.User


@Database(entities = [User::class], version = 1)
abstract class DatabaseClass : RoomDatabase()
{
    abstract fun daoClass(): Daoclass
}