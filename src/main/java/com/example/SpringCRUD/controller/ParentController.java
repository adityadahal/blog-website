package com.example.SpringCRUD.controller;

import com.example.SpringCRUD.dto.StudentDataDto;
import com.example.SpringCRUD.model.PaymentData;
import com.example.SpringCRUD.model.StudentData;
import com.example.SpringCRUD.repo.ParentRepo;
import com.example.SpringCRUD.repo.PaymentRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ParentController {
//    @Autowired
    private final ParentRepo parentRepo;
    private final PaymentRepo paymentRepo;
    private ParentController(ParentRepo parentRepo, PaymentRepo paymentRepo){
        this.parentRepo = parentRepo;
        this.paymentRepo = paymentRepo;
    }


    @PostMapping("/data")

    public String createNewData(@RequestBody StudentDataDto studentDataDto) throws ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
        String date = studentDataDto.getDob();
        Date dp = dateParser.parse(date);
        studentDataDto.setDob(dateParser.format(dp));

        StudentData studentData = new StudentData();
        studentData.setDob(studentDataDto.getDob());
        studentData.setEmail(studentDataDto.getEmail());
        studentData.setFirstName(studentDataDto.getFirstName());

        PaymentData paymentData = paymentRepo.findById(studentDataDto.getPaymentId())
                        .orElseThrow(() -> new EntityNotFoundException("exception"));
        studentData.setPaymentData(paymentData);
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

    @GetMapping("/data/dob")
        public ResponseEntity <List<StudentData>> getByDob(@RequestParam String dob){
            return new ResponseEntity<List<StudentData>> (parentRepo.getByDob(dob), HttpStatus.OK);
        }

//        @GetMapping("/data/dob/year")
//    public  ResponseEntity <List<StudentData>> getDobByYear(@RequestParam String dobYear){
//        return  new ResponseEntity<List<StudentData>>(parentRepo.getByYear(dobYear), HttpStatus.OK);
//        }

}
