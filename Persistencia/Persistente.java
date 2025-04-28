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

    public void alteracao (Entidade entidade, int id) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId() == id) {
                array.set(i, entidade);
                return;
            }
        }
        System.out.println("ID não encontrado");
    }

    public void remover (int id) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId() == id) {
                array.remove(i);
                return;
            }
        }
        System.out.println("ID não encontrado");
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