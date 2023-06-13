package org.example;

public class Plaza {
    boolean libre;
    int num, precio;

    public Plaza(int num) {
        this.num = num;
        libre=true;
        precio=15;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return String.format("PLAZA:%d;%b ",num,libre);
    }
}
