package eje2;

import java.io.IOException;
import java.util.List;

public interface FuenteDeDatos {

	List<String[]> consumirDatos() throws IOException;

}
