package com.works.restcontrollers;


import com.works.entities.Customer;
import com.works.entities.DBook;
import com.works.repositories.DBookRepository;
import com.works.service.DBookService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("dyrbook")
@Validated
public class DBookRestcontroller {


    final DBookService dbookService;



    @PostMapping("booksave")
    public DBook save(@RequestBody DBook dubook) {
        return dbookService.save(dubook);
    }

    @PostMapping("allbooksave")
    public List<DBook> saveAll(@RequestBody List<DBook> dybook) {
        return dbookService.findAll(dybook);
    }


    @GetMapping("booklist")
    public Page<DBook> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @Min(5) @Max(20) @RequestParam int size
    ) {
        return dbookService.getBooks(page, size);
    }


   @DeleteMapping("bdelete/{bid}")
    public ResponseEntity delete(@PathVariable Long bid) {
        return dbookService.deleteProduct(bid);
    }




    @GetMapping("booksearch")
    public Page<DBook> searchBooks(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return dbookService.searchBooksByTitle(title, PageRequest.of(page, size));
    }



}
