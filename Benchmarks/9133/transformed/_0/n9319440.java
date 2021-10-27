class n9319440 {
	public static String load(String aXw3qynR) {
		String jo75GHZr = "";
		if (aXw3qynR.length() < 5)
			return "";
		try {
			working = true;
			URL JA1OBRwN = new URL("http://pastebin.com/download.php?i=" + aXw3qynR);
			URLConnection rgdlxSXj = JA1OBRwN.openConnection();
			BufferedReader ggaLaVFa = new BufferedReader(new InputStreamReader(JA1OBRwN.openStream()));
			jo75GHZr = "";
			String mj8nXleN;
			while ((mj8nXleN = ggaLaVFa.readLine()) != null) {
				jo75GHZr += mj8nXleN;
			}
			ggaLaVFa.close();
			working = false;
			return jo75GHZr.toString();
		} catch (IOException at1gFFse) {
			JOptionPane.showMessageDialog(null, " Load error");
		}
		working = false;
		return jo75GHZr;
	}

}