package com.example.lab10.controller;
import com.example.lab10.model.JopApplication;
import com.example.lab10.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/system/application")
public class JopApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/get")
    public ResponseEntity<?> getApplication(){
       return ResponseEntity.status(200).body(applicationService.getAllApplication());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addApplication(@RequestBody @Valid JopApplication jopApplication , Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    applicationService.AddApplication(jopApplication);
    return ResponseEntity.status(200).body("added");
    }

    @PutMapping("/updated")
    public ResponseEntity<?> updateApplication (@PathVariable Integer Id , @Valid @RequestBody
    JopApplication jopApplication , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean IsUpdated = applicationService.updateApplication(jopApplication , Id);
        if (!IsUpdated){
            ResponseEntity.status(400).body("error - cant find it");
        }
        return ResponseEntity.status(200).body("deleted");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteApplication (@PathVariable Integer Id){
        boolean IsDeleted = applicationService.deleteApplication(Id);
        if (!IsDeleted){
            ResponseEntity.status(400).body("error - not deleted");
        }
        return ResponseEntity.status(200).body("deleted");

    }





}
