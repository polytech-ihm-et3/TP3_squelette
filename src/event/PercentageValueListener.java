package event;

import java.util.EventListener;

public interface PercentageValueListener extends EventListener
{
	/**
	 * R�agit � un changement de la valeur du pourcentage dans le mod�le.
	 * @param event l'�venement correspondant � ce changement
	 */
	public void percentageValueChanged(PercentageValueChangedEvent event);
}