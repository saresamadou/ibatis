package aboudou.ibatis.app;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import aboudou.ibatis.model.Employee;

public class IbatisUpdate  {

	static Logger logger = LoggerFactory.getLogger(IbatisUpdate.class);
	
	public static void main(String[] args) throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		
		logger.info("Going to update record .....");
		
		Employee employeeToUpdate = new Employee();
		employeeToUpdate.setId(1);
		employeeToUpdate.setFirst_name("SARRE");
		sqlMapClient.update("Employee.update", employeeToUpdate);
		
		logger.info("Record update successfully ");
	}
}
