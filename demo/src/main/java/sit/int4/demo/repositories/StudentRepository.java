package sit.int4.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int4.demo.entites.Student;

public interface StudentRepository extends
    JpaRepository<Student,Integer> {
}
