package eje4;

public class Main {
	public static void main(String[] args) {
		ListadoItems listado = new JdbcListadoItems(new Conn(),
				new FileListadoItems(new RestCall("https://jsonplaceholder.typicode.com/posts/3"), "listaPost.txt"));
		System.out.println(listado.obtenerListado());
	}
}
