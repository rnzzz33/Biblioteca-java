import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {

        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // LIVROS

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Livro buscarLivro(int codigo) {

        for (Livro l : livros) {

            if (l.getCodigo() == codigo) {
                return l;
            }
        }

        return null;
    }

    // USUÁRIOS

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(int codigo) {

        for (Usuario u : usuarios) {

            if (u.getCodigo() == codigo) {
                return u;
            }
        }

        return null;
    }

    // EMPRÉSTIMOS

    public boolean realizarEmprestimo(
            int codigoLivro,
            int codigoUsuario) {

        Livro livro = buscarLivro(codigoLivro);
        Usuario usuario = buscarUsuario(codigoUsuario);

        if (livro == null || usuario == null) {
            return false;
        }

        for (Emprestimo e : emprestimos) {

            if (e.getLivro().getCodigo() == codigoLivro
                    && !e.isDevolvido()) {

                return false;
            }
        }

        emprestimos.add(
                new Emprestimo(livro, usuario));

        return true;
    }

    public boolean devolverLivro(int codigoLivro) {

        for (Emprestimo e : emprestimos) {

            if (e.getLivro().getCodigo()
                    == codigoLivro
                    && !e.isDevolvido()) {

                e.devolver();
                return true;
            }
        }

        return false;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}