class n11830587 {
	public void afficherMetar(String EysYw8qX) {
		if (EysYw8qX.length() != 4) {
			System.out.println("un code METAR est compos¨¦ de 4 caracteres");
		}
		EysYw8qX.toUpperCase();
		try {
			URL Tr39Cbrx = new URL("http://weather.noaa.gov/pub/data/observations/metar/stations/" + EysYw8qX + ".TXT");
			System.out.println(Tr39Cbrx.toString());
			Proxy jKXfPCca = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.ac-reunion.fr", 8080));
			HttpURLConnection iIqeZHZp = (HttpURLConnection) Tr39Cbrx.openConnection(jKXfPCca);
			InputStreamReader TAElZYu8 = new InputStreamReader(iIqeZHZp.getInputStream());
			BufferedReader wgSVMui1 = new BufferedReader(TAElZYu8);
			Vector qyTGeZS2 = new Vector();
			String pfEjoDHS;
			System.out.println("Affichage METAR");
			System.out.println("--------");
			while ((pfEjoDHS = wgSVMui1.readLine()) != null) {
				System.out.println(pfEjoDHS);
				qyTGeZS2.add(pfEjoDHS);
			}
			System.out.println("--------");
			wgSVMui1.close();
		} catch (java.io.FileNotFoundException UsHSE85s) {
			System.out.println("Impossible de trouver le METAR");
			System.out.println(UsHSE85s);
		} catch (Exception cVj66eE6) {
			System.out.println(cVj66eE6.toString());
		}
	}

}