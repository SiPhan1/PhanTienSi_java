package com.example.Course.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "lecture_name", nullable = false)
    @NotBlank(message = "Tên giảng viên không được để trống")
    @Size(max = 100, message = "Tên giảng viên tối đa {max} ký tự")
    private String lectureName;

    @Column(name = "place", nullable = false)
    @NotBlank(message = "Bắt Buộc Điền")
    @Pattern(regexp = "\\S+", message = "Địa Điểm không Được Để Trống")
    private String place;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public Course() {
    }

    public Course(String lectureName, String place, LocalDate startDate) {
        this.lectureName = lectureName;
        this.place = place;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

