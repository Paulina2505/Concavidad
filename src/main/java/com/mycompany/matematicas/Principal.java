/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.matematicas;

/**
 *
 * @author Paulina
 */
public class Principal {
    private static int posiciones[] = new int [7]; 
    public static void main(String[] args) {
        System.out.println("FUNCION: f(x)=x^4");
        System.out.println("PRIMER DERIVADA: f'(x)="+derivar(0,4));
        System.out.println("SEGUNDA DERIVADA: f''(x)="+derivar(4,3));
        System.out.println("f(0)="+f(0,0,4));
        System.out.println("f'(0)="+f(4,0,3));
        System.out.println("f''(0)="+f(12,0,2));
        System.out.println("\nG R A F I C A de f''(x)");
        System.out.println(graficar(12,2));
        System.out.println("\nDe acuerdo con la relación III, no es posible hacer afirmación alguna sobre la concavidad cuando x=0.\n" +
"Sin embargo, al sustituir valores de x en f y al graficar es obvio que la gráfica es cóncava hacia arriba");
    }
    
    public static String graficar(int cons, int pot) {
        String mostrar = "";
        int p[] = new int [7];
        int grafica[] = new int[7]; int g[] = new int[7];
        g[0] = (int)f(cons,-3,pot); p[0] = 0;
        g[1] = (int)f(cons,-2,pot); p[1] = 1;
        g[2] = (int)f(cons,-1,pot); p[2] = 2;
        g[3] = (int)f(cons,0,pot); p[3] = 3;
        g[4] = (int)f(cons,1,pot); p[4] = 4;
        g[5] = (int)f(cons,2,pot); p[5] = 5;
        g[6] = (int)f(cons,3,pot); p[6] = 6;
        int aux = -3;
        System.out.println(" x |  y");
        System.out.println("--------");
        for (int i = 0; i < 7; i++) {
            if (aux >= 0) System.out.println(" "+aux+" | "+g[i]);
            else System.out.println(aux+" | "+g[i]);
            aux ++;
            
        }
        grafica = burbuja(g,p);
        int saltos = grafica[0];
        for (int i = 0; i < 7; i++) grafica[i] = saltos-grafica[i];
        int puntos[] = new int[7]; int contP = 0;
        for (int i = 0; i <= saltos; i++) {
            for (int d = 0; d < 7; d++) {
                if (i == grafica[d]) {
                    mostrar += "\n";
                contP = 0;
                int cont = d; int otra  = 0;
                    try {
                        while (i == grafica[cont]) {
                    if (otra > 0) {
                        posiciones[cont] = posiciones[cont] - posiciones[cont-1];
                    }
                    grafica[cont] = 10000;
                    for (int j = 0; j < posiciones[cont]; j++) mostrar += " ";
                    mostrar += "P";
                    puntos[contP] = posiciones[cont]; contP ++;
                    cont ++; otra ++;
                }
                    } catch (Exception e) {
                    }
                
                } else {
                    mostrar += "\n";
                    for (int j = 0; j < contP; j++) {
                        for (int k = 0; k < puntos[j]; k++) mostrar += " ";
                        mostrar += "|";
                    }
                }
            } 
        }
        return mostrar;
    }
    
    public static double f(int cons, int x, int pot) {
        if (cons == 0) return Math.pow(x, pot);
        else return cons*(Math.pow(x, pot));
    }
    
    public static String derivar(int cons, int pot) {
        if (cons == 0) return ""+pot+"x^"+(pot-1);
        else return ""+(cons+pot)+"x^"+(pot-1);
    }
    
    public static int[] burbuja(int[] arreglo, int[] pos) {
      int auxiliar;
      int posicion;
      int[] arregloOrdenado = new int[7];
      for(int i = 2; i < arreglo.length; i++)
      {
        for(int j = 0;j < arreglo.length-i;j++)
        {
          if(arreglo[j] > arreglo[j+1])
          {
            auxiliar = arreglo[j];
            arreglo[j] = arreglo[j+1];
            arreglo[j+1] = auxiliar;
            
            posicion = pos[j];
            pos[j] = pos[j+1];
            pos[j+1] = posicion;
          }   
        }
      }
      int diez = 0;
        for (int i = 0; i < arreglo.length; i++) {
            arregloOrdenado[arreglo.length-i-1] = arreglo[i];
            posiciones[arreglo.length-i-1] = pos[i];
        }
        for (int i = 0; i < arreglo.length-1; i++) {
            if (arregloOrdenado[i] == arregloOrdenado[i+1]) {
                if (posiciones[i] > posiciones[i+1]) {
                    int auxx = posiciones[i];
                    posiciones[i] = posiciones[i+1];
                    posiciones[i+1] = auxx;
                }
            }
        }
      return arregloOrdenado;
    }
}
