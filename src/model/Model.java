package model;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;
import java.util.ArrayList;

public class Model implements ModelInterface
{
	private double percentageValue;
	private ArrayList<PercentageValueListener> percentageValueListeners;
	
	public Model(double initialValue)
	{
		percentageValueListeners = new ArrayList<>();
		setValue(initialValue);
	}
	
	public Model()
	{
		this(0.0F);
	}
	
	@Override
	public double getValue()
	{
		return percentageValue / 100f;
	}
	
	@Override
	public void setValue(double value)
	{
		if (valueIsOK(value))
		{
			percentageValue = Math.round(value * 100);
			fireValueChanged();
		}
		else
		{
			throw (new IllegalArgumentException("La valeur entr�e en param�tre n'est pas un pourcentage compris entre 0 et 1 (value = " + value + ")."));
		}
	}
	
	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		percentageValueListeners.add(percentageValueListener);
	}

	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		percentageValueListeners.remove(percentageValueListener);
	}
	
	@Override
	public boolean valueIsOK(double value)
	{
		return ((0.0F <= value) && (value <= 1.0F));
	}
	
	@Override
	public void fireValueChanged()
	{
		for(PercentageValueListener percentageValueListener : percentageValueListeners)
		{
			//TODO pr�venir les listeners que le mod�le a chang�
		}
	}
}