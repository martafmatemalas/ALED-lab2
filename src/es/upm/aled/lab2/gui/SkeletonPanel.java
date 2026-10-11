package es.upm.aled.lab2.gui;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import es.upm.aled.lab2.kinematics.*;

/**
 * Draws on a window an exoskeleton represented as a tree of Nodes.
 * 
 * @author rgarciacarmona
 */
public class SkeletonPanel extends JPanel {

	private static final long serialVersionUID = 8724301078499171545L;
	private Segment root;//como atributo presenta un segmento raiz

	/**
	 * Shows a window containing a 2D representation of an exoskeleton. Each joint
	 * in the kinematic chain is represented with a dot, and each segment with a
	 * line that connects two dots together. The end effector is also represented as
	 * a dot. It can be animated to show the exoskeleton's movement by calling the
	 * repaint() method after modifying the attributes of the kinematic chain's
	 * elements.
	 * 
	 * This class uses ForwardKinematics to compute the positions of every element
	 * in the kinematic chain.
	 * 
	 * @param root  The first Segment of the kinematic chain.
	 * @param sizeX The width of the window.
	 * @param sizeX The height of the window.
	 */
	public SkeletonPanel(Segment root, int sizeX, int sizeY) { //constructor
		this.root = root;
		// Setup Swing window
		JFrame frame = new JFrame("Recursive Skeleton - Forward Kinematics");
		frame.add(this);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Draws the window
		super.paintComponent(g);
		float originX = getWidth() / 2;//el ancho de la ventana partido por dos
		float originY = getHeight() / 2;//el largo de la ventana partido por dos
		// esto permite que el nodo raiz se dibuje justo en el centro de la ventana

		// Computes the full tree of positions
		Node nodeRoot = ForwardKinematics.computePositions(root, originX, originY);
		//esto te genera cual es el nodo raiz

		// Draw the tree of Nodes recursively
		drawSkeleton(g, originX, originY, nodeRoot);
	}

	/**
	 * Dibuja de forma recursiva el "esqueleto" de un árbol: un círculo en cada
	 * nodo y una línea que lo une con su nodo padre.
	 *
	 * @param g       contexto gráfico sobre el que se dibuja
	 * @param parentX coordenada X del nodo padre
	 * @param parentY coordenada Y del nodo padre
	 * @param node    nodo actual que se va a dibujar
	 */
	private void drawSkeleton(Graphics g, double parentX, double parentY, Node node) { 
		//parentX y parentY al principio presentarán los valores de originX y originY, pero a medida que se vayan dibujando nodos hijos, se va a ir guardando los valores de su localidad.
		// TODO: Ponga comentarios en este método
	
		//código común, cualquier llamada al código, se va a realizar estas dos lineas
		g.fillOval((int) node.getX() - 4, (int) node.getY() - 4, 8, 8);//pinta un circulo en la ventana(fillOval) en las coordenadas del nodo. Le das el incio dodne va a dibujar el circulo, y asignarle un ancho y un alto, consiguiendo que el dibujo del circulo sea de radio 4 y se centre en el punto del nodo.
		g.drawLine((int) parentX, (int) parentY, (int) node.getX(), (int) node.getY());//pinta una linea desde el nodo anterior (direcciones parent) al actual (getters a las coordenadas del nodo actual)
		//
		
		//caso base, caso en el que si se llega, se para la recursividad
		if (node.getChildren().size() == 0) {
			return;
		}//si no tiene hijos, para
		
		//paso recursivo
		for (Node child : node.getChildren()) {
			drawSkeleton(g, node.getX(), node.getY(), child); //se llama a sí mismo, al propio método
		}
	}//primero dibujará el nodo raiz
}

// ¿Qué tareas realiza el constructor?
// Las tareas del constructor son: guardar el atributo segmento raiz, configura la ventana donde se va a dibujar, le fijamos el tamaño 600,600, y ademas llama a un metodo que cierra la ventana
//
//¿Qué hace el método paintComponent()?
// Se encarga de pintar el exoesqueleto. Crea el origen de coordenadas donde se va a empezar a pinter cuando se invoque a este método, que será el centro de la ventana creada. Para pintarlo, va a llamar al metodo drawskeleton pasandole el nodo raiz, ademas de las coordenadas de origenes que hemos dicho y el grafico donde pintarlo (g)
//
//¿A qué dos métodos, que representan cada uno un algoritmo recursivo distinto, llama el método paintComponent()?¿Cuál de ellos ya está implementado?
//Llama al método computerPositions de la clase ForwardKinematics, que no esta programado todavía, y llama a drawSkeleton que sí está programao y es recursivo.
//
//¿Algún método se llama a sí mismo?
//Sí, drawSkeleton












