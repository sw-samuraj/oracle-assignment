package cz.swsamuraj.orcl.ws.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.swsamuraj.orcl.ws.model.Element;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * InsertAfter
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-09T22:40:21.869+02:00")

public class InsertAfter   {
  private Element element = null;

  private Element after = null;

  public InsertAfter element(Element element) {
    this.element = element;
    return this;
  }

   /**
   * Get element
   * @return element
  **/
  @ApiModelProperty(required = true, value = "")
  public Element getElement() {
    return element;
  }

  public void setElement(Element element) {
    this.element = element;
  }

  public InsertAfter after(Element after) {
    this.after = after;
    return this;
  }

   /**
   * Get after
   * @return after
  **/
  @ApiModelProperty(required = true, value = "")
  public Element getAfter() {
    return after;
  }

  public void setAfter(Element after) {
    this.after = after;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsertAfter insertAfter = (InsertAfter) o;
    return Objects.equals(this.element, insertAfter.element) &&
        Objects.equals(this.after, insertAfter.after);
  }

  @Override
  public int hashCode() {
    return Objects.hash(element, after);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsertAfter {\n");
    
    sb.append("    element: ").append(toIndentedString(element)).append("\n");
    sb.append("    after: ").append(toIndentedString(after)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

