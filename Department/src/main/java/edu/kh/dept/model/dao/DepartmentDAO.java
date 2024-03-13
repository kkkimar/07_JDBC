package edu.kh.dept.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dto.Department;

public interface DepartmentDAO {

	/** 부서 전체 조회
	 * @param conn
	 * @return deptList
	 * @throws SQLExceptionl
	 */
	List<Department> selectAll(Connection conn) throws SQLException;

	
	/** 부서 추가
	 * @param conn
	 * @param dept
	 * @return result
	 */
	int insertDepartment(Connection conn, Department dept) throws SQLException;

}
