class n22346314 {
	public URLConnection makeURLcon() {
		URI JUxgq6Nx;
		URL V5135JD5;
		try {
			JUxgq6Nx = new URI(this.URLString);
			V5135JD5 = JUxgq6Nx.toURL();
			this.urlcon = (HttpURLConnection) V5135JD5.openConnection();
		} catch (final URISyntaxException rTllTjYD) {
			rTllTjYD.printStackTrace();
		} catch (final MalformedURLException oP05TatL) {
			oP05TatL.printStackTrace();
		} catch (final IOException tuPysUhP) {
			tuPysUhP.printStackTrace();
		}
		return this.urlcon;
	}

}