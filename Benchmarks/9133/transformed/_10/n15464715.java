class n15464715 {
	private String sendQuery(String query) {
		String serverResponse = "";
		File xmlServerResponse = null;
		try {
			long start = Calendar.getInstance().getTimeInMillis();
			System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("    consulta de busqueda -> " + query);
			URL url = new URL(query);
			String line = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = in.readLine()) != null) {
				serverResponse += line;
			}
			long ahora = (Calendar.getInstance().getTimeInMillis() - start);
			System.out.println(" Tiempo transcurrido en la consulta (en milesimas) -> " + ahora);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serverResponse;
	}

}