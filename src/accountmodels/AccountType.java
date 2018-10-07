package accountmodels;

import java.util.List;

/**
 *
 * @author Christian Serad
 */
public class AccountType {
    private String accountType;
    private List<Account> accounts;
    
    public String getAccountType(){
        return accountType;
    }
    
    public List<Account> getAccounts(){
        return accounts;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
}
