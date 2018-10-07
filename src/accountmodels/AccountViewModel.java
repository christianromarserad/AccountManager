package accountmodels;

/**
 *
 * @author Christian Serad
 */
public class AccountViewModel {
    private String category;
    private String accountType;
    private String userName;
    
    public String getCategory(){
        return category;
    }
    
    public String getAccountType(){
        return accountType;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
}


