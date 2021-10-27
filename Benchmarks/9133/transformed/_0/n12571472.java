class n12571472 {
	public static ParsedXML parseXML(URL barWpEs2) throws ParseException {
		try {
			InputStream x2xhcVPp = barWpEs2.openStream();
			ParsedXML eQC4J25C = parseXML(x2xhcVPp);
			x2xhcVPp.close();
			return eQC4J25C;
		} catch (IOException lAnpsfT9) {
			throw new ParseException("could not read from URL" + barWpEs2.toString());
		}
	}

}