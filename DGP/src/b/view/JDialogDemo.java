package b.view;

import javax.swing.JFrame;  
import javax.swing.JDialog;  
import javax.swing.JButton;  
  
import java.awt.Dimension;  
import java.awt.FlowLayout;  
import java.awt.Frame;  
import java.awt.Toolkit;  
  
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;  
  
public class JDialogDemo extends JFrame implements ActionListener {  
    private JButton b1;  
    private JDialog dialog;  
      
    public JDialogDemo() {  
        init();  
    }  
      
    public void init() {  
        this.setTitle("JDialog的应用");  
        this.setSize(500, 400);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocation(300, 100);  
        this.setResizable(false);  
        this.getContentPane().setLayout(new FlowLayout());  
          
        Toolkit tkit = Toolkit.getDefaultToolkit();  
        Dimension screenSize = tkit.getScreenSize();  
        Dimension frameSize = this.getSize();  
        setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height)/2);  
          
        b1 = new JButton("点击查看JDialog");  
        this.getContentPane().add(b1);  
        b1.addActionListener(this);  
          
        this.setVisible(true);  
    }  
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
        Object o = e.getSource();  
        if (o == b1) {  
//        	 dialog = new JDialog(this, "我是一个JDialog", true);  
//             dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
//             dialog.setSize(300, 200);  
//             dialog.setVisible(true);  
            new GameDialog(this);
        }  
    }  
      
    public static void main(String[] args) {  
        new JDialogDemo();  
    }  
  
}  

