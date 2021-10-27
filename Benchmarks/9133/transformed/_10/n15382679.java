class n15382679 {
	public static InputStream obterConteudoArquivo(String u) {
		URL url;
		try {
			URLConnection conn = null;
			url = new URL(u);
			if (proxy != null)
				conn = url.openConnection(proxy.getProxy());
			else
				conn = url.openConnection();
			return new DataInputStream(conn.getInputStream());
		} catch (MalformedURLException e) {
			throw new AlfredException(e);
		} catch (IOException e) {
			throw new AlfredException(e);
		}
	}

}