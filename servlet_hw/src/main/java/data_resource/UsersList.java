package data_resource;

import models.User;
import java.util.HashMap;

public class UsersList {

    public final HashMap<String, String> users = new HashMap<String, String>()
    {{
        put("admin", "adminpass");
        put("user1", "user1pass");
        put("user2", "user2pass");
    }};

    public boolean authorization(User user) {
        if (!users.containsKey(user.getName())) {
            return false;
        } else {
            return users.get(user.getName()).equals(user.getPassword());
        }
    }
}
