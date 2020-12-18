package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("=== TEST 1: dep findByID ===");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		System.out.println();
		
		System.out.println("=== TEST 2: dep findAll ===");
		List<Department> list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("=== TEST 4: dep insert ===");
		Department newDep = new Department(null, "D1");
		depDao.insert(newDep);
		System.out.println("Inserted! new id = " + newDep.getId());
		System.out.println();
		
		System.out.println("=== TEST 5: dep update ===");
		dep = depDao.findById(1);
		dep.setName("Computers");
		depDao.update(dep);
		System.out.println("Update completed");
		System.out.println();
		
		System.out.println("=== TEST 6: dep delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
