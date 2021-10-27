class n11830587 {
	public void afficherMetar(String oaci) {
		if (oaci.length() != 4) {
			System.out.println("un code METAR est compos¨¦ de 4 caracteres");
		}
		oaci.toUpperCase();
		try {
			URL url = new URL("http://weather.noaa.gov/pub/data/observations/metar/stations/" + oaci + ".TXT");
			System.out.println(url.toString());
			Proxy acReunion = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.ac-reunion.fr", 8080));
			HttpURLConnection con = (HttpURLConnection) url.openConnection(acReunion);
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			Vector vListe = new Vector();
			String line;
			System.out.println("Affichage METAR");
			System.out.println("--------");
			for (; (line = in.readLine()) != null;) {
				System.out.println(line);
				vListe.add(line);
			}
			System.out.println("--------");
			in.close();
		} catch (java.io.FileNotFoundException e) {
			System.out.println("Impossible de trouver le METAR");
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}