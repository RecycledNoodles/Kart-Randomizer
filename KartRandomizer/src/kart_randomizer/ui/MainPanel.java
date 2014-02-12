package kart_randomizer.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import kart_randomizer.KartRandomizer;
import kart_randomizer.model.Vehicle;
import kart_randomizer.model.Racer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8995255850456427973L;

	private KartRandomizer randomizer;
	
	/* widgets */
	private JComboBox<Integer> playersComboBox;
	private JComboBox<Integer> tracksComboBox;
	private JTextArea textArea;
	private JCheckBox chckbxIncludeLuigiCircuit;
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		JLabel lblPlayers = new JLabel("Players:");
		
		playersComboBox = new JComboBox<Integer>();
		playersComboBox.addItem(1);
		playersComboBox.addItem(2);
		playersComboBox.addItem(3);
		playersComboBox.addItem(4);
		
		JLabel lblTracks = new JLabel("Tracks:");
		
		tracksComboBox = new JComboBox<Integer>();
		tracksComboBox.addItem(2);
		tracksComboBox.addItem(3);
		tracksComboBox.addItem(4);
		tracksComboBox.addItem(5);
		tracksComboBox.addItem(8);
		tracksComboBox.addItem(10);
		tracksComboBox.addItem(12);
		tracksComboBox.addItem(16);
		tracksComboBox.addItem(32);
		
		tracksComboBox.setSelectedIndex(2);
		
		randomizer = new KartRandomizer();
		
		JButton randomizeButton = new JButton("Make Selections");
		randomizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numPlayers = (int)(playersComboBox.getSelectedItem());
				int numTracks = (int)(tracksComboBox.getSelectedItem());
				Map<String,Object>[] selections = randomizer.pickPlayerSelections(numPlayers);
				String results = "";
				
				for (int i=1; i<= selections.length; i++) {
					results += "Player " + i + " will be racing the ";
					results += ((Vehicle)(selections[i-1].get("vehicle"))).getName() + " with ";
					results += ((Racer)(selections[i-1].get("racer"))).getName();
					results += ".\n";
				}
				results += "\n";
				String[] tracks = randomizer.pickTracks(chckbxIncludeLuigiCircuit.isSelected(), numTracks);
				
				for (int i=1; i <= tracks.length; i++) {
					results += "Track " + i + " will be ";
					results += tracks[i-1] + ".\n";
				}
				textArea.setText(results);
				
				updateWindow();

			}
		});
		
		JSeparator separator = new JSeparator();
		
		chckbxIncludeLuigiCircuit = new JCheckBox("Luigi Circuit Final", true);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor("Label.background"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(chckbxIncludeLuigiCircuit)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPlayers)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTracks)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tracksComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addComponent(randomizeButton)
							.addGap(17)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlayers)
						.addComponent(lblTracks)
						.addComponent(randomizeButton)
						.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tracksComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(chckbxIncludeLuigiCircuit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	
	public void updateWindow() {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.pack();
	}
}
