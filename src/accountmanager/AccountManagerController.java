package accountmanager;

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
    public String getAccounts(String category, String accountType, String userName) throws FileNotFoundException{
        InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/accountmanager/accounts.json")); 
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Account>>(){}.getType();
        List<Account> allAccounts = gson.fromJson(reader, listType); 
        List<Account> accounts = new ArrayList<Account>();
        
        for(Account account : allAccounts){
            if(category == null || category.equals(account.getCategory())){
                if(accountType == null || accountType.equals(account.getAccountType())){
                    if(userName == null || userName.equals(account.getUserName())){
                        accounts.add(account);
                    }
                }
            }
        }
        
        String accountsJson = gson.toJson(accounts); 
        return accountsJson;
    }
}
