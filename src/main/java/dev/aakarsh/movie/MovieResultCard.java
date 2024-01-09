package dev.aakarsh.movie;

import lombok.Getter;
import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MovieResultCard {
    private final Movie movie;
    private final Font FONT = new Font("Cambria", Font.PLAIN, 20);
    @Getter
    private Container resultCard;

    MovieResultCard(Movie movie) {
        this.movie = movie;
        initComponents();
    }

    private void initComponents() {
        resultCard = new Container();
        resultCard.setSize(600, 400);
        resultCard.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new MigLayout(
                "", // Layout Constraints
                "", // Column constraints
                "[]20[]")); // Row constraints

        JLabel headerLabel = new JLabel(movie.getTitle() + " (" + movie.getYear() + ") " + "  [" + movie.getGenre() + "]");
        headerLabel.setFont(FONT);
        contentPanel.add(headerLabel, "wrap");

        JLabel directorLabel = new JLabel("Directed by " + movie.getDirector());
        directorLabel.setFont(FONT);
        contentPanel.add(directorLabel, "wrap");

        JLabel actorLabel = new JLabel("Starring " + movie.getActors());
        actorLabel.setFont(FONT);
        contentPanel.add(actorLabel, "wrap");

        JTextArea moviePlot = new JTextArea(movie.getPlot());
        moviePlot.setLineWrap(true);
        moviePlot.setWrapStyleWord(true);
        moviePlot.setEditable(false);
        moviePlot.setFont(FONT);
        moviePlot.setRows(5);
        moviePlot.setHighlighter(null);
        moviePlot.setBackground(contentPanel.getBackground());
        moviePlot.setForeground(Color.black);
        JScrollPane plotScrollPane = new JScrollPane(moviePlot);
        plotScrollPane.createVerticalScrollBar();
        contentPanel.add(plotScrollPane, "grow, wrap");
        plotScrollPane.setBorder(null);
        plotScrollPane.setVisible(false);

        JButton moviePlotButton = new JButton("Show Plot");
        moviePlotButton.setFont(FONT);
        contentPanel.add(moviePlotButton, "wrap");
        moviePlotButton.addActionListener(e -> {
            moviePlotButton.setVisible(false);
            plotScrollPane.setVisible(true);
        });

        JLabel ratingsLabel = new JLabel("IMDB Rating: " + movie.getImdbRating() + "/10;  " + "Rotten Tomatoes: " + movie.getTomatoMeter() + "%");
        ratingsLabel.setFont(FONT);
        contentPanel.add(ratingsLabel, "wrap");

        JLabel detailsLabel = new JLabel(movie.getCountry() + " ; " + movie.getLanguage() + " (" + movie.getRuntime() + ")");
        detailsLabel.setFont(FONT);
        contentPanel.add(detailsLabel, "wrap");

        if (!movie.getAwards().equals("N/A")) {
            JLabel footerLabel = new JLabel(movie.getAwards());
            footerLabel.setFont(FONT);
            contentPanel.add(footerLabel, "wrap");
        }

        resultCard.add(contentPanel, BorderLayout.CENTER);
    }

}
