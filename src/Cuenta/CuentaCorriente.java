package Cuenta;

public class CuentaCorriente extends Cuenta{
    float sobregiro;

    public CuentaCorriente(float saldo, float tasa){
        super(saldo, tasa);
        sobregiro=0;

    }
    public void retirar(float cantidad){
        float saldotemporal=saldo-cantidad;

        if(saldotemporal<0){
            sobregiro=sobregiro-saldotemporal;
            saldo=0;
        }
        else{
            super.retirar(cantidad);
        }

    }
    public void consignar(float cantidad){
        float residuosobregiro=sobregiro-cantidad;

        if(sobregiro>0) {
            if (residuosobregiro>0) {
                sobregiro = 0;
                saldo = residuosobregiro;
            } else {
                sobregiro =-residuosobregiro;
                saldo = 0;
            }
        }
        else {
            super.consignar(cantidad);

        }

    }
    public void extractoMensual(){
        super.extractoMensual();
    }
    public void imprimir(){
        System.out.println("Saldo = $ "+saldo);
        System.out.println("Cargo mensual = $ "+comisionMensual);
        System.out.println("Numero de transacciones = "+(numeroConsignaciones+numeroRetiros));
        System.out.println("Valor de sobregiro = $"+(numeroConsignaciones+numeroRetiros));
        System.out.println();

    }

}
