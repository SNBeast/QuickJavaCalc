import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
	private final byte ADD = 0;
	private final byte SUBTRACT = 1;
	private final byte MULTIPLY = 2;
	private final byte DIVIDE = 3;
	
	private long memoryValue = 0;
	private byte operator = ADD;
	
	private JFrame frame = new JFrame("A Swing and AWT calculator in Java");
	private Container canvas = frame.getContentPane();
	
	private JPanel displayContainer = new JPanel();
	private JLabel memory = new JLabel("0 +");
	private JLabel display = new JLabel("0");
	
	private JPanel buttonContainer = new JPanel();
	private JPanel numberButtons = new JPanel();
	private JPanel topButtons = new JPanel();
	private JPanel upUpButtons = new JPanel();
	private JPanel upMiddleButtons = new JPanel();
	private JPanel bottomButtons = new JPanel();
	private JPanel downMiddleButtons = new JPanel();
	private JPanel downDownButtons = new JPanel();
	private JPanel eastButtons = new JPanel();
	private JPanel upEastButtons = new JPanel();
	private JPanel downEastButtons = new JPanel();

	private JButton zero = new JButton("0");
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton negative = new JButton("(-)");
	private JButton equals = new JButton("=");
	private JButton plus = new JButton("+");
	private JButton minus = new JButton("-");
	private JButton times = new JButton("*");
	private JButton divided = new JButton("/");
	private JButton clear = new JButton("clear");
	
	public Main () {
		displayContainer.setPreferredSize(new Dimension(200, 90));
		displayContainer.setLayout(new BorderLayout());
		display.setPreferredSize(new Dimension(200, 70));
		display.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		displayContainer.add(memory, BorderLayout.NORTH);
		displayContainer.add(display, BorderLayout.SOUTH);
		

		upUpButtons.setLayout(new BorderLayout());
		upUpButtons.add(one, BorderLayout.WEST);
		upUpButtons.add(two, BorderLayout.CENTER);
		upUpButtons.add(three, BorderLayout.EAST);
		
		upMiddleButtons.setLayout(new BorderLayout());
		upMiddleButtons.add(four, BorderLayout.WEST);
		upMiddleButtons.add(five, BorderLayout.CENTER);
		upMiddleButtons.add(six, BorderLayout.EAST);

		downMiddleButtons.setLayout(new BorderLayout());
		downMiddleButtons.add(seven, BorderLayout.WEST);
		downMiddleButtons.add(eight, BorderLayout.CENTER);
		downMiddleButtons.add(nine, BorderLayout.EAST);
		
		downDownButtons.setLayout(new BorderLayout());
		downDownButtons.add(negative, BorderLayout.WEST);
		downDownButtons.add(zero, BorderLayout.CENTER);
		downDownButtons.add(equals, BorderLayout.EAST);
		
		upEastButtons.setLayout(new BorderLayout());
		upEastButtons.add(plus, BorderLayout.NORTH);
		upEastButtons.add(minus, BorderLayout.CENTER);
		
		downEastButtons.setLayout(new BorderLayout());
		downEastButtons.add(times, BorderLayout.NORTH);
		downEastButtons.add(divided, BorderLayout.CENTER);
		
		topButtons.setLayout(new BorderLayout());
		topButtons.add(upUpButtons, BorderLayout.NORTH);
		topButtons.add(upMiddleButtons, BorderLayout.CENTER);
		
		bottomButtons.setLayout(new BorderLayout());
		bottomButtons.add(downMiddleButtons, BorderLayout.NORTH);
		bottomButtons.add(downDownButtons, BorderLayout.CENTER);
		
		eastButtons.setLayout(new BorderLayout());
		eastButtons.add(upEastButtons, BorderLayout.NORTH);
		eastButtons.add(downEastButtons, BorderLayout.CENTER);

		numberButtons.setLayout(new BorderLayout());
		numberButtons.add(topButtons, BorderLayout.NORTH);
		numberButtons.add(bottomButtons, BorderLayout.CENTER);
		
		buttonContainer.setLayout(new BorderLayout());
		buttonContainer.add(numberButtons, BorderLayout.CENTER);
		buttonContainer.add(eastButtons, BorderLayout.EAST);
		
		canvas.setPreferredSize(new Dimension(300, 235));
		canvas.setLayout(new BorderLayout());
		canvas.add(displayContainer, BorderLayout.NORTH);
		canvas.add(buttonContainer, BorderLayout.CENTER);
		canvas.add(clear, BorderLayout.SOUTH);
		

		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		negative.addActionListener(this);
		equals.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		times.addActionListener(this);
		divided.addActionListener(this);
		clear.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed (ActionEvent e) {
		JButton source = (JButton)e.getSource();
		if (source == zero) {
			concatenate(0);
		}
		else if (source == one) {
			concatenate(1);
		}
		else if (source == two) {
			concatenate(2);
		}
		else if (source == three) {
			concatenate(3);
		}
		else if (source == four) {
			concatenate(4);
		}
		else if (source == five) {
			concatenate(5);
		}
		else if (source == six) {
			concatenate(6);
		}
		else if (source == seven) {
			concatenate(7);
		}
		else if (source == eight) {
			concatenate(8);
		}
		else if (source == nine) {
			concatenate(9);
		}
		else if (source == negative) {
			negate();
		}
		else if (source == plus) {
			operation(ADD);
		}
		else if (source == minus) {
			operation(SUBTRACT);
		}
		else if (source == times) {
			operation(MULTIPLY);
		}
		else if (source == divided) {
			operation(DIVIDE);
		}
		else if (source == clear) {
			clear();
		}
		else {
			evaluate();
		}
	}
	private void concatenate (long digit) {
		long value = Long.parseLong(display.getText());
		if (value > (Long.MAX_VALUE - digit)/10 + (Long.MAX_VALUE % 10)) return;
		if (value < (Long.MIN_VALUE + digit)/10 + (Long.MIN_VALUE % 10)) return;
		if (value >= 0) display.setText("" + (value * 10 + digit));
		else display.setText("" + (value * 10 - digit));
	}
	private void negate () {
		long value = Long.parseLong(display.getText());
		if (value == Long.MIN_VALUE) return;
		else display.setText("" + (value * -1));
	}
	private void operation (byte type) {
		operator = type;
		memoryValue = Long.parseLong(display.getText());
		display.setText("0");
		String text = memoryValue + " ";
		if (type == ADD) text += "+";
		if (type == SUBTRACT) text += "-";
		if (type == MULTIPLY) text += "*";
		if (type == DIVIDE) text += "/";
		memory.setText(text);
	}
	private void clear () {
		operator = ADD;
		memoryValue = 0;
		display.setText("0");
		memory.setText("0 +");
	}
	private void evaluate () {
		long result = 0;
		long value = Long.parseLong(display.getText());
		if (operator == SUBTRACT) result = memoryValue - value;
		else if (operator == MULTIPLY) result = memoryValue * value;
		else if (operator == DIVIDE) result = memoryValue / value;
		else result = memoryValue + value;
		display.setText("" + result);
		operator = ADD;
		memoryValue = 0;
		memory.setText("0 +");
	}
	public static void main (String[] args) {
		new Main();
	}
}
