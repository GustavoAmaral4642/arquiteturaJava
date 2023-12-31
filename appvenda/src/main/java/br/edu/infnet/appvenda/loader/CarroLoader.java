package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.CarroService;
import br.edu.infnet.appvenda.utils.FileLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class CarroLoader implements ApplicationRunner {

    @Autowired
    private CarroService carroService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/carro.txt");

        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        System.out.println("[Processamento iniciado]");
        while(linha != null) {
            campos = linha.split(";");
            Carro carro = new Carro();

            carro.setCodigo(Integer.valueOf(campos[0]));
            carro.setMarca(campos[1]);
            carro.setModelo(campos[2]);
            carro.setAno(Integer.valueOf(campos[3]));
            carro.setPreco(Float.valueOf(campos[4]));
            carro.setEstoque(Boolean.valueOf(campos[5]));
            carro.setQuilometragem(campos[6]);
            carro.setMotor(campos[7]);
            carro.setEstoque(Boolean.valueOf(campos[8]));

            Vendedor vendedor = new Vendedor();
            vendedor.setId(Integer.valueOf(campos[9]));
            carro.setVendedor(vendedor);

            try {
                carroService.incluir(carro);
            } catch (ConstraintViolationException c){
                FileLogger.logException("[Carro] " + carro + c.getMessage());
            }
            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for(Carro c : carroService.obterLista()){
            System.out.println("[Carro] - " + c);
        }

        leitura.close();
    }
}
