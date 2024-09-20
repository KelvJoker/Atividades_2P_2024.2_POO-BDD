package AT_04;

public class main_pessoa {
    public static void main(String[] args) {
        pessoa pessoa1 = new pessoa("Talles", 30, "123.456.789-00", "Rua tall, 123", "99999-9999", 
                                   "tpacheco@email.com", "Masculino", "Brasileiro", "Solteiro", "Dev");
        
        pessoa pessoa2 = new pessoa("Lena", 25, "987.654.321-00", "Rua floral, 456", "88888-8888", 
                                   "lenaprof@email.com", "Feminino", "Brasileira", "Casada", "Professora");

        System.out.println("Pessoa 1:");
        System.out.println("Nome: " + pessoa1.getNome());
        System.out.println("Idade: " + pessoa1.getIdade());
        System.out.println("CPF: " + pessoa1.getCpf());
        System.out.println("Endereço: " + pessoa1.getEndereco());
        System.out.println("Telefone: " + pessoa1.getTelefone());
        System.out.println("Email: " + pessoa1.getEmail());
        System.out.println("Gênero: " + pessoa1.getGenero());
        System.out.println("Nacionalidade: " + pessoa1.getNacionalidade());
        System.out.println("Estado Civil: " + pessoa1.getEstadoCivil());
        System.out.println("Profissão: " + pessoa1.getProfissao());

        System.out.println("\nPessoa 2:");
        System.out.println("Nome: " + pessoa2.getNome());
        System.out.println("Idade: " + pessoa2.getIdade());
        System.out.println("CPF: " + pessoa2.getCpf());
        System.out.println("Endereço: " + pessoa2.getEndereco());
        System.out.println("Telefone: " + pessoa2.getTelefone());
        System.out.println("Email: " + pessoa2.getEmail());
        System.out.println("Gênero: " + pessoa2.getGenero());
        System.out.println("Nacionalidade: " + pessoa2.getNacionalidade());
        System.out.println("Estado Civil: " + pessoa2.getEstadoCivil());
        System.out.println("Profissão: " + pessoa2.getProfissao());
    }
}