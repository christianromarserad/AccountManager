package accountmodels;

/**
 *
 * @author Christian Serad
 */
public class AccountDetailViewModel {
    private String category;
    private String accountType;
    private Account account;
    
    public String getCategory(){
        return category;
    }
    
    public String getAccountType(){
        return accountType;
    }
    
    public Account getAccount(){
        return account;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public void setAccount(Account account){
        this.account = account;
    }
}
