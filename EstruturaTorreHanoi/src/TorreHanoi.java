import java.util.Scanner;
import java.util.Stack;

public class TorreHanoi {
    public static int Num;
    // SE CREA LA PILA CON ARRAY
    public static Stack<Integer> varilla_torre[]= new Stack[4];

    public static void torre(int numero){
        for(int disco=numero; disco>0; disco--)
            varilla_torre[1].push(disco);
        mostrarMovimiento();
        movimiento(numero, 1,2,3);
    }

    public static void movimiento(int numero, int posicionA, int posicionB, int posicionC){
        if(numero>0){
            movimiento(numero -1, posicionA, posicionC, posicionB);
            int d= varilla_torre[posicionA].pop();
            varilla_torre[posicionC].push(d);
            mostrarMovimiento();
            movimiento(numero-1, posicionB, posicionA, posicionC);
        }
    }

    public static void mostrarMovimiento(){
        System.out.println("  VARILLA A  |  VARILLA B  |  VARILLA C");
        System.out.println("-------------------------------------------------------");
        for(int i=Num-1; i>=0; i--){
            String direccion1=" ", direccion2=" ", direccion3=" ";
            try{
                direccion1=String.valueOf(varilla_torre[1].get(i));
            }
            catch(Exception e){          
            }
            try{
                direccion2=String.valueOf(varilla_torre[2].get(i));
            }
            catch(Exception e){
            }
            try{
                direccion3=String.valueOf(varilla_torre[3].get(i));
            }
            catch(Exception e){
            }
            System.out.println("      "+direccion1+"      |  "+direccion2+"           |  "+direccion3);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); int num;
        varilla_torre[1]= new Stack<Integer>();
        varilla_torre[2]= new Stack<Integer>();
        varilla_torre[3]= new Stack<Integer>();
        System.out.println("*****\t\t\tBIENVENIDO AL PROGRAMA\t\t\t*****");
        System.out.println("\n\t\t\tTORRES DE HANOI\t");   
        System.out.print("\nDIGITE EL NUMERO DE DISCOS: ");
        num= entrada.nextInt();
        Num=num;
        torre(num);
    }
}
