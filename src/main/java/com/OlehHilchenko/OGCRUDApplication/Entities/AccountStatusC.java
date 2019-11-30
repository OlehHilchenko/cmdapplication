package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

public class AccountStatusC implements AccountStatus {

   public String accountStatusValue;

   @Override
   public String toString() {
      return "AccountStatusC{" +
              "accountStatusValue='" + accountStatusValue + '\'' +
              '}';
   }
}
