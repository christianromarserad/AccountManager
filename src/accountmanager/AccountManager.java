/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanager;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

/**
 *
 * @author Christian Serad
 */
public class AccountManager extends Application {
    private AccountManagerController controller;
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        WebView browser = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        WebEngine webEngine = browser.getEngine();
        URL urlHello = getClass().getResource("/resources/index.html");
        webEngine.load(urlHello.toExternalForm());
        
        
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
