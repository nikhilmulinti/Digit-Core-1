package org.egov.infra.indexer.custom.bpa;

import java.util.Objects;

import org.egov.common.contract.request.RequestInfo;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contract class to receive request. Array of Property items  are used in case of create . Where as single Property item is used for update
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-06-23T05:52:32.717Z[GMT]")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class EnrichedBPARequest {
  @JsonProperty("RequestInfo")
  private RequestInfo requestInfo = null;

  @JsonProperty("BPA")
  private EnrichedBPA BPA = null;

  public EnrichedBPARequest requestInfo(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
    return this;
  }

  /**
   * Get requestInfo
   * @return requestInfo
  **/

    @Valid
    public RequestInfo getRequestInfo() {
    return requestInfo;
  }

  public void setRequestInfo(RequestInfo requestInfo) {
    this.requestInfo = requestInfo;
  }

  public EnrichedBPARequest BPA(EnrichedBPA BPA) {
    this.BPA = BPA;
    return this;
  }

  /**
   * Get BPA
   * @return BPA
  **/

    @Valid
    public EnrichedBPA getBPA() {
    return BPA;
  }

  public void setBPA(EnrichedBPA BPA) {
    this.BPA = BPA;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrichedBPARequest bpARequest = (EnrichedBPARequest) o;
    return Objects.equals(this.requestInfo, bpARequest.requestInfo) &&
        Objects.equals(this.BPA, bpARequest.BPA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestInfo, BPA);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BPARequest {\n");
    
    sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
    sb.append("    BPA: ").append(toIndentedString(BPA)).append("\n");
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
