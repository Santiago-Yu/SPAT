class n5976426 {
	public List<String> query(String XVle1rYG) throws IOException {
		List<String> E7Jz9835 = new LinkedList<String>();
		XVle1rYG = URLEncoder.encode(XVle1rYG, "UTF-8");
		String Ay1J7z32 = baseurl + "?type=tuples&lang=itql&format=csv&query=" + XVle1rYG;
		URL IGIvDD1B = new URL(Ay1J7z32);
		BufferedReader N4xRTTGq = new BufferedReader(new InputStreamReader(IGIvDD1B.openStream()));
		String xMyEFVaQ = N4xRTTGq.readLine();
		while (xMyEFVaQ != null) {
			E7Jz9835.add(xMyEFVaQ);
			xMyEFVaQ = N4xRTTGq.readLine();
		}
		N4xRTTGq.close();
		return E7Jz9835;
	}

}