package pe.jiyoung.newtoy.spring.util;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.jiyoung.newtoy.spring.mvc.domain.User;

public class ConvertUtil {

    public static User mapToUser(final Map<String, Object> map){
        if (map == null) {
            return null;
        }
        final ObjectMapper m = new ObjectMapper();
        return m.convertValue(map, User.class);
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> userToMap(final User user){
        if(user == null) {
            return null;
        }
        final ObjectMapper m = new ObjectMapper();
        return m.convertValue(user, Map.class);
    }

}
