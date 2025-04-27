package com.works.service;


import com.works.entities.Customer;
import com.works.entities.DBook;
import com.works.repositories.CustomerRepository;
import com.works.repositories.DBookRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DBookService {


    final DBookRepository dBookRepository;
    final HttpServletRequest request;
    final CustomerRepository customerRepository;

    public DBook save (DBook productKsm) {

        Customer customer = (Customer) request.getSession().getAttribute("user");
        productKsm.setCid(customer.getCid());
        dBookRepository.save(productKsm);
        return productKsm;
    }


    public List<DBook> findAll( List<DBook> dyrbook) {
        return dBookRepository.saveAll(dyrbook);
    }


    public Page<DBook> getBooks(int page, int size) {
        Customer customer = (Customer) request.getSession().getAttribute("user");

        Pageable pageable = PageRequest.of(page, size);
        Page<DBook> books = dBookRepository.findByCidEquals(customer.getCid() , pageable);
        return books;
    }


    public ResponseEntity deleteProduct(Long pid) {
        ResponseEntity res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (pid == null || pid < 1) {
            return res;
        }

        Optional<DBook> productOptional = dBookRepository.findById(pid);
        if (productOptional.isPresent()) {
            DBook dBook = productOptional.get();

            Customer customer = (Customer) request.getSession().getAttribute("user");

            if (dBook.getCid().equals(customer.getCid())) {
                dBookRepository.deleteById(pid);
                res = new ResponseEntity<>(HttpStatus.OK);
            } else {

                res = new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        return res;
    }





    /* public ResponseEntity deleteProduct(Long pid) {
        ResponseEntity res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (pid == null || pid < 1) { } else {
            Optional<DBook> productOptional = dBookRepository.findById(pid);
            if (productOptional.isPresent()) {
                dBookRepository.deleteById(pid);
                res = new ResponseEntity(HttpStatus.OK);
            }
        }
        return res;
    }
    */

    public Page<DBook> searchBooksByTitle(String title, Pageable pageable) {
        return dBookRepository.findByTitleContainingIgnoreCase(title, pageable);
    }




}
