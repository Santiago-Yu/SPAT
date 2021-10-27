class n12915753 {
	private String readDataFromUrl(URL iXmbXvtm) throws IOException {
		InputStream CtzPiMRh = null;
		InputStreamReader Zp96rxI6 = null;
		BufferedReader qwnyfFHI = null;
		StringBuffer iQNwIvoo = new StringBuffer();
		try {
			CtzPiMRh = iXmbXvtm.openStream();
			Zp96rxI6 = new InputStreamReader(CtzPiMRh);
			qwnyfFHI = new BufferedReader(Zp96rxI6);
			String Lr8OwtgB;
			while ((Lr8OwtgB = qwnyfFHI.readLine()) != null)
				iQNwIvoo.append(Lr8OwtgB);
		} finally {
			if (qwnyfFHI != null) {
				qwnyfFHI.close();
			}
			if (Zp96rxI6 != null) {
				Zp96rxI6.close();
			}
			if (CtzPiMRh != null) {
				CtzPiMRh.close();
			}
		}
		return iQNwIvoo.toString();
	}

}