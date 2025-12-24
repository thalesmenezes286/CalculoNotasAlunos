import java.util.Scanner;

public class CalculoNotas {

    private String nomeCurso;
    private int total; // armazena o total das notas inseridas
    private int contNota; //

    //Contagem de notas, de A até E
    private int contA;
    private int contB;
    private int contC;
    private int contD;
    private int contE;

    public CalculoNotas(String nome){
        this.nomeCurso = nome;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void exibeMensagemBoasVindas(){
        System.out.printf("Seja bem-vindo ao curso de \n%s!\n\n",getNomeCurso());
    }

    //Insere a nota específica
    public void insereNotas(){
        Scanner entrada = new Scanner(System.in);

        int nota; //nota inserida pelo usuário

        System.out.printf("%s%n%s%n",
                "Digite as notas inseridas no intervalo de 0 a 100",
                "Pressione Ctrl+D (Linux/Mac) ou Ctrl+Z (Windows) para finalizar:");

        while(entrada.hasNext()){
            nota = entrada.nextInt(); //lê a nota
            total += nota; //soma e salva o total das notas
            ++contNota;

            incrementarContadorDeNotasPorLetra(nota);
        }
    }

    //Adiciona um contador adequado da nota especificada
    private void incrementarContadorDeNotasPorLetra(int nota) {
        // Agora o switch avalia a nota diretamente (de 0 a 10)
        switch (nota) {
            case 10, 9 -> ++contA;
            case 8     -> ++contB;
            case 7     -> ++contC;
            case 6     -> ++contD;
            default    -> ++contE;
        }
    }

    //Realiza a média aritmética das notas
    private double getMediaNotas(int total, int contNota){
        double media = (double) total / contNota;

        return media;
    }

    public void exibeRelatorioNota() {
        System.out.println("\nRelatório Notas");

        if (contNota != 0) {
            double media = getMediaNotas(total, contNota);

            // Corrigido: Ordem das variáveis e placeholders
            System.out.printf("Total das notas (soma): %d%nNotas lançadas (quantidade): %d%n", total, contNota);

            // Corrigido: de %2.f para %.2f
            System.out.printf("Média das notas: %.2f%n", media);

            // Corrigido: Simplificado para evitar erros de contagem de argumentos
            System.out.println("Numero de alunos que receberam cada nota:");
            System.out.printf("A: %d%n", contA);
            System.out.printf("B: %d%n", contB);
            System.out.printf("C: %d%n", contC);
            System.out.printf("D: %d%n", contD);
            System.out.printf("E: %d%n", contE);

        } else {
            System.out.println("Nenhuma nota inserida!");
        }
    }
}
