package com.saxena.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saxena.dto.AllCustomer;
import com.saxena.model.Customer;
import com.saxena.model.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * 
	 * @param request
	 */
	public void createNewCustomer(Customer request) {
		customerRepository.save(request);
	}

	/**
	 * 
	 * @return
	 */
	public AllCustomer getAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		return AllCustomer.builder().customers(list).build();
	}

	/**
	 * 
	 * @param request
	 */
	public void updateCustomer(Customer request) {
		Customer customer = customerRepository.findByCustId(request.getCustId());
		customer.setName(request.getName());
		customer.setAmount(request.getAmount());
		customer.setModifiedDate(new Date());
		customerRepository.save(customer);
	}

	/**
	 * 
	 * @param custId
	 */
	public void deleteCustomer(String custId) {
		Customer customer = customerRepository.findByCustId(custId);
		customerRepository.delete(customer);
	}

	public Customer getCustomer() {
		Customer customer = customerRepository.findByCustId("100");
		return customer;
	}

	public void initializeDB() {
		int count = 0;
		for (int i = 1; i <=10; i++) {
			//////////////////////////////////////////////////////
			List<String> firstNameList = Arrays.asList("Ram", "Sunita", "Sri", "Anita", "Santosh", "Sanjay", "Sunil",
					"Rajesh", "Gita", "Ramesh", "Ashok", "Rekha", "Manoj", "Anil", "Suresh", "Vijay", "Lakshmi", "Mo",
					"Anuj", "Raju", "Manju", "Shanti", "Vinod", "Suman", "Rajendra", "Raj", "Usha", "Asha", "Dinesh",
					"Rakesh", "Krishna", "Mina", "Kiran", "Dilip", "Pushpa", "Ajay", "Laxmi", "Urmila", "Mukesh",
					"Amit", "Sita", "Rita", "Sushila", "Shankar", "Mohan", "Ravi", "Lalita", "Radha", "Sima", "Sangita",
					"Savitri", "Rani", "Munni", "Ganesh", "Sumitra", "Nirmala", "Rina", "Savita", "Gopal", "Maya",
					"Arun", "Rama", "Shiv", "Rahul", "Mahesh", "Jitendra", "Kamal", "Prakash", "Saroj", "Surendra",
					"Sarita", "Jyoti", "Mahendra", "Kavita", "Mamta", "Pa", "Pramod", "Mira", "Subhash", "Punam",
					"Narayan", "Pradip", "Kalpana", "Kamla", "Shobha", "Prem", "Uma", "Ranjit", "Smt", "Umesh", "A",
					"Ravindra", "Dipak", "Pankaj", "Shakuntala", "Naresh", "Shyam", "Pramila", "Basanti", "Parvati",
					"Ka", "Priyanka", "Saraswati", "Kamala");
			Random randFirstName = new Random();
			String firstName = firstNameList.get(randFirstName.nextInt(firstNameList.size()));

			List<String> lastNameList = Arrays.asList("Bedi", "Basu", "Chopra", "Gupta", "Iyer", "Joshi", "Jha", "Jain",
					"Kumar", "Kapoor", "Kulkarni", "Khanna", "Malhotra", "Mehta", "Naidu", "Pandey", "Patel", "Pillai",
					"Reddy", "Saxena", "Seth", "Shah", "Sharma", "Singh,", "Varma", "Acharya", "Adhikari", "Agarwal",
					"Agnihotri", "Apte", "Bajwa", "Bakshi", "Bal", "Balakrishna", "Bandhopadhyay", "Bawa", "Bhagat",
					"Bhalla", "Bhandari", "Dave", "Dayal", "Desai", "Fadnavis", "Gaidher", "Godbole", "Guha", "Arya",
					"Awasthi", "Bharadwaj", "Amin", "Bhargava", "Bhatt", "Bhattacharya", "Chakravarti", "Chattopadhyay",
					"Chowdhury", "Chabbra", "Chadha", "Deora", "Deshmukh", "Deshpande, ", "Dubashi", "Gairola",
					"Ganguly", "Garg", "Kapadia", "Mehra", "Mishra", "Mukhopadhyay", "Shukla", "Trivedi 	",
					"Ahluwalia", "Ahuja", "Arora", "Chaturvedi", "Chawla", "Das", "Dewan", "Dhar", "Dhawan", "Dutta",
					"Dwivedi", "Gill", "Gokhale", "Ghosh", "Gandhi", "Johar", "Kakkar", "Kaul", "Kaur", "Kashyap",
					"Khan", "Khanna", "Khatri", "Kocchar", "Kohli", "Krishna", "Lal", "Mahajan", "Malik", "Nehru",
					"Rana", "Saini", "Sethi", "Tagore", "Talwar", "Tandon");
			Random randLastName = new Random();
			String lastName = lastNameList.get(randLastName.nextInt(lastNameList.size()));
			//////////////////////////////////////////////////////
			Customer customer = new Customer();
			customer.setName(firstName + " " + lastName);
			customer.setCustId(randBetween(1,250)+"");
			customer.setAmount(ThreadLocalRandom.current().nextFloat()*100 + "");
			customer.setCreationDate(new Date());
			customer.setModifiedDate(new Date());
			createNewCustomer(customer);
			count++;
			
		}
		System.out.println(count + " Record inserted successfully");
	}

	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
