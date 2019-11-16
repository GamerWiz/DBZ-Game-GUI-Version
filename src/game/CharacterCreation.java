package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import customwidgets.widgets;

public class CharacterCreation {

	public static void run() {
		Shell charCreate = new Shell(Display.getCurrent());
		//Shell represents a window within the application
	    charCreate.setSize(250, 300);
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 2;
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
	    gridData.horizontalSpan = 2;
	    charCreate.setLayout(layout);
	    
	    Group input = new Group(charCreate, SWT.TRANSPARENT);
	    input.setLayoutData(gridData);
	    input.setLayout(layout);
	    Label r = widgets.createLabel(input, SWT.CENTER, "Type:");
	    Text type = widgets.createTextBox(input, SWT.BORDER, "");
	    Label n = widgets.createLabel(input, SWT.CENTER, "Name:");
	    Text name = widgets.createTextBox(input, SWT.BORDER, "");
	    Label SP = widgets.createLabel(input, SWT.CENTER, "Super Attack:");
	    Text SPname = widgets.createTextBox(input, SWT.BORDER, ""); 
	    
	    type.setLayoutData(gridData);
	    name.setLayoutData(gridData);
	    SPname.setLayoutData(gridData);

	    
	     
	    Composite buttons = new Composite(charCreate, 0);
	    Button submit = new Button(buttons, SWT.PUSH);
	    submit.setText("Submit");
		Button close = widgets.createCloseButton(charCreate);
		Label success = widgets.createLabel(charCreate, 0, "Character created!");
		success.setVisible(false);
		submit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
					success.setVisible(true);
					try {
						createCharSheet(type.getText(), name.getText(), SPname.getText());
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});	
		charCreate.open();	
	}
	
	  static void createCharSheet(String type, String name, String SPname) throws IOException, ClassNotFoundException {
		  FileWriter wr = new FileWriter("src/characters/" + name);
		  BufferedWriter writer = new BufferedWriter(wr); 
    	  writer.write(type + System.lineSeparator());
    	  writer.write(name + System.lineSeparator());
    	  writer.write(SPname);
    	  writer.close();
	  }

}

