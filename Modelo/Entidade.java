package Modelo;
public abstract class Entidade {
    private int id;

    public Entidade (int id) {
        this.id = id;
    }

    public int getId () {
        return this.id;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Override
    public String toString () {
        return id + "\n";
    }
}
