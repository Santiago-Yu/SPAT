class n7542014 {
	public static String[] parsePLS(String XPl7tQLR, Context eODbeca6) {
		URL VssbTKFR;
		URLConnection CQqc5Pop = null;
		String zkiklP7w = "parsePLS";
		Vector<String> ZiUqZgWN = new Vector<String>();
		final String uaNTpuFd = "file";
		final String Xitp6sDZ = "=";
		try {
			VssbTKFR = new URL(XPl7tQLR);
			CQqc5Pop = VssbTKFR.openConnection();
			Log.d(zkiklP7w, "Got data");
		} catch (IOException qOwSKGxz) {
			Log.e(zkiklP7w, "Could not connect to " + XPl7tQLR);
		}
		try {
			DataInputStream kPLFAy6u = new DataInputStream(CQqc5Pop.getInputStream());
			BufferedReader PlfXnNb5 = new BufferedReader(new InputStreamReader(kPLFAy6u));
			String tiE9DGex;
			while ((tiE9DGex = PlfXnNb5.readLine()) != null) {
				String DL5KT2Mu = tiE9DGex.toLowerCase();
				Log.d(zkiklP7w, tiE9DGex);
				if (DL5KT2Mu.startsWith(uaNTpuFd)) {
					String[] HL9Dq6yp = Pattern.compile(Xitp6sDZ).split(DL5KT2Mu);
					ZiUqZgWN.add(HL9Dq6yp[1]);
					Log.d(zkiklP7w, "Found audio " + HL9Dq6yp[1]);
				}
			}
			PlfXnNb5.close();
			kPLFAy6u.close();
		} catch (Exception bmwmphbq) {
			Log.e(zkiklP7w, "Trouble reading file: " + bmwmphbq.getMessage());
		}
		String[] LmHLtQLA = new String[0];
		String[] c6YHuzSM = null;
		if (ZiUqZgWN.size() != 0) {
			c6YHuzSM = (String[]) ZiUqZgWN.toArray(LmHLtQLA);
			Log.d(zkiklP7w, "Found total: " + String.valueOf(c6YHuzSM.length));
		}
		return c6YHuzSM;
	}

}