package kart_randomizer.ui;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;

import kart_randomizer.KartRandomizer;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {
	private KartRandomizer randomizer;
	
	/* widgets */
	private JComboBox<Integer> playersComboBox;
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
		
		JButton randomizeButton = new JButton("Randomize");
		randomizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numPlayers = (int)(playersComboBox.getSelectedItem());
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel outputLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(outputLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
							.addComponent(randomizeButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(playersComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(randomizeButton))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(outputLabel, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
