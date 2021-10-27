class n10332410 {
	protected EntailmentType invokeHttp(String ECxRQogj) {
		String wK29m1sd = encode("theory") + "=" + encode(ECxRQogj);
		URL mBHhxp7i;
		EntailmentType t7RUQnhv = EntailmentType.unkown;
		try {
			mBHhxp7i = new URL(httpAddress);
		} catch (MalformedURLException eFCE10X9) {
			throw new RuntimeException("FOL Reasoner not correclty configured: '" + httpAddress + "' is not an URL");
		}
		log.debug("sending theory to endpoint: " + mBHhxp7i);
		try {
			URLConnection u6smxR1k = mBHhxp7i.openConnection();
			u6smxR1k.setDoOutput(true);
			OutputStreamWriter GUhfnfVS = new OutputStreamWriter(u6smxR1k.getOutputStream());
			GUhfnfVS.write(wK29m1sd);
			GUhfnfVS.flush();
			BufferedReader Vcst84zW = new BufferedReader(new InputStreamReader(u6smxR1k.getInputStream()));
			String og3HVuW6;
			while ((og3HVuW6 = Vcst84zW.readLine()) != null) {
				log.debug("resultline: " + og3HVuW6);
				if (og3HVuW6.contains("Proof found")) {
					t7RUQnhv = EntailmentType.entailed;
				}
				if (og3HVuW6.contains("Ran out of time")) {
					t7RUQnhv = EntailmentType.unkown;
				}
				if (og3HVuW6.contains("Completion found")) {
					t7RUQnhv = EntailmentType.notEntailed;
				}
			}
			GUhfnfVS.close();
			Vcst84zW.close();
		} catch (IOException fEHpgtjC) {
			throw new RuntimeException("the remote reasoner did not respond:" + fEHpgtjC, fEHpgtjC);
		}
		return t7RUQnhv;
	}

}