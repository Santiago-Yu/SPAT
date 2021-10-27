class n7797614 {
	protected String readFileUsingFileUrl(String fileUrlName) {
		String response = "";
		try {
			URL url = new URL(fileUrlName);
			URLConnection connection = url.openConnection();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			String inputLine = "";
			BufferedReader in = new BufferedReader(isr);
			while ((inputLine = in.readLine()) != null) {
				response += inputLine + "\n";
			}
			if (response.endsWith("\n")) {
				response = response.substring(0, response.length() - 1);
			}
			in.close();
		} catch (Exception x) {
			x.printStackTrace();
		}
		return response;
	}

}