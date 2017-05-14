package trmsystem.rest.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import trmsystem.model.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lion on 11.05.17.
 */

public class JacksonCustomUserDeserializer extends StdDeserializer<User> {

    public JacksonCustomUserDeserializer(){
        this(null);
    }

    public JacksonCustomUserDeserializer(Class<User> t) {
        super(t);
    }

    @Override
    public User deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        JsonNode node = parser.getCodec().readTree(parser);
        User user = new User();
        UUID id = UUID.fromString(node.get("id").asText(null));
        String username = node.get("username").asText(null);
        String firstName = node.get("firstName").asText(null);
        String lastName = node.get("lastName").asText(null);
        Date birthDate = null;
        String birthDateStr = node.get("birthDate").asText(null);
        try {
            birthDate = formatter.parse(birthDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        String userType = node.get("userType").asText(null);
        Date registrationDate = null;
        String registrationDateStr = node.get("registrationDate").asText(null);
        try {
            registrationDate = formatter.parse(registrationDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        String email = node.get("email").asText(null);
        String status = node.get("status").asText(null);

        if (!(id == null)) {
            user.setId(id);
        }
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        user.setUserType(userType);
        user.setRegistrationDate(registrationDate);
        user.setEmail(email);
        user.setStatus(status);
        return user;
    }
}
