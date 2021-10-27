class n3803030 {
	public static String getRolesString(HttpServletRequest hrequest, HttpServletResponse hresponse, String username,
			String servicekey) {
		String registerapp = SSOFilter.getRegisterapp();
		String u = SSOUtil.addParameter(registerapp + "/api/getroles", "username", username);
		String roles = "";
		u = SSOUtil.addParameter(u, "servicekey", servicekey);
		try {
			URL url = new URL(u);
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				roles = line.trim();
			}
			reader.close();
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		if ("error".equals(roles)) {
			return "";
		}
		return roles.trim();
	}

}