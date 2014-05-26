package generalchair;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class Generalchair extends CustomComponent implements TabSheet.SelectedTabChangeListener {	
	public Button quit = new Button("Quitter", this, "quit");
	public VerticalLayout vl = new VerticalLayout();
	private MysqlConnection con;
	public Panel personInfo;
	public Panel conferenceInfo;
	

	public Generalchair() {
		setCompositionRoot(vl);
		vl.setMargin(true);
		vl.setSpacing(true);
		vl.setSizeFull();
		Panel panel = new Panel();
		vl.addComponent(panel);
		panel.addComponent(createToolbar());		
	}
	
	public HorizontalLayout createToolbar() {
		HorizontalLayout hl = new HorizontalLayout();
		TabSheet tabsheet = new TabSheet();
		tabsheet.addListener(this);
		personInfo = personInfo();
		conferenceInfo = conferenceInfo();
		tabsheet.addTab(personInfo, "My information", null);
        tabsheet.addTab(conferenceInfo, "My conference", null); 
        hl.addComponent(tabsheet);
        quit.addStyleName("quitButton");
        hl.addComponent(quit);
		return hl;
	}
	
	private Panel personInfo() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new PersonInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}

	private Panel conferenceInfo() {
		Panel panel = new Panel();
		panel.setHeight("550px");
		panel.setWidth("1280px");
		try {
			panel.setContent(new ConferenceInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return panel;
	}

	public void quit() {
		getApplication().close();
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
