import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TelaBiblioteca tela =
                    new TelaBiblioteca();

            tela.setVisible(true);

        });
    }
}