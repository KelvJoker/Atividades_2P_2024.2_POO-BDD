package src;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

class Restaurante {
    private Long id;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private Categoria categoria;
    private Time horaFuncio;
    private Boolean isRetirada;
    private List<Produto> produtos;
}

class Categoria {
    private Long id;
    private String tipo;
    private String nome;
    private String descricao;
    private List<Produto> produtos;
}

class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Categoria categoria;
    private Restaurante restaurante;
    private List<PedidoProduto> pedidoProdutos;
    private List<Acompanhamento> acompanhamentos;
}

class FormaPagamento {
    private Long id;
    private String tipoDePagamento;
    private List<HistoricoPagamento> historicos;
    private List<Pedido> pedidos;
}

class HistoricoPagamento {
    private Long id;
    private Date data;
    private FormaPagamento formaPagamento;
    private BigDecimal valor;
}

class HistoricoEntrega {
    private Long id;
    private StatusEntrega statusEntrega;
    private Pedido pedido;
    private Date dataEntrega;
    private String observacoes;
}

class StatusEntrega {
    private Long id;
    private String nome;
    private List<HistoricoEntrega> historicosEntrega;
    private List<Pedido> pedidos;
}

class Endereco {
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;
    private String complemento;
    private String pontoReferencia;
    private List<Restaurante> restaurantes;
    private List<Pedido> pedidos;
}

class Promocao {
    private Long id;
    private String nome;
    private String codigo;
    private String tipo;
    private BigDecimal valor;
    private Date validade;
    private List<Pedido> pedidos;
}

class Pedido {
    private Long id;
    private Date data;
    private Restaurante restaurante;
    private BigDecimal valor;
    private BigDecimal taxaEntrega;
    private Promocao promocao;
    private StatusEntrega statusEntrega;
    private FormaPagamento formaPagamento;
    private String observacao;
    private BigDecimal troco;
    private Endereco endereco;
    private List<PedidoProduto> pedidoProdutos;
}

class PedidoProduto {
    private Long id;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    private List<PedidoProdutoAcompanhamento> acompanhamentos;
}

class PedidoProdutoAcompanhamento {
    private Long id;
    private PedidoProduto pedidoProduto;
    private Acompanhamento acompanhamento;
}

class Acompanhamento {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private List<Produto> produtos;
    private List<PedidoProdutoAcompanhamento> pedidoProdutosAcompanhamento;
}

class Avaliacao {
    private Long id;
    private int nota;
    private Pedido pedido;
    private Restaurante restaurante;
}

class RestaurantePagamento {
    private Restaurante restaurante;
    private FormaPagamento formaPagamento;
}