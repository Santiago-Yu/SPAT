class n9938081 {
	public void load(String Xw1AQ0Yt) {
		BufferedReader DvJSh8JX;
		loaded = false;
		vector.removeAllElements();
		try {
			if (Xw1AQ0Yt.startsWith("http:")) {
				URL Aa3FCesg = new URL(Xw1AQ0Yt);
				DvJSh8JX = new BufferedReader(new InputStreamReader(Aa3FCesg.openStream()));
			} else
				DvJSh8JX = new BufferedReader(new FileReader(Xw1AQ0Yt));
			String GaPnOHMd;
			while ((GaPnOHMd = DvJSh8JX.readLine()) != null) {
				if (listener != null)
					listener.handleLine(GaPnOHMd);
				else
					vector.add(GaPnOHMd);
			}
			DvJSh8JX.close();
			loaded = true;
		} catch (IOException vdwRPzqd) {
			errorMsg = vdwRPzqd.getMessage();
		}
	}

}