package Persistencia;

import java.util.ArrayList;

import Modelo.Entidade;

//Lista de objetos genérica para qualquer entidade

public class Persistente <T extends Entidade> {
    ArrayList<T> array;

    public Persistente () {
        array = new ArrayList<T>();
    }

    public void insercao (T entidade) {
        array.add(entidade);
    }

    public void alteracao (T entidade) throws IdNotFoundException {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId() == entidade.getId()) {
                array.set(i, entidade);
                return;
            }
        }
        throw new IdNotFoundException(entidade.getId());
    }

    public void remover (int id) throws IdNotFoundException {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId() == id) {
                array.remove(i);
                return;
            }
        }
        throw new IdNotFoundException(id);
    }

    public ArrayList<T> getArray () {
        return array;
    }

    public T procuraId (int id) throws IdNotFoundException {
        for (T i : array) {
            if (i.getId() == id) {
                return i;
            }
        }
        throw new IdNotFoundException(id);
    }

    @Override
    public String toString () {
        String retornoTotal = "";
        for (T i : array) {
            retornoTotal += i + "\n";
        }
        return retornoTotal;
    }
}