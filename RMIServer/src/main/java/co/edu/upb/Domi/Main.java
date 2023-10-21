package co.edu.upb.Domi;

import java.util.Scanner;

public class Main {
    private static int[][] grafo;
    private static int[] distance;

    public static void main(String[] args) {
        boolean finPrograma = false;
        Scanner sc = new Scanner(System.in);
        grafo = crearGrafo(31);
        /*crearConexion(1, 2, 3);
        crearConexion(1, 3, 5);
        crearConexion(1, 4, 4);
        crearConexion(1, 30, 20);

        crearConexion(2, 3,3);

        crearConexion(3, 4,5);
        crearConexion(3, 13,3);
        crearConexion(3, 14,5);

        crearConexion(4,5, 4);
        crearConexion(4,15, 7);

        crearConexion(5,15, 3);
        crearConexion(5,6, 4);
        crearConexion(5,16, 5);
        crearConexion(5,7, 3);
        crearConexion(5,30, 15);


        crearConexion(6,15,3);
        crearConexion(6,8,7);
        crearConexion(6,9,5);
        crearConexion(6,12,8);
        crearConexion(6,7,4);
        crearConexion(6,13,9);

        crearConexion(7,8,2);
        crearConexion(7,16,6);

        crearConexion(8,9,4);
        crearConexion(8,10,4);
        crearConexion(8,11,6);
        crearConexion(8,16,6);

        crearConexion(9,12, 7);
        crearConexion(9,17, 6);
        crearConexion(9,10,3);
        crearConexion(9,19,5);

        crearConexion(10,11,5);
        crearConexion(10,10,1);
        crearConexion(10,19,4);
        crearConexion(10,21,5);
        crearConexion(10,26,10);

        crearConexion(11,16, 5);
        crearConexion(11,30,10);

        crearConexion(12,13,5);
        crearConexion(12,17, 6);

        crearConexion(13,14,2);
        crearConexion(13,15,3);

        crearConexion(17,18,7);

        crearConexion(18,23,8);
        crearConexion(18,22,7);
        crearConexion(18,19,7);

        crearConexion(19,22,6);
        crearConexion(19,20,7);
        crearConexion(19,21,7);

        crearConexion(20,22,5);
        crearConexion(20,23,7);
        crearConexion(20,24,5);
        crearConexion(20,25,9);

        crearConexion(21,25,7);

        crearConexion(22,23,7);

        crearConexion(23,24,4);

        crearConexion(24,25,7);

        crearConexion(26,27,3);
        crearConexion(26,29,3);

        crearConexion(27,28,3);
        crearConexion(27,29,3);

        crearConexion(28,30,3);
        crearConexion(28,29,3);

        crearConexion(29,30,3);*/

        crearConexion(1, 2, 3);
        crearConexion(1, 3, 5);
        crearConexion(1, 4, 4);
        crearConexion(1, 30, 20);

        crearConexion(2, 1, 3);
        crearConexion(2, 3, 3);

        crearConexion(3, 1, 5);
        crearConexion(3, 2, 3);
        crearConexion(3, 4, 5);
        crearConexion(3, 13, 3);
        crearConexion(3, 14, 5);

        crearConexion(4, 3, 5);
        crearConexion(4, 5, 4);
        crearConexion(4, 15, 7);
        crearConexion(4, 1, 4);

        crearConexion(5, 4, 4);
        crearConexion(5, 15, 3);
        crearConexion(5, 6, 4);
        crearConexion(5, 16, 5);
        crearConexion(5, 7, 3);
        crearConexion(5, 30, 15);

        crearConexion(6, 5, 6);
        crearConexion(6, 15, 3);
        crearConexion(6, 8, 7);
        crearConexion(6, 9, 5);
        crearConexion(6, 12, 8);
        crearConexion(6, 7, 4);
        crearConexion(6, 13, 9);

        crearConexion(7, 5, 6);
        crearConexion(7, 6, 3);
        crearConexion(7, 8, 2);
        crearConexion(7, 16, 6);

        crearConexion(8, 6, 7);
        crearConexion(8, 9, 4);
        crearConexion(8, 7, 2);
        crearConexion(8, 10, 4);
        crearConexion(8, 11, 6);
        crearConexion(8, 16, 6);

        crearConexion(9, 6, 5);
        crearConexion(9, 12, 7);
        crearConexion(9, 17, 6);
        crearConexion(9, 8, 6);
        crearConexion(9, 10, 3);
        crearConexion(9, 19, 5);

        crearConexion(10, 11, 5);
        crearConexion(10, 9, 3);
        crearConexion(10, 8, 4);
        crearConexion(10, 10, 1);
        crearConexion(10, 19, 4);
        crearConexion(10, 21, 5);
        crearConexion(10, 26, 10);

        crearConexion(11, 16, 5);
        crearConexion(11, 8, 5);
        crearConexion(11, 10, 4);
        crearConexion(11, 30, 10);

        crearConexion(12, 13, 5);
        crearConexion(12, 6, 8);
        crearConexion(12, 17, 6);
        crearConexion(12, 9, 7);

        crearConexion(13, 14, 2);
        crearConexion(13, 3, 4);
        crearConexion(13, 15, 3);
        crearConexion(13, 6, 9);
        crearConexion(13, 12, 7);

        crearConexion(14, 13, 2);

        crearConexion(15, 5, 3);
        crearConexion(15, 4, 7);
        crearConexion(15, 3, 5);
        crearConexion(15, 13, 3);
        crearConexion(15, 6, 3);

        crearConexion(16, 7, 6);
        crearConexion(16, 8, 6);
        crearConexion(16, 5, 5);
        crearConexion(16, 5, 5);

        crearConexion(17, 12, 6);
        crearConexion(17, 9, 6);
        crearConexion(17, 18, 7);

        //CONEXIONES DE CADA COMUNA DE FLORIDABLANCA

        crearConexion(18, 23, 8);
        crearConexion(18, 22, 7);
        crearConexion(18, 19, 7);
        crearConexion(18, 17, 7);

        crearConexion(19, 18, 7);
        crearConexion(19, 22, 6);
        crearConexion(19, 17, 8);
        crearConexion(19, 20, 7);
        crearConexion(19, 21, 7);
        crearConexion(19, 9, 5);
        crearConexion(19, 10, 4);

        crearConexion(20, 19, 7);
        crearConexion(20, 22, 5);
        crearConexion(20, 23, 7);
        crearConexion(20, 24, 5);
        crearConexion(20, 25, 9);
        crearConexion(20, 21, 5);

        crearConexion(21, 19, 7);
        crearConexion(21, 10, 5);
        crearConexion(21, 20, 5);
        crearConexion(21, 25, 7);

        crearConexion(22, 18, 7);
        crearConexion(22, 19, 6);
        crearConexion(22, 20, 5);
        crearConexion(22, 23, 7);

        crearConexion(23, 18, 8);
        crearConexion(23, 22, 7);
//        crearConexion(23,0,7);
        crearConexion(23, 24, 4);

        crearConexion(24, 23, 4);
        crearConexion(24, 20, 5);
        crearConexion(24, 25, 7);

        crearConexion(25, 24, 7);
        crearConexion(25, 20, 9);
        crearConexion(25, 21, 7);

        //CONEXIONES DE CADA COMUNA DE GIRON
        crearConexion(26, 27, 3);
        crearConexion(26, 29, 3);
        crearConexion(26, 10, 10);

        crearConexion(27, 28, 3);
        crearConexion(27, 6, 3);
        crearConexion(27, 29, 3);

        crearConexion(28, 30, 3);
        crearConexion(28, 29, 3);
        crearConexion(28, 27, 3);

        crearConexion(29, 26, 2);
        crearConexion(29, 27, 4);
        crearConexion(29, 28, 2);
        crearConexion(29, 30, 3);

        crearConexion(30, 29, 3);
        crearConexion(30, 28, 3);
        crearConexion(30, 1, 20);
        crearConexion(30, 5, 15);
        crearConexion(30, 11, 10);

        distance = new int[grafo.length];

        System.out.println("-- SISTEMA PARA APLICACIÓN DE ALGORITMO DE DIJKSTRA --");
        while (!finPrograma) {
            System.out.println("Escoja una opción: \n1. Hallar algoritmo de Dijkstra entre dos vértices");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Ingrese nodo origen ");
                    int opt = sc.nextInt() - 1;
                    System.out.println("ingrese nodo Final ");
                    int optFin = sc.nextInt() - 1;
                    System.out.println("origen: " + (opt + 1) + "---> " + "destino: " + (optFin + 1) + " valor camino  : " + dijkstrasAlgorithmArry(opt, optFin));
                    //int[] rest = dijkstrasAlgorithmArry(opt, optFin);
                    //System.out.printf(String.valueOf(getTotalRute(rest)));
                    break;
                case 2:
                    finPrograma = true;
                    System.out.println("hasta la prosimaaaaa");
                    break;

            }
        }
        for (int i = 0; i < grafo.length; i++) {
            System.out.print(i + " ) ");
            for (int j = 0; j < grafo.length; j++) {
                System.out.print(grafo[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static int dijkstrasAlgorithm(int primerNodo, int segundoNodo) {
        int compare[] = new int[grafo.length];
        int index = 0;
        int cont = 0;
        int quantity = 0;
        int minimo = 0;
        int posmin = primerNodo;


        for (index = 0; index < grafo.length; index++) {
            compare[index] = 0;
            distance[index] = grafo[primerNodo][index];
        }
        compare[primerNodo] = 1;
        cont = 2;

        while (cont <= grafo.length) {
            minimo = 999;
            for (quantity = 0; quantity < grafo.length; quantity++) {
                if ((distance[quantity] < minimo) && compare[quantity] != 1) {
                    minimo = distance[quantity];
                    posmin = quantity;
                }
            }

            compare[posmin] = 1;
            cont++;

            for (quantity = 0; quantity < grafo.length; quantity++) {
                if ((distance[posmin] + grafo[posmin][quantity] < distance[quantity]) && compare[quantity] != 1) {
                    distance[quantity] = distance[posmin] + grafo[posmin][quantity];
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (i == segundoNodo) {
                return distance[i];
            }
        }
        return 0;
    }

    public static int[] dijkstrasAlgorithmArry(int primerNodo, int segundoNodo) {
        int[] compare = new int[grafo.length];
        int[] distance = new int[grafo.length];
        int[] prevVertice = new int[grafo.length];

        for (int index = 0; index < grafo.length; index++) {
            compare[index] = 0;
            distance[index] = Integer.MAX_VALUE; // Initialize distances to infinity
            prevVertice[index] = -1; // Initialize previous vertices to -1
        }

        distance[primerNodo] = 0;

        while (true) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            // Find the unvisited node with the minimum distance
            for (int quantity = 0; quantity < grafo.length; quantity++) {
                if (compare[quantity] == 0 && distance[quantity] < minDistance) {
                    minDistance = distance[quantity];
                    minIndex = quantity;
                }
            }

            if (minIndex == -1 || minIndex == segundoNodo) {
                break;
            }

            compare[minIndex] = 1;

            // Update distances and previous vertices
            for (int quantity = 0; quantity < grafo.length; quantity++) {
                if (compare[quantity] == 0 && grafo[minIndex][quantity] > 0
                        && distance[minIndex] + grafo[minIndex][quantity] < distance[quantity]) {
                    distance[quantity] = distance[minIndex] + grafo[minIndex][quantity];
                    prevVertice[quantity] = minIndex;
                }
            }
        }

        // Reconstruct the shortest path
        int[] shortestPath = new int[grafo.length];
        int verti = segundoNodo;
        int pathLength = 0;

        while (verti != -1) {
            shortestPath[pathLength++] = verti;
            verti = prevVertice[verti];
        }

        // Reverse the path array to get it from start to finish
        int[] finalPath = new int[pathLength];
        for (int i = 0; i < pathLength; i++) {
            finalPath[i] = shortestPath[pathLength - i - 1] +1;
        }
        for (int i = 0; i < finalPath.length; i++) {
            System.out.println(finalPath[i]);
        }

        return finalPath;
    }

    public static int getTotalRute(int[] arrRuta) {
        int suma = 0;
        for (int i = 1; i <= arrRuta.length + 1; i++) {
            if (arrRuta.length > i) {
                suma += grafo[arrRuta[i - 1]][arrRuta[i]];
            }
        }
        return suma;
    }


    public static int[][] crearGrafo(int cantidadVertices) {
        int[][] matriz = new int[cantidadVertices][cantidadVertices];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 999;
            }
        }
        return matriz;
    }

    public static int[][] crearConexion(int primerNodo, int segundoNodo, int peso) {
        grafo[primerNodo - 1][segundoNodo - 1] = peso;
        grafo[segundoNodo - 1][primerNodo - 1] = peso;
        return grafo;
    }

    public static int cantidadAristas() {
        int cantidadAristas = 0;
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] != -1) {
                    cantidadAristas++;
                }
            }
        }
        return (cantidadAristas / 2);
    }

    public static int cantidadConexiones(int[] vertice) {
        int gradoVertice = 0;
        for (int pos = 0; pos < vertice.length; pos++) {
            if (vertice[pos] != -1) {
                gradoVertice++;
            }
        }
        return gradoVertice;
    }

    public int switchStrInt(String str) {
        switch (str) {
            case "PROVENZA":
                return 10;
        }
        return 200000;
    }
}

