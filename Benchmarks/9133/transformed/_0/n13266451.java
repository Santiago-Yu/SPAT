class n13266451 {
	public String loadURLString(java.net.URL pZRCYlcj) {
		try {
			BufferedReader bF50hEmg = new BufferedReader(new InputStreamReader(pZRCYlcj.openStream()));
			StringBuffer vWMbgJiL = new StringBuffer();
			String tkSuTj39 = "";
			while (bF50hEmg.ready() && tkSuTj39 != null) {
				tkSuTj39 = bF50hEmg.readLine();
				if (tkSuTj39 != null) {
					vWMbgJiL.append(tkSuTj39);
					vWMbgJiL.append("\n");
				}
			}
			return vWMbgJiL.toString();
		} catch (IOException Jf2R0mpK) {
			return "";
		} catch (NullPointerException MUHvovaH) {
			return "";
		}
	}

}