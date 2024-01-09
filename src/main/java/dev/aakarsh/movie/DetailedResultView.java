package dev.aakarsh.movie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DetailedResultView extends JFrame
{
    public static final String CARD_PREFIX = "Movie_Result_";
    private final Movie[] matchedMovies;
    private final int numberOfMatchedMovies;
    private Container[] cardContainers;
    private final Font FONT = new Font("Cambria", Font.PLAIN, 20);
    private int currentCardIndex = 0;
    JPanel cardPanel;
    CardLayout cardLayout;

    public DetailedResultView(Movie[] matchedMovies, int numberOfMatchedMovies)
    {
        this.matchedMovies = matchedMovies;
        this.numberOfMatchedMovies = numberOfMatchedMovies;
        populateCards();
        initComponents();
    }

    private void initComponents()
    {
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        for(int i=0; i<numberOfMatchedMovies; i++)
        {
            cardPanel.add(cardContainers[i], CARD_PREFIX+i);
        }

        JPanel buttonPanel = new JPanel();

        JButton forwardButton = new JButton("-->");
        forwardButton.setFont(FONT);
        forwardButton.addActionListener(e -> {
            if(currentCardIndex<numberOfMatchedMovies-1)
            {
                currentCardIndex++;
                showSpecificCard();
            }
        });

        JButton backButton = new JButton("<--");
        backButton.setFont(FONT);
        backButton.addActionListener(e -> {
            if(currentCardIndex>0)
            {
                currentCardIndex--;
                showSpecificCard();

            }

        });

        buttonPanel.add(backButton);
        buttonPanel.add(forwardButton);

        setLayout(new BorderLayout());

        add(cardPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);

        setSize(675,600);
        setLocation(1100,0);
        setTitle("Detailed Results");
        setResizable(false);
        setVisible(false);
    }

    private void populateCards()
    {
        cardContainers = new Container[numberOfMatchedMovies];
        for (int i=0; i<numberOfMatchedMovies; i++)
        {
            MovieResultCard resultCard = new MovieResultCard(matchedMovies[i]);
            cardContainers[i] = resultCard.getResultCard();
        }

    }

    public int getCurrentCardIndex()
    {
        return currentCardIndex;
    }

    public DetailedResultView setCurrentCardIndex(int currentCardIndex)
    {
        this.currentCardIndex = currentCardIndex;
        return this;
    }

    public void showSpecificCard()
    {
        cardLayout.show(cardPanel, CARD_PREFIX+currentCardIndex);
    }
}
