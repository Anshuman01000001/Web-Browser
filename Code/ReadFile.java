import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public ReadFile(){
		super("Anshuman's Browser");
		
		addressBar = new JTextField("Type a URL");
		addressBar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					loadHTML(e.getActionCommand());
				}
			}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener(){
				public void hyperlinkUpdate(HyperlinkEvent e){
					if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
						loadHTML(e.getURL().toString());
					}
				}
			}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	//loadHTML to display on the screen
	private void loadHTML(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			System.out.println("Error");
		}
	}
}