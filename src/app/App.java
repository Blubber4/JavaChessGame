package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * This is the Main Class of our project. 
 */

public class App extends JPanel {
	private static final long serialVersionUID = 1L;

	// private ArrayList<Board> destinationlist = new ArrayList<Board>();

	public static void main(String[] args) {
		this.GUI = new GUI();
	}
}

