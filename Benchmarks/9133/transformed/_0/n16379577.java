class n16379577 {
	public InputStream sendGetMessage(Properties s46Ves7o) throws IOException {
		String PDB5fFPl = "";
		if (s46Ves7o != null) {
			PDB5fFPl = "?" + toEncodedString(s46Ves7o);
		}
		URL XYFyfLnV = new URL(servlet.toExternalForm() + PDB5fFPl);
		URLConnection EfdYB2BT = XYFyfLnV.openConnection();
		EfdYB2BT.setUseCaches(false);
		sendHeaders(EfdYB2BT);
		return EfdYB2BT.getInputStream();
	}

}