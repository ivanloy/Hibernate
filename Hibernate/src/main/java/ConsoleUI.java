import boundaries.ListarCriaturitasBoundary;
import entidades.Criaturita;

import javax.inject.Inject;
import java.util.Scanner;

public class ConsoleUI {

    public enum OptionsEnum{
        EXIT, LISTAR_CRIATURITAS
    }

    private ListarCriaturitasBoundary listarCriaturitasBoundary;

    private Scanner scanner;
    private OptionsEnum option;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        option = OptionsEnum.EXIT;
    }

    public void startApp(){
        appLoop();
    }

    private void appLoop() {
        do {
            printMenu();
            option = readOption();
            processOption();
        }while (option != OptionsEnum.EXIT);
    }

    private OptionsEnum readOption() {
        return OptionsEnum.values()[scanner.nextInt()];
    }

    private void processOption() {
        switch (option){
            case LISTAR_CRIATURITAS:
                listarCriaturitas();
                break;
            default:
                break;
        }
    }

    private void printMenu(){
        System.out.println(
                "Que quiere aseh tu, miarma?\n" +
                "0 - Exit\n" +
                "1 - Listar Criaturitas"
        );
    }

    private void listarCriaturitas() {
        for(Criaturita c : listarCriaturitasBoundary.getListadoCriaturitas())
            System.out.println(c.toString());
    }

    @Inject
    public void setListarCriaturitasBoundary(ListarCriaturitasBoundary listarCriaturitasBoundary){
        this.listarCriaturitasBoundary = listarCriaturitasBoundary;
    }

}


