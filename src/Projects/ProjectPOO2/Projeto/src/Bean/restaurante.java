package Bean;

public class restaurante {
    private int id, end_id, cat_id, is_retirada;
    private String nome, telefone, hora_funcio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnd_id() {
        return end_id;
    }

    public void setEnd_id(int end_id) {
        this.end_id = end_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getIs_retirada() {
        return is_retirada;
    }

    public void setIs_retirada(int is_retirada) {
        this.is_retirada = is_retirada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHora_funcio() {
        return hora_funcio;
    }

    public void setHora_funcio(String hora_funcio) {
        this.hora_funcio = hora_funcio;
    }
}
