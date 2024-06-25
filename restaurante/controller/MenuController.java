package restaurante.controller;

import restaurante.model.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MenuController {
    private Menu menu;

    public MenuController() {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.ser"))) {
            menu = (Menu) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            menu = new Menu();
        }
    }

    public Menu getMenu() {
        return menu;
    }
}
