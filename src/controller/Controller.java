package controller;

import event.PercentageValueListener;
import model.Model;

public class Controller implements ControllerInterface
{
	private final Model model;
	
	public Controller(Model model)
	{
		this.model = model;
	}
	
	@Override
	public double getValue()
	{
		/**TODO 4. Compl�tez la classe Controller pour qu'elle fasse
		 * le lien entre le mod�le et les vues.
		 */
		return 0.0d;
	}
	
	@Override
	public void setValue(double value)
	{
		/**TODO 4. Compl�tez la classe Controller pour qu'elle fasse
		 * le lien entre le mod�le et les vues.
		 */
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		/**TODO 4. Compl�tez la classe Controller pour qu'elle fasse
		 * le lien entre le mod�le et les vues.
		 */
	}
	
	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		/**TODO 4. Compl�tez la classe Controller pour qu'elle fasse
		 * le lien entre le mod�le et les vues.
		 */
	}
	
	@Override
	public void notifyValueChanged(double value)
	{
		/**TODO 4. Compl�tez la classe Controller pour qu'elle fasse
		 * le lien entre le mod�le et les vues.
		 */
	}
}