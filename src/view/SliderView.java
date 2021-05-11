package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import controller.Controller;

public class SliderView extends Slider
/** TODO 6. Faites en sorte que les différentes vues aient
 * chacune une méthode permettant de la mettre à jour.
 */
/** TODO 7.Faites en sorte que les différentes vues reçoivent
 * un événement de type PercentageValueChangedEvent si l'état
 * interne du modèle est modifié.
 */
{
	@SuppressWarnings("unused")
	private final Controller controller;
	
	public SliderView(Controller controller)
	{
		this.controller = controller;
		
		//On personnalise le Slider
		setMin(0);
		setMax(100);
		this.setMinorTickCount(5);
		this.setMajorTickUnit(10);
		this.setShowTickLabels(true);
		this.setShowTickMarks(true);
		this.setBlockIncrement(10);
		this.setSnapToTicks(true);
		
		valueProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				/** TODO 5. Implémentez SliderView pour qu'elle mette
				 *  à jour le modèle si l'utilisateur la manipule
				 *  (attention, tout doit passer par le controlleur).
				 */
			}
		});
	}
}
