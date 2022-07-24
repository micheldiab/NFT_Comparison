package application;
import java.net.URL;
import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;

import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.apache.xmlbeans.impl.tool.Extension;

import ahmad.Calcuator;
import ahmad.Collection1;
import ahmad.MagicEdenGetCollections;
import ahmad.NullCollection;
import ahmad.Upload;
import ahmad.getPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogManager;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;



public class GuiController implements Initializable,Upload{
	
	private Integer[] array= {17,25,50,100};

	 @FXML
	    private TableView<row> tableView;

    @FXML
    private TableColumn<row, String> name;

    @FXML
    private TableColumn<row, Double> opensea;

    @FXML
    private TableColumn<row, Double> magic;

    @FXML
    private TableColumn<row, Double> diff;

    @FXML
    private Button addCollectionBtn;

    @FXML
    private TextField searchTextField;
    
    @FXML
    private ComboBox<Integer> comboBox;

 
    @FXML
    private Button refreshSaveBtn;

    @FXML
    private Button checkEmailSaveBtn;

    @FXML
    private Button previousBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Button saveListBtn;

    @FXML
    private Button uploadBtn;

    @FXML
    private Button emailsToSaveBtn;

    @FXML
    private Button emailThresholdSaveBtn;
    
    @FXML
    private TextField refreshText;

    @FXML
    private TextField checkEmailText;

    @FXML
    private TextField thresholdText;

    @FXML
    private TextField emailsText;

    @FXML
    private TextField collectText;

    @FXML
    private TextField magicText;

    @FXML
    private TextField openText;


    @FXML
    private Button addBtn;

    @FXML
    private Label tenLabel;
    

    @FXML
    private Label showing;
    @FXML
    private Label openLabel;

    @FXML
    private Label collectLabel;

    @FXML
    private Label magicLabel;
    
    @FXML
    private Button oneBtn;

    @FXML
    private Button secondBtn;

    @FXML
    private Button thirdBtn;

    @FXML
    private Button fourthBtn;

    @FXML
    private Button fiveBtn;

    @FXML
    private Button sixBtn;
    
    @FXML
    private Label collectLabel1;

    @FXML
    private TextField collectText1;


    private String checkTime;
    private String emails;
    private String refreshTime;
    private String threshold;
    private static String text="";
    private int saveNumber=0;
	ObservableList<row> rows=FXCollections.observableArrayList();
	ObservableList<row> table=FXCollections.observableArrayList();
	ArrayList<ahmad.Collections> collections = new ArrayList<>();
	//ObservableList<row> show10=FXCollections.observableArrayList();
	//ObservableList<row> show25=FXCollections.observableArrayList();
	//ObservableList<row> show50=FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		checkTime=checkEmailText.getText();
		emails=emailsText.getText();
		refreshTime=refreshText.getText();
		threshold=thresholdText.getText();
		comboBox.getItems().addAll(array);
		comboBox.setValue(17);
		oneBtn.setStyle("-fx-background-color: grey;");
		
		/*try {
			collections=MagicEdenGetCollections.getCollections();
		
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		   /*
		for(int i=0;i<collections.size();i++)
		{
		
			if(collections.get(i) instanceof NullCollection)
				continue;
			Collection1 collect=(Collection1) collections.get(i);
			double openseaa=0.0;
	    	String collectName,formatted;
	    	Double diffe,magiccc;
	    	
	    	System.out.println(collect.getOpenSeaFloorPrice());
	    
	    	magiccc=(double) collect.getMagicEdenFloorPrice();
	    	collectName=collect.getCollectionName();
	    	Calcuator.getInstance();
			magiccc=Calcuator.magicToSol(magiccc);
			openseaa=collect.getOpenSeaFloorPrice();
			openseaa=Calcuator.openSeaToSol(openseaa);
			DecimalFormat diffDec=new DecimalFormat("#.##");
			
			formatted=diffDec.format(openseaa);
			openseaa=Double.parseDouble(formatted);
			
			formatted=diffDec.format(magiccc);
			magiccc=Double.parseDouble(formatted);
	   
	    	
	    	System.out.println("oneseaa: "+openseaa);
	    	System.out.println("magicc "+magiccc);
	    	if(openseaa==0|| magiccc==0)
	    		diffe=0.0;
	    	else
	    	{
	    	diffe=1- ((double)magiccc)/openseaa;
	    	diffe=diffe*100;
	    	if(diffe!=0)
	    	diffe=diffe*-1;
	    	formatted=diffDec.format(diffe);
	    	diffe=Double.parseDouble(formatted);
	    	}
	    	System.out.println("diff "+diffe);
			rows.add(new row(collectName,openseaa,magiccc,diffe));
		}
*/
		name.setCellValueFactory(new PropertyValueFactory<row, String>("name"));
		opensea.setCellValueFactory(new PropertyValueFactory<row, Double>("opensea"));
		magic.setCellValueFactory(new PropertyValueFactory<row, Double>("magic"));
		diff.setCellValueFactory(new PropertyValueFactory<row, Double>("diff"));
		sortList();
	
