package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestKeyListener extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestKeyListener(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 1, 2, 2));
		// 选择角色
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("选择角色："));
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("教师");
		jcb.addItem("学生");
		jcb.setSelectedIndex(1);
		panel1.add(jcb);
		c.add(panel1);
		// 输入学号
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("输入学号："));
		FgTextField txtNum = new FgTextField("", 15, true);
		panel2.add(txtNum);
		c.add(panel2);
		// 输入密码
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("输入密码："));
		panel3.add(new JPasswordField("", 15));
		c.add(panel3);
		// 登录按钮
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel4.add(new JButton("登录"));
		panel4.add(new JButton("取消"));
		c.add(panel4);
	}

	public static void main(String args[]) {
		TestKeyListener f = new TestKeyListener("键盘事件");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}

// 自定义单行文本框，从JTextField继承过来
class FgTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean m_bOnlyInteger;// 用于指示是否只允许输入整数

	FgTextField(String sText, int columns, boolean bOnlyInteger) {
		super(sText, columns);

		m_bOnlyInteger = bOnlyInteger;
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (m_bOnlyInteger) {
					char c = e.getKeyChar();
					if (c < '0' | c > '9')
						e.consume(); // 取消输入
				}
			}
		});
	}
}
