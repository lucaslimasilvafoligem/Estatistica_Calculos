import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os valores, se espera uma String composta por numeros separados por espaços");
        System.out.println("(Fim) para encerrar/(Novos dados) inserir novos valores/ (Rol)/" +
                "(Moda)/ (Mediana)/ (Media)/(Desvio)/ (Variancia) / (Desvio Padrao)");
        String[] valores = sc.nextLine().split(" ");
        Calcula dados = new Calcula(valores);
        String comando = "";
        while (!comando.equals("Fim")) {
            System.out.println("(Fim) para encerrar/(Novos dados) inserir novos valores/ (Rol)/" +
                    "(Moda)/ (Mediana)/ (Media)/(Desvio)/ (Variancia) / (Desvio Padrao)");
            comando = sc.nextLine();
            if(comando.equals("Novos dados")) {
                String[] novosValores = sc.nextLine().split(" ");
                dados = new Calcula(novosValores);
            }
            if (comando.equals("Rol")) {System.out.println(dados.rol());}
            if (comando.equals("Moda")) {System.out.println(dados.moda());}
            if (comando.equals("Mediana")) {System.out.println(dados.mediana());}
            if (comando.equals("Media")) {System.out.println(dados.media());}
            if (comando.equals("Desvio")) {System.out.println(dados.getDesvio());}
            if (comando.equals("Variancia")) {System.out.println(dados.variancia());}
            if (comando.equals("Desvio Padrao")) {System.out.println(dados.desvioPadrao());}
        }
    }
}