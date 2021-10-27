class n8292552 {
	public void run() {
		BufferedReader g78kLX4j = null;
		try {
			String mmSM7Bn3 = "http://www.hubtracker.com/query.php?action=add&username=" + user + "&password=" + pass
					+ "&email=" + e_mail + "&address=" + Vars.Hub_Host;
			URL AweMKVK3 = new URL(mmSM7Bn3);
			URLConnection XSrDs3b8;
			if (!Vars.Proxy_Host.equals(""))
				XSrDs3b8 = AweMKVK3.openConnection(
						new Proxy(Proxy.Type.HTTP, new InetSocketAddress(Vars.Proxy_Host, Vars.Proxy_Port)));
			else
				XSrDs3b8 = AweMKVK3.openConnection();
			XSrDs3b8.setDoInput(true);
			XSrDs3b8.setDoOutput(true);
			XSrDs3b8.connect();
			g78kLX4j = new BufferedReader(new InputStreamReader(XSrDs3b8.getInputStream()));
			String GtWBnmz5;
			while ((GtWBnmz5 = g78kLX4j.readLine()) != null)
				PluginMain.result += "\n" + GtWBnmz5;
			if (curCmd != null)
				this.curCmd.cur_client.sendFromBot("[hubtracker:] " + PluginMain.result);
			else
				PluginMain.curFrame.showMsg();
			g78kLX4j.close();
			g78kLX4j = null;
		} catch (MalformedURLException YmUX5KwA) {
			PluginMain.result = YmUX5KwA.toString();
		} catch (Exception rK54wuDZ) {
			PluginMain.result = rK54wuDZ.toString();
		}
		done = true;
	}

}