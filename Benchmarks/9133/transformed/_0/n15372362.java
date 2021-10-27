class n15372362 {
	public List<String> loadList(String gm9P2SDM) {
		List<String> GkpO8flV = new ArrayList<String>();
		try {
			URL ZyplmsdN = getClass().getClassLoader().getResource("lists/" + gm9P2SDM + ".utf-8");
			BufferedReader PBKTx8W1 = new BufferedReader(new InputStreamReader(ZyplmsdN.openStream(), "UTF-8"));
			String tJp3ktuz;
			while ((tJp3ktuz = PBKTx8W1.readLine()) != null) {
				GkpO8flV.add(tJp3ktuz);
			}
			PBKTx8W1.close();
		} catch (IOException gdDwxzBE) {
			showError("No se puede cargar la lista de valores: " + gm9P2SDM, gdDwxzBE);
		}
		return GkpO8flV;
	}

}