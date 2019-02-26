import boundaries.ListarCriaturitasBoundary;
import boundaries.ListarRegalosBoundary;
import boundaries.ModificarCriaturitaBoundary;
import boundaries.ModificarRegaloBoundary;
import entidades.Criaturita;
import entidades.Regalo;

import javax.inject.Inject;
import java.util.Scanner;

public class ConsoleUI {

    public enum OptionsEnum{
        EXIT, LISTAR_CRIATURITAS, LISTAR_REGALOS, CRIATURITA_CON_REGALOS, QUITAR_REGALO_A_CRIATURITA,
        NOT_EXISTENT_OPTION
    }

    private ListarCriaturitasBoundary listarCriaturitasBoundary;
    private ListarRegalosBoundary listarRegalosBoundary;
    private ModificarCriaturitaBoundary modificarCriaturitaBoundary;

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

    private int readIntAbsoluteValue() throws NumberFormatException {
        return Math.abs(Integer.valueOf(scanner.nextLine()));
    }

    private OptionsEnum readOption() {
        return OptionsEnum.values()[getTrimmedMenuOptionIntAbsoluteValue()];
    }

    private int getTrimmedMenuOptionIntAbsoluteValue(){
        int notExistentOption = OptionsEnum.NOT_EXISTENT_OPTION.ordinal();
        int optionSelected = notExistentOption;
        try {
             optionSelected = readIntAbsoluteValue();
        }
        catch (NumberFormatException e){}

        return optionSelected <= OptionsEnum.values().length ?
                optionSelected : notExistentOption;
    }


    private void processOption() {
        switch (option){
            case LISTAR_CRIATURITAS:
                listarCriaturitas();
                break;
            case LISTAR_REGALOS:
                listarRegalos();
                break;
            case CRIATURITA_CON_REGALOS:
                listarCriaturitaConRegalos();
                break;
            case QUITAR_REGALO_A_CRIATURITA:
                quitarRegaloACriaturita();
                break;
            default:
                break;
        }
    }

    private void printMenu(){
        System.out.println(
                "Que quiere aseh tu, miarma?\n" +
                "0 - Exit\n" +
                "1 - Listar Criaturitas\n" +
                "2 - Listar Regalos\n" +
                "3 - Criaturita con Regalos\n" +
                "4 - Quitar regalo a criaturita"
        );
    }

    private void listarCriaturitas() {
        for(Criaturita c : listarCriaturitasBoundary.getListadoCriaturitas())
            System.out.println(c.toString());
    }

    private void listarRegalos() {
        for(Regalo r : listarRegalosBoundary.getListadoRegalos())
            System.out.println(r.toString());
    }

    private void listarCriaturitaConRegalos() {
        listarCriaturitas();
        System.out.println("De que criaturita, surmano?");
        try {
            listarRegalos(readIntAbsoluteValue());
        }catch (NumberFormatException e){}
    }

    private void quitarRegaloACriaturita() {
        listarCriaturitaConRegalos();
        System.out.println("Que regalito, surmano?");
        try {
            modificarCriaturitaBoundary.quitarRegalo(readIntAbsoluteValue());
        }catch (NumberFormatException e){}

    }
    private void listarRegalos(int idCriaturita) {
        for(Regalo r : listarRegalosBoundary.getListadoRegalos(idCriaturita))
            System.out.println(r.toString());
    }

    @Inject
    public void setListarCriaturitasBoundary(ListarCriaturitasBoundary listarCriaturitasBoundary){
        this.listarCriaturitasBoundary = listarCriaturitasBoundary;
    }

    @Inject
    public void setListarRegalosBoundary(ListarRegalosBoundary listarRegalosBoundary){
        this.listarRegalosBoundary = listarRegalosBoundary;
    }

    @Inject
    public void setModificarRegaloBoundary(ModificarCriaturitaBoundary modificarCriaturitaBoundary){
        this.modificarCriaturitaBoundary = modificarCriaturitaBoundary;
    }
}


