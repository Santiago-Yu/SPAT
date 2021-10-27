class n15679088 {
	public static String createStringFromHtml(MyUrl fiYCbPfl) {
		try {
			BufferedReader CdRTpKPZ = new BufferedReader(
					new InputStreamReader(fiYCbPfl.getUrl().openStream(), "UTF-8"));
			String C7kZA6ot;
			String Yh95cQgm = "";
			while ((C7kZA6ot = CdRTpKPZ.readLine()) != null) {
				Yh95cQgm += C7kZA6ot;
			}
			CdRTpKPZ.close();
			return Yh95cQgm;
		} catch (Exception syaYXf15) {
			return null;
		}
	}

}