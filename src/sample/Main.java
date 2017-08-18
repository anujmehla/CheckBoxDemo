package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

/*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 200, 275));
        primaryStage.show();
    }
*/
    CheckBox cbWeb, cbDesktop,cbMobile;
    Label response, alltargets;
    String targets="";
    public void start(Stage myStage)
    {
        myStage.setTitle("Check box Demo");
        FlowPane rootNode =new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode,200,200);
        myStage.setScene(myScene);

        Label heading = new Label("Select Deployment Options");
        response = new Label("No Deployment Selected.");
        alltargets= new Label("Target list: <none>");
        cbWeb= new CheckBox("Web");
        cbDesktop = new CheckBox("Desktop");
        cbMobile = new CheckBox("Mobile");

        cbWeb.setAllowIndeterminate(true);

        cbWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cbWeb.isSelected())
                {
                    response.setText("Web deployment selected");
                }
                else if (cbWeb.isIndeterminate())
                {
                    response.setText("Web deployment is indeterminate");
                }
                else
                {
                    response.setText("Web deployment cleared");
                }

                showAll();
            }
        });
        cbMobile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cbMobile.isSelected())
                    response.setText("Mobile deployement selected");
                else
                    response.setText("Mobile deployment cleared");
                showAll();
            }
        });
        cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cbDesktop.isSelected())
                    response.setText("Desktop Deployment selected");
                else
                    response.setText("Desktop Deployment cleared");
                showAll();
            }
        });

        Separator separator = new Separator();
        separator.setPrefWidth(300);

        rootNode.getChildren().addAll(heading,separator,cbDesktop,cbMobile,cbWeb,response,alltargets);
        myStage.show();
    }
    void showAll()
    {
        targets="";
        if (cbWeb.isSelected())
            targets="Web";
        if(cbMobile.isSelected())
            targets+=" Mobile";
        if(cbDesktop.isSelected())
            targets+=" Desktop";
        if (targets.equals(""))
            targets="<none>";
        alltargets.setText("Target List: "+targets);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
