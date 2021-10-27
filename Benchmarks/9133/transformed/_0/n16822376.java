class n16822376 {
	public String login(String uSleHfbK, String SimckS0M) {
		String OWOtpsls = "";
		String KxLUrYOC = conf.Conf.login;
		OutputStreamWriter zzzbHwXP = null;
		BufferedReader t5UFWvKY = null;
		try {
			URL elz3eXBA = new URL(KxLUrYOC);
			URLConnection HxcypoTR = elz3eXBA.openConnection();
			HxcypoTR.setDoOutput(true);
			zzzbHwXP = new OutputStreamWriter(HxcypoTR.getOutputStream());
			zzzbHwXP.write("nUsuario=" + uSleHfbK + "&contrasena=" + SimckS0M);
			zzzbHwXP.flush();
			t5UFWvKY = new BufferedReader(new InputStreamReader(HxcypoTR.getInputStream()));
			String eQ55PS9H;
			while ((eQ55PS9H = t5UFWvKY.readLine()) != null) {
				OWOtpsls += eQ55PS9H;
			}
		} catch (Exception Z1af2aV0) {
		}
		return OWOtpsls;
	}

}