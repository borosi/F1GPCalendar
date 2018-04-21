package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Location   {
  
  @SerializedName("lat")
  private Double lat = null;
  
  @SerializedName("_long")
  private Double _long = null;
  
  @SerializedName("locality")
  private String locality = null;
  
  @SerializedName("country")
  private String country = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Double getLat() {
    return lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Double getLong() {
    return _long;
  }
  public void setLong(Double _long) {
    this._long = _long;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getLocality() {
    return locality;
  }
  public void setLocality(String locality) {
    this.locality = locality;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(lat, location.lat) &&
        Objects.equals(_long, location._long) &&
        Objects.equals(locality, location.locality) &&
        Objects.equals(country, location.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, _long, locality, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    _long: ").append(toIndentedString(_long)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
