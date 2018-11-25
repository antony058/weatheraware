package ru.priamosudov.weatheraware.weatheraware.model.geocoder.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityGeoData {

    private String lat;

    private String lon;

    private String localityName;

    @JsonProperty(value = "response")
    public void getNecessaryFields(JsonNode responseNode) {
        if (responseNode.hasNonNull("GeoObjectCollection")) {
            JsonNode geoObjectCollection = responseNode.get("GeoObjectCollection");
            if (geoObjectCollection.hasNonNull("featureMember")) {
                JsonNode featureMemberArray = geoObjectCollection.get("featureMember");
                if (featureMemberArray.isArray()) {
                    if (featureMemberArray.hasNonNull(0) &&
                            featureMemberArray.get(0).hasNonNull("GeoObject")) {
                        JsonNode geoObject = featureMemberArray.get(0).get("GeoObject");
                        if (geoObject.hasNonNull("metaDataProperty") &&
                                geoObject.get("metaDataProperty").hasNonNull("GeocoderMetaData")) {
                            JsonNode geoCoderMetaData = geoObject.get("metaDataProperty").get("GeocoderMetaData");
                            if (geoCoderMetaData.hasNonNull("text")) {
                                localityName = geoCoderMetaData.get("text").asText();
                            }
                        }
                        if (geoObject.hasNonNull("Point")) {
                            JsonNode point = geoObject.get("Point");
                            if (point.hasNonNull("pos")) {
                                String[] coordinates = point.get("pos").asText().split(" ");
                                lon = coordinates[0];
                                lat = coordinates[1];
                            }
                        }
                    }
                }
            }
        }
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getLocalityName() {
        return localityName;
    }

    @Override
    public String toString() {
        return "CityGeoData{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", localityName='" + localityName + '\'' +
                '}';
    }
}
