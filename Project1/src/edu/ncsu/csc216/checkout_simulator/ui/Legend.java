package edu.ncsu.csc216.checkout_simulator.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import edu.ncsu.csc216.checkout_simulator.simulation.Simulator;


/**
 * Utility GUI class for automation legend
 * @author Jo Perry
 */
public class Legend extends JPanel {
	
	private Color[] hue = Simulator.simulationColors();
	private String[] description = Simulator.simulationLabels();
	
	/**
	 * Set up the legend based on a custom AbstractTableModel
	 */
	public Legend() {
		super(new GridLayout(1, 0));
		this.setPreferredSize(new Dimension(300, 60));		 
        JTable table = new JTable(new ColorTableModel(hue, description));
        table.setDefaultRenderer(Color.class, new ColorRenderer()); //true));
        add(table);
	}

	/**
	 * Provides an custom AbstractTableModel so that colors will display properly
	 * @author Jo Perry
	 */
	private class ColorTableModel extends AbstractTableModel {
		
		private Object[][] content;  // Legend colors and corresponding descriptions
		
		/**
		 * Create the model based on legend colors and descriptions.		
		 * @param hue  Legend colors
		 * @param description  Descriptions of what the colors mean
		 */
		public ColorTableModel(Color[] hue, String[] description) {
			int numLegendItems = hue.length;
			content = new Object[numLegendItems][numLegendItems];
			for (int i = 0; i < numLegendItems; i++) {
				content[i][0] = hue[i];
				content[i][1] = description[i];
			}			
		}
		
		/**
		 * The table always has 2 columns. (Declared abstract in Abstract Table Model.)
		 */
        public int getColumnCount() {
            return 2;
        }
        
        /**
		 * The number of table rows. (Declared abstract in Abstract Table Model.)
		 */
        public int getRowCount() {
            return content.length;
        }
        /**
		 * Columns don't need names. (Declared abstract in Abstract Table Model.)
		 */
        public String getColumnName(int col) {
            return "";
        }
 
        public Object getValueAt(int row, int col) {
            return content[row][col];
        }
 
        /**
         * Determine the default renderer for each cell.  
         */
        @Override
        public Class<?> getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        /**
         * Nail down the legend so it can't be edited.
         */
        public boolean isCellEditable(int row, int col) {
        	return false;
        }
    }
 
	/**
	 * Required to render colors as colors rather than RGB text strings.
	 * @author Jo Perry
	 */
    private class ColorRenderer extends JLabel implements TableCellRenderer {

    	/**
    	 * Background must be opaque
    	 * @param isBordered
    	 */
    	public ColorRenderer( ) { // boolean isBordered) {
    		setOpaque(true); //MUST do this for background to show up.
    	}

    	/**
    	 * Renders the cell color.
    	 */
    	public Component getTableCellRendererComponent(
    			JTable table, Object color,
    			boolean isSelected, boolean hasFocus,
    			int row, int column) {
    		Color newColor = (Color)color;
    		setBackground(newColor);
    		return this;
    	}
    }	
	
	
	
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("TableDialogEditDemo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Create and set up the content pane.
//        JComponent newContentPane = new Legend();
////        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
// 
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
    

// 
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
}