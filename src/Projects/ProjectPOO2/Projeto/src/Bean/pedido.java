package Bean;

public class pedido {
    private int id, id_restaurante, valor, taxa_entrega, id_promocao, id_status_entrega, id_forma_pagamento, troco, id_endereco;
    private String data, observacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(int taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
    }

    public int getId_promocao() {
        return id_promocao;
    }

    public void setId_promocao(int id_promocao) {
        this.id_promocao = id_promocao;
    }

    public int getId_status_entrega() {
        return id_status_entrega;
    }

    public void setId_status_entrega(int id_status_entrega) {
        this.id_status_entrega = id_status_entrega;
    }

    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public int getTroco() {
        return troco;
    }

    public void setTroco(int troco) {
        this.troco = troco;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
