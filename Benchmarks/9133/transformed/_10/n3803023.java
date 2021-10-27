class n3803023 {
	public static String callApi(String api, String paramname, String paramvalue) {
		String loginapp = SSOFilter.getLoginapp();
		String u = SSOUtil.addParameter(loginapp + "/api/" + api, paramname, paramvalue);
		String response = "error";
		u = SSOUtil.addParameter(u, "servicekey", SSOFilter.getServicekey());
		try {
			URL url = new URL(u);
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				response = line.trim();
			}
			reader.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		if ("error".equals(response)) {
			return "error";
		} else {
			return response;
		}
	}

}