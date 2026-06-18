public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private boolean devolvido;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.devolvido = false;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void devolver() {
        devolvido = true;
    }

    @Override
    public String toString() {

        String status = devolvido ?
                "DEVOLVIDO" :
                "EMPRESTADO";

        return livro.getTitulo()
                + " -> "
                + usuario.getNome()
                + " (" + status + ")";
    }
}