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
		//TODO r�cup�rer la valeur du mod�le
		return 0.0d;
	}
	
	@Override
	public void setValue(double value)
	{
		//TODO modifier la valeur du mod�le
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		//TODO ajouter l'�l�ment � la liste du mod�le
	}
	
	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		//TODO retirer l'�l�ment de la liste du mod�le
	}
	
	@Override
	public void notifyValueChanged(double value)
	{
		//TODO pr�venir le mod�le que la valeur a chang�
	}
}