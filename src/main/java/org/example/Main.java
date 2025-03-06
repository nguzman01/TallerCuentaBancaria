package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); //obtener la entrada del usuario
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>(); // implementa una lista dinámica, donde permite agregar, eliminar y acceder a los elementos
        boolean continuar = true; //Inicializa la variable continuar como verdadera controla el bucle while e indica cuando debe detenerse

        while (continuar) {
            System.out.println("\n MENU CUENTA BANCARIA");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Mostrar cuentas registradas");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Mostrar información actualizada");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:// Crear una cuenta

                    System.out.println("\n-CREAR CUENTA");
                    System.out.println("Ingrese el nombre del titular:");
                    String titular = teclado.nextLine();
                    System.out.println("Ingrese el número de cuenta:");
                    String numeroCuenta = teclado.nextLine();
                    System.out.println("Ingrese el saldo inicial:");
                    double saldo = teclado.nextDouble();

                    // Crear y agregar la cuenta a la lista
                    cuentas.add(new CuentaBancaria(titular, numeroCuenta,saldo));
                    System.out.println("¡La cuenta fue registrada con éxito!");
                    break;

                case 2:// Mostrar cuentas registradas

                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas.");
                    } else {
                        System.out.println("\n-CUENTAS REGISTRADAS-");
                        for (CuentaBancaria cuenta : cuentas) {
                            cuenta.mostrarinformacion();
                            System.out.println("----------------------");
                        }
                    }
                    break;
                case 3: // Depositar dinero
                    System.out.println("DEPOSITAR DINERO A UNA CUENTA");
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas. Registre una cuenta primero.");
                        break;
                    }

                    // Listar números de cuentas registradas con índices
                    System.out.println("Cuentas registradas:");
                    for (int i = 0; i < cuentas.size(); i++) {
                        System.out.println((i + 1) + ". Número de cuenta: " + cuentas.get(i).getNumeroCuenta());
                    }

                    // Solicitar al usuario que seleccione una cuenta por número
                    System.out.print("Seleccione el número de cuenta para depositar: ");
                    int seleccionDeposito = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de línea restante

                    // Verificar si la selección es válida
                    if (seleccionDeposito > 0 && seleccionDeposito <= cuentas.size()) {
                        CuentaBancaria cuentaSeleccionadaDeposito = cuentas.get(seleccionDeposito - 1); // Obtener la cuenta seleccionada
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = teclado.nextDouble();
                        teclado.nextLine(); // Consumir el salto de línea restante
                        cuentaSeleccionadaDeposito.consignar(cantidadDeposito);
                    } else {
                        System.out.println("Selección inválida. Por favor, elija un número de cuenta válido.");
                    }
                    break;

                case 4: // Retirar dinero
                    System.out.println("RETIRAR DINERO DE UNA CUENTA");
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas. Registre una cuenta primero.");
                        break;
                    }

                    // Listar números de cuentas registradas con índices
                    System.out.println("Cuentas registradas:");
                    for (int i = 0; i < cuentas.size(); i++) {
                        System.out.println((i + 1) + ". Número de cuenta: " + cuentas.get(i).getNumeroCuenta());
                    }

                    // Solicitar al usuario que seleccione una cuenta por número
                    System.out.print("Seleccione el número de cuenta para retirar: ");
                    int seleccionRetiro = teclado.nextInt();
                    teclado.nextLine(); // Consumir el salto de línea restante

                    // Verificar si la selección es válida
                    if (seleccionRetiro > 0 && seleccionRetiro <= cuentas.size()) {
                        CuentaBancaria cuentaSeleccionadaRetiro = cuentas.get(seleccionRetiro - 1); // Obtener la cuenta seleccionada
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRetiro = teclado.nextDouble();
                        teclado.nextLine(); // Consumir el salto de línea restante
                        cuentaSeleccionadaRetiro.retirar(cantidadRetiro);
                    } else {
                        System.out.println("Selección inválida. Por favor, elija un número de cuenta válido.");
                    }
                    break;

                case 5://Mostar informacion actualizada

                    System.out.println("MOSTRAR IFORMACION");
                    // mostar informacion  actualizada buscando la cuenta
                    System.out.println("Ingrese el número de cuenta para mostrar información:");
                    String cuentaInfo = teclado.nextLine();
                    CuentaBancaria cuentaSeleccionadaInfo = buscarCuenta(cuentas, cuentaInfo);

                    if (cuentaSeleccionadaInfo != null) {
                        cuentaSeleccionadaInfo.mostrarinformacion();
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;

                case 6:
                    // Salir del programa
                    continuar = false;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        teclado.close();
    }

    // metodo buscarCuenta estatico se llama sin necesidad de hacer una instancia
    //este metodo es para buscar una cuenta por numero de cuenta

    private static CuentaBancaria buscarCuenta(ArrayList<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null; // Si no se encuentra la cuenta
    }
}

















 /*case 3:
                    // Depositar dinero
                    System.out.println("Ingrese el número de cuenta para depositar:");
                    String cuentaDeposito = teclado.nextLine();
                    CuentaBancaria cuentaSeleccionadaDeposito = buscarCuenta(cuentas, cuentaDeposito);

                    if (cuentaSeleccionadaDeposito != null) {
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = teclado.nextDouble();
                        cuentaSeleccionadaDeposito.consignar(cantidadDeposito);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;*/
               /* case 3:// Depositar dinero

                    System.out.println("DEPOSITAR DINERO A UNA CUENTA");
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas. Registre una cuenta primero.");
                        break;
                    }

                    // Listar números de cuentas registradas
                    System.out.println("Cuentas registradas:");
                    // for --> Iterar sobre la lista de cuentas y mostar el numero de cuenta
                    for (CuentaBancaria cuenta : cuentas) {
                        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
                        System.out.println("----------------------");
                    }

                    // Solicitar el número de cuenta para depositar
                    System.out.println("Ingrese el número de cuenta para depositar:");
                    String cuentaDeposito = teclado.nextLine();
                    CuentaBancaria cuentaSeleccionadaDeposito = buscarCuenta(cuentas, cuentaDeposito);

                    // Verificar si la cuenta existe
                    if (cuentaSeleccionadaDeposito != null) {
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = teclado.nextDouble();
                        cuentaSeleccionadaDeposito.consignar(cantidadDeposito);
                    } else {
                        System.out.println("Cuenta no encontrada.Ingresar un número de cuenta válido.");
                    }
                    break;

                case 4: // Retirar dinero

                    System.out.println("RETIRAR DINERO DE UNA CUENTA");
                    System.out.println("Ingrese el número de cuenta para retirar:");
                    String cuentaRetiro = teclado.nextLine();
                    CuentaBancaria cuentaSeleccionadaRetiro = buscarCuenta(cuentas, cuentaRetiro);

                    if (cuentaSeleccionadaRetiro != null) {
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidadRetiro = teclado.nextDouble();
                        cuentaSeleccionadaRetiro.retirar(cantidadRetiro);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                    break;*/
                    /*case 5://Mostar informacion actualizada

                            // Mostrar información actualizada de todas las cuentas
                    /*System.out.println("Mostrar Informacion Actualizada");

                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas registradas.");
                    } else {
                        System.out.println("--- Información Actualizada de Todas las Cuentas ---");
                        for (CuentaBancaria cuenta : cuentas) {
                            cuenta.mostrarinformacion();
                            System.out.println("----------------------"); // Separador entre cuentas
                        }
                    }

                            break;*/