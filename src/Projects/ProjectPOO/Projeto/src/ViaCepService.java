import Bean.endereco;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import java.io.IOException;

public class ViaCepService {

    private static final String BASE_URL = "https://viacep.com.br/ws/";

    public static endereco buscarEnderecoPorCep(String cep) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + cep + "/json/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                Gson gson = new Gson();
                ViaCepResponse viaCepResponse = gson.fromJson(responseBody, ViaCepResponse.class);

                if (viaCepResponse.getErro() != null && viaCepResponse.getErro()) {
                    return null;
                }

                endereco endereco = new endereco();
                endereco.setRua(viaCepResponse.getLogradouro());
                endereco.setBairro(viaCepResponse.getBairro());
                endereco.setCidade(viaCepResponse.getLocalidade());
                endereco.setEstado(viaCepResponse.getUf());
                return endereco;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class ViaCepResponse {
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
        private Boolean erro;

        public String getLogradouro() {
            return logradouro;
        }

        public String getBairro() {
            return bairro;
        }

        public String getLocalidade() {
            return localidade;
        }

        public String getUf() {
            return uf;
        }

        public Boolean getErro() {
            return erro;
        }
    }
}