package a.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMail {
	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("1293193511@qq.com", "测试邮件", "测试内容");
	}
}
