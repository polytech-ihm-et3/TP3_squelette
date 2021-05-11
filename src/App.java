import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.Controller;
import model.Model;
import view.ConsoleView;
import view.LabelView;
import view.PieChartView;
import view.SliderView;

public class App extends VBox
{
	Model model;
	
	Controller controller;
	
	LabelView labelView;
	PieChartView pieChartView;
	SliderView sliderView;
	ConsoleView consoleView;
	
	public App()
	{
		//On cr�e le mod�le
		model = new Model(0.0f);
		
		//On cr�e le controlleur
		controller = new Controller(model);
		
		//On cr�e les vues
		//labelView = new LabelView();
		//TODO Cr�er les vues
		
		//On connecte les vues au controlleur
		//controller.addPercentageValueListener(labelView);
		//TODO Lier les vues
		
		//On initialise l'interface utilisateur
		initialiserUI();
		
		//On rend la fen�tre visible
		setVisible(true);
	}
	
	/**
	 * Initialise l'interface utilisateur (UI) de l'application.
	 */
	private void initialiserUI()
	{
		Label label = new Label("Percentage: ");
		labelView.setDisable(true);
		
		//On cr�e un sous-Pane pour le label et sa valeur (labelView)
		HBox northPanel = new HBox();
		northPanel.getChildren().addAll(label,labelView);
		
		//On d�finit l'espacement entre les diff�rents �l�ments du Pane
		this.setSpacing(30);
		VBox.setMargin(this, new Insets(15, 15, 15, 15));
		this.setAlignment(Pos.CENTER);
		
		//On ajoute tous les �l�ments au Pane
		this.getChildren().addAll(northPanel,pieChartView,sliderView);
	}
}
