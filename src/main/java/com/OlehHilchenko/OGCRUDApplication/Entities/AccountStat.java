package main.java.com.OlehHilchenko.OGCRUDApplication.Entities;

public class AccountStat implements AccountStatus {

   public String accountStatus;

   @Override
   public String toString() {
      return "AccountStat{" +
              "accountStatus='" + accountStatus + '\'' +
              '}';
   }
}
