class n7542015 {
	public static String[] parseM3U(String UMbDrH1v, Context HevXYGRu) {
		URL SJp6pERA;
		URLConnection I4Pt3u8T = null;
		String F1GRY2BP = "parseM3U";
		Vector<String> BWfpIAaH = new Vector<String>();
		final String caMelJoD = "http";
		try {
			SJp6pERA = new URL(UMbDrH1v);
			I4Pt3u8T = SJp6pERA.openConnection();
			Log.d(F1GRY2BP, "Got data");
		} catch (IOException R4mjPIun) {
			Log.e(F1GRY2BP, "Could not connect to " + UMbDrH1v);
		}
		try {
			DataInputStream bIZwGS5c = new DataInputStream(I4Pt3u8T.getInputStream());
			BufferedReader OBxaW6zM = new BufferedReader(new InputStreamReader(bIZwGS5c));
			String z29whMbj;
			while ((z29whMbj = OBxaW6zM.readLine()) != null) {
				String WkXoX0FO = z29whMbj.toLowerCase();
				Log.d(F1GRY2BP, z29whMbj);
				if (WkXoX0FO.startsWith(caMelJoD)) {
					BWfpIAaH.add(WkXoX0FO);
					Log.d(F1GRY2BP, "Found audio " + WkXoX0FO);
				}
			}
			OBxaW6zM.close();
			bIZwGS5c.close();
		} catch (Exception vKUL5x8x) {
			Log.e(F1GRY2BP, "Trouble reading file: " + vKUL5x8x.getMessage());
		}
		String[] uO0UtqFR = new String[0];
		String[] pFIntjfv = null;
		if (BWfpIAaH.size() != 0) {
			pFIntjfv = (String[]) BWfpIAaH.toArray(uO0UtqFR);
			Log.d(F1GRY2BP, "Found total: " + String.valueOf(pFIntjfv.length));
		}
		return pFIntjfv;
	}

}