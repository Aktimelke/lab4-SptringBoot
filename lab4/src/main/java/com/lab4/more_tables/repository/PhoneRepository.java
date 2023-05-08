package com.lab4.more_tables.repository;

import com.lab4.more_tables.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
}
