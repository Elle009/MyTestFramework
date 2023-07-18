package api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.openjdk.nashorn.internal.objects.annotations.Getter;

@JsonDeserialize(as = Address1.class)
public class Address1 {
    @JsonProperty("Ref")
    public String ref;
    @JsonProperty("SettlementType")
    public String settlementType;
    @JsonProperty("Latitude")
    public String latitude;
    @JsonProperty("Longitude")
    public String longitude;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("DescriptionRu")
    public String descriptionRu;
    @JsonProperty("DescriptionTranslit")
    public String descriptionTranslit;
    @JsonProperty("SettlementTypeDescription")
    public String settlementTypeDescription;
    @JsonProperty("SettlementTypeDescriptionRu")
    public String settlementTypeDescriptionRu;
    @JsonProperty("SettlementTypeDescriptionTranslit")
    public String settlementTypeDescriptionTranslit;
    @JsonProperty("Region")
    public String region;
    @JsonProperty("RegionsDescription")
    public String regionsDescription;
    @JsonProperty("RegionsDescriptionRu")
    public String regionsDescriptionRu;
    @JsonProperty("RegionsDescriptionTranslit")
    public String regionsDescriptionTranslit;
    @JsonProperty("Area")
    public String area;
    @JsonProperty("AreaDescription")
    public String areaDescription;
    @JsonProperty("AreaDescriptionRu")
    public String areaDescriptionRu;
    @JsonProperty("AreaDescriptionTranslit")
    public String areaDescriptionTranslit;
    @JsonProperty("Index1")
    public String index1;
    @JsonProperty("Index2")
    public String index2;
    @JsonProperty("IndexCOATSU1")
    public String indexCOATSU1;
    @JsonProperty("Delivery1")
    public String delivery1;
    @JsonProperty("Delivery2")
    public String delivery2;
    @JsonProperty("Delivery3")
    public String delivery3;
    @JsonProperty("Delivery4")
    public String delivery4;
    @JsonProperty("Delivery5")
    public String delivery5;
    @JsonProperty("Delivery6")
    public String delivery6;
    @JsonProperty("Delivery7")
    public String delivery7;
    @JsonProperty("SpecialCashCheck")
    public int specialCashCheck;
    @JsonProperty("Warehouse")
    public String warehouse;

    @JsonCreator
    public Address1(@JsonProperty("ref") String ref, @JsonProperty("settlementType") String settlementType, @JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude, @JsonProperty("description") String description, @JsonProperty("descriptionRu") String descriptionRu, @JsonProperty("descriptionTranslit") String descriptionTranslit, @JsonProperty("settlementTypeDescription") String settlementTypeDescription, @JsonProperty("settlementTypeDescriptionRu") String settlementTypeDescriptionRu, @JsonProperty("settlementTypeDescriptionTranslit") String settlementTypeDescriptionTranslit, @JsonProperty("region") String region, @JsonProperty("regionsDescription") String regionsDescription, @JsonProperty("regionsDescriptionRu") String regionsDescriptionRu, @JsonProperty("regionsDescriptionTranslit") String regionsDescriptionTranslit, @JsonProperty("area") String area, @JsonProperty("areaDescription") String areaDescription, @JsonProperty("areaDescriptionRu") String areaDescriptionRu, @JsonProperty("areaDescriptionTranslit") String areaDescriptionTranslit, @JsonProperty("index1") String index1, @JsonProperty("index2") String index2, @JsonProperty("indexCOATSU1") String indexCOATSU1) {
        this.ref = ref;
        this.settlementType = settlementType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.descriptionRu = descriptionRu;
        this.descriptionTranslit = descriptionTranslit;
        this.settlementTypeDescription = settlementTypeDescription;
        this.settlementTypeDescriptionRu = settlementTypeDescriptionRu;
        this.settlementTypeDescriptionTranslit = settlementTypeDescriptionTranslit;
        this.region = region;
        this.regionsDescription = regionsDescription;
        this.regionsDescriptionRu = regionsDescriptionRu;
        this.regionsDescriptionTranslit = regionsDescriptionTranslit;
        this.area = area;
        this.areaDescription = areaDescription;
        this.areaDescriptionRu = areaDescriptionRu;
        this.areaDescriptionTranslit = areaDescriptionTranslit;
        this.index1 = index1;
        this.index2 = index2;
        this.indexCOATSU1 = indexCOATSU1;
    }

    @Getter
    public String getRef() {
        return ref;
    }

    @Getter
    public String getSettlementType() {
        return settlementType;
    }

    @Getter
    public String getLatitude() {
        return latitude;
    }

    @Getter
    public String getLongitude() {
        return longitude;
    }

    @Getter
    public String getDescription() {
        return description;
    }

    @Getter
    public String getDescriptionRu() {
        return descriptionRu;
    }

    @Getter
    public String getDescriptionTranslit() {
        return descriptionTranslit;
    }

    @Getter
    public String getSettlementTypeDescription() {
        return settlementTypeDescription;
    }

    @Getter
    public String getSettlementTypeDescriptionRu() {
        return settlementTypeDescriptionRu;
    }

    @Getter
    public String getSettlementTypeDescriptionTranslit() {
        return settlementTypeDescriptionTranslit;
    }

    @Getter
    public String getRegion() {
        return region;
    }

    @Getter
    public String getRegionsDescription() {
        return regionsDescription;
    }

    @Getter
    public String getRegionsDescriptionRu() {
        return regionsDescriptionRu;
    }

    @Getter
    public String getRegionsDescriptionTranslit() {
        return regionsDescriptionTranslit;
    }

    @Getter
    public String getArea() {
        return area;
    }

    @Getter
    public String getAreaDescription() {
        return areaDescription;
    }

    @Getter
    public String getAreaDescriptionRu() {
        return areaDescriptionRu;
    }

    @Getter
    public String getAreaDescriptionTranslit() {
        return areaDescriptionTranslit;
    }

    @Getter
    public String getIndex1() {
        return index1;
    }

    @Getter
    public String getIndex2() {
        return index2;
    }

    @Getter
    public String getIndexCOATSU1() {
        return indexCOATSU1;
    }

    @Override
    public String toString() {
        return "Address1{" +
                "ref='" + ref + '\'' +
                ", settlementType='" + settlementType + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", description='" + description + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", descriptionTranslit='" + descriptionTranslit + '\'' +
                ", settlementTypeDescription='" + settlementTypeDescription + '\'' +
                ", settlementTypeDescriptionRu='" + settlementTypeDescriptionRu + '\'' +
                ", settlementTypeDescriptionTranslit='" + settlementTypeDescriptionTranslit + '\'' +
                ", region='" + region + '\'' +
                ", regionsDescription='" + regionsDescription + '\'' +
                ", regionsDescriptionRu='" + regionsDescriptionRu + '\'' +
                ", regionsDescriptionTranslit='" + regionsDescriptionTranslit + '\'' +
                ", area='" + area + '\'' +
                ", areaDescription='" + areaDescription + '\'' +
                ", areaDescriptionRu='" + areaDescriptionRu + '\'' +
                ", areaDescriptionTranslit='" + areaDescriptionTranslit + '\'' +
                ", index1='" + index1 + '\'' +
                ", index2='" + index2 + '\'' +
                ", indexCOATSU1='" + indexCOATSU1 + '\'' +
                '}';
    }
}
