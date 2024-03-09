/**
 * DPL Main.java
 * @author Roberto E. Lopez-Herrejon
 * Main class of Draw Product Line
 * SEP SPL Course July 2010
 */
package dpl;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class Main extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	protected JPanel toolPanel = new JPanel();
	protected Canvas canvas = new Canvas();
	private Container contentPane;
	// #if Linha
//@	private JButton lineButton;
	// #endif
	// #if Retangulo
	private JButton rectButton;
	// #endif
	// #if Limpar	
	private JButton wipeButton;
	private static final String wipeText = "   Limpar   ";
	// #endif
	private static final String rectText = "Retângulo";
	// #if Linha
//@	private static final String lineText = "    Linha    ";
	// #endif

	// *** Initialization of atomic elements
	public void initAtoms() {
		// #if Linha
//@		lineButton = new JButton(lineText);
		// #endif
		// #if Retangulo
		rectButton = new JButton(rectText);
		// #endif
		// #if Limpar
		wipeButton = new JButton(wipeText);
		// #endif
	}

	// Layout components declaration

	/** Initializes layout . No need to change */
	public void initLayout() {
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
	}

	/** Initializes the content pane */
	public void initContentPane() {
		// #if Linha
//@		toolPanel.add(lineButton);
		// #endif
		// #if Retangulo
		toolPanel.add(rectButton);
		// #endif
		// #if Limpar
		toolPanel.add(wipeButton);
		// #endif
		contentPane.add(toolPanel, BorderLayout.WEST);
		contentPane.add(canvas, BorderLayout.CENTER);
	}

	public void initListeners() {
		// #if Linha
//@		lineButton.addActionListener(new ActionListener() {
//@			public void actionPerformed(ActionEvent e) {
//@				canvas.selectedFigure(Canvas.FigureTypes.LINE);
//@			}
//@		});
		// #endif

		// #if Retangulo
		rectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.selectedFigure(Canvas.FigureTypes.RECT);
			}
		});
		// #endif

		// #if Limpar
		wipeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.wipe();
			}
		});
		// #endif
	}

	// Initializes entire containment hierarchy
	public void init() {
		initAtoms();
		initLayout();
		initContentPane();
		initListeners();
	}

	/* Constructor. No need to modify */
	public Main(String appTitle) {
		super(appTitle);
		init();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setResizable(true);
		validate();
	}

	/** main method */
	public static void main(String[] args) {
		new Main("DPL Antenna");
	}

}
