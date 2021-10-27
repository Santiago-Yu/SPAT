class n4080688 {
	public static String getStringFromAFileAtURL(String yiUBTKVQ) {
		String aGiU4pxO = "<html><body></body></html>";
		try {
			URL o9CPhjww = new URL(yiUBTKVQ);
			URLConnection YovSW1ED = o9CPhjww.openConnection();
			BufferedReader WIhCatNB = new BufferedReader(new InputStreamReader(YovSW1ED.getInputStream()));
			String fackhDnr = "";
			aGiU4pxO = "";
			while ((fackhDnr = WIhCatNB.readLine()) != null)
				aGiU4pxO += fackhDnr + "\n";
			WIhCatNB.close();
		} catch (Exception JDBvCSGi) {
			logs.info("URLResolver : lien mort");
			JOptionPane.showMessageDialog(null, "lien mort");
			return "<html><body></body></html>";
		}
		return checkXMLTagsLowerCase(aGiU4pxO);
	}

}