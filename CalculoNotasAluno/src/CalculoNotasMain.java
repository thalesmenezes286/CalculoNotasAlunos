//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalculoNotasMain {
    public static void main(String[] args) {
        CalculoNotas calculoNotas = new CalculoNotas("Java como programar 8");
        calculoNotas.exibeMensagemBoasVindas();
        calculoNotas.insereNotas();
        calculoNotas.exibeRelatorioNota();
    }
}