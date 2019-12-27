package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.java1234.entity.Customer;
import com.java1234.repository.CustomerRepository;
import com.java1234.service.CustomerService;
import com.java1234.util.StringUtil;

/**
 * 客户Service实现类
 * @author java1234 小锋 老师
 *
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Resource
	private CustomerRepository customerRepository;
	

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> list(Customer customer, Integer page, Integer pageSize, Direction direction, String... properties) {
		Pageable pageable=new PageRequest(page-1, pageSize, direction,properties);
		Page<Customer> pageCustomer=customerRepository.findAll(new Specification<Customer>() {
			
			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(customer!=null){
					if(StringUtil.isNotEmpty(customer.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+customer.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		}, pageable);
		return pageCustomer.getContent();
	}

	@Override
	public Long getCount(Customer customer) {
		Long count=customerRepository.count(new Specification<Customer>() {

			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(customer!=null){
					if(StringUtil.isNotEmpty(customer.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+customer.getName().trim()+"%"));
					}	
				}
				return predicate;
			}
		});
		return count;
	}

	@Override
	public void delete(Integer id) {
		customerRepository.delete(id);
	}

	@Override
	public Customer findById(Integer id) {
		return customerRepository.findOne(id);
	}

	@Override
	public List<Customer> findByName(String name) {
		return customerRepository.findByName(name);
	}


}
