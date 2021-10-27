class n8665322 {
	public Vector<String> getVoiceServersNames() {
		Vector<String> result = new Vector<String>();
		boolean serverline = false;
		String line;
		String[] splitline;
		try {
			URL url = new URL(voiceaddress);
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
				if (serverline) {
					splitline = line.split(":");
					result.add(splitline[0]);
				}
				serverline = (line.startsWith("!VOICE SERVERS")) ? true : serverline;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}