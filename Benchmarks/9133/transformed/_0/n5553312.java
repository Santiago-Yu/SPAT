class n5553312 {
	public static List<String> retrieveLanguages() throws Exception {
		List<String> Lbcx0yn4 = new ArrayList<String>();
		URL SmSxYS9E = new URL("http://translatewiki.net/w/i.php?title=Special:MessageGroupStats&group=out-osm-site");
		String KHfFyoUE = StreamUtil.toString(SmSxYS9E.openStream());
		Pattern vq72Bb3O = Pattern.compile(".*language=([^;\"]+).*");
		Matcher tP80MqS8 = vq72Bb3O.matcher(KHfFyoUE);
		while (tP80MqS8.find()) {
			String BnMOn1k0 = tP80MqS8.group(1);
			if (!Lbcx0yn4.contains(BnMOn1k0)) {
				Lbcx0yn4.add(BnMOn1k0);
			}
		}
		return Lbcx0yn4;
	}

}