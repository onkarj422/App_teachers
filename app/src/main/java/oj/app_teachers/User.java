package oj.app_teachers;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Onkar J on 20-07-2017.
 */
@Table(database = AppDatabase.class)
class User extends BaseModel {
    @Column
    @PrimaryKey
    private int id;

    @Column(name= "Name")
    private String name;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    public int getId() {
        return id;
    }
    String getPassword() { return password; }
    String getRole() { return role; }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {this.name = name;}
    void setPassword(String password) { this.password = password; }
    void setRole(String role) { this.role = role; }

}
