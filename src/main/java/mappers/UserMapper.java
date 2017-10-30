package mappers;

import roles.User;

public interface UserMapper {

    public User getUser(int id);

    public int insertUser(User user);
}
