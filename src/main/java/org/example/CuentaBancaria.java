package org.example;
import java.text.NumberFormat;
import java.util.Locale;

public class CuentaBancaria {
    //atributos
    private String Titular;
    private String NumeroCuenta;
    private double Saldo;

    //contructores

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, String numeroCuenta, double saldo) {
        this.Titular = titular;
        this.NumeroCuenta = numeroCuenta;
        this.Saldo = saldo;
    }

    // metodos get y set


    public String getTitular() {
        return Titular;
    }
    public String getNumeroCuenta() {
        return NumeroCuenta;
    }
    public double getSaldo() {
        return Saldo;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }
    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    // toString


   // @Override
    /*public String toString() {
        return super.toString();
    }*/

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "Titular='" + Titular + '\'' +
                ", NumeroCuenta='" + NumeroCuenta + '\'' +
                ", Saldo=" + Saldo +
                '}';
    }

    //  metodo para consignar
    public void consignar( double valor){
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO")); // Para dar formato en pesos colombianos
        if(valor > 0 ){
            Saldo += valor;
            System.out.println("se ha consignado "+ formatoMoneda.format(valor) + " a nombre de " + Titular);

        }else {

            System.out.println("la valor a consignar debe ser superior a cero");
        }

    }

    // metodo para retirar

    public void retirar(double valor){
        // Crear un formateador de números para la moneda
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        if(valor > 0 && valor <= Saldo){
            Saldo -= valor;
            System.out.println("Se ha retirado "+ formatoMoneda.format(valor) + ". de la cuenta le queda un saldo de " + formatoMoneda.format(Saldo) + ".");
        }else{
            System.out.println("Su saldo es Inferior al valor solicitada");

        }

    }
     //metodo mostrar para informacion
    public void mostrarinformacion(){
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        System.out.println("El tutular de la cuenta es: " + Titular);
        System.out.println("El numero de cuenta es: " + NumeroCuenta);
        System.out.println("El saldo que tiene es de: " + formatoMoneda.format(Saldo));

    }


}
