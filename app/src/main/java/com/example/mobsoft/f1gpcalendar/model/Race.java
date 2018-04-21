package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Circuit;
import java.util.Date;

import com.google.gson.annotations.SerializedName;




@ApiModel(description = "")
public class Race   {
  
  @SerializedName("season")
  private Integer season = null;
  
  @SerializedName("round")
  private Integer round = null;
  
  @SerializedName("url")
  private String url = null;
  
  @SerializedName("raceName")
  private String raceName = null;
  
  @SerializedName("circuit")
  private Circuit circuit = null;
  
  @SerializedName("date")
  private Date date = null;
  
  @SerializedName("time")
  private String time = null;
  

  
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
  public Integer getRound() {
    return round;
  }
  public void setRound(Integer round) {
    this.round = round;
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
  public String getRaceName() {
    return raceName;
  }
  public void setRaceName(String raceName) {
    this.raceName = raceName;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Circuit getCircuit() {
    return circuit;
  }
  public void setCircuit(Circuit circuit) {
    this.circuit = circuit;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTime() {
    return time;
  }
  public void setTime(String time) {
    this.time = time;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Race race = (Race) o;
    return Objects.equals(season, race.season) &&
        Objects.equals(round, race.round) &&
        Objects.equals(url, race.url) &&
        Objects.equals(raceName, race.raceName) &&
        Objects.equals(circuit, race.circuit) &&
        Objects.equals(date, race.date) &&
        Objects.equals(time, race.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(season, round, url, raceName, circuit, date, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Race {\n");
    
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    round: ").append(toIndentedString(round)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    raceName: ").append(toIndentedString(raceName)).append("\n");
    sb.append("    circuit: ").append(toIndentedString(circuit)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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
