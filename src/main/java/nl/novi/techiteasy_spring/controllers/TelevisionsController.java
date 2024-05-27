package nl.novi.techiteasy_spring.controllers;

import nl.novi.techiteasy_spring.exceptions.ExceptionController;
import nl.novi.techiteasy_spring.exceptions.RecordNotFoundException;
import nl.novi.techiteasy_spring.models.TV;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {
    private ArrayList<TV> TVs = new ArrayList<>();

    @GetMapping()
    public ResponseEntity<ArrayList<TV>> getAll() {
        if (!TVs.isEmpty()) {
            return ResponseEntity.ok(TVs);
        }
        else {
            throw new RecordNotFoundException("No tvs");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TV> getTVById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(TVs.get(id));
        }
        catch (Exception e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }

    @PostMapping()
    public ResponseEntity<TV> createTV(@RequestBody String brand) {
        TV tv = new TV();
        tv.brand = brand;
        TVs.add(tv);
        return ResponseEntity.created(null).body(tv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editTVById(@RequestBody String editedBrand, @PathVariable int id) {
        try {
            TVs.get(id).brand = editedBrand;
            return ResponseEntity.ok("tv with id:" + id + " has been edited to " + editedBrand);
        } catch (IndexOutOfBoundsException e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTVById(@PathVariable int id)
    {
        try {
            TVs.remove(id);
            return ResponseEntity.ok("tv with id:" + id + " has been removed");
        }
        catch (IndexOutOfBoundsException e) {
            throw new RecordNotFoundException("Id:" + id + " has not been found");
        }
    }
}
