package Persistencia;

public class IdNotFoundException extends Exception {
    public IdNotFoundException(int arg){
        super("Id não encontrado: " + arg);
    }
}