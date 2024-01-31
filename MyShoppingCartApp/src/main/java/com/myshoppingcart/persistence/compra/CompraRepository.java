package com.myshoppingcart.persistence.compra;

import com.myshoppingcart.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer>, ICompraRepository {
}
