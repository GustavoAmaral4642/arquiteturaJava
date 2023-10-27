package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class MotoLoader implements ApplicationRunner {

    @Autowired
    private MotoService motoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/moto.txt");

        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        System.out.println("[Processamento iniciado]");
        while(linha != null) {
            campos = linha.split(";");
            Moto moto = new Moto();

            moto.setCodigo(Integer.valueOf(campos[0]));
            moto.setMarca(campos[1]);
            moto.setModelo(campos[2]);
            moto.setAno(Integer.valueOf(campos[3]));
            moto.setPreco(Float.valueOf(campos[4]));
            moto.setEstoque(Boolean.valueOf(campos[5]));
            moto.setQuilometragem(campos[7]);
            moto.setCilindrada(campos[7]);
            moto.setInjecaoEletronica(Boolean.valueOf(campos[8]));

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[9]));
            moto.setVendedor(vendedor);

            motoService.incluir(moto);
            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for (Moto m : motoService.obterLista()){
            System.out.println("[Moto] - " + m);
        }

        leitura.close();
    }
}
