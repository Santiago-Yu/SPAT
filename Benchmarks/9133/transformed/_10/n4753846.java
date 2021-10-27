class n4753846 {
	public static boolean checkVersion(String vers) throws IOException {
		try {
			URL url = new URL("http://rbmsoft.com.br/apis/ql/index.php?url=null&versao=" + vers);
			String tmp = "";
			int dado = 0;
			BufferedInputStream buf = new BufferedInputStream(url.openStream());
			char letra;
			while ((dado = buf.read()) != -1) {
				letra = (char) dado;
				tmp += letra;
			}
			if (tmp.contains("FALSE")) {
				return false;
			} else if (tmp.contains("TRUE")) {
				new UpdateCheck().updateDialog();
				return true;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return false;
	}

}