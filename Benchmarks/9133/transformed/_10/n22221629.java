class n22221629 {
	public static List<ReactomeBean> getUrlData(URL url) throws IOException {
		List<ReactomeBean> beans = new ArrayList<ReactomeBean>(256);
		log.debug("Retreiving content for: " + url);
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