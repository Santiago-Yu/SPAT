class n7542014 {
	public static String[] parsePLS(String strURL, Context c) {
		URLConnection urlConn = null;
		URL url;
		String TAG = "parsePLS";
		Vector<String> radio = new Vector<String>();
		final String filetoken = "file";
		try {
			url = new URL(strURL);
			urlConn = url.openConnection();
			Log.d(TAG, "Got data");
		} catch (IOException ioe) {
			Log.e(TAG, "Could not connect to " + strURL);
		}
		final String SPLITTER = "=";
		try {
			DataInputStream in = new DataInputStream(urlConn.getInputStream());
			String strLine;
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while ((strLine = br.readLine()) != null) {
				String temp = strLine.toLowerCase();
				Log.d(TAG, strLine);
				if (temp.startsWith(filetoken)) {
					String[] s = Pattern.compile(SPLITTER).split(temp);
					radio.add(s[1]);
					Log.d(TAG, "Found audio " + s[1]);
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