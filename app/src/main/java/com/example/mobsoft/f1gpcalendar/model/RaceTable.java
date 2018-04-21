package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Race;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class RaceTable   {
  
  @SerializedName("season")
  private Integer season = null;
  
  @SerializedName("races")
  private List<Race> races = new ArrayList<Race>();
  

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Integer getSeason() {
    return season;
  }
  public void setSeason(Integer season) {
    this.season = season;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public List<Race> getRaces() {
    return races;
  }
  public void setRaces(List<Race> races) {
    this.races = races;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RaceTable raceTable = (RaceTable) o;
    return Objects.equals(season, raceTable.season) &&
        Objects.equals(races, raceTable.races);
  }

  @Override
  public int hashCode() {
    return Objects.hash(season, races);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RaceTable {\n");
    
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    races: ").append(toIndentedString(races)).append("\n");
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
