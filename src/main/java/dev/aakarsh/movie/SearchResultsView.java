package dev.aakarsh.movie;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


class SearchResultsView extends JFrame
{
    private final Movie[] matchedMovies;
    private final int numberOfMatchedMovies;
    private Object[][] usableObjectArray;

    SearchResultsView(Movie[] matchedMovies, int numberOfMatchedMovies)
    {
        this.matchedMovies = matchedMovies;
        this.numberOfMatchedMovies = numberOfMatchedMovies;
        formatTableElements();
        initComponents();
    }

    private void formatTableElements()
    {
        usableObjectArray = new Object[numberOfMatchedMovies][1];
        for (int i = 0; i < numberOfMatchedMovies; i++)
        {
            String result_title = matchedMovies[i].getTitle();
            String result_consensus = matchedMovies[i].getTomatoConsensus();
            String result_actors = matchedMovies[i].getActors();
            String result_genre = matchedMovies[i].getGenre();
            String result_final = result_title + " (" +result_genre + ")\n" + (result_consensus.equals("N/A") ? "Starring "+result_actors : result_consensus) + '\n';
            usableObjectArray[i][0] = result_final;
        }
    }

    private void initComponents()
    {
        DetailedResultView detailedResultView = new DetailedResultView(matchedMovies, numberOfMatchedMovies);

        SearchTableModel tableModel = new SearchTableModel();
        tableModel.setDataVector(usableObjectArray, null);
        JTable searchResultsTable = new JTable(tableModel);
        searchResultsTable.setFont(new Font("Cambria", Font.PLAIN, 20));
        searchResultsTable.setRowHeight(90);
        searchResultsTable.setTableHeader(null);
        searchResultsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResultsTable.setDefaultRenderer(String.class, new MultiLineTableCellRenderer());
        ListSelectionModel selectionModel = searchResultsTable.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting())
            {
                if (searchResultsTable.getSelectedRow() > -1 && searchResultsTable.getSelectedColumn() == 0)
                {
                    detailedResultView.setCurrentCardIndex(searchResultsTable.getSelectedRow());
                    detailedResultView.showSpecificCard();
                    if(!detailedResultView.isVisible())
                    {
                        detailedResultView.setVisible(true);
                    }
                }
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JScrollPane tableScrollPane = new JScrollPane(searchResultsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setTitle("Compact Results");
        setSize(1000, 800);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        contentPane.add(tableScrollPane);
    }
}

class SearchTableModel extends DefaultTableModel
{

    @Override
    public int getColumnCount()
    {
        return 1;
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        return String.class;
    }


    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }
}

class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer
{

    MultiLineTableCellRenderer()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column)
    {
        if (isSelected)
        {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        }
        else
        {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setFont(table.getFont());
        if (hasFocus)
        {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            if (table.isCellEditable(row, column))
            {
                setForeground(UIManager.getColor("Table.focusCellForeground"));
                setBackground(UIManager.getColor("Table.focusCellBackground"));
            }
        }
        if (value != null)
        {
            setText(value.toString());
        }
        else
        {
            setText("");
        }
        setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 0));
        return this;
    }
}