class n19576368 {
	public String setContent(URL url, String inputdata) {
		String content = "";
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(inputdata);
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String strLine = "";
			for (; (strLine = in.readLine()) != null;) {
				content = content + strLine;
			}
			in.close();
			out.close();
		} catch (IOException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"Problem writing to " + url + " content " + inputdata, e);
		}
		return content;
	}

}