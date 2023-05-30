package dsw.gerumap.app.serializer;

import com.google.gson.*;
import dsw.gerumap.app.mapRepository.composite.MapNode;

import java.lang.reflect.Type;

public class ProjectDeserializer implements JsonDeserializer<MapNode>, JsonSerializer<MapNode> {

    @Override
    public final JsonElement serialize(final MapNode object, final Type interfaceType, final JsonSerializationContext context)
    {
        final JsonObject member = new JsonObject();

        member.addProperty("type", object.getClass().getName());

        member.add("data", context.serialize(object));

        return member;
    }

    @Override
    public final MapNode deserialize(final JsonElement elem, final Type interfaceType, final JsonDeserializationContext context)
            throws JsonParseException
    {
        final JsonObject member = (JsonObject) elem;
        final JsonElement typeString = get(member, "type");
        final JsonElement data = get(member, "data");
        final Type actualType = typeForName(typeString);

        return context.deserialize(data, actualType);
    }

    private Type typeForName(final JsonElement typeElem)
    {
        try
        {
            return Class.forName(typeElem.getAsString());
        }
        catch (ClassNotFoundException e)
        {
            throw new JsonParseException(e);
        }
    }

    private JsonElement get(final JsonObject wrapper, final String memberName)
    {
        final JsonElement elem = wrapper.get(memberName);

        if (elem == null)
        {
            throw new JsonParseException(
                    "no '" + memberName + "' member found in json file.");
        }
        return elem;
    }
}
