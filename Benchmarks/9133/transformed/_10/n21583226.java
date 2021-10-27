class n21583226 {
	public String getMessageofTheDay(String id) {
		int serverModId = 0;
		StringBuffer mod = new StringBuffer();
		BufferedReader input = null;
		int clientModId = 0;
		try {
			URL url = new URL(FlyShareApp.BASE_WEBSITE_URL + "/mod.txt");
			String inputLine;
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			inputLine = input.readLine();
			try {
				clientModId = Integer.parseInt(id);
				serverModId = Integer.parseInt(inputLine);
			} catch (NumberFormatException e) {
			}
			if (clientModId < serverModId || clientModId == 0) {
				mod.append(serverModId);
				mod.append('|');
				while ((inputLine = input.readLine()) != null)
					mod.append(inputLine);
			}
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		} finally {
			try {
				input.close();
			} catch (Exception e) {
			}
		}
		return mod.toString();
	}

}