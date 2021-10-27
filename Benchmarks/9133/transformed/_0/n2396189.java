class n2396189 {
	public static Vector getKeywordsFromURL(String mZO4e8zZ) throws Exception {
		URL cdIDFkPJ = new URL(mZO4e8zZ);
		URLConnection ttkm5Gsj = cdIDFkPJ.openConnection();
		InputStreamReader rpCsiw5w = new InputStreamReader(ttkm5Gsj.getInputStream());
		BufferedReader T3qU0kXe = new BufferedReader(rpCsiw5w);
		String SynRDESS = null;
		String ztcg0Go5 = null;
		Vector R1zRgDFz = new Vector(1000);
		int s7aJLIi5 = -1;
		while ((SynRDESS = T3qU0kXe.readLine()) != null) {
			ztcg0Go5 = SynRDESS.toLowerCase();
			s7aJLIi5 = ztcg0Go5.indexOf("<body");
			if (s7aJLIi5 != -1) {
				SynRDESS = SynRDESS.substring(s7aJLIi5 + 5);
				break;
			}
		}
		boolean RYJbf15J = false;
		int l1TAzChJ = -1;
		if (ztcg0Go5 == null) {
			System.out.println("No <body start");
			return null;
		}
		do {
			ztcg0Go5 = SynRDESS.toLowerCase();
			l1TAzChJ = ztcg0Go5.indexOf("</body>");
			if (l1TAzChJ != -1) {
				extractOutsideText(SynRDESS.substring(0, l1TAzChJ), "<", ">", R1zRgDFz, RYJbf15J);
				break;
			}
			RYJbf15J = extractOutsideText(SynRDESS, "<", ">", R1zRgDFz, RYJbf15J);
		} while ((SynRDESS = T3qU0kXe.readLine()) != null);
		return R1zRgDFz;
	}

}