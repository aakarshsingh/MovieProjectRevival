package dev.aakarsh.movie;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.miginfocom.swing.MigLayout;
import org.json.JSONException;

/**
 * Use MigLayout to take it out from the Old Main View to this new one
 * So that there are no issues in rendering of the screen in the JAR
 */
public class MoviePickerView extends JFrame
{
    private JComboBox actorComboBox;
    private JComboBox directorComboBox;
    private JComboBox genreComboBox;

    private JTextField yearMinValue;
    private JTextField yearMaxValue;
    private JTextField runningMinValue;
    private JTextField runningMaxValue;
    private JTextField IMDBMinValue;
    private JTextField IMDBMaxValue;
    private JTextField rottenMinValue;
    private JTextField rottenMaxValue;

    private JButton showButton;
    private JButton yearDownBy1Button;
    private JButton yearUpBy1Button;
    private JButton runningDownBy1Button;
    private JButton runningUpBy1Button;
    private JButton IMDBDownBy1Button;
    private JButton IMDBUpBy1Button;
    private JButton rottenDownBy1Button;
    private JButton rottenUpBy1Button;

    private JPanel moviePickerPanel;

    private JLabel actorLabel;
    private JLabel directorLabel;
    private JLabel genreLabel;
    private JLabel yearLabel;
    private JLabel IMDBLabel;
    private JLabel runningLabel;
    private JLabel rottenLabel;

    private JSlider yearMinSlider;
    private JSlider yearMaxSlider;
    private JSlider runningMinSlider;
    private JSlider runningMaxSlider;
    private JSlider IMDBMinSlider;
    private JSlider IMDBMaxSlider;
    private JSlider rottenMinSlider;
    private JSlider rottenMaxSlider;

    private JButton feelingLuckyButton;

    private String minimumYearValue;
    private String maximumYearValue;
    private String minimumRunningValue;
    private String maximumRunningValue;

    private final Font FONT = new Font("Cambria", Font.PLAIN, 16);

    MoviePickerView() throws JSONException, InvocationTargetException, InterruptedException
    {

        new SeedFromJSON();
        initComponents();
    }

