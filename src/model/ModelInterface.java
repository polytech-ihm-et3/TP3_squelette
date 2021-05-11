package model;

import event.PercentageValueListener;

public interface ModelInterface
{
	/**
	 * Permet d'obtenir la valeur actuelle du pourcentage.
	 * @return La valeur actuelle du pourcentage
	 */
	public double getValue();
	
	/**
	 * Permet de modifier la valeur actuelle du pourcentage.
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
	 * Teste si une valeur est un pourcentage compris entre 0 et 1.
	 * @param value La valeur a tester
	 * @return "true" si la valeur est comprise entre 0 et 1, "false" sinon 
	 */
	public boolean valueIsOK(double value);
	
	/**
	 * Signale que la valeur actuelle du pourcentage � chang�.
	 */
	public void fireValueChanged();
}