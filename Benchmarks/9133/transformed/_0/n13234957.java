class n13234957 {
	protected String readFileUsingHttp(String kNKmu1jc) {
		String zH4tHa7V = "";
		try {
			URL TXmaldGo = new URL(kNKmu1jc);
			URLConnection HrhA0uCi = TXmaldGo.openConnection();
			HttpURLConnection FIX6hJPg = (HttpURLConnection) HrhA0uCi;
			FIX6hJPg.setRequestProperty("Content-Type", "text/html");
			FIX6hJPg.setRequestProperty("Content-Length", "0");
			FIX6hJPg.setRequestMethod("GET");
			FIX6hJPg.setDoOutput(true);
			FIX6hJPg.setDoInput(true);
			FIX6hJPg.setAllowUserInteraction(false);
			InputStreamReader EXzEOnOr = new InputStreamReader(FIX6hJPg.getInputStream());
			BufferedReader tXM7uw8o = new BufferedReader(EXzEOnOr);
			String FQBjjlCu = "";
			while ((FQBjjlCu = tXM7uw8o.readLine()) != null) {
				zH4tHa7V += FQBjjlCu + "\n";
			}
			if (zH4tHa7V.endsWith("\n")) {
				zH4tHa7V = zH4tHa7V.substring(0, zH4tHa7V.length() - 1);
			}
			tXM7uw8o.close();
		} catch (Exception Via8oVQT) {
			Via8oVQT.printStackTrace();
		}
		return zH4tHa7V;
	}

}