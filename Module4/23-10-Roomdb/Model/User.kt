package tops.tech.roomdbex.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User
{
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "user_name")
    var user_name = ""

    @ColumnInfo(name = "user_number")
    var user_number = ""
}