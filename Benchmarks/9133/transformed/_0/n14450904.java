class n14450904 {
	@Override
	public void run() {
		handle.start();
		handle.switchToIndeterminate();
		FacebookJsonRestClient N5Rm7XtN = new FacebookJsonRestClient(API_KEY, SECRET);
		N5Rm7XtN.setIsDesktop(true);
		HttpURLConnection LcHTvNlA;
		List<String> vwGj6J5M;
		try {
			String YfIlgnUj = N5Rm7XtN.auth_createToken();
			String zpOpSSEQ = "http://www.facebook.com/login.php";
			String ktR1yBRg = "http://www.facebook.com/login.php" + "?api_key=" + API_KEY + "&v=1.0" + "&auth_token="
					+ YfIlgnUj;
			HttpURLConnection.setFollowRedirects(true);
			LcHTvNlA = (HttpURLConnection) new URL(ktR1yBRg).openConnection();
			LcHTvNlA.setRequestMethod("GET");
			LcHTvNlA.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
			LcHTvNlA.setRequestProperty("Host", "www.facebook.com");
			LcHTvNlA.setRequestProperty("Accept-Charset", "UFT-8");
			LcHTvNlA.connect();
			vwGj6J5M = LcHTvNlA.getHeaderFields().get("Set-Cookie");
			LcHTvNlA = (HttpURLConnection) new URL(zpOpSSEQ).openConnection();
			LcHTvNlA.setRequestMethod("POST");
			LcHTvNlA.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
			LcHTvNlA.setRequestProperty("Host", "www.facebook.com");
			LcHTvNlA.setRequestProperty("Accept-Charset", "UFT-8");
			if (vwGj6J5M != null) {
				for (String NyRQQbYL : vwGj6J5M) {
					LcHTvNlA.addRequestProperty("Cookie", NyRQQbYL.split(";", 2)[0]);
				}
			}
			String pO9Ds0Nr = "api_key=" + API_KEY + "&auth_token=" + YfIlgnUj + "&email="
					+ URLEncoder.encode(email, "UTF-8") + "&pass=" + URLEncoder.encode(pass, "UTF-8") + "&v=1.0";
			LcHTvNlA.setRequestProperty("Content-Length", Integer.toString(pO9Ds0Nr.length()));
			LcHTvNlA.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			LcHTvNlA.setDoOutput(true);
			LcHTvNlA.connect();
			LcHTvNlA.getOutputStream().write(pO9Ds0Nr.toString().getBytes("UTF-8"));
			LcHTvNlA.getOutputStream().close();
			vwGj6J5M = LcHTvNlA.getHeaderFields().get("Set-Cookie");
			if (vwGj6J5M == null) {
				ActionListener FBgawT3n = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent QEYjH8SL) {
						String d10DfF2t = "http://www.chartsy.org/facebook/";
						DesktopUtil.browseAndWarn(d10DfF2t, null);
					}
				};
				NotifyUtil.show("Application Permission", "You need to grant permission first.", MessageType.WARNING,
						FBgawT3n, false);
				LcHTvNlA.disconnect();
				loggedIn = false;
			} else {
				sessionKey = N5Rm7XtN.auth_getSession(YfIlgnUj);
				sessionSecret = N5Rm7XtN.getSessionSecret();
				loggedIn = true;
			}
			LcHTvNlA.disconnect();
			handle.finish();
		} catch (FacebookException lJM7kKb1) {
			handle.finish();
			NotifyUtil.error("Login Error", lJM7kKb1.getMessage(), lJM7kKb1, false);
		} catch (IOException EeX9b4T4) {
			handle.finish();
			NotifyUtil.error("Login Error", EeX9b4T4.getMessage(), EeX9b4T4, false);
		}
	}

}