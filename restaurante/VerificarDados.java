package restaurante;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class VerificarDados {
    public static void main(String[] args) {
        verificarMesas();
        verificarMenu();
        verificarListaDeEspera();
    }

    private static void verificarMesas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mesas.ser"))) {
            ArrayList<Mesa> mesas = (ArrayList<Mesa>) ois.readObject();
            System.out.println("Mesas:");
            mesas.forEach(mesa -> System.out.println("Mesa " + mesa.getNumeroAssentos() + " lugares: " + (mesa.isDisponivel() ? "Disponível" : "Ocupada")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void verificarMenu() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("menu.ser"))) {
            Menu menu = (Menu) ois.readObject();
            System.out.println("Menu:");
            System.out.println(menu.imprimirMenu());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void verificarListaDeEspera() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("listaDeEspera.ser"))) {
            ListaDeEspera listaDeEspera = (ListaDeEspera) ois.readObject();
            System.out.println("Lista de Espera:");
            System.out.println(listaDeEspera.imprimirLista());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
