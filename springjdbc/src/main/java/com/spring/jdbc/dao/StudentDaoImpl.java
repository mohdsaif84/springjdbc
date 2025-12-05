
package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;
    
	public int insert(Student student) {
		 //insert query
              String query ="insert into student(id,name,city) values(?,?,?)";
              int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		      return r;
}
	
	@Override
	public int change(Student student) {
		// update data
		 String query="update student set name=? , city=? where id=?";
		 int r = this.jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	@Override
	public int delete(int studentId) {
		// delete operation
		String query="delete from student where id=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}
	@Override
	public Student getStudent(int studentId) {
		// select single student data
		String query="select *from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		
		return student;
	}
	
	@Override
	public List<Student> getAllStudents() {
		// select multiple all student data
		String query = "select *from student"; 
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}
	@Autowired
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
