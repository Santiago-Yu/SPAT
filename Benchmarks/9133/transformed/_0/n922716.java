class n922716 {
	private static String getDocumentAt(String NX0iiUBA) {
		StringBuffer V7DM5LPl = new StringBuffer();
		try {
			URL SBRrA1J4 = new URL(NX0iiUBA);
			URLConnection ulY61Ehp = SBRrA1J4.openConnection();
			BufferedReader EpD4K3Gp = new BufferedReader(new InputStreamReader(ulY61Ehp.getInputStream()));
			String SVPboYMM = null;
			while ((SVPboYMM = EpD4K3Gp.readLine()) != null)
				V7DM5LPl.append(SVPboYMM + "\n");
			EpD4K3Gp.close();
		} catch (MalformedURLException UOEfaGEK) {
			System.out.println("??งน??URL: " + NX0iiUBA);
		} catch (IOException fz1uUraz) {
			fz1uUraz.printStackTrace();
		}
		return V7DM5LPl.toString();
	}

}