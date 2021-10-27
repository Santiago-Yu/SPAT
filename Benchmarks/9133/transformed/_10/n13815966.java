class n13815966 {
	private void getRdfResponse(StringBuilder sb, String url) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			String inputLine = null;
			while ((inputLine = reader.readLine()) != null) {
				sb.append(inputLine);
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}