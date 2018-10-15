package Blackjack;

import java.util.ArrayList;
import static java.util.Collections.shuffle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javafx.scene.text.Font.font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Aaron
 */
public class BlackjackWindow extends Application {
    private Deck deck = new Deck();
    private ArrayList<Card> playerHand = new ArrayList<>();
    private ArrayList<Card> dealerHand = new ArrayList<>();
    private Button btDeal = new Button("Deal");
    private Button btHit = new Button("Hit");
    private Button btStand = new Button("Stand");
    private Button btChangeBet = new Button("Change Bet");
    private HBox playerSide = new HBox(8);
    private HBox dealerSide = new HBox(8);
    private int playerMoney = 1000;
    private int dealerMoney = 1000;
    
    @Override
    public void start(Stage primaryStage) {
        StackPane background = new StackPane();
        BorderPane environment = new BorderPane();
        ImageView backg = new ImageView(new Image("Cards/fintable6.png"));
        background.getChildren().add(backg);
        background.getChildren().add(environment);
        HBox buttons = new HBox(30);
        buttons.setPrefWidth(100);
        btDeal.setMinWidth(buttons.getPrefWidth());
        btHit.setMinWidth(buttons.getPrefWidth());
        btStand.setMinWidth(buttons.getPrefWidth());
        btChangeBet.setMinWidth(buttons.getPrefWidth());
        buttons.getChildren().addAll(btDeal, btHit, btStand, btChangeBet);
        environment.setCenter(buttons);
        buttons.setAlignment(Pos.CENTER);
        environment.setTop(dealerSide);
        environment.setBottom(playerSide);
        playerSide.setAlignment(Pos.TOP_LEFT);
        dealerSide.setAlignment(Pos.BOTTOM_LEFT);
        dealerSide.setPrefSize(500,255);
        playerSide.setPrefSize(500,250);

        dealerSide.setPadding(new Insets(0,0,0,150));
        playerSide.setPadding(new Insets(0,0,0,150));
        btDeal.setDisable(false);
        btHit.setDisable(true);
        btStand.setDisable(true);
        btChangeBet.setDisable(false);
        
        btDeal.setOnAction(e ->  Deal() );
        btHit.setOnAction(e -> Hit() );
        btStand.setOnAction(e -> Stand() );
        btChangeBet.setOnAction(e -> ChangeBet() );
        
        
        Scene scene = new Scene(background,1080,680);
        primaryStage.setTitle("Welcome to Blackjack!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void Deal()    {
        for(int k = 0; k < 2; k++) {
        playerHand.add(deck.topCard());
        dealerHand.add(deck.topCard());
        }
        
        for(int k = 0; k < playerHand.size(); k++) {
            playerSide.getChildren().add(playerHand.get(k).getCardFront());
        }
        
        dealerSide.getChildren().add(dealerHand.get(0).getCardBack());
        dealerSide.getChildren().add(dealerHand.get(1).getCardFront());
        
        btDeal.setDisable(true);
        btHit.setDisable(false);
        btStand.setDisable(false);
        btChangeBet.setDisable(true);
        
        if(playerHandValue() == 21) {
            gameOver(0);
        }
    }    
      
    public void Hit() {
        playerHand.add(deck.topCard());
        playerSide.getChildren().add(playerHand.get(playerHand.size()-1).getCardFront());
        
        int value = playerHandValue();
        
        if(value > 21)
            gameOver(6);
    }
    
    public void Stand() {
        if(dealerHandValue() == 21)
            gameOver(4);
        else {
            while (dealerHandValue() < 17) {
                dealerHand.add(deck.topCard());
                dealerSide.getChildren().add(dealerHand.get(dealerHand.size()-1).getCardFront());
            }
            if(dealerHandValue() > 21)
                gameOver(2);     
            else if(dealerHandValue() > playerHandValue())
                gameOver(5);
            else if(dealerHandValue() == playerHandValue())
                gameOver(3);
            else
                gameOver(1);
        }
            
    }
    
    public void ChangeBet() {
        ChangeBetWindow win = new ChangeBetWindow();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(e -> resetTable());
            win.start(stage);
    }
    
    public int playerHandValue() {
        int sum = 0;
        for(int k = 0; k < playerHand.size(); k++) {
            int value = playerHand.get(k).getValue();
            sum += value;
        }
        if (sum > 21) {
            for(int k = 0; k < playerHand.size() || sum <= 21; k++) {
                if(playerHand.get(k).getValue() == 11) {
                    sum -= 10;
                }
            }
        }
        
        return sum;
    }
    
    public int dealerHandValue() {
        int sum = 0;
        for(int k = 0; k < dealerHand.size(); k++) {
            int value = dealerHand.get(k).getValue();
            sum += value;
        }
        if (sum > 21) {
            for(int k = 0; k < dealerHand.size() || sum <= 21; k++) {
                if(dealerHand.get(k).getValue() == 11) {
                    sum -= 10;
                }
            }
        }
        
        return sum;
    }
    
    private void gameOver(int endCondition) {
        dealerSide.getChildren().set(0, dealerHand.get(0).getCardFront());
        GameOverWindow win = new GameOverWindow(endCondition);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest(e -> resetTable());
            win.start(stage);
    }
        
      
    public void resetTable() {
        btDeal.setDisable(false);
        btHit.setDisable(true);
        btStand.setDisable(true);
        btChangeBet.setDisable(false);
        playerSide.getChildren().clear();
        dealerSide.getChildren().clear();
        playerHand.clear();
        dealerHand.clear();
        deck.Shuffle();
    }

    

    
    public static void main(String[] args) {
        launch(args);
    }
class GameOverWindow extends Application {
    private int winType;
    
    public GameOverWindow(int winType) {
        this.winType = winType;
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox vbox = new VBox();
        Label label0 = new Label("Blackjack! You Win!");
        Label label1 = new Label("You Win!");
        Label label2 = new Label("Dealer Busted! You Win!");
        Label label3 = new Label("Push!");
        Label label4 = new Label("Dealer Blackjack! You Lose!");
        Label label5 = new Label("You Lose!");
        Label label6 = new Label("You Busted!");
        
        label0.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label1.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label2.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label3.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label4.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label5.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        label6.setFont(font("Times New Roman", FontWeight.NORMAL, 
                FontPosture.ITALIC, 30));
        
        switch(winType) {
            case 0: vbox.getChildren().add(label0); break;
            case 1: vbox.getChildren().add(label1); break;
            case 2: vbox.getChildren().add(label2); break;
            case 3: vbox.getChildren().add(label3); break;
            case 4: vbox.getChildren().add(label4); break;
            case 5: vbox.getChildren().add(label5); break;
            case 6: vbox.getChildren().add(label5); break;
        }

        vbox.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vbox, 350, 100);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
                
    }
}
class ChangeBetWindow extends Application {
    private TextField tfBet = new TextField();
    private Button btChange = new Button("Change Bet");
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        Label lb1 = new Label("Enter Bet Amount:");
        
