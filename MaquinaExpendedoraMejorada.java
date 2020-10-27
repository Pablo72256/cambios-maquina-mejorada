public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Variable para saber el tipo de maquina
    private String tipoDeMaquina;
    // Cantidad de billetes
    private int cantidadDeBilletes;
    //Cantidad de billetes maximos
    private int maximoDeBilletes;


    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, String tipoDeLaMaquina, int maximoDeLosBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        cantidadDeBilletes = 0;
        maximoDeBilletes = maximoDeLosBilletes;
        tipoDeMaquina = tipoDeLaMaquina;
        estacionOrigen = origen;
        estacionDestino = destino;
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }
    
    /**
     * Devuelve el numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return cantidadDeBilletes;
    }
    
    /**
     * Vacia toda la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int dineroDevolver = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual <= 0){
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            dineroDevolver = -1;
        }
        return dineroDevolver;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    
    /**
     * Imprime por pantalla el numero de billetes vendidos.
     */
    public void imprimeNumeroBilletesVendidos() {
            // Simula la cuenta de los billetes vendidos.
            System.out.println("##################");
            System.out.println("# Cantidad de billetes vendidos:");
            System.out.println("##################");
            System.out.println(cantidadDeBilletes);
            System.out.println();
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadDeBilletes >= maximoDeBilletes){
            System.out.println("Cantidad maxima de billetes cubierta");
        }
        else {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
               
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual ;
        if (cantidadDeBilletes >= maximoDeBilletes){
            System.out.println("Cantidad maxima de billetes cubierta");
        }
        else {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                if (tipoDeMaquina == "premio"){
                    System.out.println("Enhorabuena, ha ganado un descuento del 10 por ciento del coste del billete para compras en el comercio que tu elijas");
                }
                System.out.println("##################");
                System.out.println();         
        
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //Suma en 1 la cantidad de billetes vendidos
                cantidadDeBilletes = cantidadDeBilletes + 1;
                
                }
                else {
                    System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                        
                }
          }
                    
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
