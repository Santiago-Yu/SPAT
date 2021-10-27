class n14450903 {
	public void login() {
		if (email.isEmpty() || pass.isEmpty()) {
			NotifyUtil.warn("Acount Data", "You need to specify and account e-mail and password.", false);
			return;
		}
		final ProgressHandle mS3MsLH0 = ProgressHandleFactory.createHandle("Connecting to Facebook ...");
		final Runnable Nlt0mmUR = new Runnable() {

			@Override
			public void run() {
				mS3MsLH0.start();
				mS3MsLH0.switchToIndeterminate();
				FacebookJsonRestClient P1UXGjTg = new FacebookJsonRestClient(API_KEY, SECRET);
				P1UXGjTg.setIsDesktop(true);
				HttpURLConnection t8pK01XE;
				List<String> Suvt58A5;
				try {
					String FAxyM7gQ = P1UXGjTg.auth_createToken();
					String u5ymx2nX = "http://www.facebook.com/login.php";
					String JQVWg0gW = "http://www.facebook.com/login.php" + "?api_key=" + API_KEY + "&v=1.0"
							+ "&auth_token=" + FAxyM7gQ;
					HttpURLConnection.setFollowRedirects(true);
					t8pK01XE = (HttpURLConnection) new URL(JQVWg0gW).openConnection();
					t8pK01XE.setRequestMethod("GET");
					t8pK01XE.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
					t8pK01XE.setRequestProperty("Host", "www.facebook.com");
					t8pK01XE.setRequestProperty("Accept-Charset", "UFT-8");
					t8pK01XE.connect();
					Suvt58A5 = t8pK01XE.getHeaderFields().get("Set-Cookie");
					t8pK01XE = (HttpURLConnection) new URL(u5ymx2nX).openConnection();
					t8pK01XE.setRequestMethod("POST");
					t8pK01XE.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
					t8pK01XE.setRequestProperty("Host", "www.facebook.com");
					t8pK01XE.setRequestProperty("Accept-Charset", "UFT-8");
					if (Suvt58A5 != null) {
						for (String ipPRE01m : Suvt58A5) {
							t8pK01XE.addRequestProperty("Cookie", ipPRE01m.split(";", 2)[0]);
						}
					}
					String fwVqYct5 = "api_key=" + API_KEY + "&auth_token=" + FAxyM7gQ + "&email="
							+ URLEncoder.encode(email, "UTF-8") + "&pass=" + URLEncoder.encode(pass, "UTF-8")
							+ "&v=1.0";
					t8pK01XE.setRequestProperty("Content-Length", Integer.toString(fwVqYct5.length()));
					t8pK01XE.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					t8pK01XE.setDoOutput(true);
					t8pK01XE.connect();
					t8pK01XE.getOutputStream().write(fwVqYct5.toString().getBytes("UTF-8"));
					t8pK01XE.getOutputStream().close();
					Suvt58A5 = t8pK01XE.getHeaderFields().get("Set-Cookie");
					if (Suvt58A5 == null) {
						ActionListener IgaavJ4j = new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent WE7bzoYr) {
								String Q2LFsJ25 = "http://www.chartsy.org/facebook/";
								DesktopUtil.browseAndWarn(Q2LFsJ25, null);
							}
						};
						NotifyUtil.show("Application Permission", "You need to grant permission first.",
								MessageType.WARNING, IgaavJ4j, false);
						t8pK01XE.disconnect();
						loggedIn = false;
					} else {
						sessionKey = P1UXGjTg.auth_getSession(FAxyM7gQ);
						sessionSecret = P1UXGjTg.getSessionSecret();
						loggedIn = true;
					}
					t8pK01XE.disconnect();
					mS3MsLH0.finish();
				} catch (FacebookException PTSU5mFB) {
					mS3MsLH0.finish();
					NotifyUtil.error("Login Error", PTSU5mFB.getMessage(), PTSU5mFB, false);
				} catch (IOException dARtDjNg) {
					mS3MsLH0.finish();
					NotifyUtil.error("Login Error", dARtDjNg.getMessage(), dARtDjNg, false);
				}
			}
		};
		WindowManager.getDefault().invokeWhenUIReady(Nlt0mmUR);
	}

}