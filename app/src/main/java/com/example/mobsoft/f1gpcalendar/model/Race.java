package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Race   {
  
  @SerializedName("season")
  @Expose
  private Integer season = null;
  
  @SerializedName("round")
  @Expose
  private Integer round = null;
  
  @SerializedName("url")
  @Expose
  private String url = null;
  
  @SerializedName("raceName")
  @Expose
  private String raceName = null;
  
  @SerializedName("circuit")
  @Expose
  private Circuit circuit = null;
  
  @SerializedName("date")
  @Expose
  private Date date = null;
  
  @SerializedName("time")
  @Expose
  private String time = null;

  public Integer getSeason() {
    return season;
  }
  public void setSeason(Integer season) {
    this.season = season;
  }

  public Integer getRound() {
    return round;
  }
  public void setRound(Integer round) {
    this.round = round;
  }

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  public String getRaceName() {
    return raceName;
  }
  public void setRaceName(String raceName) {
    this.raceName = raceName;
  }

  public Circuit getCircuit() {
    return circuit;
  }
  public void setCircuit(Circuit circuit) {
    this.circuit = circuit;
  }

  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

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
