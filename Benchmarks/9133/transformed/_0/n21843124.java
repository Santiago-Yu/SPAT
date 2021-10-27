class n21843124 {
	protected String connectPost(String jeDgs9DX, String plMasg2p) {
		String otepScj2 = null;
		try {
			URL eun14BC7 = new URL(jeDgs9DX);
			HttpsURLConnection vT4CXkaW = (HttpsURLConnection) eun14BC7.openConnection();
			vT4CXkaW.setDoOutput(true);
			vT4CXkaW.setUseCaches(false);
			vT4CXkaW.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			log.fine(vT4CXkaW.getURL().toString());
			DataOutputStream Mf2llDiT = new DataOutputStream(vT4CXkaW.getOutputStream());
			Mf2llDiT.write(plMasg2p.getBytes());
			Mf2llDiT.flush();
			Mf2llDiT.close();
			BufferedReader PRPlj7JA = new BufferedReader(new InputStreamReader(vT4CXkaW.getInputStream()));
			otepScj2 = PRPlj7JA.readLine();
			PRPlj7JA.close();
			log.finest(otepScj2);
		} catch (Exception N2Irkql4) {
			log.log(Level.SEVERE, jeDgs9DX, N2Irkql4);
		}
		return otepScj2;
	}

}