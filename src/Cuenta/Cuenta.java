package Cuenta;

import javax.swing.*;

public  class Cuenta {
    protected float saldo;
    protected int numeroConsignaciones=0;
    protected int numeroRetiros=0;
    protected float tasaAnualPorcent;
    protected float comisionMensual=0;

    public Cuenta(float saldo, float tasaAnualPorcent) {
        this.saldo = saldo;
        this.tasaAnualPorcent = tasaAnualPorcent;
    }
    public void consignar(float cantidad){
        saldo=saldo+cantidad;
        numeroConsignaciones +=1;

    }
    public void retirar(float cantidad){
        float nuevoSaldo=saldo-cantidad;
        if(nuevoSaldo >=0){
            saldo -= cantidad;
            numeroRetiros +=1;
        }
        else{
            JOptionPane.showMessageDialog(null, "No tienes saldo suficiente", "Sin Saldo",
                    JOptionPane.ERROR_MESSAGE);

            System.out.println("La cantidad a retirar excede el saldo actual");

        }

    }
    public void calcularIntereses(){
        float   tasaMensual=tasaAnualPorcent/12;
        float interesMensual=saldo*tasaMensual;
        saldo += interesMensual;
    }
    public void extractoMensual(){
        saldo -= comisionMensual;
        calcularIntereses();

    }

}

