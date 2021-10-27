class n4159104 {
	public String GetUserPage(String User, int pagetocrawl) {
		int page = pagetocrawl;
		URL url;
		String finalstring;
		String line;
		StringBuffer buffer = new StringBuffer();
		setStatus("Start moling....");
		startTimer();
		try {
			url = new URL(HTMLuserpage + User + "?setcount=100&page=" + page);
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			connect.addRequestProperty("User-Agent", userAgent);
			System.out.println("moling: page " + page + " of " + User);
			BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			while ((line = input.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
			input.close();
			connect.disconnect();
			stopTimer();
			setStatus("Dauer : " + dauerMs() + " ms");
			finalstring = buffer.toString();
			return finalstring;
		} catch (MalformedURLException e) {
			System.err.println("Bad URL: " + e);
			return null;
		} catch (IOException io) {
			System.err.println("IOException: " + io);
			return null;
		}
	}

}