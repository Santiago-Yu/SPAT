class n15858891 {
	@Override
	public void send() {
		BufferedReader jGUqeDjI = null;
		StringBuffer ZElfmDct = new StringBuffer();
		try {
			URL bHbviR2V = new URL(getUrl());
			jGUqeDjI = new BufferedReader(new InputStreamReader(bHbviR2V.openStream()));
			String wUmuqZ7Y;
			while ((wUmuqZ7Y = jGUqeDjI.readLine()) != null) {
				ZElfmDct.append(wUmuqZ7Y);
			}
		} catch (ConnectException PPK2RysG) {
			logger.error("MockupExecutableCommand excute fail: " + PPK2RysG.getMessage());
		} catch (Exception yJwFFPup) {
			logger.error("MockupExecutableCommand excute fail: " + yJwFFPup.getMessage());
		} finally {
			if (jGUqeDjI != null) {
				try {
					jGUqeDjI.close();
				} catch (IOException f3dYwbxo) {
					logger.error("BufferedReader could not be closed", f3dYwbxo);
				}
			}
		}
	}

}