package controller;

import event.PercentageValueListener;

public interface ControllerInterface
{
	/**
	 * Permet d'obtenir la valeur actuelle du pourcentage dans le mod�le.
	 * @return La valeur actuelle du pourcentage
	 */
	public double getValue();
	
	/**
	 * Permet de modifier la valeur actuelle du pourcentage dans le mod�le.
	 * @param value La nouvelle valeur du pourcentage
	 */
	public void setValue(double value);
	
	/**
	 * Ajoute un �l�ment impl�mentant l'interface PercentageValueListener
	 * � la liste des �l�ments surveillant le mod�le.
	 * @param percentageValueListener L'�l�ment de type ValueListener � ajouter � la liste
	 */
	public void addPercentageValueListener(PercentageValueListener percentageValueListener);
	
	/**
	 * Retire un �l�ment impl�mentant l'interface PercentageValueListener
	 * de la liste des �l�ments surveillant le mod�le.
	 * @param percentageValueListener L'�l�ment de type ValueListener � retirer de la liste
	 */
	public void removePercentageValueListener(PercentageValueListener percentageValueListener);
	
	/**
	 * Pr�vient le mod�le que la valeur actuelle du pourcentage � chang�. 
	 * @param value La nouvelle valeur du pourcentage
	 */
	public void notifyValueChanged(double value);
}