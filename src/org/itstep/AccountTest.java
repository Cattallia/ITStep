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

	@Test
	public void testUpdate() {
		AccountDAO c = new AccountDAO();
		
		Random b = new Random();
		int random_part1 = b.nextInt(10) + 1;
		
		Account account = new Account();
		account.setFirstName("TestName" + random_part1);
		account.setSecondName("TestsName" + random_part1);
		account.setPassword("12345");
		account.setEmail("q@q.q" + random_part1);

		c.save(account);
		
		String first_name = account.getFirstName();
		String second_name = account.getSecondName();

		account.setFirstName("FirstName1" + random_part1);
		account.setSecondName("SecondName1" + random_part1);
		account.setPassword("8721" + random_part1);
		account.setEmail("fm@sgd.gs" + random_part1);

		c.update(first_name, second_name, account);

		Account buff = c.get(account.getFirstName(), account.getSecondName());

		assertEquals(account.getFirstName(), buff.getFirstName());
		assertEquals(account.getSecondName(), buff.getSecondName());
		assertEquals(account.getPassword(), buff.getPassword());
		assertEquals(account.getEmail(), buff.getEmail());
	}

	@Test
	public void testDelete() {
		AccountDAO b = new AccountDAO();

		Random r = new Random();
		int random_part2 = r.nextInt(10) + 1;

		Account account = new Account();
		account.setFirstName("TestName" + random_part2);
		account.setSecondName("TestsName" + random_part2);

		b.save(account);

		b.delete(account.getFirstName(), account.getSecondName());
		
		Account buff = b.get(account.getFirstName(), account.getSecondName());

		assertNull(buff.getFirstName());
		assertNull(buff.getSecondName());
		assertNull(buff.getPassword());
		assertNull(buff.getEmail());
		

	}
}