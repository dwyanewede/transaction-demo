package com.sk.transaction.mybatis.service.impl;

import com.sk.transaction.mybatis.bean.User1;
import com.sk.transaction.mybatis.bean.User2;
import com.sk.transaction.mybatis.service.TransactionPropagationExample;
import com.sk.transaction.mybatis.service.User1Service;
import com.sk.transaction.mybatis.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionPropagationExampleImpl implements TransactionPropagationExample {
	@Autowired
	private User1Service user1Service;
	@Autowired
	private User2Service user2Service;
	
	
	@Override
	public void truncated() {
		user1Service.truncate();
		user2Service.truncate();
	}
	
	
	@Override
	public void notransaction_exception_notransaction_notransaction(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	
	@Override
	public void notransaction_notransaction_notransaction_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addException(user2);
	}
	
	@Override
	@Transactional
	public void transaction_exception_notransaction_notransaction(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	/**
	 * 对user1数据源开启事务
	 */
	@Override
	@Transactional(value="user1TM")
	public void transaction_exception_notransaction_notransaction_user1(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	/**
	 * 对user2数据源开启事务
	 */
	@Override
	@Transactional(value="user2TM")
	public void transaction_exception_notransaction_notransaction_user2(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional
	public void transaction_notransaction_notransaction_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addException(user2);
	}
	
	/**
	 * 没有事务注解。
	 */
	@Override
	public void notransaction_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
	}
	
	/**
	 * 方法本身抛出异常
	 */
	@Override
	public void notransaction_exception_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
		
		throw new RuntimeException();
	}
	
	
	/**
	 * 调用方法抛出异常
	 */
	@Override
	public void notransaction_required_required_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiredException(user2);
	}
	
	/**
	 * 方法本身抛出异常
	 */
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
		
		throw new RuntimeException();
	}
	
	
	/**
	 * 调用方法抛出异常
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiredException(user2);
	}
	
	
	@Override
	public void notransaction_supports_supports_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupportsException(user2);
	}
	
	@Override
	public void notransaction_exception_supports_supports(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupports(user2);
		throw new RuntimeException();
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_supports_supports_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupportsException(user2);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_supports_supports(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupports(user2);
		
		throw new RuntimeException();
	}
	
	
	
	@Override
	public void notransaction_requiresNew_requiresNew_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequiresNew(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNewException(user2);
	}
	
	@Override
	public void notransaction_exception_requiresNew_requiresNew(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequiresNew(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		throw new RuntimeException();
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		
		User2 user3=new User2();
		user3.setName("王五");
		user2Service.addRequiresNewException(user3);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		User2 user3=new User2();
		user3.setName("王五");
		try {
			user2Service.addRequiresNewException(user3);
		} catch (Exception e) {
			System.out.println("回滚");
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_requiresNew_requiresNew(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		
		User2 user3=new User2();
		user3.setName("王五");
		user2Service.addRequiresNew(user3);
		
		throw new RuntimeException();
	}
	
	
	@Override
	public void notransaction_exception_required_notSuppored(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupported(user2);
		throw new RuntimeException();
	}
	
	@Override
	public void notransaction_required_notSuppored_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupportedException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_exception_required_notSuppored(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupported(user2);
		throw new RuntimeException();
	}	
	
	@Transactional
	@Override
	public void transaction_required_notSuppored_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupportedException(user2);
	}

	
	@Override
	public void notransaction_mandatory(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
	}
	
	@Transactional
	@Override
	public void transaction_exception_mandatory_mandatory(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addMandatory(user2);
		throw new RuntimeException();
	}
	
	
	@Transactional
	@Override
	public void transaction_mandatory_mandatory_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addMandatoryException(user2);
	}
	

	
	@Override
	public void notransaction_exception_never_never(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNever(user2);
		throw new RuntimeException();
	}
	
	@Override
	public void notransaction_never_never_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNeverException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_never(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
	}
	
	
	@Transactional
	@Override
	public void transaction_exception_nested_nested(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNested(user2);
		throw new RuntimeException();
	}
	
	@Transactional
	@Override
	public void transaction_nested_nested_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNestedException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_nested_nested_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addNestedException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
	
	@Transactional
	@Override
	public void transaction_required_required_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addRequiredException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
	
	@Transactional
	@Override
	public void transaction_noTransaction_noTransaction_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
	
	
}