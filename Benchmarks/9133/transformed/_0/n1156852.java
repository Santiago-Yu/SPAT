class n1156852 {
	private List<String> getRobots(String QTqG8lOl, String jbmwrS89) {
		List<String> IJ5N3TLW = new ArrayList<String>();
		BufferedReader a6IXnPT2 = null;
		try {
			URL IUqKc74H = new URL(QTqG8lOl + "/" + jbmwrS89 + "/" + "robots.txt");
			URLConnection UGeFrAvF = IUqKc74H.openConnection();
			UGeFrAvF.setUseCaches(false);
			a6IXnPT2 = new BufferedReader(new InputStreamReader(UGeFrAvF.getInputStream()));
			String GpLGesyU = "";
			while ((GpLGesyU = a6IXnPT2.readLine()) != null) {
				if (GpLGesyU.startsWith("Disallow:")) {
					IJ5N3TLW.add(GpLGesyU.substring(10));
				}
			}
		} catch (Exception snxWQTJ4) {
			PetstoreUtil.getLogger().log(Level.SEVERE, "Exception" + snxWQTJ4);
			IJ5N3TLW = null;
		} finally {
			try {
				if (a6IXnPT2 != null) {
					a6IXnPT2.close();
				}
			} catch (Exception jNop9UIP) {
			}
		}
		return IJ5N3TLW;
	}

}