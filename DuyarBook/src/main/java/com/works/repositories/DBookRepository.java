package com.works.repositories;

import com.works.entities.Customer;
import com.works.entities.DBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface DBookRepository extends JpaRepository<DBook, Long> {

    Page<DBook> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<DBook> findByOwner(Customer owner, Pageable pageable);




}