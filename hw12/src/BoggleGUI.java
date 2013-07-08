import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 * An event driven graphical user interface for the Boggle game using the design
 * of DiceTray and Boggle classes during Rick Mercer's C Sc classes at the UofA
 */
@SuppressWarnings("serial")
public class BoggleGUI extends JFrame {
	public static void main(String[] args) {
		BoggleGUI theView = new BoggleGUI();
		theView.setVisible(true);
	}

	private Boggle game;

	// GUI components you will need
	private JTextArea diceTrayArea;
	private JButton newGameButton = new JButton("New Game");
	private JButton endButton = new JButton("End game");
	private JTextArea userInputArea = new JTextArea();
	private JLabel label;

	public BoggleGUI() {
		setUpModel();
		layoutWindow();
		setupListeners();
		startNewGame();
	}

	private void startNewGame() {
		userInputArea.setText("");
		game = null;
		game = new Boggle();
		diceTrayArea.setText(game.getBoggleTrayAsString());
		userInputArea.setEditable(true);
	}

	private void setupListeners() {
		ActionListener newListener = new newGameListener();
		newGameButton.addActionListener(newListener);

		ActionListener endListener = new endGameListener();
		endButton.addActionListener(endListener);
	}

	private void setUpModel() {
		game = new Boggle();
	}

	// Add five GUI components to this JFrame
	private void layoutWindow() {
		// Set up the JFrame
		this.setSize(500, 270);
		this.setResizable(false);
		setLocation(10, 10);
		setTitle("Boggle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// With null layout, you must set the size and location of every
		// component.
		setLayout(null);

		diceTrayArea = new JTextArea(game.getBoggleTrayAsString());
		diceTrayArea.setEditable(false);
		diceTrayArea.setBackground(Color.cyan);
		diceTrayArea.setFont(new Font("Courier", Font.BOLD, 24));
		diceTrayArea.setSize(220, 240);
		diceTrayArea.setLocation(10, 10);
		add(diceTrayArea);
		Border border = BorderFactory.createLineBorder(Color.cyan);
		diceTrayArea.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(20, 15, 25, 15)));

		label = new JLabel("Enter your words below");
		label.setLocation(280, 5);
		label.setSize(180, 30);
		label.setVisible(true);
		add(label);

		userInputArea.setLocation(245, 40);
		userInputArea.setSize(240, 170);
		userInputArea.setVisible(true);
		userInputArea.setLineWrap(true);
		userInputArea.setWrapStyleWord(true);
		userInputArea.setBackground(Color.white);
		add(userInputArea);

		newGameButton.setLocation(245, 220);
		newGameButton.setSize(110, 30);
		add(newGameButton);

		endButton.setLocation(375, 220);
		endButton.setSize(110, 30);
		add(endButton);
	}

	private class newGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			startNewGame();
		}
	}

	private class endGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Scanner scanner = new Scanner(userInputArea.getText());
			while (scanner.hasNext()) {
				String temp = scanner.next();
				game.addGuess(temp);
			}
			JOptionPane pane = new JOptionPane();
			

			pane.setMessage(
					"Your score: "
							+ game.getScore()
							+ '\n'
							+ '\n'
							+ "Words you found:"
							+ '\n'
							+ game.getWordsFound().toString()
							+ '\n'
							+ '\n'
							+ "You could have found "
							+ game.wordsMissedNumber()
							+ " more words"
							+ '\n'
							+ "The computer found all of your words plus these you could have:"
							+ '\n' + '\n'
							+ game.getWordsNotGuessed().toString());
			JDialog dialog = pane.createDialog(null, "Boggle");
			dialog.setSize(600, 400);
			dialog.setResizable(true);
			dialog.setVisible(true);
			userInputArea.setEditable(false);
		}
	}
}
