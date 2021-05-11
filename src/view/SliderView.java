package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import controller.Controller;

public class SliderView extends Slider //TODO implements
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
				controller.notifyValueChanged(getValue() / 100F);
			}
		});
	}
	
	//TODO SliderView should blabla
}
