package mappers;

import roles.Spitter;

import java.util.List;

public interface SpitterMapper {
    void save(Spitter spitter);
    Spitter getOne(String username);
    List<Spitter> getListsByName(String firstname, String lastname);
}