        hBox.getChildren().addAll(lb1, tfBet, btChange);
        hBox.setAlignment(Pos.CENTER);
       
        //btChange.setOnAction ( e -> )
        
        
        Scene scene = new Scene(hBox, 350, 50);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

}
class Card {
    private Suit cardSuit;
    private int cardNumber;
    private ImageView cardFront;
    private ImageView cardBack;
    
    public Card(Suit cardSuit, int cardNumber, ImageView cardFront) {
        this.cardSuit = cardSuit;
        this.cardNumber = cardNumber;
        this.cardFront = cardFront;
        this.cardBack = new ImageView(new Image("image/Cards/backdesign2.png"));
    }

    public int getValue() {
        if(this.getCardNumber() == 1)
            return 11;
        else if(this.getCardNumber() < 10)
            return this.getCardNumber();
        else
            return 10;
    }

    /**
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }

    /**
     * @return the cardFront
     */
    public ImageView getCardFront() {
        return cardFront;
    }

    /**
     * @return the cardBack
     */
    public ImageView getCardBack() {
        return cardBack;
    }
    
}
class Deck {
    private ArrayList<Card> cardDeck;
    private int Indx = 0;
    
    public Deck() {
        this.cardDeck = new ArrayList<>();
        
        for(int s = 0; s < 4; s++) {
            for(int c = 1; c <= 13; c++) {
                cardDeck.add(new Card(Suit.values()[s],c,
                        new ImageView(new Image("image/Cards/" + (c+13*s) + 
                                ".png"))));
            }
        }
        shuffle(this.cardDeck);
        
}
    public Card topCard() {
        Card desiredCard = cardDeck.get(Indx);
        this.Indx++;
        return desiredCard;
    }
    
    public void Shuffle() {
        shuffle(this.cardDeck);
        this.Indx = 0;
    }
    
    
}
enum Suit {
    Hearts,
    Diamonds,
    Spades,
    Clubs,
}