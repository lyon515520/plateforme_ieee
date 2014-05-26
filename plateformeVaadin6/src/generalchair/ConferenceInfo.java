package generalchair;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ConferenceInfo extends CustomComponent {
	private MysqlConnection con;
	//public Button quit = new Button("Quitter", this, "quit");
	public HorizontalLayout hl= new HorizontalLayout(); 
	private VerticalLayout vl;
	private GridLayout gl;
	private int num = 21;
	private Button[] note = new Button[num];
	private Label[] line = new Label[num-1];
	private Label noteredcount;
	private Label noterednumber;
	private Label noteorangecount;
	private Label noteorangenumber;
	private Label notegreencount;
	private Label notegreennumber;
	private Label task;
	
	
	public ConferenceInfo() {
		Filrouge();
		setCompositionRoot(hl);
		
	}
	
	private HorizontalLayout Filrouge(){
		hl = new HorizontalLayout();
		hl.setMargin(true);
		hl.setSizeFull();
		
		
		vl = filprogress();
		
		gl = new GridLayout();
		
		hl.addComponent(vl);
		hl.addComponent(gl);
		hl.setExpandRatio(vl, 1);
		hl.setExpandRatio(gl, 2);
		
		vl.setSizeFull();
		gl.setSizeFull();
		
		gl.setColumns(15);
		gl.setRows(11);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		
		for(int i = 0; i<num; i++){
			
			note[i] = new Button("",this,"showtask");
			note[i].addStyleName("note"+(i+1));
			//note[i].setId("note"+(i+1));
			note[i].setWidth("100.0%");
			note[i].setHeight("100.0%");
			//note[i].setIcon(new ThemeResource("image/buttonred"));
			
			if(i<6){
				
				gl.addComponent(note[i], 2*(i+1), 2);
				
			}
			
			else if(i>=6 && i<12){
				
				gl.addComponent(note[i], 2*(12-i), 4);
				
			}
			
			else if(i>=12 && i<18){
				
				gl.addComponent(note[i], 2*((i-12)+1), 6);
				
			}
			
			else{
				
				gl.addComponent(note[i], 2*((24-i)), 8);
				
			}
			
			gl.setComponentAlignment(note[i], new Alignment(48));
		
			}
		
		
		for(int j = 0; j<num-1; j++){
			
			line[j] = new Label();
			line[j].addStyleName("line"+(j+1));
			
			if(j<5){
				
				gl.addComponent(line[j], 2*(j+1)+1, 2);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==5){
				
				gl.addComponent(line[j], 12, 3);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else if(j>=6 && j<11){
				
				gl.addComponent(line[j], 2*(12-(j+1))+1, 4);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==11){
				
				gl.addComponent(line[j], 2, 5);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else if(j>=12 && j<17){
				
				gl.addComponent(line[j],  2*((j+1)-12)+1, 6);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			else if(j==17){
				
				gl.addComponent(line[j], 12, 7);
				line[j].setWidth("10.0%");
				line[j].setHeight("100.0%");
				
			}
			
			else{
				
				gl.addComponent(line[j], 2*(24-(j+1))+1, 8);
				line[j].setWidth("100.0%");
				line[j].setHeight("10.0%");
				
			}
			
			gl.setComponentAlignment(line[j], new Alignment(48));
			
		}
		
	
		return hl;
		
	}
	
	public VerticalLayout filprogress() {
		VerticalLayout vl = new VerticalLayout();
		HorizontalLayout hl1 = new HorizontalLayout();
		HorizontalLayout hl2 = new HorizontalLayout();
		HorizontalLayout hl3 = new HorizontalLayout();
		vl.setSizeFull();
		//hl1.setSizeFull();
		//hl2.setSizeFull();
		//hl3.setSizeFull();
		vl.setSpacing(true);
		vl.setMargin(true);
		
		noteredcount = new Label("");
		noterednumber = new Label("21");
		noteorangecount = new Label(" ");
		noteorangenumber = new Label("0");
		notegreencount = new Label(" ");
		notegreennumber = new Label("0");
		
		noteredcount.addStyleName("noteredcount");
		noteorangecount.addStyleName("noteorangecount");
		notegreencount.addStyleName("notegreencount");
		
		hl1.addComponent(noteredcount);
		hl1.addComponent(noterednumber);
		hl2.addComponent(noteorangecount);
		hl2.addComponent(noteorangenumber);
		hl3.addComponent(notegreencount);
		hl3.addComponent(notegreennumber);
		
		vl.addComponent(hl1);
		vl.addComponent(hl2);
		vl.addComponent(hl3);
		return vl;
	}
	
	//here to add the connection with BDD, to show all the tasks of one certain note!
	public void showtask(){
		vl.removeAllComponents();
		task = new Label("task show successful");
		vl.addComponent(task);
		
	}



}