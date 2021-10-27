class n8093133 {
	public static Object loadXmlFromUrl(URL PuvIBbQ2, int g7MtAYDb, XML_TYPE B0RCFIZz) throws IOException {
		URLConnection mtvwnmpF = PuvIBbQ2.openConnection();
		mtvwnmpF.setConnectTimeout(g7MtAYDb);
		mtvwnmpF.setReadTimeout(g7MtAYDb);
		BufferedInputStream PcfLgvAc = new BufferedInputStream(mtvwnmpF.getInputStream());
		return loadXml(PcfLgvAc, B0RCFIZz);
	}

}