package com.dlviet.Courses.Service;

import com.dlviet.Courses.Model.Course;
import com.dlviet.Courses.Model.Review;
import com.dlviet.Courses.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> singleCourse(String courseNumber) {
        return repository.findCourseByNumber(courseNumber);
    }

    public double averageDifficulty(String courseNumber) {
        Optional<Course> optionalCourse = singleCourse(courseNumber);

        return optionalCourse.map(course -> course.getReview_ids().stream()
                        .mapToDouble(r -> {
                            try {
                                return Double.parseDouble(r.getDifficulty());
                            } catch (NumberFormatException e) {
                                return 0.0;
                            }
                        })
                        .average()
                        .orElse(0.0))
                .orElse(0.0);
    }

}
