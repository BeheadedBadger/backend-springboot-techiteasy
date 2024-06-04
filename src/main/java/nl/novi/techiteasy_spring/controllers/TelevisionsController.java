package nl.novi.techiteasy_spring.controllers;

import nl.novi.techiteasy_spring.exceptions.InvalidBrandException;
import nl.novi.techiteasy_spring.exceptions.RecordNotFoundException;
import nl.novi.techiteasy_spring.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {
    private ArrayList<Television> Television = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<ArrayList<Television>> getAll() {
        if (!Television.isEmpty()) {
            return ResponseEntity.ok(Television);
        }
        else {
            throw new RecordNotFoundException("No tvs");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTVById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(Television.get(id));
        }
        catch (Exception e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }

    @PostMapping()
    public ResponseEntity<Television> createTV(@RequestBody String brand) {
        if (brand.length() > 20) {
            throw new InvalidBrandException("Brand name:" + brand + " is " + brand.length() + " characters. Must be under 20 characters.");
        }

        Television television = new Television();
        television.setBrand(brand);
        Television.add(television);
        return ResponseEntity.created(null).body(television);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editTVById(@RequestBody String editedBrand, @PathVariable int id) {
        try {
            Television.get(id).setBrand(editedBrand);
            return ResponseEntity.ok("tv with id:" + id + " has been edited to " + editedBrand);
        } catch (IndexOutOfBoundsException e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTVById(@PathVariable int id)
    {
        try {
            Television.remove(id);
            return ResponseEntity.ok("tv with id:" + id + " has been removed");
        }
        catch (IndexOutOfBoundsException e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }
}
