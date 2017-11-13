package com.dennis.time;





import java.io.IOException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;




public class controller{
//sets up brains to be used == this is where the timetable projects gets the information to display
brains brains= new brains();
//both of these control the display
private String displaySubject[][]= new String[7][18];
private String displayRoom[][]= new String[7][18];


ObservableList<String> courseOptions = FXCollections.observableArrayList(
		"All",
        "ACCOUNTING",
        "ADMIN",
        "ARCHITECTURE",
        "BIOLOGY",
        "CCAD",
        "CIVIL",
        "COMPUTING",
        "CONSTRUCTION",
        "CRAFTSTUDIES",
        "ELECTRICAL",
        "MANAGEMENT",
        "MARKETING",
        "MATHS",
        "MECHANICAL",
        "MEDIA",
        "NMCI",
        "ORGANISATION",
        "PHYSICAL SCIENCES",
        "PROCESS",
        "SOCIAL",
        "SPORT",
        "TOURISM"
		    );
@FXML
private Tooltip toolTip;
@FXML

private ChoiceBox<String> courseType;
@FXML
private Text monday9;
@FXML
private Text monday10;
@FXML
private Text monday11;
@FXML
private Text monday12;
@FXML
private Text monday13;
@FXML
private Text monday14;
@FXML
private Text monday15;
@FXML
private Text monday16;
@FXML
private Text monday17;
@FXML
private Text monRoom9;
@FXML
private Text monRoom10;
@FXML
private Text monRoom11;
@FXML
private Text monRoom12;
@FXML
private Text monRoom13;
@FXML
private Text monRoom14;
@FXML
private Text monRoom15;
@FXML
private Text monRoom16;
@FXML
private Text monRoom17;
@FXML
private Text tuesday9;
@FXML
private Text tuesday10;
@FXML
private Text tuesday11;
@FXML
private Text tuesday12;
@FXML
private Text tuesday13;
@FXML
private Text tuesday14;
@FXML
private Text tuesday15;
@FXML
private Text tuesday16;
@FXML
private Text tuesday17;
@FXML
private Text tueRoom9;
@FXML
private Text tueRoom10;
@FXML
private Text tueRoom11;
@FXML
private Text tueRoom12;
@FXML
private Text tueRoom13;
@FXML
private Text tueRoom14;
@FXML
private Text tueRoom15;
@FXML
private Text tueRoom16;
@FXML
private Text tueRoom17;
@FXML
private Text wednesday9;
@FXML
private Text wednesday10;
@FXML
private Text wednesday11;
@FXML
private Text wednesday12;
@FXML
private Text wednesday13;
@FXML
private Text wednesday14;
@FXML
private Text wednesday15;
@FXML
private Text wednesday16;
@FXML
private Text wednesday17;
@FXML
private Text wedRoom9;
@FXML
private Text wedRoom10;
@FXML
private Text wedRoom11;
@FXML
private Text wedRoom12;
@FXML
private Text wedRoom13;
@FXML
private Text wedRoom14;
@FXML
private Text wedRoom15;
@FXML
private Text wedRoom16;
@FXML
private Text wedRoom17;
@FXML
private Text thursday9;
@FXML
private Text thursday10;
@FXML
private Text thursday11;
@FXML
private Text thursday12;
@FXML
private Text thursday13;
@FXML
private Text thursday14;
@FXML
private Text thursday15;
@FXML
private Text thursday16;
@FXML
private Text thursday17;
@FXML
private Text thurRoom9;
@FXML
private Text thurRoom10;
@FXML
private Text thurRoom11;
@FXML
private Text thurRoom12;
@FXML
private Text thurRoom13;
@FXML
private Text thurRoom14;
@FXML
private Text thurRoom15;
@FXML
private Text thurRoom16;
@FXML
private Text thurRoom17;
@FXML
private Text friday9;
@FXML
private Text friday10;
@FXML
private Text friday11;
@FXML
private Text friday12;
@FXML
private Text friday13;
@FXML
private Text friday14;
@FXML
private Text friday15;
@FXML
private Text friday16;
@FXML
private Text friday17;
@FXML
private Text friRoom9;
@FXML
private Text friRoom10;
@FXML
private Text friRoom11;
@FXML
private Text friRoom12;
@FXML
private Text friRoom13;
@FXML
private Text friRoom14;
@FXML
private Text friRoom15;
@FXML
private Text friRoom16;
@FXML
private Text friRoom17;

@FXML
private void initialize() throws IOException {
	
courseType.setValue("All");
courseType.setItems(courseOptions);
com.dennis.time.brains.engine();


}   @FXML
private void processNumpad(ActionEvent event) {
    
  
    monday9.setText("It works");
}
@FXML
public void processNumpad2(ActionEvent event) {
	for (int displayDay = 1; displayDay <= 6; displayDay ++){
		for (int displayTime=9;displayTime<18;displayTime++){
			if (com.dennis.time.brains.free[displayDay][displayTime])
			{	
				displaySubject[displayDay][displayTime]="FREE PERIOD";
				displayRoom[displayDay][displayTime]="";
				}
			else if (com.dennis.time.brains.doubleLab[displayDay][displayTime])
			{
				displaySubject[displayDay][displayTime]=com.dennis.time.brains.module[displayDay][displayTime-1]+" Continues";
				displayRoom[displayDay][displayTime]="";
			}
			else if (com.dennis.time.brains.trebleLab[displayDay][displayTime])
			{
				displaySubject[displayDay][displayTime]=com.dennis.time.brains.module[displayDay][displayTime-2]+" Continues";
				displayRoom[displayDay][displayTime]="";
			}
			else 
				{
				displaySubject[displayDay][displayTime]=com.dennis.time.brains.module[displayDay][displayTime];
				displayRoom[displayDay][displayTime]=com.dennis.time.brains.location[displayDay][displayTime];
				}
		}// displayTime loop
	} // display day loop
	// populate
	monday9.setText(displaySubject[1][9]);
	monday10.setText(displaySubject[1][10]);
	monday11.setText(displaySubject[1][11]);
	monday12.setText(displaySubject[1][12]);
	monday13.setText(displaySubject[1][13]);
	monday14.setText(displaySubject[1][14]);
	monday15.setText(displaySubject[1][15]);
	monday16.setText(displaySubject[1][16]);
	monday17.setText(displaySubject[1][17]);
	monRoom9.setText(displayRoom[1][9]);
	monRoom10.setText(displayRoom[1][10]);
	monRoom11.setText(displayRoom[1][11]);
	monRoom12.setText(displayRoom[1][12]);
	monRoom13.setText(displayRoom[1][13]);
	monRoom14.setText(displayRoom[1][14]);
	monRoom15.setText(displayRoom[1][15]);
	monRoom16.setText(displayRoom[1][16]);
	monRoom17.setText(displayRoom[1][17]);
	tuesday9.setText(displaySubject[2][9]);
	tuesday10.setText(displaySubject[2][10]);
	tuesday11.setText(displaySubject[2][11]);
	tuesday12.setText(displaySubject[2][12]);
	tuesday13.setText(displaySubject[2][13]);
	tuesday14.setText(displaySubject[2][14]);
	tuesday15.setText(displaySubject[2][15]);
	tuesday16.setText(displaySubject[2][16]);
	tuesday17.setText(displaySubject[2][17]);
	tueRoom9.setText(displayRoom[2][9]);
	tueRoom10.setText(displayRoom[2][10]);
	tueRoom11.setText(displayRoom[2][11]);
	tueRoom12.setText(displayRoom[2][12]);
	tueRoom13.setText(displayRoom[2][13]);
	tueRoom14.setText(displayRoom[2][14]);
	tueRoom15.setText(displayRoom[2][15]);
	tueRoom16.setText(displayRoom[2][16]);
	tueRoom17.setText(displayRoom[2][17]);
	wednesday9.setText(displaySubject[3][9]);
	wednesday10.setText(displaySubject[3][10]);
	wednesday11.setText(displaySubject[3][11]);
	wednesday12.setText(displaySubject[3][12]);
	wednesday13.setText(displaySubject[3][13]);
	wednesday14.setText(displaySubject[3][14]);
	wednesday15.setText(displaySubject[3][15]);
	wednesday16.setText(displaySubject[3][16]);
	wednesday17.setText(displaySubject[3][17]);
	wedRoom9.setText(displayRoom[3][9]);
	wedRoom10.setText(displayRoom[3][10]);
	wedRoom11.setText(displayRoom[3][11]);
	wedRoom12.setText(displayRoom[3][12]);
	wedRoom13.setText(displayRoom[3][13]);
	wedRoom14.setText(displayRoom[3][14]);
	wedRoom15.setText(displayRoom[3][15]);
	wedRoom16.setText(displayRoom[3][16]);
	wedRoom17.setText(displayRoom[3][17]);
	thursday9.setText(displaySubject[4][9]);
	thursday10.setText(displaySubject[4][10]);
	thursday11.setText(displaySubject[4][11]);
	thursday12.setText(displaySubject[4][12]);
	thursday13.setText(displaySubject[4][13]);
	thursday14.setText(displaySubject[4][14]);
	thursday15.setText(displaySubject[4][15]);
	thursday16.setText(displaySubject[4][16]);
	thursday17.setText(displaySubject[4][17]);
	thurRoom9.setText(displayRoom[4][9]);
	thurRoom10.setText(displayRoom[4][10]);
	thurRoom11.setText(displayRoom[4][11]);
	thurRoom12.setText(displayRoom[4][12]);
	thurRoom13.setText(displayRoom[4][13]);
	thurRoom14.setText(displayRoom[4][14]);
	thurRoom15.setText(displayRoom[4][15]);
	thurRoom16.setText(displayRoom[4][16]);
	thurRoom17.setText(displayRoom[4][17]);
	friday9.setText(displaySubject[5][9]);
	friday10.setText(displaySubject[5][10]);
	friday11.setText(displaySubject[5][11]);
	friday12.setText(displaySubject[5][12]);
	friday13.setText(displaySubject[5][13]);
	friday14.setText(displaySubject[5][14]);
	friday15.setText(displaySubject[5][15]);
	friday16.setText(displaySubject[5][16]);
	friday17.setText(displaySubject[5][17]);
	friRoom9.setText(displayRoom[5][9]);
	friRoom10.setText(displayRoom[5][10]);
	friRoom11.setText(displayRoom[5][11]);
	friRoom12.setText(displayRoom[5][12]);
	friRoom13.setText(displayRoom[5][13]);
	friRoom14.setText(displayRoom[5][14]);
	friRoom15.setText(displayRoom[5][15]);
	friRoom16.setText(displayRoom[5][16]);
	friRoom17.setText(displayRoom[5][17]);
}// end numpad
}





	
	  
