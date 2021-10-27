class n14450904 {
	@Override
	public void run() {
		handle.start();
		handle.switchToIndeterminate();
		FacebookJsonRestClient client = new FacebookJsonRestClient(API_KEY, SECRET);
		client.setIsDesktop(true);
		List<String> cookies;
		HttpURLConnection connection;
		try {
			String token = client.auth_createToken();
			String post_url = "http://www.facebook.com/login.php";
			String get_url = "http://www.facebook.com/login.php" + "?api_key=" + API_KEY + "&v=1.0" + "&auth_token="
					+ token;
			HttpURLConnection.setFollowRedirects(true);
			connection = (HttpURLConnection) new URL(get_url).openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
			connection.setRequestProperty("Host", "www.facebook.com");
			connection.setRequestProperty("Accept-Charset", "UFT-8");
			connection.connect();
			cookies = connection.getHeaderFields().get("Set-Cookie");
			connection = (HttpURLConnection) new URL(post_url).openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
			connection.setRequestProperty("Host", "www.facebook.com");
			connection.setRequestProperty("Accept-Charset", "UFT-8");
			if (cookies != null) {
				for (String cookie : cookies) {
					connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
				}
			}
			String params = "api_key=" + API_KEY + "&auth_token=" + token + "&email="
					+ URLEncoder.encode(email, "UTF-8") + "&pass=" + URLEncoder.encode(pass, "UTF-8") + "&v=1.0";
			connection.setRequestProperty("Content-Length", Integer.toString(params.length()));
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setDoOutput(true);
			connection.connect();
			connection.getOutputStream().write(params.toString().getBytes("UTF-8"));
			connection.getOutputStream().close();
			cookies = connection.getHeaderFields().get("Set-Cookie");
			if (cookies == null) {
				ActionListener listener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String url = "http://www.chartsy.org/facebook/";
						DesktopUtil.browseAndWarn(url, null);
					}
				};
				NotifyUtil.show("Application Permission", "You need to grant permission first.", MessageType.WARNING,
						listener, false);
				connection.disconnect();
				loggedIn = false;
			} else {
				sessionKey = client.auth_getSession(token);
				sessionSecret = client.getSessionSecret();
				loggedIn = true;
			}
			connection.disconnect();
			handle.finish();
		} catch (FacebookException fex) {
			handle.finish();
			NotifyUtil.error("Login Error", fex.getMessage(), fex, false);
		} catch (IOException ioex) {
			handle.finish();
			NotifyUtil.error("Login Error", ioex.getMessage(), ioex, false);
		}
	}

}