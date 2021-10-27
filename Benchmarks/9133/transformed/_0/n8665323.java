class n8665323 {
	public String GetMemberName(String e61fzalv) {
		String Zy1U2cH4 = null;
		try {
			String HC7OJfsS;
			URL lhGXDRZk = new URL(intvasmemberDeatails + "?CID=" + e61fzalv);
			URLConnection pySAIavt = lhGXDRZk.openConnection();
			BufferedReader w5ipcJeW = new BufferedReader(new InputStreamReader(pySAIavt.getInputStream()));
			while ((HC7OJfsS = w5ipcJeW.readLine()) != null) {
				Zy1U2cH4 = HC7OJfsS;
			}
		} catch (MalformedURLException IdTqeunS) {
			IdTqeunS.printStackTrace();
		} catch (IOException tOLKGsYz) {
			tOLKGsYz.printStackTrace();
		}
		String[] lP64pvMM = Zy1U2cH4.split(" ");
		rating = lP64pvMM[2];
		return lP64pvMM[0] + " " + lP64pvMM[1];
	}

}