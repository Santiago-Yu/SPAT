class n206497 {
	public static void main(String[] bTHkHP1e) {
		RSSReader vfnaH7qG = new RSSReader();
		try {
			XmlPullParserFactory CE26z2Ao = XmlPullParserFactory.newInstance();
			XmlPullParser SYdFdmdF = CE26z2Ao.newPullParser();
			String QB6rjE8j = bTHkHP1e[0];
			InputStreamReader Oi4zwPnY = new InputStreamReader(new URL(QB6rjE8j).openStream());
			SYdFdmdF.setInput(Oi4zwPnY);
			XmlSerializer HFLgP0sy = CE26z2Ao.newSerializer();
			HFLgP0sy.setOutput(new OutputStreamWriter(System.out));
			vfnaH7qG.convertRSSToHtml(SYdFdmdF, HFLgP0sy);
		} catch (Exception dQ7rpWvm) {
			dQ7rpWvm.printStackTrace(System.err);
		}
	}

}