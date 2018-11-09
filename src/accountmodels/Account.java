package accountmodels;

import java.util.HashMap;

/**
 *
 * @author Christian Serad
 */
public class Account {
    private HashMap<String, String> accountDetails = new HashMap<String, String>();
    
    public String get(String field){
        return accountDetails.get(field);
    }
    
    public void set(String field, String value){
        accountDetails.put(field,value);
    }
    
    public void remove(String field){
        accountDetails.remove(field);
    }
}
