package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HomeWindow extends JFrame {

	JList<ListItem> linkList;
	JPanel cards;
	JPanel consoleBar;

	ListItem itemLogin = new ListItem("Login", true);
	ListItem itemBookTitle = new ListItem("View Titles", false);
	ListItem itemAddBook = new ListItem("Add Book", false);
	JLabel txtConsole = new JLabel("Welcome to the Book Club!");

	boolean loginStatus = false;

	List<String> bookList = Data.bookTitles;

	ListItem[] group1 = {itemLogin, itemBookTitle, itemAddBook};
	ListItem[] group2 = {itemLogin};

	public HomeWindow() {

		setSize(600, 450);

		createLinkLabels();
		createMainPanels();
		createButtonBar();
		linkList.addListSelectionListener(event -> {
			String value = linkList.getSelectedValue().getItemName();
			boolean allowed = linkList.getSelectedValue().highlight();
			System.out.println(value + " " + allowed);

			CardLayout cl = (CardLayout) (cards.getLayout());

			if (!allowed) {
				value = itemLogin.getItemName();
				linkList.setSelectedIndex(0);
			}
			cl.show(cards, value);
		});

		// set up split panes

		JSplitPane innerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				linkList, cards);

		innerPane.setDividerLocation(150);
		JSplitPane outerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				innerPane, consoleBar);
		outerPane.setDividerLocation(350);
		add(outerPane, BorderLayout.CENTER);
	}

	public void createButtonBar() {
		consoleBar = new JPanel();
		consoleBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtConsole.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtConsole.setForeground(new Color(59, 42, 145));
		consoleBar.setBackground(new Color(255, 255, 255));
		consoleBar.add(txtConsole);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void updateList(ListItem[] items) {
		DefaultListModel<ListItem> model = (DefaultListModel) linkList.getModel();
		int size = model.getSize();
		if (items != null) {
			List<Integer> indices = new ArrayList<>();
			for (ListItem item : items) {
				int index = model.indexOf(item);
				indices.add(index);
				ListItem next = (ListItem) model.get(index);
				next.setHighlight(true);

			}
			for (int i = 0; i < size; ++i) {
				if (!indices.contains(i)) {
					ListItem next = (ListItem) model.get(i);
					next.setHighlight(false);
				}
			}
		} else {
			for (int i = 0; i < size; ++i) {
				ListItem next = (ListItem) model.get(i);
				next.setHighlight(true);
			}
		}
	}

	@SuppressWarnings("serial")
	public void createLinkLabels() {
	    DefaultListModel<ListItem> model = new DefaultListModel<>();
		model.addElement(itemLogin);
		model.addElement(itemBookTitle);
		model.addElement(itemAddBook);
	
		linkList = new JList<ListItem>(model);
	    linkList.setCellRenderer(new DefaultListCellRenderer() {

			@SuppressWarnings("rawtypes")
			@Override
			public Component getListCellRendererComponent(JList list, 
					Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, 
						value, index, isSelected, cellHasFocus);
				if (value instanceof ListItem) {
					ListItem nextItem = (ListItem) value;
					setText(nextItem.getItemName());
					if (nextItem.highlight()) {
						setForeground(Util.LINK_AVAILABLE);
					} else {
						setForeground(Util.LINK_NOT_AVAILABLE);
					}
					if (isSelected) {
						setForeground(Color.BLACK);
						setBackground(new Color(236,243,245));
					}
				} else {
					setText("illegal item");
				}
				return c;
			}

		});
	}

	public void createMainPanels() {
		// item1 panel
		ItemLoginPanel p1 = new ItemLoginPanel();
		JPanel panel1 = p1.getMainPanel();

		// item2 panel
		ItemViewTitlePanel p2 = new ItemViewTitlePanel();
		JPanel panel2 = p2.getMainPanel();

		// item3 panel
		ItemAddBookPanel p3 = new ItemAddBookPanel();
		JPanel panel3 = p3.getMainPanel();

		cards = new JPanel(new CardLayout());
		cards.add(panel1, itemLogin.getItemName());
		cards.add(panel2, itemBookTitle.getItemName());
		cards.add(panel3, itemAddBook.getItemName());
	}

	class ItemLoginPanel {
		JPanel mainPanel = new JPanel();
		JLabel lblLogin = new JLabel("Login");
		JLabel lblUsername = new JLabel("Username");
		JLabel lblPassword = new JLabel("Password");
		JTextField txtUserName, txtPassword;

		JButton btnLogin = new JButton("Login");


		ItemLoginPanel() {
			mainPanel.setLayout(null);
			lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblLogin.setBounds(0, 0, 156, 41);
			lblLogin.setForeground(new Color(59, 42, 145));
			mainPanel.add(lblLogin);

			txtUserName = new JTextField();
			txtUserName.setBounds(5, 40, 130, 20);
			mainPanel.add(txtUserName);
			txtUserName.setColumns(10);

			lblUsername.setBounds(10, 65, 77, 19);
			mainPanel.add(lblUsername);

			txtPassword = new JPasswordField();
			txtPassword.setBounds(150, 40, 130, 20);
			mainPanel.add(txtPassword);

			lblPassword.setBounds(155, 65, 77, 19);
			mainPanel.add(lblPassword);


			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					doLogIn();
				}
			});
			btnLogin.setForeground(new Color(0, 0, 0));
			btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
			btnLogin.setBounds(155, 100, 89, 23);
			mainPanel.add(btnLogin);
		}

		JPanel getMainPanel() {
			return mainPanel;
		}

		private void doLogIn(){
			for (User user : Data.logins) {
				if (txtUserName.getText().equals(user.username) && txtPassword.getText().equals(user.password)){
					loginStatus = true; break;
				}
			}
			if (loginStatus) {
				updateList(group1);
				repaint();
				txtConsole.setText("Login Successful!!!");
				txtConsole.setForeground(new Color(10, 93, 35));
			}else {
				updateList(group2);
				repaint();
				txtConsole.setText("Login Fail. Please Try again!!!");
				txtConsole.setForeground(new Color(240, 51, 51, 180));
			}
		}

	}

	class ItemViewTitlePanel {
		JPanel mainPanel = new JPanel();

		JLabel lblViewTitle = new JLabel("View Title");

		private JList<String> mainList;
		private JScrollPane mainScroll;

		private DefaultListModel<String> listModel = new DefaultListModel<String>();

		ItemViewTitlePanel() {
			mainPanel.setLayout(null);

			lblViewTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblViewTitle.setBounds(0, 0, 156, 41);
			lblViewTitle.setForeground(new Color(59, 42, 145));
			mainPanel.add(lblViewTitle);

			mainList = createJList();

			listModel.addAll(bookList);

			mainList.setFixedCellWidth(200);
			mainList.setFixedCellHeight(20);
			mainScroll = new JScrollPane(mainList);
			JPanel jListPanel = new JPanel();
			jListPanel.add(mainScroll);
			jListPanel.setBounds(50, 50, 250, 250);
			mainPanel.add(jListPanel);
		}

		JPanel getMainPanel() {
			return mainPanel;
		}

		private JList<String> createJList() {
			JList<String> ret = new JList<String>(listModel);
			ret.setVisibleRowCount(4);
			return ret;
		}

	}

	class ItemAddBookPanel {
		JPanel mainPanel = new JPanel();
		JLabel lblAddBookTitle = new JLabel("Add Book Title");
		JLabel lblFirstName = new JLabel("Author First Name");
		JLabel lblLastName = new JLabel("Author Last Name");
		JLabel lblBookTitle = new JLabel("Book Title");

		JTextField txtFirstName, txtLastName, txtBookTitle;
		JButton btnAddBook = new JButton("Add Book");

		ItemAddBookPanel() {
			mainPanel.setLayout(null);
			lblAddBookTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			lblAddBookTitle.setBounds(0, 0, 156, 41);
			lblAddBookTitle.setForeground(new Color(59, 42, 145));
			mainPanel.add(lblAddBookTitle);

			lblFirstName.setBounds(50, 60, 130, 20);
			mainPanel.add(lblFirstName);

			txtFirstName = new JTextField();
			txtFirstName.setBounds(200, 60, 150, 20);
			txtFirstName.setColumns(15);
			mainPanel.add(txtFirstName);

			lblLastName.setBounds(50, 90, 130, 20);
			mainPanel.add(lblLastName);

			txtLastName = new JTextField();
			txtLastName.setBounds(200, 90, 150, 20);
			txtLastName.setColumns(15);
			mainPanel.add(txtLastName);

			lblBookTitle.setBounds(50, 120, 130, 20);
			mainPanel.add(lblBookTitle);

			txtBookTitle = new JTextField();
			txtBookTitle.setBounds(200, 120, 150, 20);
			txtBookTitle.setColumns(15);
			mainPanel.add(txtBookTitle);

			btnAddBook.setBounds(120, 170, 120, 30);
			mainPanel.add(btnAddBook);

			btnAddBook.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (txtBookTitle.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty()){
						txtConsole.setText("Add Book title fail. Please provide complete information.");
						txtConsole.setForeground(new Color(240, 51, 51, 180));
						updateList(group2);
						repaint();
					}else {
						bookList.add(txtBookTitle.getText());
						txtConsole.setText("Add Book Title Successful!!!");
						txtConsole.setForeground(new Color(10, 93, 35));
						updateList(group1);
						repaint();
					}
				}
			});

		}

		JPanel getMainPanel() {
			return mainPanel;
		}

	}
	private static final long serialVersionUID = -7438493168871970597L;
}
