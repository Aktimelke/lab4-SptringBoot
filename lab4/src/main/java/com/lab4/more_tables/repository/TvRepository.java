package com.lab4.more_tables.repository;

import com.lab4.more_tables.model.Tv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvRepository extends JpaRepository<Tv,Long> {
}
