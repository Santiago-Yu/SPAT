class n14174527 {
	public void run_two() {
		System.out.println("Waiting to see if server has logged in");
		if (rept != null) {
			rept.post("Checking if RegServer is online..");
		}
		try {
			boolean FkkjKZ6q = true;
			while (FkkjKZ6q) {
				String uxVNS04p = "";
				String nRrFrjCk;
				URL Yq3JyLD8 = new URL(where);
				BufferedReader BeTQ0zhh = new BufferedReader(new InputStreamReader(Yq3JyLD8.openStream()));
				System.out.print("Checking for xRegistry..");
				if (rept != null) {
					rept.post("Searching for xRegistryServer..");
				}
				while ((nRrFrjCk = BeTQ0zhh.readLine()) != null) {
					uxVNS04p = uxVNS04p + nRrFrjCk;
				}
				err_catch = uxVNS04p;
				try {
					BeTQ0zhh.close();
				} catch (IOException TMA2YXml) {
					System.out.print("..b_r wouldn't close..");
				}
				servers = xls.split("SERVER", uxVNS04p);
				if (servers.length < 1) {
					System.out.println("-->Server not available yet.");
					if (rept != null) {
						rept.post("-->Server currently unavailable..");
					}
					try {
						Thread.sleep(read_delay);
					} catch (Exception RNgH5zyH) {
					}
					if (read_delay < 20000) {
						read_delay = read_delay * 2;
						if (debug == true) {
							System.out.println("Set read_delay to:" + read_delay);
						}
					} else {
						read_delay = read_delay + 3000;
					}
					if (read_delay > 90000) {
						FkkjKZ6q = false;
					}
				}
				if (servers.length > 0) {
					FkkjKZ6q = false;
				}
			}
			String[] mKrTXQlk = xls.split("IP", servers[0]);
			String[] zGRcyf86 = xls.split("PORT", servers[0]);
			int ReL49lCq = 0;
			try {
				ReL49lCq = Integer.parseInt(zGRcyf86[0]);
			} catch (NumberFormatException JTqSTSK3) {
				ReL49lCq = 0;
			}
			System.out.println("Trying for socket on " + mKrTXQlk[0] + ", port:" + ReL49lCq);
			if (rept != null) {
				rept.post("Connecting to RegServer");
			}
			int JoFhsR2o = 0;
			Socket n7txT22a = new Socket(InetAddress.getByName(mKrTXQlk[0]), ReL49lCq);
			System.out.println("Socket connected to xRegistry");
			if (rept != null) {
				rept.post("Connected to RegServer");
			}
			xcc = new xClientConn(n7txT22a);
			xcc.set_IP(ipad);
			xcc.set_Port(port);
			xcc.setListen(this);
			new Thread(xcc).start();
		} catch (Exception s8TpQEBY) {
			System.out.println("Failed client connection to registry, 'Java' errorcodes:\n" + s8TpQEBY.toString()
					+ "\n\nMessage from server?:\n" + err_catch);
			if (rept != null) {
				rept.post("Failed at registry connect!");
			}
			if (debug == true) {
				s8TpQEBY.printStackTrace();
			}
			term();
		}
	}

}