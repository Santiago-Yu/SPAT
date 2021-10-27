class n1643092 {
	private static URL handleRedirectUrl(URL url) {
		try {
			URLConnection cn = url.openConnection();
			Utils.setHeader(cn);
			if (!(cn instanceof HttpURLConnection)) {
				return url;
			}
			HttpURLConnection hcn = (HttpURLConnection) cn;
			hcn.setInstanceFollowRedirects(false);
			int resCode = hcn.getResponseCode();
			String location = hcn.getHeaderField("Location");
			if (resCode == 200) {
				System.out.println("URL: " + url);
				return url;
			}
			hcn.disconnect();
			return handleRedirectUrl(new URL(location.replace(" ", "%20")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

}