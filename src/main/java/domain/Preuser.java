package domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by lily on 2016/4/22.
 */
public class Preuser implements Serializable{
   private Long puid;
   private String name;
   private String password;
   private String email;
   private String phone;
   private String address;
   private Integer state;
   private String code;
   private Set<Order> orders;

   public Set<Order> getOrders() {
      return orders;
   }

   public void setOrders(Set<Order> orders) {
      this.orders = orders;
   }

   public Long getPuid() {
      return puid;
   }

   public void setPuid(Long puid) {
      this.puid = puid;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Integer getState() {
      return state;
   }

   public void setState(Integer state) {
      this.state = state;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }
}
