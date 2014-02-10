package kart_randomizer.ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;

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
	private JTextArea textArea;
	private JCheckBox chckbxIncludeLuigiCircuit;
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		JLabel lblNewLabel = new JLabel("Number of Players:");
		
		playersComboBox = new JComboBox<Integer>();
		playersComboBox.addItem(1);
		playersComboBox.addItem(2);
		playersComboBox.addItem(3);
		playersComboBox.addItem(4);
		
		randomizer = new KartRandomizer();
		
		JButton randomizeButton = new JButton("Make Selections");
		randomizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numPlayers = (int)(playersComboBox.getSelectedItem());
				Map<String,Object>[] selections = randomizer.pickPlayerSelections(numPlayers);
				String results = "";
				
				for (int i=1; i<= selections.length; i++) {
					results += "Player " + i + " will be racing the ";
					results += ((Vehicle)(selections[i-1].get("vehicle"))).getName() + " with ";
					results += ((Racer)(selections[i-1].get("racer"))).getName();
					results += ".\n";
				}
				results += "\n";
				String[] tracks = randomizer.pickTracks(chckbxIncludeLuigiCircuit.isSelected());
				
				for (int i=1; i <= tracks.length; i++) {
					results += "Track " + i + " will be ";
					results += tracks[i-1] + ".\n";
				}
				textArea.setText(results);
			}
		});
		
		JSeparator separator = new JSeparator();
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(UIManager.getColor("Label.background"));
		
		chckbxIncludeLuigiCircuit = new JCheckBox("Include Luigi Circuit", true);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(chckbxIncludeLuigiCircuit, Alignment.LEADING)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
							.addComponent(randomizeButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(randomizeButton)
						.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(chckbxIncludeLuigiCircuit)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
