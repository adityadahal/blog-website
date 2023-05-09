package com.example.SpringCRUD.controller;

import com.example.SpringCRUD.model.StudentData;
import com.example.SpringCRUD.repo.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ParentController {
    @Autowired
    ParentRepo parentRepo;

    @PostMapping("/data")

    public String createNewData(@RequestBody StudentData studentData) {

        parentRepo.save(studentData);
        return "Succesfully Saved";
    }

    @GetMapping("/data")

    public List<StudentData> getAllData(){
        return parentRepo.findAll();
    }

    @GetMapping("/data/{parentId}")

    public ResponseEntity<StudentData> getDatabyId(@PathVariable int parentId){
        StudentData studentData = parentRepo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Id not Found"));
        return  ResponseEntity.ok(studentData);

    }

    @PutMapping("/data/{parentId}")
    public String updateData(@PathVariable int parentId, @RequestBody StudentData studentData ){
      Optional<StudentData>  upData = Optional.of(parentRepo.getById(parentId));
      if (upData.isPresent()){
          StudentData stData = upData.get();
          stData.setFirstName(studentData.getFirstName());
          stData.setEmail(studentData.getEmail());
          stData.setLastName(studentData.getLastName());
          parentRepo.save(stData);
          return  "Details has been updated.";

      }else{
          return "Couldn't Save Details";
      }
    }

    @DeleteMapping("/data/{parentId}")

    public  String deleteData(@PathVariable int parentId){
        parentRepo.deleteById(parentId);
        return  "Deleted Succesfully !";
    }

    @GetMapping("/data/firstName")

    public  ResponseEntity<List<StudentData>> getByfirstName(@RequestParam String firstName, String lastName){
    return  new  ResponseEntity<List<StudentData>> (parentRepo.findByFirstNameOrLastName(firstName, lastName), HttpStatus.OK);
    }
}