    private void initComponents() throws InvocationTargetException, InterruptedException
    {
        MigLayout layout = new MigLayout();
        moviePickerPanel = new JPanel(layout);

        actorLabel = new JLabel("Actor");
        actorLabel.setFont(FONT);

        actorComboBox = new JComboBox();
        actorComboBox.setFont(FONT);
        actorComboBox.setEnabled(true);

        moviePickerPanel.add(actorLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(actorComboBox, "gaptop 15, gapleft 25, wrap 15, span 2, wrap, w 500!, h 40!");

        directorLabel = new JLabel("Director");
        directorLabel.setFont(FONT);

        directorComboBox = new JComboBox();
        directorComboBox.setFont(FONT);
        directorComboBox.setEnabled(true);

        moviePickerPanel.add(directorLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(directorComboBox, "gaptop 15, gapleft 25, wrap 15, span 2, wrap, w 500!, h 40!");

        genreLabel = new JLabel("Genre");
        genreLabel.setFont(FONT);

        genreComboBox = new JComboBox();
        genreComboBox.setFont(FONT);
        genreComboBox.setEnabled(true);

        moviePickerPanel.add(genreLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(genreComboBox, "gaptop 15, gapleft 25, wrap 15, span 2, wrap, w 500!, h 40!");

        yearLabel = new JLabel("Year");
        yearLabel.setFont(FONT);

        yearMinSlider = new JSlider();
        yearMinSlider.setFont(FONT);
        yearMinSlider.setPaintTrack(true);
        yearMinSlider.setEnabled(true);

        yearMinValue = new JTextField();
        yearMinValue.setFont(FONT);
        yearMinValue.setEditable(false);
        yearMinValue.setEnabled(true);

        moviePickerPanel.add(yearLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(yearMinSlider, "gaptop 15, gapleft 25, span 2, w 500!, h 40!");
        moviePickerPanel.add(yearMinValue, "wrap, gapleft 25, h 40!, span 1, w 125!");

        yearMaxSlider = new JSlider();
        yearMaxSlider.setFont(FONT);
        yearMaxSlider.setPaintTrack(true);
        yearMaxSlider.setEnabled(true);

        yearMaxValue = new JTextField();
        yearMaxValue.setFont(FONT);
        yearMaxValue.setEditable(false);
        yearMaxValue.setEnabled(true);

        moviePickerPanel.add(yearMaxSlider, "gaptop 15, gapleft 115, span 3, w 500!, h 40!");
        moviePickerPanel.add(yearMaxValue, "wrap, gapleft 25, span 1,h 40!, w 125!");

        runningLabel = new JLabel("Running");
        runningLabel.setFont(FONT);

        runningMinSlider = new JSlider();
        runningMinSlider.setFont(FONT);
        runningMinSlider.setPaintTrack(true);
        runningMinSlider.setEnabled(true);

        runningMinValue = new JTextField();
        runningMinValue.setFont(FONT);
        runningMinValue.setEditable(false);
        runningMinValue.setEnabled(true);

        moviePickerPanel.add(runningLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(runningMinSlider, "gaptop 15, gapleft 25, span 2, w 500!, h 40!");
        moviePickerPanel.add(runningMinValue, "wrap, gapleft 25, h 40!, span 1, w 125!");

        runningMaxSlider = new JSlider();
        runningMaxSlider.setFont(FONT);
        runningMaxSlider.setPaintTrack(true);
        runningMaxSlider.setEnabled(true);

        runningMaxValue = new JTextField();
        runningMaxValue.setFont(FONT);
        runningMaxValue.setEditable(false);
        runningMaxValue.setEnabled(true);

        moviePickerPanel.add(runningMaxSlider, "gaptop 15, gapleft 115, span 3, w 500!, h 40!");
        moviePickerPanel.add(runningMaxValue, "wrap, gapleft 25, span 1,h 40!, w 125!");

        IMDBLabel = new JLabel("IMDB");
        IMDBLabel.setFont(FONT);

        IMDBMinSlider = new JSlider();
        IMDBMinSlider.setFont(FONT);
        IMDBMinSlider.setPaintTrack(true);
        IMDBMinSlider.setEnabled(true);

        IMDBMinValue = new JTextField();
        IMDBMinValue.setFont(FONT);
        IMDBMinValue.setEditable(false);
        IMDBMinValue.setEnabled(true);

        moviePickerPanel.add(IMDBLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(IMDBMinSlider, "gaptop 15, gapleft 25, span 2, w 500!, h 40!");
        moviePickerPanel.add(IMDBMinValue, "wrap, gapleft 25, h 40!, span 1, w 125!");

        IMDBMaxSlider = new JSlider();
        IMDBMaxSlider.setFont(FONT);
        IMDBMaxSlider.setPaintTrack(true);
        IMDBMaxSlider.setEnabled(true);

        IMDBMaxValue = new JTextField();
        IMDBMaxValue.setFont(FONT);
        IMDBMaxValue.setEditable(false);
        IMDBMaxValue.setEnabled(true);

        moviePickerPanel.add(IMDBMaxSlider, "gaptop 15, gapleft 115, span 3, w 500!, h 40!");
        moviePickerPanel.add(IMDBMaxValue, "wrap, gapleft 25, span 1,h 40!, w 125!");

        rottenLabel = new JLabel("Rotten");
        rottenLabel.setFont(FONT);

        rottenMinSlider = new JSlider();
        rottenMinSlider.setFont(FONT);
        rottenMinSlider.setPaintTrack(true);
        rottenMinSlider.setEnabled(true);

        rottenMinValue = new JTextField();
        rottenMinValue.setFont(FONT);
        rottenMinValue.setEditable(false);
        rottenMinValue.setEnabled(true);

        moviePickerPanel.add(rottenLabel, "gaptop 15, gapleft 10, span 1, w 75!");
        moviePickerPanel.add(rottenMinSlider, "gaptop 15, gapleft 25, span 2, w 500!, h 40!");
        moviePickerPanel.add(rottenMinValue, "wrap, gapleft 25, h 40!, span 1, w 125!");

        rottenMaxSlider = new JSlider();
        rottenMaxSlider.setFont(FONT);
        rottenMaxSlider.setPaintTrack(true);
        rottenMaxSlider.setEnabled(true);

        rottenMaxValue = new JTextField();
        rottenMaxValue.setFont(FONT);
        rottenMaxValue.setEditable(false);
        rottenMaxValue.setEnabled(true);

        moviePickerPanel.add(rottenMaxSlider, "gaptop 15, gapleft 115, span 3, w 500!, h 40!");
        moviePickerPanel.add(rottenMaxValue, "wrap, gapleft 25, span 1,h 40!, w 125!");

        showButton = new JButton("Show");
        showButton.setEnabled(true);
        showButton.setFont(FONT);

        feelingLuckyButton = new JButton("Feeling Lucky");
        feelingLuckyButton.setEnabled(true);
        feelingLuckyButton.setFont(FONT);

        moviePickerPanel.add(showButton, "gaptop 15, span 3, gapleft 165, w 400!, h 40!");
        moviePickerPanel.add(feelingLuckyButton, "gaptop 15, span 1, w 160!, h 40!");

        seedValues();
        populateUIComponents();

        add(moviePickerPanel);
        setSize(800,800);
        setResizable(false);
        setVisible(true);
    }

    private void populateUIComponents() throws InvocationTargetException, InterruptedException
    {
        setupSliderListeners();
        setupButtonListeners();
        SwingUtilities.invokeAndWait(new Runnable()
        {
            public void run()
            {
                setupComboBoxes();
            }
        });
    }

    private void seedValues()
    {
        java.util.List<Integer> listOfYear = new ArrayList<Integer>(SeedFromJSON.sortedYearList);
        java.util.List<Integer> listOfRunning = new ArrayList<Integer>(SeedFromJSON.sortedRunningTimeList);
        java.util.List<Integer> listOfRotten = new ArrayList<Integer>(SeedFromJSON.sortedRottenList);
        java.util.List<Double> listOfIMDB = new ArrayList<Double>(SeedFromJSON.sortedIMDBList);

        minimumYearValue = listOfYear.get(0).toString();
        yearMinValue.setText(minimumYearValue);

        maximumYearValue = listOfYear.get(listOfYear.size() - 1).toString();
        yearMaxValue.setText(maximumYearValue);

        minimumRunningValue = listOfRunning.get(0).toString();
        runningMinValue.setText(minimumRunningValue);

        maximumRunningValue = listOfRunning.get(listOfRunning.size() - 1).toString();
        runningMaxValue.setText(maximumRunningValue);

        String minimumRottenValue = listOfRotten.get(0).toString();
        rottenMinValue.setText(minimumRottenValue);

        String maximumRottenValue = listOfRotten.get(listOfRotten.size() - 1).toString();
        rottenMaxValue.setText(maximumRottenValue);

        String minimumIMDBValue = listOfIMDB.get(0).toString().substring(0, 1);
        IMDBMinValue.setText(minimumIMDBValue);

        String maximumIMDBValue = listOfIMDB.get(listOfIMDB.size() - 1).toString().substring(0, 1);
        IMDBMaxValue.setText(maximumIMDBValue);
    }

    private void setupComboBoxes()
    {
        @SuppressWarnings("unchecked") java.util.List<String> listOfActors = new ArrayList<String>(
            SeedFromJSON.sortedActorList);
        final EventList<String> eventListActors = GlazedLists.eventList(listOfActors);
        AutoCompleteSupport.install(actorComboBox, eventListActors);

        java.util.List<String> listOfDirectors = new ArrayList<String>(SeedFromJSON.sortedDirectorList);
        final EventList<String> eventListDirectors = GlazedLists.eventList(listOfDirectors);
        AutoCompleteSupport.install(directorComboBox, eventListDirectors);

        java.util.List<String> listOfGenre = new ArrayList<String>(SeedFromJSON.sortedGenreList);
        final EventList<String> eventListGenre = GlazedLists.eventList(listOfGenre);
        AutoCompleteSupport.install(genreComboBox, eventListGenre);
    }

    private void setupSliderListeners()
    {
        yearMaxSlider.setMaximum(Integer.parseInt(maximumYearValue));
        yearMaxSlider.setMinimum(Integer.parseInt(minimumYearValue));
        yearMaxSlider.setValue(Integer.parseInt(maximumYearValue));
        yearMaxSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                yearMaxValue.setText(""+yearMaxSlider.getValue());
            }
        });
        yearMaxSlider.setMajorTickSpacing(39);
        yearMaxSlider.setPaintLabels(true);
        yearMinSlider.setMaximum(Integer.parseInt(maximumYearValue));
        yearMinSlider.setMinimum(Integer.parseInt(minimumYearValue));
        yearMinSlider.setValue(Integer.parseInt(minimumYearValue));
        yearMinSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                yearMinValue.setText(""+yearMinSlider.getValue());
            }
        });
        yearMinSlider.setMajorTickSpacing(39);
        yearMinSlider.setPaintLabels(true);
        runningMaxSlider.setMaximum(Integer.parseInt(maximumRunningValue));
        runningMaxSlider.setMinimum(Integer.parseInt(minimumRunningValue));
        runningMaxSlider.setValue(Integer.parseInt(maximumRunningValue));
        runningMaxSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                runningMaxValue.setText(""+runningMaxSlider.getValue());
            }
        });
        runningMaxSlider.setMajorTickSpacing(48);
        runningMinSlider.setMaximum(Integer.parseInt(maximumRunningValue));
        runningMinSlider.setMinimum(Integer.parseInt(minimumRunningValue));
        runningMinSlider.setValue(Integer.parseInt(minimumRunningValue));
        runningMinSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                runningMinValue.setText(""+runningMinSlider.getValue());
            }
        });
        runningMinSlider.setMajorTickSpacing(48);
        IMDBMaxSlider.setMaximum(10);
        IMDBMaxSlider.setMinimum(4);
        IMDBMaxSlider.setValue(10);
        IMDBMaxSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                IMDBMaxValue.setText(""+IMDBMaxSlider.getValue());
            }
        });
        IMDBMaxSlider.setMajorTickSpacing(1);
        IMDBMinSlider.setMaximum(10);
        IMDBMinSlider.setMinimum(4);
        IMDBMinSlider.setValue(4);
        IMDBMinSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                IMDBMinValue.setText(""+IMDBMinSlider.getValue());
            }
        });
        IMDBMinSlider.setMajorTickSpacing(1);
        rottenMaxSlider.setMaximum(100);
        rottenMaxSlider.setMinimum(0);
        rottenMaxSlider.setValue(100);
        rottenMaxSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                rottenMaxValue.setText(""+rottenMaxSlider.getValue());
            }
        });
        rottenMaxSlider.setMajorTickSpacing(20);
        rottenMinSlider.setMaximum(100);
        rottenMinSlider.setMinimum(0);
        rottenMinSlider.setValue(0);
        rottenMinSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent changeEvent)
            {
                rottenMinValue.setText(""+rottenMinSlider.getValue());
            }
        });
        rottenMinSlider.setMajorTickSpacing(20);
    }

    private void setupButtonListeners()
    {
        showButton.addActionListener(new ActionListener()
        {
            int finalMinYear;
            int finalMaxYear;
            int finalMinRunning;
            int finalMaxRunning;
            int finalMinRotten;
            int finalMaxRotten;
            int finalMinIMDB;
            int finalMaxIMDB;
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                SearchFields fields = new SearchFields();
                if(actorComboBox.getSelectedItem()!=null)
                {
                    SearchFields.setActor((String) actorComboBox.getSelectedItem());
                }
                if(directorComboBox.getSelectedItem()!=null)
                {
                    SearchFields.setDirector((String) directorComboBox.getSelectedItem());
                }
                if(genreComboBox.getSelectedItem()!=null)
                {
                    SearchFields.setGenre((String) genreComboBox.getSelectedItem());
                }
                finalMinYear = yearMinSlider.getValue();
                finalMaxYear = yearMaxSlider.getValue();
                finalMinRunning = Integer.parseInt(runningMinValue.getText());
                finalMaxRunning = Integer.parseInt(runningMaxValue.getText());
                finalMinRotten = Integer.parseInt(rottenMinValue.getText());
                finalMaxRotten = Integer.parseInt(rottenMaxValue.getText());
                finalMinIMDB = Integer.parseInt(IMDBMinValue.getText());
                finalMaxIMDB = Integer.parseInt(IMDBMaxValue.getText());
                fixYearValue(finalMaxYear, finalMinYear);
                fixRunningValue(finalMaxRunning, finalMinRunning);
                fixIMDBValue(finalMaxIMDB, finalMinIMDB);
                fixRottenValue(finalMaxRotten, finalMinRotten);
                SearchFields.setMinYear(finalMinYear);
                SearchFields.setMaxYear(finalMaxYear);
                SearchFields.setMinRunning(finalMinRunning);
                SearchFields.setMaxRunning(finalMaxRunning);
                SearchFields.setMinIMDB(finalMinIMDB);
                SearchFields.setMaxIMDB(finalMaxIMDB);
                SearchFields.setMinRotten(finalMinRotten);
                SearchFields.setMaxRotten(finalMaxRotten);
                SearchMovies searchMovies = new SearchMovies(fields, SeedFromJSON.getAllTheMovies());
                Movie matchedMovies [] = searchMovies.getMatchedMovies();
                int numberOfMatchedMovies = SearchMovies.getNumberOfMatchedMovies();
                SearchResultsView resultsView = new SearchResultsView(matchedMovies, numberOfMatchedMovies);
                resultsView.setVisible(true);
            }

            private void fixRottenValue(int finalMaxRotten, int finalMinRotten)
            {
                if(finalMinRotten > finalMaxRotten)
                {
                    finalMinRotten = finalMaxRotten;
                    rottenMinValue.setText(""+finalMinRotten);
                    rottenMinSlider.setValue(finalMinRotten);
                }
            }

            private void fixIMDBValue(int finalMaxIMDB, int finalMinIMDB)
            {
                if(finalMinIMDB > finalMaxIMDB)
                {
                    finalMinIMDB = finalMaxIMDB;
                    IMDBMinValue.setText(""+finalMinIMDB);
                    IMDBMinSlider.setValue(finalMinIMDB);
                }
            }

            private void fixRunningValue(int finalMaxRunning, int finalMinRunning)
            {
                if(finalMinRunning > finalMaxRunning)
                {
                    finalMinRunning = finalMaxRunning;
                    runningMinValue.setText(""+finalMinRunning);
                    runningMinSlider.setValue(finalMinRunning);
                }
            }

            private void fixYearValue(int finalMaxYear, int finalMinYear)
            {
                if(finalMinYear > finalMaxYear)
                {
                    finalMinYear = finalMaxYear;
                    yearMinValue.setText(""+finalMinYear);
                    yearMinSlider.setValue(finalMinYear);
                }
            }
        });
        feelingLuckyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int numberOfMovies = SeedFromJSON.getNumberOfMovies();
                int indexOfInterest = (int)(Math.random() * (numberOfMovies)+1);
                Movie allTheMovies[] = SeedFromJSON.getAllTheMovies();
                Movie randomlyPickedMovie[] = {allTheMovies[indexOfInterest]};
                DetailedResultView resultView = new DetailedResultView(randomlyPickedMovie, 1);
                resultView.setVisible(true);
            }
        });
    }
}
