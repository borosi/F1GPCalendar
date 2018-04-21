package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Location;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Circuit   {
  
  @SerializedName("circuitId")
  private String circuitId = null;
  
  @SerializedName("url")
  private String url = null;
  
  @SerializedName("circuitName")
  private String circuitName = null;
  
  @SerializedName("location")
  private Location location = null;
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCircuitId() {
    return circuitId;
  }
  public void setCircuitId(String circuitId) {
    this.circuitId = circuitId;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getCircuitName() {
    return circuitName;
  }
  public void setCircuitName(String circuitName) {
    this.circuitName = circuitName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Location getLocation() {
    return location;
  }
  public void setLocation(Location location) {
    this.location = location;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Circuit circuit = (Circuit) o;
    return Objects.equals(circuitId, circuit.circuitId) &&
        Objects.equals(url, circuit.url) &&
        Objects.equals(circuitName, circuit.circuitName) &&
        Objects.equals(location, circuit.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(circuitId, url, circuitName, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Circuit {\n");
    
    sb.append("    circuitId: ").append(toIndentedString(circuitId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    circuitName: ").append(toIndentedString(circuitName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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
