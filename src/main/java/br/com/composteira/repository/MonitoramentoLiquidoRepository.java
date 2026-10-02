package br.com.composteira.repository;

import br.com.composteira.model.MonitoramentoLiquido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MonitoramentoLiquidoRepository extends JpaRepository<MonitoramentoLiquido, Long> {
    List<MonitoramentoLiquido> findAllByOrderByDataRegistroDesc();
}
