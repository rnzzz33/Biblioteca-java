import javax.swing.*;
import java.awt.*;

public class TelaBiblioteca extends JFrame {

    private Biblioteca biblioteca;

    private JTextArea area;

    public TelaBiblioteca() {

        biblioteca = new Biblioteca();

        setTitle("Sistema Gerencial de Biblioteca");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        JButton btnLivro =
                new JButton("Cadastrar Livro");

        JButton btnUsuario =
                new JButton("Cadastrar Usuário");

        JButton btnEmprestar =
                new JButton("Emprestar Livro");

        JButton btnDevolver =
                new JButton("Devolver Livro");

        JButton btnLivros =
                new JButton("Listar Livros");

        JButton btnUsuarios =
                new JButton("Listar Usuários");

        JButton btnRelatorio =
                new JButton("Relatório Empréstimos");

        painel.add(btnLivro);
        painel.add(btnUsuario);
        painel.add(btnEmprestar);
        painel.add(btnDevolver);
        painel.add(btnLivros);
        painel.add(btnUsuarios);
        painel.add(btnRelatorio);

        area = new JTextArea();

        JScrollPane scroll =
                new JScrollPane(area);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnLivro.addActionListener(e -> cadastrarLivro());

        btnUsuario.addActionListener(e -> cadastrarUsuario());

        btnEmprestar.addActionListener(e -> emprestarLivro());

        btnDevolver.addActionListener(e -> devolverLivro());

        btnLivros.addActionListener(e -> listarLivros());

        btnUsuarios.addActionListener(e -> listarUsuarios());

        btnRelatorio.addActionListener(
                e -> relatorioEmprestimos());
    }

    private void cadastrarLivro() {

        try {

            int codigo = Integer.parseInt(
                    JOptionPane.showInputDialog("Código"));

            String titulo =
                    JOptionPane.showInputDialog("Título");

            String autor =
                    JOptionPane.showInputDialog("Autor");

            int ano = Integer.parseInt(
                    JOptionPane.showInputDialog("Ano"));

            biblioteca.adicionarLivro(
                    new Livro(
                            codigo,
                            titulo,
                            autor,
                            ano));

            JOptionPane.showMessageDialog(
                    this,
                    "Livro cadastrado!");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao cadastrar.");
        }
    }

    private void cadastrarUsuario() {

        try {

            int codigo = Integer.parseInt(
                    JOptionPane.showInputDialog("Código"));

            String nome =
                    JOptionPane.showInputDialog("Nome");

            biblioteca.adicionarUsuario(
                    new Usuario(codigo,nome));

            JOptionPane.showMessageDialog(
                    this,
                    "Usuário cadastrado!");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Erro ao cadastrar.");
        }
    }

    private void emprestarLivro() {

        int livro = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Código do Livro"));

        int usuario = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Código do Usuário"));

        boolean ok =
                biblioteca.realizarEmprestimo(
                        livro,
                        usuario);

        JOptionPane.showMessageDialog(
                this,
                ok ? "Empréstimo realizado!"
                        : "Erro no empréstimo!");
    }

    private void devolverLivro() {

        int livro = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Código do Livro"));

        boolean ok =
                biblioteca.devolverLivro(livro);

        JOptionPane.showMessageDialog(
                this,
                ok ? "Livro devolvido!"
                        : "Livro não encontrado!");
    }

    private void listarLivros() {

        area.setText("");

        for (Livro l : biblioteca.getLivros()) {

            area.append(l + "\n");
        }
    }

    private void listarUsuarios() {

        area.setText("");

        for (Usuario u :
                biblioteca.getUsuarios()) {

            area.append(u + "\n");
        }
    }

    private void relatorioEmprestimos() {

        area.setText("");

        for (Emprestimo e :
                biblioteca.getEmprestimos()) {

            area.append(e + "\n");
        }
    }
}