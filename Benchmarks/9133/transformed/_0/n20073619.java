class n20073619 {
	public static String getPagina(String tpE3hu75) {
		String y4WyoXYu = "";
		Authenticator.setDefault(new Autenticador());
		try {
			URL qE2SEKsX = new URL(tpE3hu75);
			BufferedReader jVnrIU8C = new BufferedReader(new InputStreamReader(qE2SEKsX.openStream()));
			String BOOSZnan;
			while ((BOOSZnan = jVnrIU8C.readLine()) != null) {
				y4WyoXYu += BOOSZnan;
			}
			jVnrIU8C.close();
		} catch (MalformedURLException M9MAtuxw) {
			y4WyoXYu = M9MAtuxw.toString();
		} catch (IOException wRt9ETKJ) {
			y4WyoXYu = wRt9ETKJ.toString();
		} catch (Exception i9ZXqBHb) {
			y4WyoXYu = i9ZXqBHb.toString();
		}
		return y4WyoXYu;
	}

}