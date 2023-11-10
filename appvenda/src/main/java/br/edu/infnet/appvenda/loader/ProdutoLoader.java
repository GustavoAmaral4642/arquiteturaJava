package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.utils.FileLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/produto.txt");

        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        System.out.println("[Processamento iniciado]");

        Vendedor vendedor = null;
        while (linha != null) {
            campos = linha.split(";");
            vendedor = new Vendedor();

            switch (campos[9]) {
                case "C":
                    Carro carro = new Carro();

                    carro.setCodigo(Integer.valueOf(campos[0]));
                    carro.setMarca(campos[1]);
                    carro.setModelo(campos[2]);
                    carro.setAno(Integer.valueOf(campos[3]));
                    carro.setPreco(Float.valueOf(campos[4]));
                    carro.setEstoque(Boolean.valueOf(campos[5]));
                    carro.setQuilometragem(campos[6]);
                    carro.setMotor(campos[7]);

                    vendedor.setId(Integer.valueOf(campos[10]));
                    carro.setVendedor(vendedor);

                    try {
                        produtoService.incluir(carro);
                    } catch (ConstraintViolationException c){
                        FileLogger.logException("[Carro] " + carro + c.getMessage());
                    }

                    break;
                case "M":
                    Moto moto = new Moto();

                    moto.setCodigo(Integer.valueOf(campos[0]));
                    moto.setMarca(campos[1]);
                    moto.setModelo(campos[2]);
                    moto.setAno(Integer.valueOf(campos[3]));
                    moto.setPreco(Float.valueOf(campos[4]));
                    moto.setEstoque(Boolean.valueOf(campos[5]));
                    moto.setQuilometragem(campos[7]);
                    moto.setCilindrada(campos[7]);

                    vendedor.setId(Integer.valueOf(campos[10]));
                    moto.setVendedor(vendedor);

                    try {
                        produtoService.incluir(moto);
                    } catch (ConstraintViolationException c){
                        FileLogger.logException("[Moto] " + moto + c.getMessage());
                    }
                    break;
                default:
                    break;

            }
            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for (Produto p : produtoService.obterLista()) {
            System.out.println("[Produto] - " + p);
        }

        System.out.println("Produtos do vendedor " + vendedor.getId());
        for(Produto p : produtoService.obterLista(vendedor)){
            System.out.println("[Produto]" + p);
        }

    }
}
