package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class Characters {
	
	static File charFolder = new File("src/characters/");
	static String[] characterList = charFolder.list();
	
	public static void run() throws FileNotFoundException {
		Shell charList = new Shell(Display.getCurrent());
		charList.setSize(500, 500);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		charList.setLayout(layout);
		
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		
		List characters = new List(charList, SWT.SINGLE);
		characters.setLayoutData(data);
		characters.setItems(characterList);

		
		Group stats = new Group(charList, SWT.BORDER);
		stats.setText("Stats");
		stats.setLayoutData(data);
		GridLayout statsLayout = new GridLayout();
		statsLayout.makeColumnsEqualWidth = true;
		statsLayout.numColumns = 3;
		stats.setLayout(statsLayout);
		GridData statDat = new GridData();
		statDat.widthHint = 150;
		
			Label race = new Label(stats, 0);
			race.setText("No selection");
			race.setLayoutData(statDat);
			Label name = new Label(stats, 0);
			name.setText("No selection");
			name.setLayoutData(statDat);
			Label SPname = new Label(stats, 0);
			SPname.setText("No selection");
			SPname.setLayoutData(statDat);

		
		characters.addSelectionListener(new SelectionListener() {
		      public void widgetSelected(SelectionEvent event) {
		    	  File sheet = new File("src/characters/" + characterList[characters.getSelectionIndex()]);
	    		  Scanner r = null;
				try {
					r = new Scanner(sheet);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		  race.setText("Race: " + r.nextLine());
	    		  name.setText("Name: " + r.nextLine());
	    		  SPname.setText("Special: " + r.nextLine());
		      }

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		charList.open();
				
	}
}


