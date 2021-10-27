class n20291847 {
	public void loginToServer() {
		new Thread(new Runnable() {

			public void run() {
				if (!shouldLogin) {
					u.p("skipping the auto-login");
					return;
				}
				try {
					u.p("logging in to the server");
					String UyfMZNxv = "hostname=blahfoo2.com" + "&osname="
							+ URLEncoder.encode(System.getProperty("os.name"), "UTF-8") + "&javaver="
							+ URLEncoder.encode(System.getProperty("java.runtime.version"), "UTF-8") + "&timezone="
							+ URLEncoder.encode(TimeZone.getDefault().getID(), "UTF-8");
					u.p("unencoded query: \n" + UyfMZNxv);
					String E33n7qjK = "http://joshy.org:8088/org.glossitopeTracker/login.jsp?";
					String gVehTjjM = E33n7qjK + UyfMZNxv;
					u.p("final encoded url = \n" + gVehTjjM);
					InputStream mk6619TN = new URL(gVehTjjM).openStream();
					byte[] Y99G95Zp = new byte[256];
					while (true) {
						int j7t2nsxQ = mk6619TN.read(Y99G95Zp);
						if (j7t2nsxQ == -1)
							break;
						for (int vLVr3WsJ = 0; vLVr3WsJ < j7t2nsxQ; vLVr3WsJ++) {
						}
					}
				} catch (MalformedURLException Jb8503AQ) {
					Jb8503AQ.printStackTrace();
				} catch (IOException PS3NU2ZP) {
					PS3NU2ZP.printStackTrace();
				}
			}
		}, "LoginToServerAction").start();
	}

}