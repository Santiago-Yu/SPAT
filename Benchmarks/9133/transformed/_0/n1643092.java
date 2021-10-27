class n1643092 {
	private static URL handleRedirectUrl(URL SOR3XFWE) {
		try {
			URLConnection dKtsgFey = SOR3XFWE.openConnection();
			Utils.setHeader(dKtsgFey);
			if (!(dKtsgFey instanceof HttpURLConnection)) {
				return SOR3XFWE;
			}
			HttpURLConnection tm9LyKc3 = (HttpURLConnection) dKtsgFey;
			tm9LyKc3.setInstanceFollowRedirects(false);
			int auLXzWI6 = tm9LyKc3.getResponseCode();
			if (auLXzWI6 == 200) {
				System.out.println("URL: " + SOR3XFWE);
				return SOR3XFWE;
			}
			String AvxZdGjC = tm9LyKc3.getHeaderField("Location");
			tm9LyKc3.disconnect();
			return handleRedirectUrl(new URL(AvxZdGjC.replace(" ", "%20")));
		} catch (IOException TY3xGZGB) {
			TY3xGZGB.printStackTrace();
		}
		return SOR3XFWE;
	}

}