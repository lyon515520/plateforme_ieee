package vicepresident;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class Userapply extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");

	
	public Userapply() {
		User();
		setCompositionRoot(vl);
		//vl.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);

	}
	
	public VerticalLayout User(){
		vl = new VerticalLayout();

		
		return vl;
		
	}


}