		for(int i=0;i<Math.min(rows.size(), 17);i++)
    		table.add(rows.get(i));
		tableView.setItems(table);
		/*
		for(int i=0;i<rows.size();i++)
		{
	if(i<10)
		show10.add(rows.get(i));
	if(i<25)
			show25.add(rows.get(i));
	
	if(i<50)
		show50.add(rows.get(i));

		}
	
  */
	
	
	
	
		collectText.setVisible(false);
		collectText1.setVisible(false);
		
		addBtn.setVisible(false);
		
		

		collectLabel.setVisible(false);
		collectLabel1.setVisible(false);

		
		new Thread() {
			  public void run() {
			    //your code here
				  while(true)
				  {
				try {
					Thread.sleep(Integer.valueOf(checkTime) * 1000);
					
				//	emails="mishomars1@gmail.com;michel.diab162@gmail.com";
		
				String[] receiver=emails.split(";");
			
					//String[] receiver= {"mishomars1@gmail.com"};
					Double thresholdValue=Double.valueOf(threshold);
					for(int i=0;i<rows.size();i++)
					{
						Double dif=rows.get(i).getDiff();
						if(Math.abs(dif)>=thresholdValue)
						{
							System.out.println(dif);
							System.out.println(rows.get(i).getMagic());
							text=text+rows.get(i).getName()+"\t"+rows.get(i).getOpensea().toString()+"\t"+rows.get(i).getMagic().toString()+"\t"+rows.get(i).getDiff().toString()+"\n";
						}
							
					}
					if(text!="")
					sendMail(receiver);
					text="";
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				  }
			  }
			}.start();
			
			
			new Thread() {
				  public void run() {
				    //your code here
					  while(true)
					  {
		
						try {
							Thread.sleep(Integer.valueOf(refreshTime) * 1000);
							collections=MagicEdenGetCollections.getCollections();
							rows=FXCollections.observableArrayList();
							for(int i=0;i<collections.size();i++)
							{
								if(collections.get(i) instanceof NullCollection)
									continue;
								Collection1 collect=(Collection1) collections.get(i);
								double openseaa=0.0;
						    	String collectName,formatted;
						    	Double diffe,magiccc;
						    	
						    	System.out.println(collect.getOpenSeaFloorPrice());
						    
						    	magiccc=(double) collect.getMagicEdenFloorPrice();
						    	collectName=collect.getCollectionName();
						    	Calcuator.getInstance();
								magiccc=Calcuator.magicToSol(magiccc);
								openseaa=collect.getOpenSeaFloorPrice();
								openseaa=Calcuator.openSeaToSol(openseaa);
								DecimalFormat diffDec=new DecimalFormat("#.##");
								
								formatted=diffDec.format(openseaa);
								openseaa=Double.parseDouble(formatted);
								
								formatted=diffDec.format(magiccc);
								magiccc=Double.parseDouble(formatted);
						   
						    	
						    	System.out.println("oneseaa: "+openseaa);
						    	System.out.println("magicc "+magiccc);
						    	if(openseaa==0|| magiccc==0)
						    		diffe=0.0;
						    	else
						    	{
						    	diffe=1- ((double)magiccc)/openseaa;
						    	diffe=diffe*100;
						    	if(diffe!=0)
						    	diffe=diffe*-1;
						    	formatted=diffDec.format(diffe);
						    	diffe=Double.parseDouble(formatted);
						    	}
						    	System.out.println("diff "+diffe);
								rows.add(new row(collectName,openseaa,magiccc,diffe));
							}

							name.setCellValueFactory(new PropertyValueFactory<row, String>("name"));
							opensea.setCellValueFactory(new PropertyValueFactory<row, Double>("opensea"));
							magic.setCellValueFactory(new PropertyValueFactory<row, Double>("magic"));
							diff.setCellValueFactory(new PropertyValueFactory<row, Double>("diff"));
							sortList();
						
							for(int i=0;i<Math.min(rows.size(), 17);i++)
					    		table.add(rows.get(i));
							tableView.setItems(table);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
				  }
					  }
				}.start();
			
		
	
	}
	
	public void sortList()
	{
		Collections.sort(rows, new Comparator<row>(){
			 public int compare(row diff1, row diff2) {
				  Double first,second;
				  first=diff1.getDiff();
				  second=diff2.getDiff();
				  if(Math.abs(first)<Math.abs(second))
						  return 1;
				  else if(Math.abs(first)>Math.abs(second))
						  return -1;
			    return 0;
			  }
           });
	}

        
	public void choiceBoxChanged() {
		// TODO Auto-generated method stub

		tenLabel.setText(comboBox.getValue().toString());
		table=FXCollections.observableArrayList();
		int val=comboBox.getValue();
		for(int i=0;i<val;i++)
			table.add(rows.get(i));
		
			tableView.setItems(table);
 
		
	}
	

	public static void sendMail(String[] receiver)
	{
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail="MichelProject58@gmail.com";
		String password="michel585858";
		
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
			
		});
		
