import javax.swing.*;
import java.util.List;

public class PedidoStatus implements Runnable {
    private String pedido;
    private String[] statusList = {"Em produção", "Saiu para entrega", "Entregue"};
    private List<String> pedidosRealizados;

    public PedidoStatus(String pedido, List<String> pedidosRealizados) {
        this.pedido = pedido;
        this.pedidosRealizados = pedidosRealizados;
    }

    @Override
    public void run() {
        for (String status : statusList) {
            try {
                Thread.sleep(10000);
                JOptionPane.showMessageDialog(null, "Status do Pedido Atualizado: " + status);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pedidosRealizados.set(pedidosRealizados.indexOf(pedido), pedido + "\nStatus: Entregue");
    }
}
