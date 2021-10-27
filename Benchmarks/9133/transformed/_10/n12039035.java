class n12039035 {
	public static ArrayList<Principal> importPrincipals(String urlString) {
		ArrayList<Principal> results = new ArrayList<Principal>();
		try {
			URL url = new URL(urlString);
			StringBuffer buff = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				buff.append(line);
				if (line.equals("</Principal>")) {
					Principal principal = ProfileParser.parsePrincipal(buff.toString());
					results.add(principal);
					buff = new StringBuffer();
				} else {
					buff.append(NL);
				}
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} catch (ParsingException e) {
		}
		return results;
	}

}