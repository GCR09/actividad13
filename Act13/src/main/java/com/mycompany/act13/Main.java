package com.mycompany.act13;

import java.util.*;

/**
 *
 * @author Cortez Ramos
 */
//Clase anónima
interface Sort {
    public void sortLong(List lista);
    public void sortAlf(List lista);
}

//Expresión lambda
interface SortLambda {
    List sort(List list);
}

//Método de referencia
interface SortReferencia {
    List sort(List list);
}

class Sorts{
    
    static List sortLong(List listaN) {
        Collections.sort(listaN);
        Collections.sort(listaN, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return listaN;
    }
    
    static List sortAlf(List listaN) {
        Collections.sort(listaN);
        return listaN;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList( "Charles", "Alex", "Brian"
                , "Carlos", "Antonio", "Jorge","Karen", "Elias", "Roman", "Alma");
        List lista = new ArrayList<String>();
        lista.addAll(namesList);
        
        System.out.println("Clase anónima;");
        Sort ordenar = new Sort() {
            public void sortLong(List lista) {
                Collections.sort(lista);
                Collections.sort(lista, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                });
                System.out.println("Ordenado por longitud:");
                System.out.println(lista);
            }
            
            public void sortAlf(List lista) {
                Collections.sort(lista);
                System.out.println("Ordenado por orden alfabético:");
                System.out.println(lista);
            }
        };
        ordenar.sortLong(lista);
        ordenar.sortAlf(lista);
        System.out.println("----------------------------------------");
        
        
        //******************************************************************************
        
        System.out.println("Expresión lambda;");
        SortLambda ordenaLong = (list) -> {
            Collections.sort(list);
            Collections.sort(lista, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });
            return list;
        };
        
        
        SortLambda ordenaAlf = (list) -> {
            Collections.sort(list);
            return list;
        };
        
        System.out.println("Ordenado por longitud:");
        System.out.println(ordenaLong.sort(lista));
        System.out.println("Ordenado por orden alfabético:");
        System.out.println(ordenaAlf.sort(lista));
        System.out.println("----------------------------------------");
        
        //******************************************************************************
        
        System.out.println("Método de referencia;");
        SortReferencia longitud = Sorts::sortLong;
        SortReferencia alfabetico = Sorts::sortAlf;
        System.out.println("Ordenado por longitud:");
        System.out.println(longitud.sort(lista));
        System.out.println("Ordenado por orden alfabético:");
        System.out.println(alfabetico.sort(lista));
        
    }
}
