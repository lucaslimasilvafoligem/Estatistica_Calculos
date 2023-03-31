import java.util.*;

public class Calcula {
    private double[] numeros;
    Calcula(String[] valores) {
        numeros = new double[valores.length];
        numeros = convertRecursive(valores, numeros, 0);
        numeros = bubbleSort(numeros, 0, numeros.length - 1);
    }

    private double[] convertRecursive(String[] valores, double aux[], int controle) {
        if(controle == valores.length) {return aux;}
        else {
            aux[controle] = Integer.parseInt(valores[controle]);
            convertRecursive(valores, aux, controle + 1);
        }
        return aux;
    }

    private double[] bubbleSort(double[] array, int left, int rig) {
        for (int j = left; j < rig; j++) {
            boolean controle = true;
            for (int i = left; i < rig - j; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    controle = false;
                }
            }
            if (controle) {break;}
    }
        return array;
    }

    private static void swap(double[] array, int i, int j) {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String moda() {
        if(numeros.length == 1) {return "" + numeros[0];}
        String aux = "Amodal";
        int maiorFrequencia = 1;
        Map frequencia = new HashMap();
        for (int i = 0; i < numeros.length; i++) {
            if(frequencia.containsKey(numeros[i])) {
                int valor = (int) frequencia.get(numeros[i]) + 1;
                frequencia.put(numeros[i], valor);
            }
            else {frequencia.put(numeros[i],1);}
        }
        for (int i = 0; i < numeros.length; i++) {
            if (!((int) frequencia.get(numeros[i]) < maiorFrequencia)) {
                if ((int) frequencia.get(numeros[i]) == maiorFrequencia) {
                    if(i > 1) {
                        if(numeros[i - 1] != numeros[i] && (int) frequencia.get(numeros[i]) > 1) {aux += numeros[i] + " ";}
                    }
                } else {
                    aux = numeros[i] + " ";
                    maiorFrequencia = (int) frequencia.get(numeros[i]);
                }
            }
        }
        return aux;
    }

    public String rol() {
        String aux = "";
        for (int i = 0; i < numeros.length; i++) {aux += numeros[i] + " ";}
        return aux;
    }
    public double media() {
        double aux = numeros[0];
        for (int i = 1; i < numeros.length; i++) {aux += numeros[i];}
        return aux/numeros.length;
    }
    public double mediana() {
        if(numeros.length % 2 == 0) {
            System.out.println(numeros[(numeros.length/2) - 1] + " " + numeros[(numeros.length/2)]);
            return (numeros[(numeros.length/2) - 1] + numeros[numeros.length/2])/2;
        }
        else {return numeros[(numeros.length/2)];}
    }

    private double[] desvio() {
        double aux = 0;
        double[] desvios = new double[numeros.length];
        double media = media();
        for (int i = 0; i < numeros.length; i++) {
            aux = media - numeros[i];
            if (aux < 0) {aux= aux * -1;}
            desvios[i] = aux;
        }
        return desvios;
    }

    public String getDesvio() {
        double[] desvios = desvio();
        String resp = "";
        for (int i = 0; i < desvios.length; i++) {resp += desvios[i] + " ";}
        return resp;
    }

    public double variancia() {
        double[] desvios = desvio();
        double somatorio = 0;
        for (int i = 0; i < desvios.length; i++) {somatorio += desvios[i] * desvios[i];}
        return somatorio/media();
    }

    public double desvioPadrao() {
        return Math.sqrt(variancia());
    }

    public double cv() {return (desvioPadrao()/media())*100;}
}
