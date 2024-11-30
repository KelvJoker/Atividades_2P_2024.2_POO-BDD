package Bean;

public class historico_entrega {
    private int id, id_status_ent, id_pedido;
    private String datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_status_ent() {
        return id_status_ent;
    }

    public void setId_status_ent(int id_status_ent) {
        this.id_status_ent = id_status_ent;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
