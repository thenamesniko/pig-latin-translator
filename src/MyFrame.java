import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{
    //Makes a frame, setting title and default parameters

    private JButton submitButton;
    private JTextField textField;
    private JTextArea resultTextArea;
    private JScrollPane resultScrollPane;

    MyFrame() {
        this.setTitle("Pig Latin Translator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.getContentPane().setBackground(new Color(255,192,203));

         //Sets image icon and gui colour
         ImageIcon image = new ImageIcon("cartoon-pig.png");
         this.setIconImage(image.getImage());

        //Adds image to top of screen
        Image originalImage = image.getImage();
        Image resizedImage = originalImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        //Change image to JLabel
        JLabel pigImage = new JLabel();
        pigImage.setIcon(resizedIcon);
        pigImage.setHorizontalAlignment(JLabel.CENTER);
        pigImage.setBorder(new EmptyBorder(25, 0, 0, 0));

        //Adds text to top of screen
        JLabel description = new JLabel("Enter the sentence you want translated to Pig Latin:");
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setForeground(Color.black);
        description.setFont(new Font("LiSong Pro", Font.PLAIN, 25));

        //Creates the panel that holds the description text
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 25, 0));
        descriptionPanel.add(description, BorderLayout.CENTER);
        descriptionPanel.setBackground(new Color(255,192,203));

        //Create the center panel with BoxLayout
        JPanel centerPanel = new JPanel(new BorderLayout());

        //Create the text field where the user can type whatever they want
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        textFieldPanel.setBackground(new Color(255,192,203));
        textField = new JTextField(50);
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("LiSong Pro", Font.PLAIN, 20));
        textFieldPanel.add(textField);

        //Create the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(255,192,203));
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        submitButton.addActionListener(this);

        //Create the user's translated text label
        resultTextArea = new JTextArea();
        resultTextArea.setColumns(30);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setFont(new Font("LiSong Pro", Font.PLAIN, 25));
        resultTextArea.setEditable(false);

        //Create the scroll pane with the text area
        resultScrollPane = new JScrollPane(resultTextArea);

        //Calculate the preferred height based on the number of visible lines
        int visibleLines = 3;
        int lineHeight = resultTextArea.getFontMetrics(resultTextArea.getFont()).getHeight();
        int preferredHeight = lineHeight * visibleLines;
        resultScrollPane.setPreferredSize(new Dimension(resultScrollPane.getPreferredSize().width, preferredHeight));

        //Create panel to hold the translated text area
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 175, 10));
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);
        resultPanel.setBackground(new Color(255,192,203));

        //Create panel to hold pigImage and description
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(pigImage, BorderLayout.NORTH);
        topPanel.add(descriptionPanel, BorderLayout.CENTER);
        topPanel.setBackground(new Color(255,192,203));

        //Create panel to hold resultLabel and buttonPanel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(textFieldPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.setBackground(new Color(255,192,203));

        //Add components to the center panel
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(bottomPanel, BorderLayout.CENTER);
        centerPanel.add(resultPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());

        //Add components to center of main frame
        this.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submitButton) {
            String userInput = textField.getText();
            String pigLatinTranslation = App.pigLatinTranslator(userInput);

            resultTextArea.setText("Pig Latin Translation: " + pigLatinTranslation);
        }
    }

}
