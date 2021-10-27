class n11710005 {
	public static void main(String[] args) {
		try {
			BufferedReader in = null;
			URL url = new URL("http://www.lineadecodigo.com");
			String inputLine;
			try {
				in = new BufferedReader(new InputStreamReader(url.openStream()));
			} catch (Throwable t) {
			}
			String inputText = "";
			while ((inputLine = in.readLine()) != null) {
				inputText = inputText + inputLine;
			}
			System.out.println("El contenido de la URL es: " + inputText);
			in.close();
		} catch (MalformedURLException me) {
			System.out.println("URL erronea");
		} catch (IOException ioe) {
			System.out.println("Error IO");
		}
	}

}