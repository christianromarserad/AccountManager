/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanager;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import java.nio.file.Paths;

/**
 *
 * @author Christian Serad
 */
public class AccountManager extends Application {
    private AccountManagerController controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException{
        WebView browser = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        WebEngine webEngine = browser.getEngine();
        URL urlHello = getClass().getResource("/resources/index.html");
        webEngine.load(urlHello.toExternalForm());
        
        
        String path = Paths.get(AccountManager.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().getParent().toString();
        System.out.println(path);
        File file = new File(path + "/accounts.json");
        
        if(!file.createNewFile()){
            System.out.println("file already exist");
        }
        
        controller = new AccountManagerController();
        JSObject window = (JSObject) webEngine.executeScript("window");
        window.setMember("accountController", controller);
        
        Scene scene = new Scene(browser, 1000, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
