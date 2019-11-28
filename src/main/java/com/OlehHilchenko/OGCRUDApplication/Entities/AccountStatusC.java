package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

public class AccountStatusC implements AccountStatus {

   public String accountStatus;

   @Override
   public String toString() {
      return "AccountStatusC{" +
              "accountStatus='" + accountStatus + '\'' +
              '}';
   }
}
