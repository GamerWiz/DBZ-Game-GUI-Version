package customwidgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;

public class widgets {
	public static Button createButton(Shell shell, String text) {
		Button b = new Button(shell, SWT.PUSH);
		b.setText(text);
		return b;
	}
	public static Button createButton(Group group, String text) {
		Button b = new Button(group, SWT.PUSH);
		b.setText(text);
		return b;
	}
	
	
	// CLOSE BUTTON		CLOSE BUTTON	CLOSE BUTTON		CLOSE BUTTON	CLOSE BUTTON	CLOSE BUTTON	CLOSE BUTTON	
	public static Button createCloseButton(Shell shell) {
		Button close = new Button(shell, SWT.PUSH);
		close.setText("Close");
		close.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});
		return close;
	}
	public static Button createCloseButton(Shell shell, Composite composite) {
		Button close = new Button(composite, SWT.PUSH);
		close.setText("Close");
		close.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});
		return close;
	}
	public static Button createCloseButton(Shell shell, Group group) {
		Button close = new Button(group, SWT.PUSH);
		close.setText("Close");
		close.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				shell.close();
			}
		});
		return close;
	}
	
	
	// LABEL	LABEL	LABEL	LABEL	LABEL	LABEL	LABEL	LABEL	LABEL	LABEL	LABEL
	
	public static Label createLabel(Shell shell, int style, String text) {
		Label l = new Label(shell, style);
		l.setText(text);
		return l;
	}
	
	public static Label createLabel(Composite composite, int style, String text) {
		Label l = new Label(composite, style);
		l.setText(text);
		return l;
	}
	
	public static Label createLabel(Group group, int style, String text) {
		Label l = new Label(group, style);
		l.setText(text);
		return l;
	}
	
	public static Label createLabel(TabFolder tab, int style, String text) {
		Label l = new Label(tab, style);
		l.setText(text);
		return l;
	}
	
	
	
	
	
	
	public static Text createTextBox(Shell shell, int style, String text) {
		Text t = new Text(shell, style);
		t.setText(text);
		return t;
	}
	
	public static Text createTextBox(Group group, int style, String text) {
		Text t = new Text(group, style);
		t.setText(text);
		return t;
	}
	public static Text createTextBox(TabFolder tabs, int style, String text) {
		Text t = new Text(tabs, style);
		t.setText(text);
		return t;
	}



}
