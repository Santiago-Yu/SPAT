class n4928531 {
	private static String makePrefixDeclarationsWithPrefix_cc(Set<String> nrMoXNaS) {
		StringWriter QJjKBv0T = new StringWriter();
		for (Iterator<String> U2jn3hx1 = nrMoXNaS.iterator(); U2jn3hx1.hasNext();) {
			String dddmdYGj = (String) U2jn3hx1.next();
			QJjKBv0T.append(dddmdYGj);
			if (U2jn3hx1.hasNext()) {
				QJjKBv0T.append(',');
			}
		}
		String rd2viulJ = QJjKBv0T.toString();
		String ssWNHxcK = "";
		if (nrMoXNaS.size() > 0) {
			try {
				String GH0rQKYf = "http://prefix.cc/" + rd2viulJ + ".file.n3";
				URL zMiz6UJI = new URL(GH0rQKYf);
				URLConnection QRiuU67i = zMiz6UJI.openConnection();
				QRiuU67i.setRequestProperty("accept",
						"application/rdf+n3, application/rdf-turtle, application/rdf-n3," + "text/rdf+n3");
				InputStream YbAOW2H3 = QRiuU67i.getInputStream();
				StringWriter nP2tantO = new StringWriter();
				ReaderUtils.copyReader("# From prefix.cc\n", new InputStreamReader(YbAOW2H3), nP2tantO);
				ssWNHxcK = nP2tantO.toString();
				Logger.getLogger("prefix.cc")
						.info("makePrefixDeclarationsWithPrefix_cc() : From prefix.cc:\n" + ssWNHxcK);
			} catch (MalformedURLException pWae31KW) {
				pWae31KW.printStackTrace();
			} catch (IOException ZpdkNx3z) {
				ZpdkNx3z.printStackTrace();
			}
		}
		return ssWNHxcK;
	}

}