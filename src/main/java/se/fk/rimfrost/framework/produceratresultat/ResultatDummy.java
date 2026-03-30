package se.fk.rimfrost.framework.produceratresultat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableResultatDummy.class)
@JsonDeserialize(as = ImmutableResultatDummy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ResultatDummy extends ResultatMappable<ResultatDummy>
{

   String aString();

   int anInt();

   /** Static factory to deserialize JSON */
   static ResultatDummy from(String json)
   {
      return ResultatMappable.fromJson(json, ResultatDummy.class);
   }

}
