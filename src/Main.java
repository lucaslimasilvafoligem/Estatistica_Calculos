import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira os valores, se espera uma String composta por numeros separados por espaços");
        System.out.println("(Fim) para encerrar/(Novos dados) inserir novos valores/ (Rol)/" +
                "(Moda)/ (Mediana)/ (Media)/(Desvio)/ (Variancia) / (Desvio Padrao)/ (Cv)");
        String[] valores = sc.nextLine().split(" ");
        Calcula dados = new Calcula(valores);
        String comando = "";
        while (!comando.equals("Fim")) {
            System.out.println("(Fim) para encerrar/(Novos dados) inserir novos valores/ (Rol)/" +
                    "(Moda)/ (Mediana)/ (Media)/(Desvio)/ (Variancia) / (Desvio Padrao)/ (Cv)");
            comando = sc.nextLine();
            if(comando.equals("Novos dados")) {
                String[] novosValores = sc.nextLine().split(" ");
                dados = new Calcula(novosValores);
            }
            if (comando.equals("Rol")) {System.out.println(dados.rol());}
            else if (comando.equals("Moda")) {System.out.println(dados.moda());}
            else if (comando.equals("Mediana")) {System.out.println(dados.mediana());}
            else if (comando.equals("Media")) {System.out.println(dados.media());}
            else if (comando.equals("Desvio")) {System.out.println(dados.getDesvio());}
            else if (comando.equals("Variancia")) {System.out.println(dados.variancia());}
            else if (comando.equals("Desvio Padrao")) {System.out.println(dados.desvioPadrao());}
            else if (comando.equals("Cv")) {System.out.println(dados.cv() + "%");}
        }
    }
}