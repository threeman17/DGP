package a.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import a.bean.UserInfo;
import a.dao.UserInfoDao;

public class RankingListWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel titlePanel;
	private JLabel title;
	private JButton close;
	private Font font=new Font("平体",Font.BOLD,24);
	private JPanel contentPanel;
	private String [] his={
			
			"账号",
			"昵称",
			"积分",
			"等级"
			};
	private List<UserInfo> list=new ArrayList<UserInfo>();
	
	
	
	
	public RankingListWindow() throws HeadlessException {
		this.setSize(800, 600);
		this.setTitle("巅峰榜");
		//清除布局
		this.setLayout(null);
		//去除装饰,使用我们自定义的装饰
		this.setUndecorated(true);
		Color gold=new Color(255,215,0);
		 Color zi=new Color(148,0,211);
		//初始化标题面板
		titlePanel=new JPanel();
		//设置标题面板的宽度和主窗口一样,高度为48
		titlePanel.setBounds(0, 0,this.getWidth(), 32);
		//清除标题面板的布局
		titlePanel.setLayout(null);
		//初始化关闭按钮
		close=new JButton(new ImageIcon("img/vclose.png"));
		//关闭的颜色
		Color te=new Color(240,255,255);
		close.setBackground(gold);
		//位于最大化按钮右侧
		close.setBounds(titlePanel.getWidth()-32,0,32,titlePanel.getHeight());
		//清除边框
		close.setBorder(null);
		//支持鼠标对窗口的拖动操作
				titlePanel.addMouseMotionListener(new MouseMotionListener() {
					private int x=-1,y=-1;//存储上一次鼠标的位置
					@Override
					public void mouseMoved(MouseEvent e) {
						
					}
					@Override
					public void mouseDragged(MouseEvent e) {
						//鼠标拖拽事件
						if(x==-1&&y==-1){
							x=e.getX();
							y=e.getY();
						}else{
							//将当前x坐标的值减去鼠标在x方向的移动量
							int nx=RankingListWindow.this.getLocation().x+e.getX()-x;
							//将当前y坐标的值减去鼠标在y方向的移动量
							int ny=RankingListWindow.this.getLocation().y+e.getY()-y;
							RankingListWindow.this.setLocation(nx, ny);
						}
					}
				});
		//窗口标题
		title=new JLabel(this.getTitle(),JLabel.CENTER);
		title.setFont(font);
		//窗口标题的宽度是从窗口图标位置开始到最小化按钮位置结束
		title.setBounds( 0,0,titlePanel.getWidth(), titlePanel.getHeight());
		//添加点击按钮时的操作
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//退出程序
				close();
			}
		});
		//初始化内容面板
		contentPanel=new JPanel();
		contentPanel.setBounds(0,titlePanel.getY()+titlePanel.getHeight(), this.getWidth(), this.getHeight()-(titlePanel.getY()+titlePanel.getHeight()));
		//设置内容面的颜色
		Color tc=new Color(135,206,250);
		contentPanel.setBackground(tc);
		contentPanel.setLayout(null);
		//设置标题栏的颜色
		titlePanel.setBackground(gold);
		//将标题栏用到的组件添加到标题栏中
		titlePanel.add(title);
		titlePanel.add(close);
		//将标题栏添加到内容面板中
		contentPanel.add(titlePanel);
		//将窗口的内容面板设置为自定义的面板
		this.setContentPane(contentPanel);
		this.setLocationRelativeTo(null);
		 DefaultTableModel listRe=new DefaultTableModel();
		 listRe.setColumnIdentifiers(his);
		try {
			list=UserInfoDao.selrank();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++) 
		  { 
			 Object[] rowdata={
					 			list.get(i).getAccount(),list.get(i).getNick_name(),
					 			list.get(i).getIntegral(),
					 			(int)list.get(i).getXp()/100
					 			};
			 listRe.addRow(rowdata);
		} 
		 JTable table = new JTable(listRe);
		 table.setPreferredScrollableViewportSize(new Dimension(780,548));
		 table.setBackground(te);
		 table.setForeground(zi);
		 table.getTableHeader().setBackground(te);
		 table.getTableHeader().setForeground(gold);
		 JScrollPane JP= new JScrollPane(table);
		 JP.setBounds(0, 32,this.getWidth(),this.getHeight()-32);
		contentPanel.add(JP);
		this.setVisible(true);
	}
	public void close(){
		this.dispose();
	}
}
