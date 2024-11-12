package com.estacaojr10.api.Entities.Bracelet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BraceletRepository extends JpaRepository<Bracelet, String> {

}
