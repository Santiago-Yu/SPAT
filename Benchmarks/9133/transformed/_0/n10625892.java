class n10625892 {
	public static String getTextFromUrl(final String AYX4TTIb) {
		InputStreamReader gw5YT5pf = null;
		BufferedReader eWwU9RGT = null;
		try {
			final StringBuilder HJwxKSbW = new StringBuilder();
			gw5YT5pf = new InputStreamReader(new URL(AYX4TTIb).openStream());
			eWwU9RGT = new BufferedReader(gw5YT5pf);
			String Vvs32AOM;
			while ((Vvs32AOM = eWwU9RGT.readLine()) != null) {
				HJwxKSbW.append(HtmlUtil.quoteHtml(Vvs32AOM)).append("\r");
			}
			return HJwxKSbW.toString();
		} catch (final IOException Xg8pdLCR) {
			return Xg8pdLCR.getMessage();
		} finally {
			InputOutputUtil.close(eWwU9RGT);
			InputOutputUtil.close(gw5YT5pf);
		}
	}

}