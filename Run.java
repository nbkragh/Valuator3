import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Run extends Application {

    public static void main(String[] args) {
        System.out.println();
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Valuator 0.93");
        VBox ramme = new VBox();

        Label overskrift = new Label("Overskrift");
        overskrift.setMinHeight(30);
        overskrift.setMinWidth(400);

        overskrift.setAlignment(Pos.CENTER);

        VBox indhold = new VBox();

        TextArea beskedfelt = new TextArea("lol");
        beskedfelt.setStyle("-fx-padding: 10px 10px ;");

        createIndhold(indhold);
        indhold.getChildren().get(9).setStyle("-fx-font-weight: bold");

        ramme.getChildren().addAll(overskrift,indhold,beskedfelt);
        Scene scene = new Scene(ramme, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createIndhold(VBox indhold) {
        Valuator[] radixs = new Valuator[16];
        radixs[0] = new SignedBinaryValuator();
        radixs[1] = new BinaryValuator();

        for (int i = 2; i < radixs.length; i++){
            radixs[i] = new Valuator(i+1);
        }

        radixs[7].setName("Oktal");
        radixs[9].setName("Decimal");
        radixs[15].setName("Hexadecimal");

        for (int i = 0; i < radixs.length; i++){
            HBox rakke = new HBox();
            rakke.setAlignment(Pos.CENTER);

            TextField vaerdifelt = new TextField(""+radixs[i].valueForRadix());
            vaerdifelt.setMinWidth(250);
            vaerdifelt.setAlignment(Pos.CENTER_RIGHT);

            Label talLabel = new Label(""+radixs[i].getName());
            talLabel.setLabelFor(vaerdifelt);
            talLabel.setMinWidth(85);
            talLabel.setAlignment(Pos.CENTER);

            Text talInfo = new Text("0 - "+Valuator.hexChars[radixs[i].getRadix()-1]);
            talInfo.setWrappingWidth(50);
            talInfo.setTextAlignment(TextAlignment.CENTER);
            final int ii = i;
            vaerdifelt.setOnAction(e ->{
                radixs[ii].setInputValue(vaerdifelt.getText());
                for(int iii = 0; iii < radixs.length; iii++){
                    ((TextField)((HBox)indhold.getChildren().get(iii)).getChildren().get(1)).setText(radixs[iii].valueForRadix());
                }
            });
            rakke.getChildren().addAll(talLabel, vaerdifelt, talInfo);
            indhold.getChildren().add(rakke);
        }
    }
}
