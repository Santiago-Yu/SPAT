class n19794025 {
	public static int numberofLines(JApplet c5J4FVc2, String tLKlco6X) {
		int LeCSFiXO = 0;
		URL YHnEm1PU = null;
		String IL9cDxRU;
		IL9cDxRU = "data/" + tLKlco6X + ".csv";
		try {
			YHnEm1PU = new URL(c5J4FVc2.getCodeBase(), IL9cDxRU);
		} catch (MalformedURLException pO5ysvyI) {
			System.out.println("Malformed URL ");
			c5J4FVc2.stop();
		}
		System.out.println(YHnEm1PU.toString());
		try {
			InputStream zjGludo8 = YHnEm1PU.openStream();
			BufferedReader kdDGxiC0 = new BufferedReader(new InputStreamReader(zjGludo8));
			while ((kdDGxiC0.readLine()) != null) {
				LeCSFiXO++;
			}
			zjGludo8.close();
		} catch (IOException kwmE3D1c) {
		}
		return LeCSFiXO;
	}

}