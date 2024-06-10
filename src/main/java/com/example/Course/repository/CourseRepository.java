package com.example.Course.repository;

import com.example.Course.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByLectureNameContainingIgnoreCaseOrPlaceContainingIgnoreCase(String keyword, String keyword1);
}
