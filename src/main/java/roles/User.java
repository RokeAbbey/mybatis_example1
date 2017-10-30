package roles;

import roles.elements.SexPartner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User implements Cloneable{

    private int id;
    private String username="roke";
    private String password="111";
    private List parents= Arrays.asList(1,2,3,4);//new ArrayList();
    private SexPartner favorate = null;//SexPartner.Lou;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", parents=" + parents +
                ", favorate=" + favorate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getParents() {
        return parents;
    }

    public void setParents(List parents) {
        this.parents = parents;
    }

    public SexPartner getFavorate() {
        return favorate;
    }

    public void setFavorate(SexPartner favorate) {
        this.favorate = favorate;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
