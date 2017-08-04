package a.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import a.mail.MailUtils;

public class MailService {
	public static void register(String email,String nickname) {
		String sub="你好，尊敬的堆糖游戏玩家"+nickname+"，欢迎加入堆糖游戏平台这个大家庭";
		String content="堆糖游戏平台（Duitang Game Platform）是虹猫1703班三人行小组的java GUI初级项目。该项目是一个游戏平台，提供各种好玩简单方便的游戏，玩家可以通过玩游戏获得积分，然后在商城购买道具。";
		try {
			MailUtils.sendMail(email, sub, content);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
