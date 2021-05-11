package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import controller.Controller;

public class PieChartView extends Canvas
/** TODO 6. Faites en sorte que les diff�rentes vues aient
 * chacune une m�thode permettant de la mettre � jour.
 */
/** TODO 7.Faites en sorte que les diff�rentes vues re�oivent
 * un �v�nement de type PercentageValueChangedEvent si l'�tat
 * interne du mod�le est modifi�.
 */
{
	@SuppressWarnings("unused")
	private final Controller controller;
	private boolean clickedInPieChart;
	private GraphicsContext graphicsContext;
	
	public PieChartView(Controller controller)
	{
		super(100,100);
		this.controller = controller;
		clickedInPieChart = false;
		
		graphicsContext = this.getGraphicsContext2D();
		drawPieChart(0.0);
		
		this.addEventHandler(MouseEvent.MOUSE_PRESSED, event->
		{
			if (inPieChart(event))
			{
				clickedInPieChart = true;
				/** TODO 5. Impl�mentez PieChartView pour qu'elle mette
				 * � jour le mod�le si l'utilisateur la manipule
				 * (attention, tout doit passer par le controlleur).
				 */
			}
		});
		
		this.addEventHandler(MouseEvent.MOUSE_DRAGGED, event->
		{
			if(clickedInPieChart)
			{
				/** TODO 5. Impl�mentez PieChartView pour qu'elle mette
				 * � jour le mod�le si l'utilisateur la manipule
				 * (attention, tout doit passer par le controlleur).
				 */
			}
		});
		
		this.addEventHandler(MouseEvent.MOUSE_RELEASED, event->
		{
			if(clickedInPieChart)
			{
				clickedInPieChart = false;
			}
		});
	}
	
	private void drawPieChart(double value)
	{
		//On d�termine le centre de la figure
		double centerX = this.getWidth() / 2;
		double centerY = this.getHeight() / 2;
		
		//On d�termine le rayon du cercle
		double radius = Math.min(getWidth(), getHeight()) / 2;
		
		//On calcule l'angle correspondant au pourcentage
		double angle = value * 2 * Math.PI;
		
		//On cr�e deux cercles imbriqu�s, dont l'un est coup� en fonction du pourcentage
		graphicsContext.setFill(Color.GRAY);
		graphicsContext.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		graphicsContext.setFill(Color.LIGHTBLUE);
		graphicsContext.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, 0, (double) Math.toDegrees(angle), ArcType.ROUND);		
	}
	
	private boolean inPieChart(MouseEvent event)
	{
		double mouseX = event.getX();
		double mouseY = event.getY();
		double centerX = this.getWidth() / 2;
		double centerY = this.getHeight() / 2;
		double radius = Math.min(getWidth() - 4, getHeight() - 4) / 2;
		
		double distanceCenterMouse = Math.sqrt(Math.pow((centerX - mouseX), 2) + Math.pow((centerY - mouseY), 2));
		
		if(distanceCenterMouse <= radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private double pointToPercentage(MouseEvent event)
	{
		double centerX = this.getWidth() / 2;
		double centerY = this.getHeight() / 2;
		double mouseX = event.getX();
		double mouseY = event.getY();
		
		//On calcule les points de l'angle form�
		double[] pointA = new double[]{mouseX - centerX, mouseY - centerY};
		double[] pointB = new double[]{0, 0};
		double[] pointC = new double[]{10, 0};
		
		//On calcule les distances entre ces points
		double distanceAB = Math.sqrt(Math.pow((pointA[0] - pointB[0]), 2) + Math.pow((pointA[1] - pointB[1]), 2));
		double distanceBC = Math.sqrt(Math.pow((pointB[0] - pointC[0]), 2) + Math.pow((pointB[1] - pointC[1]), 2));
		double distanceCA = Math.sqrt(Math.pow((pointC[0] - pointA[0]), 2) + Math.pow((pointC[1] - pointA[1]), 2));
		
		//On calcule l'angle ABC
		//Th�or�me d'Al-Kaski : 
		//distanceCA * distanceCA = distanceAB * distanceAB + distanceBC * distanceBC - 2d * distanceAB * distanceBC * Math.Cos(angleABC);
		//0 = distanceAB * distanceAB + distanceBC * distanceBC - 2d * distanceAB * distanceBC * Math.Cos(angleABC) - distanceCA * distanceCA;
		//2d * distanceAB * distanceBC * Math.Cos(angleABC) = distanceAB * distanceAB + distanceBC * distanceBC - distanceCA * distanceCA;
		//Math.Cos(angleABC) = (distanceAB * distanceAB + distanceBC * distanceBC - distanceCA * distanceCA) / (2d * distanceAB * distanceBC);
		double angleABC = Math.acos((distanceAB * distanceAB + distanceBC * distanceBC - distanceCA * distanceCA) / (2 * distanceAB * distanceBC));
		
		if(pointA[1] >= 0)
		{
			angleABC = 2 * Math.PI - angleABC;
			return angleABC / (2 * Math.PI);
		}
		else
		{
			return angleABC / (2 * Math.PI);
		}
	}
}