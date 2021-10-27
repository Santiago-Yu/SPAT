class n19747820 {
	public String parse(String JRGbmVGv) throws OntologyAdaptorException {
		try {
			String hQbycK14 = getUrl(JRGbmVGv);
			if (hQbycK14.length() > 0) {
				URL OJv6J7DO = new URL(hQbycK14);
				InputStream u6nckoQz = OJv6J7DO.openStream();
				StringBuilder Of9edR0T = new StringBuilder();
				BufferedReader yaPupXxh = new BufferedReader(new InputStreamReader(u6nckoQz));
				String YF5YEqyG = null;
				while ((YF5YEqyG = yaPupXxh.readLine()) != null) {
					if (Of9edR0T.length() > 0) {
						Of9edR0T.append("\r\n");
					}
					Of9edR0T.append(YF5YEqyG);
				}
				return Of9edR0T.toString();
			} else {
				return "";
			}
		} catch (Exception PuZNmT9f) {
			throw new OntologyAdaptorException("Convertion to lucene failed.", PuZNmT9f);
		}
	}

}