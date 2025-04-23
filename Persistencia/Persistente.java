package Persistencia;

import java.util.ArrayList;

import Modelo.Entidade;

//Lista de objetos genérica para qualquer entidade

public class Persistente {
    ArrayList<Entidade> array;

    public Persistente () {
        array = new ArrayList<Entidade>();
    }

    public void insercao (Entidade entidade) {
        array.add(entidade);
    }

    public void alteracao (Entidade entidade, int indice) {
        array.set(indice, entidade);
    }

    public void remover (int indice) {
        array.remove(indice);
    }

    public ArrayList<Entidade> getArray () {
        return array;
    }

    public Entidade procuraId (int id) {
        for (Entidade i : array) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public String toString () {
        String retornoTotal = "";
        for (Entidade i : array) {
            retornoTotal += i + "\n";
        }
        return retornoTotal;
    }
}