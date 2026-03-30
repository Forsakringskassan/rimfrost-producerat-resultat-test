package se.fk.rimfrost.framework.produceratresultat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultatDummyTest
{

   private static final ObjectMapper MAPPER = new ObjectMapper();

   @Test
   void should_create_resultat_dummy_from_resultat_json()
   {
      String resultatJson = """
            {
              "aString": "hello",
              "anInt": 42
            }
            """;

      ResultatDummy dummy = ResultatDummy.from(resultatJson);

      assertEquals("hello", dummy.aString());
      assertEquals(42, dummy.anInt());
   }

   @Test
   void should_create_resultat_json_from_resultat_dummy() throws JsonProcessingException
   {

      var resultatDummy = ImmutableResultatDummy.builder()
            .aString("hello")
            .anInt(42)
            .build();

      var resultatJson = resultatDummy.toJson();

      JsonNode node = MAPPER.readTree(resultatJson);
      assertEquals("hello", node.get("aString").asText());
      assertEquals(42, node.get("anInt").asInt());

   }
}
