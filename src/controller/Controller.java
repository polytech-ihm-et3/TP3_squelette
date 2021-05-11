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
		//TODO récupérer la valeur du modèle
		return 0.0d;
	}
	
	@Override
	public void setValue(double value)
	{
		//TODO modifier la valeur du modèle
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		//TODO ajouter l'élément à la liste du modèle
	}
	
	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		//TODO retirer l'élément de la liste du modèle
	}
	
	@Override
	public void notifyValueChanged(double value)
	{
		//TODO prévenir le modèle que la valeur a changé
	}
}