package accountmodels;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Serad
 */
public class AccountCategory {
    private String category;
    private List<AccountType> accountTypes;
    
    public AccountCategory(String categoryName){
        category = categoryName;
        accountTypes = new ArrayList<AccountType>();
    }
    
    public String getCategory(){
        return category;
    }
    
    public List<AccountType> getAccountTypes(){
        return accountTypes;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setAccountTypes(List<AccountType> accountTypes){
        this.accountTypes = accountTypes;
    }
}
