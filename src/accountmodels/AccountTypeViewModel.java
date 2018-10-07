package accountmodels;

import java.util.ArrayList;

/**
 *
 * @author Christian Serad
 */
public class AccountTypeViewModel {
    private String category;
    private String accountType;
    
    public String getCategory(){
        return category;
    }
    
    public String getAccountType(){
        return accountType;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
}
