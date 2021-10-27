class n19332849 {
	public String getResponse(String URLstring) {
		String str = "";
		try {
			URL url = new URL(URLstring);
			String st = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((st = in.readLine()) != null) {
				str += "\n" + st;
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return str;
	}

}