package com.example.SpringCRUD.repo;

import com.example.SpringCRUD.model.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParentRepo extends JpaRepository <StudentData, Integer> {

    List<StudentData> findByFirstNameOrLastName(String firstName, String lastName);
}
