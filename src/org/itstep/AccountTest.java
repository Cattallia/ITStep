package org.itstep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.itstep.dao.AccountDAO;
import org.itstep.model.Account;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testSave() {
		AccountDAO a = new AccountDAO();
		
		Random r = new Random();
		int random_part = r.nextInt(10) + 1;
		
		Account account = new Account();
		account.setFirstName("TestName" + random_part);
		account.setSecondName("TestsName" + random_part);
		account.setPassword("12345");
		account.setEmail("q@q.q" + random_part);
		
		a.save(account);
		
		Account buff = a.get(account.getFirstName(), account.getSecondName());
		
		assertEquals(account.getFirstName(), buff.getFirstName());
		assertEquals(account.getSecondName(), buff.getSecondName());
		assertEquals(account.getPassword(), buff.getPassword());
		assertEquals(account.getEmail(), buff.getEmail());		
	}

}
