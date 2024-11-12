package com.estacaojr10.api.Entities.BraceletHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BraceletHistoryRepository extends JpaRepository<BraceletHistory, String> {
    @Query("SELECT b FROM BraceletHistory b WHERE b.number = :number")
    List<BraceletHistory> findBraceletDetails(@Param("number") String numbernumber);
    @Query("SELECT b FROM BraceletHistory b")
    List<BraceletHistory> findBracelet();
}
