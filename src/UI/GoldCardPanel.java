package UI;

import Property.GoldCardConstants;
import Util.Phase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GoldCardPanel extends JPanel {

    private JPanel                  contentsPanel;
    private JLabel                  nameLabel, contentsLabel, titleLabel;
    private JButton                 confirmButton;
    private Color                   goldColor;
    private ButtonListener          buttonListener;
    private Phase                   phase;

    public GoldCardPanel(Phase phase){
        goldColor = new Color(248, 206, 88);
        this.phase = phase;

        setBackground(goldColor);
        setBounds(40, 40, 800/7*5-80, 550/7*5-80); //491 310
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(new Color(248, 206, 88), 10));

        buttonListener = new ButtonListener();

        nameLabel = new JLabel();
        nameLabel.setBounds(0,0,800/7*5-80, 60);
        nameLabel.setFont(new Font("RixVideoGame3D", Font.PLAIN, 40));
        //nameLabel.setFont(new Font("Rix전자오락 3D", Font.PLAIN, 40));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        nameLabel.setForeground(goldColor);
        add(nameLabel);

        confirmButton = new JButton("CONFIRM");
        confirmButton.setBounds(184 , 245, 122, 50);
        confirmButton.setFont(new Font("drid herder solid", Font.PLAIN, 20));
        confirmButton.setBackground(goldColor);
        confirmButton.setOpaque(true);
        confirmButton.setForeground(Color.white);
        confirmButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        confirmButton.setVerticalAlignment(SwingConstants.CENTER);
        confirmButton.setHorizontalAlignment(SwingConstants.CENTER);
        confirmButton.addMouseListener(buttonListener);
        add(confirmButton);

        contentsPanel = new JPanel();
        contentsPanel.setBounds(10, 10, 470, 220);
        contentsPanel.setBackground(Color.white);
        contentsPanel.setLayout(null);
        add(contentsPanel);

        contentsLabel = new JLabel();
        contentsLabel.setFont(new Font("RixVideoGameB", Font.PLAIN, 30));
        contentsLabel.setBounds(0,105,470,30);
        contentsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentsLabel.setVerticalAlignment(SwingConstants.CENTER);
        contentsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        contentsLabel.setVerticalTextPosition(SwingConstants.CENTER);
        contentsPanel.add(contentsLabel);
    }//GoldCardPanel()

    public void set_card_information(int cardId){
        contentsLabel.setText(GoldCardConstants.CARD_CONTENT[cardId]);
        nameLabel.setText(GoldCardConstants.CARD_TITLE[cardId]);
    }


    private class ButtonListener implements MouseListener {

        public void mouseClicked(MouseEvent event){
            Object object = event.getSource();

            if(object == confirmButton) {
                setVisible(false);
                phase.gold_card();
            }
        }
        public void mousePressed(MouseEvent event){ }
        public void mouseReleased(MouseEvent event){ }
        public void mouseEntered(MouseEvent event) {
            JButton object = (JButton)event.getSource();

            object.setBackground(Color.white);
            object.setOpaque(true);
            object.setForeground(goldColor);
        }
        public void mouseExited(MouseEvent event){
            JButton object = (JButton)event.getSource();

            object.setBackground(goldColor);
            object.setOpaque(true);
            object.setForeground(Color.white);
        }
    }//ButtonListener class

}
