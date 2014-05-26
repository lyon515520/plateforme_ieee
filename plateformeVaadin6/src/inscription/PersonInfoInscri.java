package inscription;




import java.sql.ResultSet;

import com.example.plateformevaadin6.MysqlConnection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class PersonInfoInscri extends CustomComponent {
	private MysqlConnection con;
	public VerticalLayout vl = new VerticalLayout();
	//public Button quit = new Button("Quitter", this, "quit");
	private TextField username;
	private TextField lastname;
	private TextField firstname;
	private DateField birthday;
	private ComboBox sex;
	private ComboBox nationality;
	private TextField tel;
	private TextField email;
	private Button submit;
	
	
	public PersonInfoInscri() {
		Person();
		setCompositionRoot(vl);
		
	}
	private VerticalLayout Person(){
		vl = new VerticalLayout();
		vl.setSizeFull();
	
		username = new TextField("Username");
		lastname = new TextField("Lastname");
		firstname = new TextField("Firstname");
		birthday = new DateField("Birthday");
		sex = new ComboBox("Sex");
		nationality = new ComboBox("Nationality");
		tel = new TextField("Tel");
		email = new TextField("E-mail");
		submit = new Button("Submit", this, "setPrePerson");
		
		birthday.setDateFormat("yyyy-MM-dd");

		
	   // for(int i = 18; i<=120; i++){
		//	age.addItem(i);
	//	}
		
		//essai update
	    
	    sex.addItem("male");
	    sex.addItem("female");
	
		vl.addComponent(username);
		vl.addComponent(lastname);
		vl.addComponent(firstname);
		vl.addComponent(birthday);
		vl.addComponent(sex);
		vl.addComponent(nationality);
		vl.addComponent(tel);
		vl.addComponent(email);
		vl.addComponent(submit);
	
		vl.setComponentAlignment(username, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(lastname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(firstname, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(birthday, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(sex, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(nationality, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(tel, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(email, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(submit, Alignment.MIDDLE_CENTER);
		return vl;
	}
	
	public void setPrePerson() throws Exception{
		con = new MysqlConnection();
		//Label l = new Label(""+username.getValue()+"");
		//vl.removeAllComponents();
		//vl.addComponent(l);
		
		con.executeTable("INSERT INTO pre_user (username) VALUES ('"+username.getValue()+"')");
		//doesn't work this place
	
	}
	
	
}
