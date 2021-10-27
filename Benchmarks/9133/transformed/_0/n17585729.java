class n17585729 {
	private File sendQuery(String R7KxjRrx) throws MusicBrainzException {
		File posiBZ4O = null;
		try {
			posiBZ4O = new File(SERVER_RESPONSE_FILE);
			long ZhzUMr9C = Calendar.getInstance().getTimeInMillis();
			System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("    consulta de busqueda -> " + R7KxjRrx);
			URL I2pzzYL1 = new URL(R7KxjRrx);
			BufferedReader wl8RJEmV = new BufferedReader(new InputStreamReader(I2pzzYL1.openStream()));
			String KQbZPHdd = "";
			String dBU4s16u = "";
			System.out.println("    Respuesta del servidor: \n");
			while ((dBU4s16u = wl8RJEmV.readLine()) != null) {
				KQbZPHdd += dBU4s16u;
			}
			posiBZ4O = new File(SERVER_RESPONSE_FILE);
			System.out.println("    Ruta del archivo XML -> " + posiBZ4O.getAbsolutePath());
			BufferedWriter b1sjSm7q = new BufferedWriter(new FileWriter(posiBZ4O));
			b1sjSm7q.write(KQbZPHdd);
			b1sjSm7q.close();
			System.out.println("Tamanho del xmlFile -> " + posiBZ4O.length());
			long cwoRLc7M = (Calendar.getInstance().getTimeInMillis() - ZhzUMr9C);
			System.out.println(" Tiempo transcurrido en la consulta (en milesimas) -> " + cwoRLc7M);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
		} catch (IOException A3FjF1MD) {
			A3FjF1MD.printStackTrace();
			String TfAd4Nye = A3FjF1MD.getMessage();
			if (A3FjF1MD instanceof FileNotFoundException) {
				TfAd4Nye = "ERROR: MusicBrainz URL used is not found:\n" + TfAd4Nye;
			} else {
			}
			throw new MusicBrainzException(TfAd4Nye);
		}
		return posiBZ4O;
	}

}