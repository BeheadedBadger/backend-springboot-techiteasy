package nl.novi.techiteasy_spring.controllers;

import nl.novi.techiteasy_spring.exceptions.ExceptionController;
import nl.novi.techiteasy_spring.models.TV;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionsController {
    private ArrayList<TV> TVs = new ArrayList<>();

    @GetMapping("/all")
    public Object getAll() {
        if (TVs.isEmpty() == false) {
            return ResponseEntity.ok(TVs);
        }
        else {
            return ExceptionController.empty();
        }
    }

    @GetMapping("all/{id}")
    public Object getTVById(@PathVariable int id) {
        try {
            return TVs.get(id);
        }
        catch (IndexOutOfBoundsException e) {
            return ExceptionController.outOfBounds();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TV> createTV(@RequestBody String brand) {
        TV tv = new TV();
        tv.brand = brand;
        TVs.add(tv);
        return ResponseEntity.created(null).body(tv);
    }

    @PutMapping("/edit/{id}")
    public Object editTVById(@RequestBody String editedBrand, @PathVariable int id) {
        try {
            TVs.get(id).brand = editedBrand;
            return ResponseEntity.ok("tv with id:" + id + " has been edited to " + editedBrand);
        } catch (IndexOutOfBoundsException e) {
            return ExceptionController.outOfBounds();
        }
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteTVById(@PathVariable int id)
    {
        try {
            TVs.remove(id);
            return ResponseEntity.ok("tv with id:" + id + " has been removed");
        }
        catch (IndexOutOfBoundsException e) {
            return ExceptionController.outOfBounds();
        }
    }
}
