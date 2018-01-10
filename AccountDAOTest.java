package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.Random;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDAOTest {

	private String firstName;
	private String secondName;

	@Before
	public void setDataBeforeTest() {
		firstName = "Abcdefg";
		secondName = "Qwertyui";
		AccountDAO accDao = new AccountDAO();
		Account account = new Account(firstName, secondName);
		accDao.save(account);
	}

	@After
	public void deleteDataAfterTest() {
		AccountDAO accDao = new AccountDAO();
		accDao.delete(firstName, secondName);
	}

	@Test
	public void testUpdate() {

		AccountDAO accDao = new AccountDAO();

		assertNotNull(accDao.get(firstName, secondName).getEmail());

		Account updatedAccount = new Account();
		updatedAccount.setFirstName("Poiuytr");
		updatedAccount.setSecondName("Zxcvbnm");
		updatedAccount.setEmail("Poiuytr@ukr.net");
		updatedAccount.setPassword("123456789");

		accDao.update(firstName, secondName, updatedAccount);

		assertNull(accDao.get(firstName, secondName).getEmail());

		firstName = updatedAccount.getFirstName();
		secondName = updatedAccount.getSecondName();

		assertEquals(accDao.get(firstName, secondName).getEmail(), "Poiuytr@ukr.net");
	}

	@Test
	public void testSave() {
		AccountDAO acDaoTst = new AccountDAO();

		Random accDaoTst = new Random();
		int random_part = accDaoTst.nextInt(10) + 1;

		Account account = new Account();
		account.setFirstName("TestName" + random_part);
		account.setSecondName("TestsName" + random_part);
		account.setPassword("12345");
		account.setEmail("q@q.q" + random_part);

		acDaoTst.save(account);

		Account buff = acDaoTst.get(account.getFirstName(), account.getSecondName());

		assertEquals(account.getFirstName(), buff.getFirstName());
		assertEquals(account.getSecondName(), buff.getSecondName());
		assertEquals(account.getPassword(), buff.getPassword());
		assertEquals(account.getEmail(), buff.getEmail());
	}

	@Test
	public void testDelete() {
		AccountDAO accTst = new AccountDAO();

		Random acc = new Random();
		int random_part2 = acc.nextInt(10) + 1;

		Account account = new Account();
		account.setFirstName("TestName" + random_part2);
		account.setSecondName("TestsName" + random_part2);

		accTst.save(account);

		accTst.delete(account.getFirstName(), account.getSecondName());

		Account buff = accTst.get(account.getFirstName(), account.getSecondName());

		assertNull(buff.getFirstName());
		assertNull(buff.getSecondName());
		assertNull(buff.getPassword());
		assertNull(buff.getEmail());

	}
}