package accountmanager;

import accountmodels.Account;
import accountmodels.AccountCategory;
import accountmodels.AccountDetailViewModel;
import accountmodels.AccountType;
import accountmodels.AccountTypeViewModel;
import accountmodels.AccountViewModel;
import accountmodels.CategoryViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Serad
 */
public class AccountManagerController { 
    public List<AccountCategory> getAccounts() throws URISyntaxException, FileNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        //InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/accountmanager/accounts.json")); 
        Gson gson = new Gson();
        Type listType = new TypeToken<List<AccountCategory>>(){}.getType();
        List<AccountCategory> allAccounts = gson.fromJson(new InputStreamReader(fileInputStream), listType); 
        return allAccounts;
    }
    
    public String getAccountDetailsViewModel(String categoryName, String accountTypeName, String userName) throws FileNotFoundException, URISyntaxException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        ArrayList<AccountDetailViewModel> accountDetailsViewModels = new ArrayList<AccountDetailViewModel>();
        
        for(AccountCategory accountCategory : allAccounts){
            if(accountCategory.getCategory().equals(categoryName)){
                
                for(AccountType accountType : accountCategory.getAccountTypes()){
                    if(accountType.getAccountType().equals(accountTypeName)){
                        
                        for(Account account : accountType.getAccounts()){
                            if(account.get("userName").equals(userName)){
                                AccountDetailViewModel accountDetailViewModel = new AccountDetailViewModel();
                                accountDetailViewModel.setCategory(categoryName);
                                accountDetailViewModel.setAccountType(accountTypeName);
                                accountDetailViewModel.setAccount(account);
                                accountDetailsViewModels.add(accountDetailViewModel);
                            }
                        }
                    }
                }
            }
        }
        
        String accountDetailsViewModelJson = gson.toJson(accountDetailsViewModels);
        return accountDetailsViewModelJson;
    }
    
    public String getAccountViewModel(String categoryName, String accountTypeName) throws FileNotFoundException, URISyntaxException{
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
                            accountViewModel.setUserName(account.get("userName"));
                            accountViewModels.add(accountViewModel);
                        }
                    }
                }
            }
        }
        
        String accountsViewModelJson = gson.toJson(accountViewModels);
        return accountsViewModelJson;
    }
    
    public String getAccountTypeViewModel(String categoryName) throws FileNotFoundException, URISyntaxException{
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
        
        String accountTypesViewModelJson = gson.toJson(accountTypeViewModels);
        return accountTypesViewModelJson;
    }
    
    public String getCategoryViewModel() throws FileNotFoundException, URISyntaxException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        ArrayList<CategoryViewModel> categoryViewModels = new ArrayList<CategoryViewModel>();
        
        for(AccountCategory category : allAccounts){
            CategoryViewModel categoryViewModel = new CategoryViewModel();
            categoryViewModel.setCategory(category.getCategory());
            categoryViewModels.add(categoryViewModel);
        }
        
        String categoriesViewModelJson = gson.toJson(categoryViewModels);
        return categoriesViewModelJson;
    }
    
    public boolean editCategory(String oldCategoryName, String newCategoryName) throws FileNotFoundException, URISyntaxException, IOException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        
        for(AccountCategory category : allAccounts){
            if(category.getCategory().equals(oldCategoryName)){
                category.setCategory(newCategoryName);
                System.out.println("oh hey!");
            }
        }

        FileWriter writer = new FileWriter(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        gson.toJson(allAccounts, writer);
        writer.close();
        return true;
        
        //Not fully implemented
    }
    
    public boolean editAccountType(String categoryName, String oldAccountTypeName, String newAccountTypeName) throws FileNotFoundException, URISyntaxException, IOException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        
        for(AccountCategory category : allAccounts){
            if(category.getCategory().equals(categoryName)){
                for(AccountType accountType : category.getAccountTypes()){
                    if(accountType.getAccountType().equals(oldAccountTypeName)){
                        accountType.setAccountType(newAccountTypeName);
                    }
                }
            }
        }
        
        FileWriter writer = new FileWriter(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        gson.toJson(allAccounts, writer);
        writer.close();
        
        return true;
        
        //Not fully implemented
    }
    
    public boolean editAccount(String categoryName, String accountTypeName, String username, String field, String oldFieldValue, String newFieldValue) throws FileNotFoundException, URISyntaxException, IOException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        
        for(AccountCategory category : allAccounts){
            if(category.getCategory().equals(categoryName)){
                for(AccountType accountType : category.getAccountTypes()){
                    if(accountType.getAccountType().equals(accountTypeName)){
                        for(Account account : accountType.getAccounts()){
                            if(account.get("userName").equals(username)){
                                account.set(field, newFieldValue);
                                System.out.println(newFieldValue);
                            }
                        }
                    }
                }
            }
        }
        
        FileWriter writer = new FileWriter(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        gson.toJson(allAccounts, writer);
        writer.close();
        
        return true;
        
        //Not fully implemented
    }
    
    public void deleteCategory(String categoryName) throws URISyntaxException, FileNotFoundException, IOException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        
        for(int i = 0; i < allAccounts.size(); i++){
            if(allAccounts.get(i).getCategory().equals(categoryName)){
                allAccounts.remove(i);
                break;
            }
        }

        FileWriter writer = new FileWriter(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        gson.toJson(allAccounts, writer);
        writer.close();
        
        //Not fully implemented
    }
    
        public void deleteAccountType(String categoryName, String accountTypeName) throws URISyntaxException, FileNotFoundException, IOException{
        List<AccountCategory> allAccounts = getAccounts();
        Gson gson = new Gson();
        
        for(AccountCategory category: allAccounts){
            if(category.getCategory().equals(categoryName)){
                for(int i = 0; i < category.getAccountTypes().size(); i++){
                    if(category.getAccountTypes().get(i).getAccountType().equals(accountTypeName)){
                        category.getAccountTypes().remove(i);
                        break;
                    }
                }
            }
        }

        FileWriter writer = new FileWriter(Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString() + "/accounts.json");
        gson.toJson(allAccounts, writer);
        writer.close();
        
        //Not fully implemented
    }
}
