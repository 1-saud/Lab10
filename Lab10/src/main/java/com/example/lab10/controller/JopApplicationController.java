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

    @PutMapping("/updated/{id}")
    public ResponseEntity<?> updateApplication (@PathVariable Integer id , @Valid @RequestBody
    JopApplication jopApplication , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean IsUpdated = applicationService.updateApplication(jopApplication , id);
        if (!IsUpdated){
            ResponseEntity.status(400).body("error - cant find it");
        }
        return ResponseEntity.status(200).body("deleted");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable Integer id) {
        boolean isDeleted = applicationService.deleteApplication(id);
        if (!isDeleted) {
            return ResponseEntity.status(400).body("Application not found");
        }
        return ResponseEntity.status(200).body("deleted");
    }


}
