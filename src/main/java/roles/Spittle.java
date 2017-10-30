package roles;

import java.sql.Timestamp;

public class Spittle {

    int id;

    String context;

    Spitter owner;

    Timestamp date;

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", owner=" + owner +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public Spittle setId(int id) {
        this.id = id;
        return this;
    }

    public String getContext() {
        return context;
    }

    public Spittle setContext(String context) {
        this.context = context;
        return this;
    }

    public Spitter getOwner() {
        return owner;
    }

    public Spittle setOwner(Spitter owner) {
        this.owner = owner;
        return this;
    }

    public Timestamp getDate() {
        return date;
    }

    public Spittle setDate(Timestamp date) {
        this.date = date;
        return this;
    }
}
