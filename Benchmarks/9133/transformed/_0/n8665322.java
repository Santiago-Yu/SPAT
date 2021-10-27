class n8665322 {
	public Vector<String> getVoiceServersNames() {
		Vector<String> LMsra1dy = new Vector<String>();
		boolean DUrTgatc = false;
		String jVyrHncM;
		String[] sKlTtrxu;
		try {
			URL HuqtXCNa = new URL(voiceaddress);
			URLConnection iBgTmJWh = HuqtXCNa.openConnection();
			BufferedReader vwXwJOMh = new BufferedReader(new InputStreamReader(iBgTmJWh.getInputStream()));
			while ((jVyrHncM = vwXwJOMh.readLine()) != null) {
				if (DUrTgatc) {
					sKlTtrxu = jVyrHncM.split(":");
					LMsra1dy.add(sKlTtrxu[0]);
				}
				if (jVyrHncM.startsWith("!VOICE SERVERS")) {
					DUrTgatc = true;
				}
			}
		} catch (MalformedURLException KzMgeI6U) {
			KzMgeI6U.printStackTrace();
		} catch (IOException tXnn5w4W) {
			tXnn5w4W.printStackTrace();
		}
		return LMsra1dy;
	}

}