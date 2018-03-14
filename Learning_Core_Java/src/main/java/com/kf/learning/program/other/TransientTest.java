package com.kf.learning.program.other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientTest {
	public static void main(String[] args) {
		User user = new User();
		user.setPassWord("123");
		user.setUserName("TransientTest");
		System.out.println(user);
		try(ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream("D:/TransientTest.txt"))) {
			oout.writeObject(user);
			ObjectInputStream oin=new ObjectInputStream(new FileInputStream("D:/TransientTest.txt"));
			Object readObject = oin.readObject();
			oin.close();
			System.out.println(readObject);
			
		} catch (Exception e) {
		}
	}
}

class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private transient String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@Override
	public String toString() {
		return this.getUserName()+":"+this.getPassWord();
	}
}
