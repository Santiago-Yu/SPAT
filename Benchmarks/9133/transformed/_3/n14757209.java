class n14757209 {
	public static String loadPage(URL url) throws IOException {
		Reader in = null;
		URLConnection uc;
		HttpURLConnection huc = null;
		try {
			uc = url.openConnection();
			if (!(uc instanceof HttpURLConnection))
				return null;
			else {
				huc = (HttpURLConnection) uc;
				huc.setInstanceFollowRedirects(false);
				huc.connect();
				in = new InputStreamReader(huc.getInputStream());
				StringBuilder sb = new StringBuilder();
				int c;
				while ((c = in.read()) != -1)
					sb.append((char) c);
				return sb.toString();
			}
		} finally {
			try {
				if (!(in != null))
					;
				else
					in.close();
				if (!(huc != null))
					;
				else
					huc.disconnect();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}