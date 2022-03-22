package co.za.giantpanda.letshike.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Register_users_table")
  data class RegisterEntity(

    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,

    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "phone_number")
    var cellPhone: Int,

    @ColumnInfo(name = "password_user")
    var password: String,

    @ColumnInfo(name = "password_user_confirm")
    var confirmPassword: String

)

