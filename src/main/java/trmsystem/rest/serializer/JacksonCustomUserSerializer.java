package trmsystem.rest.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import trmsystem.model.User;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 * Created by lion on 11.05.17.
 */
public class JacksonCustomUserSerializer extends StdSerializer<User> {

    public JacksonCustomUserSerializer() {
        this(null);
    }

    protected JacksonCustomUserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        Format formatter = new SimpleDateFormat("yyyy/MM/dd");
        jgen.writeStartObject();
        if (user.getId() == null) {
            jgen.writeNullField("id");
        } else {
            jgen.writeStringField("id", user.getId().toString());
        }

        jgen.writeStringField("username", user.getUsername());
        jgen.writeStringField("firstName", user.getFirstName());
        jgen.writeStringField("lastName", user.getLastName());
        jgen.writeStringField("birthDate", formatter.format(user.getBirthDate()));
        jgen.writeStringField("userType", user.getUserType());
        jgen.writeStringField("registrationDate", formatter.format(user.getRegistrationDate()));
        jgen.writeStringField("email", user.getEmail());
        jgen.writeStringField("status", user.getStatus());
        jgen.writeEndObject();
    }
}
