package br.edu.infnet.appvenda.loader;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
//
//    private Map<String,Vendedor> mapaVendedor = new HashMap<String,Vendedor>();
//
//    private void incluir(Vendedor v){
//        mapaVendedor.put(v.getCpf(), v);
//    }
//
//    private Collection<Vendedor> obterLista(){
////        mapaVendedor.keySet(); //retorna um Set
//        return mapaVendedor.values(); //retorna uma Collection
//    }

    @Autowired
    private VendedorService vendedorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/vendedor.txt");

        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

//        System.out.println(leitura.readLine());
        System.out.println("[Processamento iniciado]");
        while(linha != null) {
            campos = linha.split(";");
            Vendedor vend = new Vendedor();

            vend.setNome(campos[0]);
            vend.setCpf(campos[1]);
            vend.setEmail(campos[2]);

            vendedorService.incluir(vend);
            linha = leitura.readLine();
        }
        System.out.println("[Processamento finalizado com sucesso]");

        for(Vendedor v : vendedorService.obterLista()){
            System.out.println("[Vendedor] - " + v);
        }

        leitura.close();

//        Vendedor vendedor = new Vendedor();
//
//        vendedor.setNome("Luiz Gustavo do Amaral Correa");
//        vendedor.setCpf("358.624.988-85");
//        vendedor.setEmail("gustavo.lgac@gmail.com");
//
//        System.out.println("Nome: " + vendedor.getNome());
//        System.out.println(vendedor.toString());


    }
}
