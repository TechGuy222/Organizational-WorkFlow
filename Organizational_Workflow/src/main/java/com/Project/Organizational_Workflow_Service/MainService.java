package com.Project.Organizational_Workflow_Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Organizational_Workflow_DAO.MainDao;
import com.Project.Organizational_Workflow_Entity.Country;
import com.Project.Organizational_Workflow_Entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;

	public String addCountry(Country c) {
		
		String msg= dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country is Not addedd";
		}
				
		return msg;
	}

	public String updateCountry(Country c, int id) {
		String msg= dao.updateCountry(c,id);
		if(Objects.isNull(msg)) {
			msg="Country is not Updated";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		
		String msg= dao.deleteCountry(id);
		if(Objects.isNull(msg)) {
			msg="Country is not Deleted";
		}
		return msg;

	}

	public List<Country> getAllCountry() {
		
		List<Country> list=dao.getAllCountry();		
		
		return list;
	}

	public Country getParticularCountryById(int id) {
		Country con= dao.getParticularCountryById(id);
		return con;
	}

	public String addEmployee(Employee emp) {
		String msg= dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Employee Addedd Successfully";
			
		}
		return msg;
		
	}

	public Map<String, Object> login(Employee emp) {
		
		Employee obj= dao.login(emp);
		Map<String, Object> map=new HashMap<String, Object>();
		if(Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		}else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}
		
		return map;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
	
			List<Employee> list= dao.salaryRange(startSal,endSal);
		
		return list;
	}
}
