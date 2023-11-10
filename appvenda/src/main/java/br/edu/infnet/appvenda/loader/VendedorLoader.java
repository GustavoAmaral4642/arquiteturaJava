package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;
import br.edu.infnet.appvenda.utils.FileLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

    @Autowired
    private VendedorService vendedorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/vendedor.txt");

        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        System.out.println("[Processamento iniciado]");
        while (linha != null) {
            campos = linha.split(";");

            Vendedor vend = new Vendedor();

            vend.setNome(campos[0]);
            vend.setCpf(campos[1]);
            vend.setEmail(campos[2]);
            vend.setEndereco(new Endereco(campos[3]));

            try {
                vendedorService.incluir(vend);
            } catch (ConstraintViolationException c) {
                FileLogger.logException("[Vendedor] " + vend + c.getMessage());
            }

            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for (Vendedor v : vendedorService.obterLista()) {
            System.out.println("[Vendedor] - " + v);
        }

        leitura.close();

    }
}
