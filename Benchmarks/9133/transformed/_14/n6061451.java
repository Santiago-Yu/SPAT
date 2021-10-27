class n6061451 {
	public String execute(Map params, String body, RenderContext renderContext) throws MacroException {
		loadData();
		String from = (String) params.get("from");
		if (body.length() > 0 && from != null) {
			try {
				URL url;
				String serverUser = null;
				String serverPassword = null;
				url = new URL(semformsSettings.getZRapServerUrl() + "ZRAP_QueryProcessor.php?from="
						+ URLEncoder.encode(from, "utf-8") + "&query=" + URLEncoder.encode(body, "utf-8"));
				if (url.getUserInfo() != null) {
					String[] userInfo = url.getUserInfo().split(":");
					if (2 == userInfo.length) {
						serverUser = userInfo[0];
						serverPassword = userInfo[1];
					}
				}
				URLConnection connection = null;
				InputStreamReader bf;
				if (serverUser != null && serverPassword != null) {
					connection = url.openConnection();
					String encoding = new sun.misc.BASE64Encoder()
							.encode((serverUser + ":" + serverPassword).getBytes());
					connection.setRequestProperty("Authorization", "Basic " + encoding);
					bf = new InputStreamReader(connection.getInputStream());
				} else {
					bf = new InputStreamReader(url.openStream());
				}
				BufferedReader bbf = new BufferedReader(bf);
				String line = bbf.readLine();
				String buffer = "";
				while (line != null) {
					buffer += line;
					line = bbf.readLine();
				}
				return buffer;
			} catch (Exception e) {
				e.printStackTrace();
				return "ERROR:" + e.getLocalizedMessage();
			}
		} else
			return "Please write an RDQL query in the macro as body and an url of the model as 'from' parameter";
	}

}