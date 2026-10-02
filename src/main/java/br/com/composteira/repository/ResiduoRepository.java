package br.com.composteira.repository;

import br.com.composteira.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    List<Residuo> findByModuloNumeroModuloOrderByDataAdicaoDesc(Integer numeroModulo);
}
