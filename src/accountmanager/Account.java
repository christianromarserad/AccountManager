package accountmanager;

/**
 *
 * @author Christian Serad
 */
public class Account {
    private String category;
    private String accountType;
    private String userName;
    private String password;
    
    public String getCategory(){
        return category;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getAccountType(){
        return accountType;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
