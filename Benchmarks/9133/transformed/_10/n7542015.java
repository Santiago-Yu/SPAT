class n7542015 {
	public static String[] parseM3U(String strURL, Context c) {
		URLConnection urlConn = null;
		URL url;
		String TAG = "parseM3U";
		Vector<String> radio = new Vector<String>();
		try {
			url = new URL(strURL);
			urlConn = url.openConnection();
			Log.d(TAG, "Got data");
		} catch (IOException ioe) {
			Log.e(TAG, "Could not connect to " + strURL);
		}
		final String filetoken = "http";
		try {
			DataInputStream in = new DataInputStream(urlConn.getInputStream());
			String strLine;
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while ((strLine = br.readLine()) != null) {
				String temp = strLine.toLowerCase();
				Log.d(TAG, strLine);
				if (temp.startsWith(filetoken)) {
					radio.add(temp);
					Log.d(TAG, "Found audio " + temp);
				}
			}
			br.close();
			in.close();
		} catch (Exception e) {
			Log.e(TAG, "Trouble reading file: " + e.getMessage());
		}
		String[] t = new String[0];
		String[] r = null;
		if (radio.size() != 0) {
			r = (String[]) radio.toArray(t);
			Log.d(TAG, "Found total: " + String.valueOf(r.length));
		}
		return r;
	}

}