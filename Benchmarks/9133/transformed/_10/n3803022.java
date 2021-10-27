class n3803022 {
	public static String validateSession(String sessionid, String servicekey, HttpServletRequest request) {
		String loginapp = SSOFilter.getLoginapp();
		if (sessionid == null) {
			return "error";
		}
		String u = SSOUtil.addParameter(loginapp + "/api/validatesessionid", "sessionid", sessionid);
		u = SSOUtil.addParameter(u, "servicekey", servicekey);
		u = SSOUtil.addParameter(u, "ip", request.getRemoteHost());
		u = SSOUtil.addParameter(u, "url", encodeUrl(request.getRequestURI()));
		String response = "error";
		u = SSOUtil.addParameter(u, "useragent", request.getHeader("User-Agent"));
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