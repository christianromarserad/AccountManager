package accountmodels;

/**
 *
 * @author Christian Serad
 */
public class AccountDetailViewModel {
    private String category;
    private String accountType;
    private String username; 
    private String password;
    
    public String getCategory(){
        return category;
    }
    
    public String getAccountType(){
        return accountType;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
