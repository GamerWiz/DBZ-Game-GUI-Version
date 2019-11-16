package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import customwidgets.widgets;

public class DBZGame {
	
	static File charFolder = new File("src/characters/");
	static String[] characterList = charFolder.list();
	

	static void createCharSheet(String race, String name, String SPname) throws IOException, ClassNotFoundException {
	  FileWriter wr = new FileWriter("characters/" + name);
	  BufferedWriter writer = new BufferedWriter(wr); 
  	  writer.write(race + System.lineSeparator());
  	  writer.write(name + System.lineSeparator());
  	  writer.write(SPname);
  	  System.out.println("Character created!");
  	  writer.close();
	  }
	

	
	public static void main(String[] args) {
		Display display = new Display();
		//Display starts everything
		Shell game = new Shell(display);
		GridLayout menuLayout = new GridLayout();
		game.setLayout(menuLayout);
		//Shell represents a window within the application
	    game.setSize(1000, 1000);
	    
	    
	    GridData menuData = new GridData(GridData.FILL_HORIZONTAL);
	    TabFolder tabs = new TabFolder(game, 0);
	    tabs.setLayoutData(menuData);
	    

	    

	    Composite charCreation = new Composite(tabs, 0);

				    GridLayout layout = new GridLayout();
				    layout.numColumns = 2;
				    charCreation.setLayout(layout);

	    
				    GridData charCreategridData = new GridData(GridData.FILL_HORIZONTAL);
				    charCreategridData.horizontalSpan = 2;
				   
				    
				    Group charCreateinput = new Group(charCreation, 0);    
				    charCreateinput.setLayoutData(charCreategridData);
				    charCreateinput.setLayout(layout);
				    Label r = widgets.createLabel(charCreateinput, SWT.CENTER, "Type:");
				    Text type = widgets.createTextBox(charCreateinput, SWT.BORDER, "");
				    Label n = widgets.createLabel(charCreateinput, SWT.CENTER, "Name:");
				    Text name = widgets.createTextBox(charCreateinput, SWT.BORDER, "");
				    Label SP = widgets.createLabel(charCreateinput, SWT.CENTER, "Super Attack:");
				    Text SPname = widgets.createTextBox(charCreateinput, SWT.BORDER, ""); 
				    
				    type.setLayoutData(charCreategridData);
				    name.setLayoutData(charCreategridData);
				    SPname.setLayoutData(charCreategridData); 
				    
				    
				     
				    Composite charCreatebuttons = new Composite(charCreation, 0);
				    charCreatebuttons.setLayout(layout);
				    Button submit = new Button(charCreatebuttons, SWT.PUSH);
				    submit.setText("Submit");
					Button close = widgets.createCloseButton(game, charCreatebuttons);
					Label success = widgets.createLabel(charCreatebuttons, 0, "Character created!");
					success.setVisible(false);

				   
					TabItem charCreationTab = new TabItem(tabs, 0);
				    charCreationTab.setText("Character Creation");			
					charCreationTab.setControl(charCreation);
	    
					
		Composite charLister = new Composite(tabs, 0);
					GridLayout layout2 = new GridLayout();
					layout.numColumns = 2; 
					charLister.setLayout(layout);
					
					GridData data = new GridData(GridData.FILL_BOTH);
					
					List characters = new List(charLister, SWT.SINGLE);
					
					submit.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
								success.setVisible(true);
								try {
									createCharSheet(type.getText(), name.getText(), SPname.getText());
									characters.add(name.getText());
								} catch (ClassNotFoundException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
					});	
					
					
					characters.setLayoutData(data);
					
					for (String character : characterList) {
						characters.add(character);
					}
					
					
					Group stats = new Group(charLister, SWT.BORDER);
					stats.setText("Stats");
					stats.setLayoutData(data);
					GridLayout statsLayout = new GridLayout();
					statsLayout.makeColumnsEqualWidth = true;
					statsLayout.numColumns = 3;
					stats.setLayout(statsLayout);
					GridData statDat = new GridData();
					statDat.widthHint = 150;
					
					Label type1 = new Label(stats, 0);
					type1.setText("No selection");
					type1.setLayoutData(statDat);
					Label name1 = new Label(stats, 0);
					name1.setText("No selection");
					name1.setLayoutData(statDat);
					Label SPname1 = new Label(stats, 0);
					SPname1.setText("No selection");
					SPname1.setLayoutData(statDat);
					
					characters.addSelectionListener(new SelectionListener() {
					      public void widgetSelected(SelectionEvent event) {
					    	  File sheet = new File("src/characters/" + characters.getItem(characters.getFocusIndex()));    	  
				    		  Scanner r = null;
							try {
								r = new Scanner(sheet);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
						 		e.printStackTrace();
							}
				    		  type1.setText("Race: " + r.nextLine());
				    		  name1.setText("Name: " + r.nextLine());
				    		  SPname1.setText("Special: " + r.nextLine());
					      }

						@Override
						public void widgetDefaultSelected(SelectionEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
					TabItem charListerTab = new TabItem(tabs, 0);
				    charListerTab.setText("Character List");			
					charListerTab.setControl(charLister);
	   
	    
		Composite battle = new Composite(tabs, 0);
				    GridLayout layout3 = new GridLayout();
				    layout.numColumns = 2;
				    battle.setLayout(layout);
					
				    GridData whoBattleData = new GridData();
					whoBattleData.horizontalSpan = 2;
					Label whoBattle = widgets.createLabel(battle, 0, "Who would you like to battle?");
					whoBattle.setLayoutData(whoBattleData);
					
					
					
					
					
					TabItem battleTab = new TabItem(tabs, 0);
					battleTab.setText("Battle");			
					battleTab.setControl(battle);
					
					

	    
		game.open();
		
		while (!game.isDisposed()) {
			if (!display.readAndDispatch()) {
			              display.sleep();
				}
			
	}


}

	
}
