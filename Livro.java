public class Livro {

    private int codigo;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int codigo,
                 String titulo,
                 String autor,
                 int ano) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {

        return codigo + " - "
                + titulo + " | "
                + autor + " | "
                + ano;
    }
}