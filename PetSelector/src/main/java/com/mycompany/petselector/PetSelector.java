package com.mycompany.petselector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pet selector application that allows users to choose their favorite pet
 * using radio buttons and shows the pet's photo.
 * 
 * @author Melissa Mumo
 */
public class PetSelector extends JFrame implements ActionListener {

    // Declare radio buttons as final
    private final JRadioButton dogButton;
    private final JRadioButton catButton;
    private final JRadioButton birdButton;
    private final JRadioButton rabbitButton;
    private final JRadioButton pigButton;
    private final ButtonGroup group;
    
    // Label to display the image
    private final JLabel imageLabel;

    public PetSelector() {
        // Set the title of the JFrame
        setTitle("Favorite Pet Selector");

        // Create the radio buttons
        dogButton = new JRadioButton("Dog");
        catButton = new JRadioButton("Cat");
        birdButton = new JRadioButton("Bird");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Fish");

        // Group the radio buttons to allow only one selection at a time
        group = new ButtonGroup();
        group.add(dogButton);
        group.add(catButton);
        group.add(birdButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add action listeners for the radio buttons
        dogButton.addActionListener(this);
        catButton.addActionListener(this);
        birdButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Label to display images
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        // Set up the layout of the window
        setLayout(new BorderLayout());

        // Panel for the radio buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        buttonPanel.add(dogButton);
        buttonPanel.add(catButton);
        buttonPanel.add(birdButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        // Add the button panel and image label to the frame
        add(buttonPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        // Set default close operation and size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which radio button is selected and show the corresponding image
        if (dogButton.isSelected()) {
            setImage("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\PetSelector\\images\\dog.jpg");
        } else if (catButton.isSelected()) {
            setImage("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\PetSelector\\images\\cat.jpg");
        } else if (birdButton.isSelected()) {
            setImage("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\PetSelector\\images\\bird.jpg");
        } else if (rabbitButton.isSelected()) {
            setImage("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\PetSelector\\images\\rabbit.jpg");
        } else if (pigButton.isSelected()) {
            setImage("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\PetSelector\\images\\pig.jpg");
        }
    }

    // Method to set the image in the label
    private void setImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        // Resize the image to fit the label
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    public static void main(String[] args) {
        // Create an instance of the SelectFavePet class
        new PetSelector();
    }
}