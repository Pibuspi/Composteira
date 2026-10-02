package br.com.composteira.config;

import br.com.composteira.model.*;
import br.com.composteira.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {
    @Bean CommandLineRunner init(ModuloRepository modulos, ResiduoRepository residuos, MonitoramentoLiquidoRepository liquidos) {
        return args -> {
            Modulo m1 = modulos.save(new Modulo(1, "Compostagem", "Ativo"));
            Modulo m2 = modulos.save(new Modulo(2, "Drenagem", "Ativo"));
            Modulo m3 = modulos.save(new Modulo(3, "Biofertilizante", "Ativo"));
            LocalDateTime agora = LocalDateTime.now();
            residuos.save(new Residuo(m1, "Úmido", "Banana", agora.minusDays(1).withHour(9).withMinute(30)));
            residuos.save(new Residuo(m1, "Úmido", "Manga", agora.minusDays(2).withHour(17).withMinute(10)));
            residuos.save(new Residuo(m1, "Seco", "Folhas secas", agora.minusDays(3).withHour(8).withMinute(0)));
            liquidos.save(new MonitoramentoLiquido(m2, true, "Baixo", agora.minusHours(3)));
            liquidos.save(new MonitoramentoLiquido(m3, true, "Médio", agora.minusDays(1).withHour(14).withMinute(20)));
        };
    }
}
