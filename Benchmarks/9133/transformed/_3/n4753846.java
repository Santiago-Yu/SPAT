class n4753846 {
	public static boolean checkVersion(String vers) throws IOException {
		try {
			String tmp = "";
			URL url = new URL("http://rbmsoft.com.br/apis/ql/index.php?url=null&versao=" + vers);
			BufferedInputStream buf = new BufferedInputStream(url.openStream());
			int dado = 0;
			char letra;
			while ((dado = buf.read()) != -1) {
				letra = (char) dado;
				tmp += letra;
			}
			if (!(tmp.contains("FALSE"))) {
				if (tmp.contains("TRUE")) {
					new UpdateCheck().updateDialog();
					return true;
				}
			} else {
				return false;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return false;
	}

}