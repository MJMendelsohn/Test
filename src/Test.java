import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Test extends Application {
	public Test() {
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage s) throws Exception {
		// TODO Auto-generated method stub
		s.setTitle("Testing");
		Group group = new Group();
		Rectangle rect = new Rectangle(100, 20);
		rect.setFill(Color.BLUE);
		rect.setX(250);
		rect.setY(308);
		//rect.setOnKeyPressed(e -> handleKeyPress(e, rect));
		rect.setOnMouseClicked(e -> handleMouseClick(e, rect));
		
//		TextField textField = new TextField("Menu");
//		ContextMenu m = new ContextMenu();
//		MenuItem move = new MenuItem();
//		MenuItem attack = new MenuItem();
//		MenuItem back = new MenuItem();
//		m.getItems().addAll(move, attack, back);
//		move.setOnAction(e -> handleMenu(e));
//		textField.setContextMenu(m);
	
		
		group.getChildren().add(rect);
		//group.getChildren().add(textField);
		
		Scene scene = new Scene(group, 400, 400);
		s.setScene(scene);
		scene.setOnKeyPressed(e -> handleKeyPress(e, rect));
		s.show();
		
		KeyFrame frame = new KeyFrame(Duration.millis(1000/60), e -> updateGameView(rect));
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.getKeyFrames().add(frame);
		timeline.play();
		

	}
	
	private void handleKeyPress(KeyEvent e, Rectangle r) {
		KeyCode k = e.getCode();
		System.out.println("KeyPressed");
		if (k == KeyCode.UP) {
			r.setX(10);
		}
	}
	
	private void handleMouseClick(MouseEvent e, Rectangle r) {
		System.out.println("Mouse Click");
		r.setX(50);
	}
	
	private void handleMenu(ActionEvent e) {
		System.out.println("Move");
	}
	
	private void updateGameView(Rectangle r) {
		//System.out.println(r.getX());
	}
}
