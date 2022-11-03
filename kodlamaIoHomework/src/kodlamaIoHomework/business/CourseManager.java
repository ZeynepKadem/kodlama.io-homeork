package kodlamaIoHomework.business;

import java.util.List;

import kodlamaIoHomework.dataAccess.CourseRepository;
import kodlamaIoHomework.entities.Course;
import kodlamaIoHomework.loging.Logger;

public class CourseManager {
	private CourseRepository courseRepository;
	private List<Logger> loggers;
	
	
	public CourseManager() {
		
	}

	public CourseManager(CourseRepository courseRepository, List<Logger> loggers) {
		
		this.courseRepository = courseRepository;
		this.loggers = loggers;
	}
	
	public void add(Course course)throws Exception {
		if (course.getPrice()<0) {
			throw new Exception("kursun fiyat� 0 dan k���k olamaz.");
		}
		
		if (courseRepository.check(course.getCourseName())) {
			throw new Exception("kurs ad� ayn� olamaz");
		}
		courseRepository.add(course);
		 for (Logger logger : loggers) {
			logger.log(course.getCourseName());
		}
		
			
		
	}

}
