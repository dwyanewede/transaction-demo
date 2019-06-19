package com.sk.transaction.mybatis.service.impl;

import com.sk.transaction.mybatis.bean.User2;
import com.sk.transaction.mybatis.mapper1.User2Mapper;
import com.sk.transaction.mybatis.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User2ServiceImpl implements User2Service {
	@Autowired
	private User2Mapper user2Mapper;
	
	@Override
	public void truncate(){
		user2Mapper.truncated();
	}
	
	@Override
	public void add(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	public void addException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	public User2 get(Integer id){
		return user2Mapper.selectByPrimaryKey(id);
	}
	
	
	/* (non-Javadoc)
	 * @see org.transaction.test.local_transaction.mybatis.service.impl.User2Service#add(org.transaction.test.local_transaction.mybatis.bean.User2)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User2 user){
		user2Mapper.insert(user);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User2 getRequired(Integer id){
		return user2Mapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupports(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupportsException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupported(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupportedException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatory(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatoryException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void addNever(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void addNeverException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(User2 user){
		user2Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(User2 user){
		user2Mapper.insert(user);
		throw new RuntimeException();
	}
	
}