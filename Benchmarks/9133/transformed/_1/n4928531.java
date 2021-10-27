class n4928531 {
	private static String makePrefixDeclarationsWithPrefix_cc(Set<String> missingPrefixes) {
		StringWriter sb = new StringWriter();
		Iterator<String> ANI07 = missingPrefixes.iterator();
		while (ANI07.hasNext()) {
			String prefix = (String) ANI07.next();
			sb.append(prefix);
			if (ANI07.hasNext()) {
				sb.append(',');
			}
		}
		String missingPrefixesForPrefix_cc = sb.toString();
		String prefixDeclarations = "";
		if (missingPrefixes.size() > 0) {
			try {
				String urlString = "http://prefix.cc/" + missingPrefixesForPrefix_cc + ".file.n3";
				URL url = new URL(urlString);
				URLConnection conn = url.openConnection();
				conn.setRequestProperty("accept",
						"application/rdf+n3, application/rdf-turtle, application/rdf-n3," + "text/rdf+n3");
				InputStream openStream = conn.getInputStream();
				StringWriter output = new StringWriter();
				ReaderUtils.copyReader("# From prefix.cc\n", new InputStreamReader(openStream), output);
				prefixDeclarations = output.toString();
				Logger.getLogger("prefix.cc")
						.info("makePrefixDeclarationsWithPrefix_cc() : From prefix.cc:\n" + prefixDeclarations);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return prefixDeclarations;
	}

}