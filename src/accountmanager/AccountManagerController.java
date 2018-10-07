package accountmanager;

import accountmodels.Account;
import accountmodels.AccountCategory;
import accountmodels.AccountType;
import accountmodels.AccountTypeViewModel;
import accountmodels.AccountViewModel;
import accountmodels.CategoryViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Serad
 */
public class AccountManagerController { 
    public List<AccountCategory> getAccounts() throws FileNotFoundException{
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/accountmanager/accounts.json")); 
        Gson gson = new Gson();
        Type listType = new TypeToken<List<AccountCategory>>(){}.getType();
        List<AccountCategory> allAccounts = gson.fromJson(reader, listType); 
        return allAccounts;
    }
    
    public String getAccountViewModel(String categoryName, String accountTypeName) throws FileNotFoundException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        ArrayList<AccountViewModel> accountViewModels = new ArrayList<AccountViewModel>();
        
        for(AccountCategory accountCategory : allAccounts){
            if(accountCategory.getCategory().equals(categoryName) || categoryName == null){
                
                for(AccountType accountType : accountCategory.getAccountTypes()){
                    if(accountType.getAccountType().equals(accountTypeName) || accountTypeName == null){
                        
                        for(Account account : accountType.getAccounts()){
                            AccountViewModel accountViewModel = new AccountViewModel();
                            accountViewModel.setAccountType(accountType.getAccountType());
                            accountViewModel.setCategory(accountCategory.getCategory());
                            accountViewModel.setUserName(account.getUserName());
                            accountViewModels.add(accountViewModel);
                        }
                    }
                }
            }
        }
        
        String categoryViewModelJson = gson.toJson(accountViewModels);
        return categoryViewModelJson;
    }
    
    public String getAccountTypeViewModel(String categoryName) throws FileNotFoundException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        ArrayList<AccountTypeViewModel> accountTypeViewModels = new ArrayList<AccountTypeViewModel>();
        
        for(AccountCategory accountCategory : allAccounts){
            if(accountCategory.getCategory().equals(categoryName) || categoryName == null){
                
                for(AccountType accountType : accountCategory.getAccountTypes()){
                    AccountTypeViewModel accountTypeViewModel = new AccountTypeViewModel();
                    accountTypeViewModel.setAccountType(accountType.getAccountType());
                    accountTypeViewModel.setCategory(accountCategory.getCategory());
                    accountTypeViewModels.add(accountTypeViewModel);
                }
            }
        }
        
        String categoryViewModelJson = gson.toJson(accountTypeViewModels);
        return categoryViewModelJson;
    }
    
    public String getCategoryViewModel() throws FileNotFoundException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        ArrayList<CategoryViewModel> categoryViewModels = new ArrayList<CategoryViewModel>();
        
        for(AccountCategory category : allAccounts){
            CategoryViewModel categoryViewModel = new CategoryViewModel();
            categoryViewModel.setCategory(category.getCategory());
            categoryViewModels.add(categoryViewModel);
        }
        
        String categoryViewModelJson = gson.toJson(categoryViewModels);
        return categoryViewModelJson;
    }
}
