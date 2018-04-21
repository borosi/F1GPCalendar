package com.example.mobsoft.f1gpcalendar.model;

import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MRData   {
  
  @SerializedName("xmlns")
  @Expose
  private String xmlns = null;
  
  @SerializedName("series")
  @Expose
  private String series = null;
  
  @SerializedName("url")
  @Expose
  private String url = null;
  
  @SerializedName("limit")
  @Expose
  private Integer limit = null;
  
  @SerializedName("offset")
  @Expose
  private Integer offset = null;
  
  @SerializedName("total")
  @Expose
  private Integer total = null;
  
  @SerializedName("RaceTable")
  @Expose
  private RaceTable raceTable = null;
  

  public String getXmlns() {
    return xmlns;
  }
  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public String getSeries() {
    return series;
  }
  public void setSeries(String series) {
    this.series = series;
  }

  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getLimit() {
    return limit;
  }
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getOffset() {
    return offset;
  }
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }

  public RaceTable getRaceTable() {
    return raceTable;
  }
  public void setRaceTable(RaceTable raceTable) {
    this.raceTable = raceTable;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MRData mRData = (MRData) o;
    return Objects.equals(xmlns, mRData.xmlns) &&
        Objects.equals(series, mRData.series) &&
        Objects.equals(url, mRData.url) &&
        Objects.equals(limit, mRData.limit) &&
        Objects.equals(offset, mRData.offset) &&
        Objects.equals(total, mRData.total) &&
        Objects.equals(raceTable, mRData.raceTable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlns, series, url, limit, offset, total, raceTable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MRData {\n");
    
    sb.append("    xmlns: ").append(toIndentedString(xmlns)).append("\n");
    sb.append("    series: ").append(toIndentedString(series)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    raceTable: ").append(toIndentedString(raceTable)).append("\n");
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
