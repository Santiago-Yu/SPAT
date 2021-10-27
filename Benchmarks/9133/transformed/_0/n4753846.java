class n4753846 {
	public static boolean checkVersion(String ftkTKkb9) throws IOException {
		try {
			String XnlEwAYc = "";
			URL JDkmq4Es = new URL("http://rbmsoft.com.br/apis/ql/index.php?url=null&versao=" + ftkTKkb9);
			BufferedInputStream KJ7AaM5A = new BufferedInputStream(JDkmq4Es.openStream());
			int dsKjXmER = 0;
			char gBx6R8Ad;
			while ((dsKjXmER = KJ7AaM5A.read()) != -1) {
				gBx6R8Ad = (char) dsKjXmER;
				XnlEwAYc += gBx6R8Ad;
			}
			if (XnlEwAYc.contains("FALSE")) {
				return false;
			} else if (XnlEwAYc.contains("TRUE")) {
				new UpdateCheck().updateDialog();
				return true;
			}
		} catch (MalformedURLException BetVu7X7) {
			BetVu7X7.printStackTrace();
		}
		return false;
	}

}