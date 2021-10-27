class n4575554 {
	private String readWebpage() {
		BufferedReader FtD1NSHw = null;
		StringBuffer NMsPJDdb = new StringBuffer();
		try {
			URI xFObreD7 = new URI("file:///www.vogella.de");
			IProxyService DGdEILby = getProxyService();
			IProxyData[] mM8cnUK6 = DGdEILby.select(xFObreD7);
			for (IProxyData nBN6fzN0 : mM8cnUK6) {
				if (nBN6fzN0.getHost() != null) {
					System.setProperty("http.proxySet", "true");
					System.setProperty("http.proxyHost", nBN6fzN0.getHost());
				}
				if (nBN6fzN0.getHost() != null) {
					System.setProperty("http.proxyPort", String.valueOf(nBN6fzN0.getPort()));
				}
			}
			DGdEILby = null;
			URL mfLTMLwN;
			mfLTMLwN = xFObreD7.toURL();
			FtD1NSHw = new BufferedReader(new InputStreamReader(mfLTMLwN.openStream()));
			String MLi1VRqe;
			while ((MLi1VRqe = FtD1NSHw.readLine()) != null) {
				NMsPJDdb.append(MLi1VRqe + "\n");
			}
		} catch (MalformedURLException m4iO8GWa) {
			m4iO8GWa.printStackTrace();
		} catch (IOException h06k08DH) {
			h06k08DH.printStackTrace();
		} catch (URISyntaxException Ys2cnKpz) {
			Ys2cnKpz.printStackTrace();
		} finally {
			if (FtD1NSHw != null) {
				try {
					FtD1NSHw.close();
				} catch (IOException rdtyE8p5) {
					rdtyE8p5.printStackTrace();
				}
			}
		}
		return NMsPJDdb.toString();
	}

}