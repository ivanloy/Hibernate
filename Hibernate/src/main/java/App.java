/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());

        ConsoleUI consoleUI = injector.getInstance(ConsoleUI.class);
        injector.injectMembers(consoleUI);

        consoleUI.startApp();
        System.exit(1);
    }
    
}
