package app;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;

/**
 * This is the Main Class of our project. All GUI Elements are declared,
 * initialized and used in this class itself. It is inherited from the JFrame
 * Class of Java's Swing Library.
 */

public class App {
	GUI gui;
	public static void main(String[] args) {
		new App();
	}

	public App() {
		this.gui = new GUI();
	}
}
