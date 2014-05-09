
package member.model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Address {
  private static final Log log = LogFactory.getLog(Address.class);
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String country;

  public Address() {
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String toString() {
      final StringBuffer sb = new StringBuffer();
      sb.append("Address");
      sb.append("{street='").append(street).append('\'');
      sb.append(", zipCode='").append(zipCode).append('\'');
      sb.append(", city='").append(city).append('\'');
      sb.append(", state='").append(state).append('\'');
      sb.append(", country='").append(country).append('\'');
      sb.append('}');
      return sb.toString();
  }

}
