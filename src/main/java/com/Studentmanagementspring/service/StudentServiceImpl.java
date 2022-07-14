package com.Studentmanagementspring.service;

	import java.util.List;

	import com.Studentmanagementspring.entity.Student;
	import com.Studentmanagementspring.repository.StudentRepository;

	import org.springframework.beans.factory.annotation.Autowired;


	import org.springframework.stereotype.Service;

	@Service
	public class StudentServiceImpl implements StudentServices {

		@Autowired
		private StudentRepository studentRepository;

		@Override
		public List<Student> findAll() {
		
			List<Student> students = studentRepository.findAll();
			return students;
		}

		@Override
		public Student findById(int theId) {
			Student student = studentRepository.findById(theId).get();
			return student;
		}

		@Override
		public void save(Student thestudent) {
			studentRepository.save(thestudent);
		}

		@Override
		public void deleteById(int theId) {

			studentRepository.deleteById(theId);

		}

}
