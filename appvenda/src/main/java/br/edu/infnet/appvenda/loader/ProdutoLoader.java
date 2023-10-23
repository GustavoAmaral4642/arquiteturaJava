package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

        while(linha != null) {
            campos = linha.split(";");

            switch (campos[9]){
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

                    produtoService.incluir(carro);

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

                    produtoService.incluir(moto);
                    break;
                default:
                    break;

            }
            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for(Produto p : produtoService.obterLista()){
            System.out.println("[Produto] - " + p);
        }

    }
}