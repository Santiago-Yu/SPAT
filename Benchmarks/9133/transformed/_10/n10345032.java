class n10345032 {
	private String GetStringFromURL(String URL) {
		InputStreamReader inputStreamReader = null;
		InputStream in = null;
		String outstring = "";
		BufferedReader bufferedReader = null;
		try {
			java.net.URL url = new java.net.URL(URL);
			in = url.openStream();
			inputStreamReader = new InputStreamReader(in);
			StringBuffer out = new StringBuffer("");
			bufferedReader = new BufferedReader(inputStreamReader);
			String nextLine;
			String newline = System.getProperty("line.separator");
			while ((nextLine = bufferedReader.readLine()) != null) {
				out.append(nextLine);
				out.append(newline);
			}
			outstring = new String(out);
		} catch (IOException e) {
			System.out.println("Failed to read from " + URL);
			outstring = "";
		} finally {
			try {
				bufferedReader.close();
				inputStreamReader.close();
			} catch (Exception e) {
			}
		}
		return outstring;
	}

}