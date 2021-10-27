class n15988143 {
	public static List getUrlData(URL url) throws IOException {
		List beans = new ArrayList(256);
		System.out.println("Retreiving content for: " + url);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer content = new StringBuffer(4096);
		String str;
		while ((str = in.readLine()) != null) {
			if (str.startsWith("#")) {
				continue;
			}
			StringTokenizer stringTokenizer = new StringTokenizer(str, "\t");
			String InteractionAc = stringTokenizer.nextToken();
			ReactomeBean reactomeBean = new ReactomeBean();
			String reactomeId = stringTokenizer.nextToken();
			reactomeBean.setReactomeID(reactomeId);
			reactomeBean.setInteractionAC(InteractionAc);
			beans.add(reactomeBean);
		}
		in.close();
		return beans;
	}

}