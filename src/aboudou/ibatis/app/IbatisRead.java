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

public class IbatisRead {

	static Logger logger = LoggerFactory.getLogger(IbatisRead.class);
	
	public static void main(String[] args) throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		
		logger.info("Going to read records .....");
		List<Employee> employeeLists =(List<Employee>) sqlMapClient.queryForList("Employee.getAll", null);
		
		Employee em = null;
		
		for(Employee employee: employeeLists) {
			logger.info(employee.toString());
			employee = em;
		}

		logger.info("Records read successfully ");
	}

}
