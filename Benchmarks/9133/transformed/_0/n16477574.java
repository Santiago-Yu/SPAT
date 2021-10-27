class n16477574 {
	public static ArrayList search(String O7sYFDov) throws Exception {
		ArrayList gXBZVMWX = new ArrayList();
		String iRluAEqj = "http://hypem.com/playlist/search/" + O7sYFDov + "/xml/1/list.xspf";
		HttpURLConnection R4FhwyxF = (HttpURLConnection) (new URL(iRluAEqj)).openConnection();
		R4FhwyxF.setRequestProperty("User-Agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		XmlNode aqkqyfVs = XmlLoader.load(R4FhwyxF.getInputStream());
		XmlNode R1Fvwd7R[] = aqkqyfVs.getFirstChild("trackList").getChild("track");
		for (int hgQDLrg8 = 0; hgQDLrg8 < R1Fvwd7R.length; hgQDLrg8++) {
			String TVUI7uDz = decrypt(R1Fvwd7R[hgQDLrg8].getFirstChild("location").getText());
			String xjEgV70i = R1Fvwd7R[hgQDLrg8].getFirstChild("annotation").getText().replaceAll("[\r\n]", "");
			gXBZVMWX.add(TVUI7uDz);
			System.out.print("found in Hypem: ");
			System.out.print(xjEgV70i);
			System.out.print(", ");
			System.out.println(TVUI7uDz);
		}
		return gXBZVMWX;
	}

}