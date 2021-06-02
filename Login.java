package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	static Login frame = new Login();
	static KhachHang kh = new KhachHang();
	static Home home = new Home();
	static NhanVien nv = new NhanVien();
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(56, 35, 441, 298);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblNewLabel_2.setBounds(183, 17, 97, 30);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(lblNewLabel_2);

		username = new JTextField();
		username.setBounds(116, 85, 216, 30);
		panel_1.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\full\\New folder\\Person-Male-Light-icon.png"));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(116, 55, 132, 30);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_1_1
				.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\full\\New folder\\Status-dialog-password-icon.png"));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(116, 126, 124, 30);
		panel_1.add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username.getText().equals("admin") && password.getText().equals("admin")) {
					home.setVisible(true);
					frame.dispose();
				} else
					JOptionPane.showMessageDialog(rootPane, "Đăng nhập thất bại");
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(166, 214, 131, 40);
		panel_1.add(btnNewButton);

		password = new JPasswordField();
		password.setBounds(116, 155, 216, 30);
		panel_1.add(password);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(-101, 5, 700, 433);
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\ASUS\\Desktop\\mo-phong-tap-gym-can-chuan-bi-nhung-gi-1479657301939.jpg"));
		panel.add(lblNewLabel);
	}
}
