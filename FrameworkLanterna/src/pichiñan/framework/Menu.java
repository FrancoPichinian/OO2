package pichiñan.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class Menu {
	private String pathConfig;
	private List<Accion> acciones;
	private static final String MSG = "Se produjo un error al instanciar una clase del config";

	public Menu(String pathConfig) {
		this.pathConfig = Objects.requireNonNull(pathConfig);
		this.acciones = new ArrayList<>();
		this.acciones = leerAccionesDelProperties();
	}

	public void run() {
		try {
			DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
			TerminalScreen screen = terminalFactory.createScreen();
			screen.startScreen();

			WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

			BasicWindow window = new BasicWindow("Menú");
			window.setHints(List.of(Window.Hint.CENTERED));

			Panel contentPanel = new Panel();
			contentPanel.setLayoutManager(new com.googlecode.lanterna.gui2.LinearLayout(Direction.VERTICAL));

			contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

			TextGraphics textGraphics = screen.newTextGraphics();
			textGraphics.setForegroundColor(TextColor.ANSI.CYAN);
			textGraphics.putString(2, 2, "Bienvenido, estas son sus opciones:");

			contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

			for (int i = 0; i < acciones.size(); i++) {
				Accion accion = acciones.get(i);
				Button button = new Button(accion.nombreItemMenu() + " (" + accion.descripcionItemMenu() + ")", () -> {
					try {
						accion.ejecutar();
						run();
					} catch (Exception e) {
						MessageDialog.showMessageDialog(textGUI, "Error", "Por favor, ingrese una opción válida");
						run();
					}
				});
				contentPanel.addComponent(button);
			}

			contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

			Button salirButton = new Button("Salir", () -> {
				MessageDialog.showMessageDialog(textGUI, "Finalizando", "");
				window.close();
			});
			contentPanel.addComponent(salirButton);

			window.setComponent(contentPanel);
			textGUI.addWindowAndWait(window);

			screen.stopScreen();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private List<Accion> leerAccionesDelProperties() {
		Properties prop = new Properties();
		ArrayList<Accion> listaDeAcciones = new ArrayList<>();
		try (InputStream configFile = getClass().getResourceAsStream(this.pathConfig);) {
			prop.load(configFile);
			String clase = prop.getProperty("acciones");
			String[] clases = clase.split(";");

			for (int i = 0; i < clases.length; i++) {
				Accion accionTemp = (Accion) Class.forName(clases[i]).getDeclaredConstructor().newInstance();
				listaDeAcciones.add(accionTemp);
			}
		} catch (Exception e) {
			throw new RuntimeException(MSG);
		}
		return listaDeAcciones;
	}
}
