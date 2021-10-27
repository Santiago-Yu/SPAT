class n6759112 {
	public static String getFurigana(String Bvpm7Lhe) throws Exception {
		Log.d("--VOA--", "getFurigana START");
		sbFurigana = new StringBuffer();
		String acml9pbM = getYahooApiURL();
		acml9pbM = addSentence(acml9pbM, Bvpm7Lhe);
		URL GOwgvJ3v = new URL(acml9pbM);
		URLConnection pm3NaimP = GOwgvJ3v.openConnection();
		DocumentBuilderFactory wTP0AYTT = DocumentBuilderFactory.newInstance();
		wTP0AYTT.setNamespaceAware(true);
		DocumentBuilder Jx1THatB = wTP0AYTT.newDocumentBuilder();
		Log.d("--VOA--", pm3NaimP.getURL().toString());
		InputStream zEA1Pp5X = pm3NaimP.getInputStream();
		doc = Jx1THatB.parse(zEA1Pp5X);
		walkThrough();
		Log.d("--VOA--", "getFurigana END");
		return sbFurigana.toString();
	}

}