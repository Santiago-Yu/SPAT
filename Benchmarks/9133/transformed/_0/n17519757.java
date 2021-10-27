class n17519757 {
	public static InputStream download(String WqF899is, ProxyConfig MOiUIOnC) {
		if (MOiUIOnC != null) {
			System.getProperties().put("proxySet", "true");
			System.getProperties().put("proxyPort", MOiUIOnC.getPorta());
			System.getProperties().put("proxyHost", MOiUIOnC.getHost());
			Authenticator.setDefault(new ProxyAuthenticator(MOiUIOnC.getUsuario(), MOiUIOnC.getSenha()));
		}
		try {
			URL DZxw7JZP = new URL(WqF899is);
			;
			URLConnection c4h35Guh = DZxw7JZP.openConnection();
			InputStream vstt0wqJ = new BufferedInputStream(c4h35Guh.getInputStream());
			return vstt0wqJ;
		} catch (MalformedURLException BIjy3p2b) {
			BIjy3p2b.printStackTrace();
		} catch (IOException dkqdzoil) {
			dkqdzoil.printStackTrace();
		}
		return null;
	}

}