		for(int i=0;i<receiver.length;i++)
		{
		Message message=prepareMessage(session,myAccountEmail,receiver[i]);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Message sent Successfully");
		}
	}
	
	private static Message prepareMessage(Session session,String myAccountEmail,String recepient)
	{
		Message message=new MimeMessage(session);
		String firstRow="Collection name\t Opensea[Sol]\t Magic eden[Sol]\t Diff[%]\n";
	
			try {
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient) );
			//	message.setSubject("My first Email");
			//	message.setText(firstRow+"DeGods\t 250\t 194\t -22.4");
				message.setText(firstRow+text);
				return message;
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null; 
			


	}
	
	 @FXML
	    void refreshSave(ActionEvent event) {

		refreshTime=refreshText.getText();
	    }
	 
	  @FXML
	    void checkEmailSave(ActionEvent event) {
		  
		  checkTime=checkEmailText.getText();

	    }
    @FXML
    void emailThresholdSave(ActionEvent event) {
    	threshold=thresholdText.getText();

    }

    @FXML
    void emailsSave(ActionEvent event) {
    	
    	emails=emailsText.getText();

    }
    
    @FXML
    void add(ActionEvent event){

		String symbol=collectText1.getText().toString();
    	String slug=collectText.getText().toString();
    
    	Double openseaa=0.0;
    	Double magicc=0.0;
    	String collectName,formatted;
    	Double diffe;
    
    	
    		try {
    			magicc=(double) getPrice.getMagicEdenFloorPrice(symbol);
    			openseaa=(double) getPrice.getOpeanSeaFloorPrice(slug);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		System.out.println("symbol:"+symbol);//magic
    		System.out.println("slug:"+slug);//opensea
    		DecimalFormat diffDec=new DecimalFormat("#.##");
    		
    		formatted=diffDec.format(openseaa);
    		openseaa=Double.parseDouble(formatted);
    		
    		formatted=diffDec.format(magicc);
    		magicc=Double.parseDouble(formatted);


    		if(openseaa==0|| magicc==0)
    			diffe=0.0;
    		else
    		{
    		diffe=1- ((double)magicc)/openseaa;
    		diffe=diffe*100;
    		if(diffe!=0)
    		diffe=diffe*-1;
    		formatted=diffDec.format(diffe);
    		diffe=Double.parseDouble(formatted);
    		}

    		rows.add(new row(symbol,openseaa,magicc,diffe));
 

    	String number="";
    	number=tenLabel.getText();
    	Integer n=Integer.valueOf(number) +1;
    	tenLabel.setText(n.toString());

    	sortList();
    	tableView.setItems(rows);
    	collectText.setVisible(false);
		collectText1.setVisible(false);
		addBtn.setVisible(false);
		
		
		collectLabel.setVisible(false);
		collectLabel1.setVisible(false);

    	}  


    @FXML
    void addCollection(ActionEvent event) {
    

			collectText.setVisible(true);
			collectText1.setVisible(true);
			addBtn.setVisible(true);
			
			
			collectLabel.setVisible(true);
			collectLabel1.setVisible(true);
		
			
			String number="";
	    	number=tenLabel.getText();
	    	Integer n=Integer.valueOf(number) +1;
	    	tenLabel.setText(n.toString());
    	
    }
    
    @FXML
    void one(ActionEvent event) {


    	table=FXCollections.observableArrayList();
    	for(int i=0;i<Math.min(rows.size(), 17);i++)
    		table.add(rows.get(i));
    	
    	if(table.isEmpty()==false)
    		showing.setText("Showing 1 to ");
    	
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: grey;");
    	secondBtn.setStyle("-fx-background-color: transparent;");
    	thirdBtn.setStyle("-fx-background-color: transparent;");
    	fourthBtn.setStyle("-fx-background-color: transparent;");
    	fiveBtn.setStyle("-fx-background-color: transparent;");
    	sixBtn.setStyle("-fx-background-color: transparent;");
;

    }
    @FXML
    void two(ActionEvent event) {
  
    	
    	table=FXCollections.observableArrayList();
    	for(int i=17;i<Math.min(rows.size(), 34);i++)
    		table.add(rows.get(i));
    	if(table.isEmpty()==false)
    	showing.setText("Showing 17 to ");
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: transparent");
    	secondBtn.setStyle("-fx-background-color: grey;");
    	thirdBtn.setStyle("-fx-background-color: transparent;");
    	fourthBtn.setStyle("-fx-background-color: transparent;");
    	fiveBtn.setStyle("-fx-background-color: transparent;");
    	sixBtn.setStyle("-fx-background-color: transparent;");
    }
    
    @FXML
    void three(ActionEvent event) {

    	table=FXCollections.observableArrayList();
    	for(int i=34;i<Math.min(rows.size(), 51);i++)
    		table.add(rows.get(i));
    	if(table.isEmpty()==false)
    	showing.setText("Showing 34 to ");
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: transparent;");
    	secondBtn.setStyle("-fx-background-color: transparent;");
    	thirdBtn.setStyle("-fx-background-color: grey;");
    	fourthBtn.setStyle("-fx-background-color: transparent;");
    	fiveBtn.setStyle("-fx-background-color: transparent;");
    	sixBtn.setStyle("-fx-background-color: transparent;");
    }
    
    @FXML
    void four(ActionEvent event) {
 
    	table=FXCollections.observableArrayList();
    	for(int i=51;i<Math.min(rows.size(), 68);i++)
    		table.add(rows.get(i));
    	if(table.isEmpty()==false)
    	showing.setText("Showing 51 to ");
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: transparent;");
    	secondBtn.setStyle("-fx-background-color: transparent;");
    	thirdBtn.setStyle("-fx-background-color: transparent;");
    	fourthBtn.setStyle("-fx-background-color: grey;");
    	fiveBtn.setStyle("-fx-background-color: transparent;");
    	sixBtn.setStyle("-fx-background-color: transparent;");
    }
    @FXML
    void five(ActionEvent event) {

    	table=FXCollections.observableArrayList();
    	for(int i=68;i<Math.min(rows.size(),85);i++)
    		table.add(rows.get(i));
    	if(table.isEmpty()==false)
    	showing.setText("Showing 68 to ");
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: transparent;");
    	secondBtn.setStyle("-fx-background-color: transparent;");
    	thirdBtn.setStyle("-fx-background-color: transparent;");
    	fourthBtn.setStyle("-fx-background-color: transparent;");
    	fiveBtn.setStyle("-fx-background-color: grey;");
    	sixBtn.setStyle("-fx-background-color: transparent;");

    }
    
    @FXML
    void six(ActionEvent event) {
    	table=FXCollections.observableArrayList();

    	for(int i=85;i<Math.min(rows.size(),102);i++)
    		table.add(rows.get(i));
    	
    	if(table.isEmpty()==false)
    	showing.setText("Showing 85 to ");
    	tableView.setItems(table);
    	oneBtn.setStyle("-fx-background-color: transparent;");
    	secondBtn.setStyle("-fx-background-color: transparent;");
    	thirdBtn.setStyle("-fx-background-color: transparent;");
    	fourthBtn.setStyle("-fx-background-color: transparent;");
    	fiveBtn.setStyle("-fx-background-color:transparent;");
    	sixBtn.setStyle("-fx-background-color: grey;");

    }
    
    @FXML
    void previous(ActionEvent event) {

    		if(secondBtn.getStyle().equals("-fx-background-color: grey;"))
    			one(event);
    		else
        		if(thirdBtn.getStyle().equals("-fx-background-color: grey;"))
        			two(event);
        		else
            		if(fourthBtn.getStyle().equals("-fx-background-color: grey;"))
            			three(event);
            		else
                		if(fiveBtn.getStyle().equals("-fx-background-color: grey;"))
                			four(event);
                		else
                    		if(sixBtn.getStyle().equals("-fx-background-color: grey;"))
                    			five(event);
    	

    }
    
    @FXML
    void next(ActionEvent event) {
     	if(oneBtn.getStyle().equals("-fx-background-color: grey;"))
    		two(event);
    	else
    		if(secondBtn.getStyle().equals("-fx-background-color: grey;"))
    			three(event);
    		else
        		if(thirdBtn.getStyle().equals("-fx-background-color: grey;"))
        			four(event);
        		else
            		if(fourthBtn.getStyle().equals("-fx-background-color: grey;"))
            			five(event);
            		else
                		if(fiveBtn.getStyle().equals("-fx-background-color: grey;"))
                			six(event);
       
  
    }
   
   
    
    
    
    @FXML
    void searchText(ActionEvent event){
    	  String keyword = searchTextField.getText();
   
    	     ObservableList<row> filteredData = FXCollections.observableArrayList();
    	     for (row val : rows) {
   
    	    		 if(startsWith(val.getName(), keyword, true)) 
    	             filteredData.add(val);
    	     }
    	   
    	     tableView.setItems(filteredData);
    	   }

 
   public static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }
   
    @FXML
    void saveList(ActionEvent event) throws IOException {
    	
    			saveNumber++;
    	        Writer writer = null;
    	        try {
    	        	String userDirectory = System.getProperty("user.dir");
 
    	            File file = new File(userDirectory+"\\SavedList"+saveNumber+".csv.");
    	            if(!file.canRead())
    	                file.setReadable(true);
    	            writer = new BufferedWriter(new FileWriter(file));
    	            String text1 = "Collection name" + "," +"Opensea [Sol]"+ "," + "Magic Eden [Sol]"  + "," + "Diff [%]" + "\n";

	                writer.write(text1);
    	            for (row val : table) {

    	                String text = val.getName() + "," + val.getOpensea() + "," + val.getMagic() + "," + val.getDiff() + "\n";

    	                writer.write(text);
    	            }
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	        }
    	        finally {

    	            writer.flush();
    	             writer.close();
    	        }
    	}
    

    @FXML
    void uploadList(ActionEvent event) throws FileNotFoundException {
    	
execute();
}  

    	
    	//tableView.setItems(savedList);

    
    @FXML
	void addMouseEntered(MouseEvent event) {
		addCollectionBtn.getScene().setCursor(Cursor.HAND);
	}

	@FXML
	void addMouseExit(MouseEvent event) {
		addCollectionBtn.getScene().setCursor(Cursor.DEFAULT);
	}
	  @FXML
		void saveListMouseEntered(MouseEvent event) {
			saveListBtn.getScene().setCursor(Cursor.HAND);
		}

		@FXML
		void saveListMouseExit(MouseEvent event) {
			saveListBtn.getScene().setCursor(Cursor.DEFAULT);
		}
		 @FXML
			void uploadListMouseEntered(MouseEvent event) {
				uploadBtn.getScene().setCursor(Cursor.HAND);
			}

			@FXML
			void uploadListMouseExit(MouseEvent event) {
				uploadBtn.getScene().setCursor(Cursor.DEFAULT);
			}
			 @FXML
				void firstSaveMouseEntered(MouseEvent event) {
					refreshSaveBtn.getScene().setCursor(Cursor.HAND);
				}

				@FXML
				void firstSaveMouseExit(MouseEvent event) {
					refreshSaveBtn.getScene().setCursor(Cursor.DEFAULT);
				}
				 @FXML
					void secondSaveMouseEntered(MouseEvent event) {
						checkEmailSaveBtn.getScene().setCursor(Cursor.HAND);
					}

					@FXML
					void secondSaveMouseExit(MouseEvent event) {
						checkEmailSaveBtn.getScene().setCursor(Cursor.DEFAULT);
					}
					
					 @FXML
						void thirdSaveMouseEntered(MouseEvent event) {
							emailThresholdSaveBtn.getScene().setCursor(Cursor.HAND);
						}

						@FXML
						void thirdSaveMouseExit(MouseEvent event) {
							emailThresholdSaveBtn.getScene().setCursor(Cursor.DEFAULT);
						}
						
						 @FXML
							void fourthSaveMouseEntered(MouseEvent event) {
								emailsToSaveBtn.getScene().setCursor(Cursor.HAND);
							}

							@FXML
							void fourthSaveMouseExit(MouseEvent event) {
								emailsToSaveBtn.getScene().setCursor(Cursor.DEFAULT);
							}

							@Override
							public void execute() throws FileNotFoundException {
								// TODO Auto-generated method stub
						    	String userDirectory = System.getProperty("user.dir");
						    	FileChooser fc=new FileChooser();
						    	fc.setInitialDirectory(new File(userDirectory));
						    	List<String> list=new ArrayList<String>();
						    	list.add("*.csv");

						    	fc.getExtensionFilters().addAll(new ExtensionFilter("Excel Files","*.csv"));
						    	List<File> selectedFiles= fc.showOpenMultipleDialog(null);

						    	String symbol;
						    	String slug;
						    	Scanner sc = new Scanner(new File(selectedFiles.get(0).getPath()));  
						    	Double openseaa=0.0;
						    	Double magicc=0.0;
						    	String collectName,formatted;
						    	Double diffe;
						    	//System.out.println(selectedFiles.get(0).getPath());
						    	sc.useDelimiter(",");   //sets the delimiter pattern
						    	sc.nextLine();

						    	int count=0;

						    	while (sc.hasNext())  //returns a boolean value  
						    	{  
						    		symbol=sc.next().toString();
						    		slug=sc.next().toString();

						    		
						    		try {
						    			magicc=(double) getPrice.getMagicEdenFloorPrice(symbol);
						    			openseaa=(double) getPrice.getOpeanSeaFloorPrice(slug);
						    		} catch (IOException e) {
						    			// TODO Auto-generated catch block
						    			e.printStackTrace();
						    		}
						    		
						    		System.out.println("symbol:"+symbol);//magic
						    		System.out.println("slug:"+slug);//opensea
						    		DecimalFormat diffDec=new DecimalFormat("#.##");
						    		
						    		formatted=diffDec.format(openseaa);
						    		openseaa=Double.parseDouble(formatted);
						    		
						    		formatted=diffDec.format(magicc);
						    		magicc=Double.parseDouble(formatted);

						    		
						    		System.out.println("openseaa: "+openseaa);
						    		System.out.println("magicc "+magicc);
						    		if(openseaa==0|| magicc==0)
						    			diffe=0.0;
						    		else
						    		{
						    		diffe=1- ((double)magicc)/openseaa;
						    		diffe=diffe*100;
						    		if(diffe!=0)
						    		diffe=diffe*-1;
						    		formatted=diffDec.format(diffe);
						    		diffe=Double.parseDouble(formatted);
						    		}

						    		rows.add(new row(symbol,openseaa,magicc,diffe));
						    			count++;
						    		
						    	}

						    	String number="";
						    	number=tenLabel.getText();
						    	Integer n=Integer.valueOf(number) +count;
						    	tenLabel.setText(n.toString());

						    	sc.close();  //closes the scanner
						    	sortList();
						    	tableView.setItems(rows);

						    	}  
								
							}
    


    	
  
   


