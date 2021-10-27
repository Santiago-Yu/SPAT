class n16353023 {
	public void setRemoteConfig(String ynXf4VG2) {
		try {
			HashMap<String, String> NnOPmFTw = new HashMap<String, String>();
			URL pqJ8ANtb = new URL(ynXf4VG2);
			BufferedReader uVDn2iAu = new BufferedReader(new InputStreamReader(pqJ8ANtb.openStream()));
			String EgfqUVx8 = null;
			while ((EgfqUVx8 = uVDn2iAu.readLine()) != null) {
				if (EgfqUVx8.startsWith("#"))
					continue;
				String[] PPkcDwqA = EgfqUVx8.split("=");
				if (PPkcDwqA.length >= 2) {
					NnOPmFTw.put(PPkcDwqA[0], PPkcDwqA[1]);
				}
			}
			MethodAndFieldSetter.setMethodsAndFields(this, NnOPmFTw);
		} catch (Exception U8IRoVU1) {
			U8IRoVU1.printStackTrace();
		}
	}

}