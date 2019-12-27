package com.java1234.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.java1234.entity.Log;

/**
 * 系统日志Repository接口
 * @author java1234 小锋 老师
 *
 */
public interface LogRepository extends JpaRepository<Log, Integer>,JpaSpecificationExecutor<Log>{

	
}
