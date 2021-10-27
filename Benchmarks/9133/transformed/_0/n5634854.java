class n5634854 {
	private static void checkClients() {
		try {
			sendMultiListEntry('l');
		} catch (Exception dipnjQph) {
			if (Util.getDebugLevel() > 90)
				dipnjQph.printStackTrace();
		}
		try {
			if (CANT_CHECK_CLIENTS != null)
				KeyboardHero.removeStatus(CANT_CHECK_CLIENTS);
			URL Gor6H6c7 = new URL(URL_STR + "?req=clients" + (server != null ? "&port=" + server.getLocalPort() : ""));
			URLConnection Xazd3a52 = Gor6H6c7.openConnection(getProxy());
			Xazd3a52.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader Wqh0961X = new BufferedReader(new InputStreamReader(Xazd3a52.getInputStream()));
			String zfpv78IU;
			if (Util.getDebugLevel() > 30)
				Util.debug("URL: " + Gor6H6c7);
			while ((zfpv78IU = Wqh0961X.readLine()) != null) {
				String[] xYD1Howi = zfpv78IU.split(":", 2);
				if (xYD1Howi.length < 2) {
					Util.debug(12, "Line read in checkClients: " + zfpv78IU);
					continue;
				}
				try {
					InetSocketAddress WqTJW8qD = new InetSocketAddress(xYD1Howi[0], Integer.parseInt(xYD1Howi[1]));
					boolean a1sLb76V = true;
					if (Util.getDebugLevel() > 25)
						Util.debug("NEW Address: " + WqTJW8qD.toString());
					synchronized (clients) {
						Iterator<Client> Y15c2ZN5 = clients.iterator();
						while (Y15c2ZN5.hasNext()) {
							final Client WsKoLAXP = Y15c2ZN5.next();
							if (WsKoLAXP.socket.isClosed()) {
								Y15c2ZN5.remove();
								continue;
							}
							if (Util.getDebugLevel() > 26 && WsKoLAXP.address != null)
								Util.debug("Address: " + WsKoLAXP.address.toString());
							if (WqTJW8qD.equals(WsKoLAXP.address)) {
								a1sLb76V = false;
								break;
							}
						}
					}
					if (a1sLb76V) {
						connectClient(WqTJW8qD);
					}
				} catch (NumberFormatException LJDnv3d4) {
				}
			}
			Wqh0961X.close();
		} catch (MalformedURLException vbi4Myng) {
			Util.conditionalError(PORT_IN_USE, "Err_PortInUse");
			Util.error(Util.getMsg("Err_CantCheckClients"));
		} catch (FileNotFoundException Har84NaA) {
			Util.error(Util.getMsg("Err_CantCheckClients_Proxy"), Util.getMsg("Err_FileNotFound"));
		} catch (SocketException j2fpj1FN) {
			Util.error(Util.getMsg("Err_CantCheckClients_Proxy"), j2fpj1FN.getLocalizedMessage());
		} catch (Exception e18Bk2Yc) {
			CANT_CHECK_CLIENTS.setException(e18Bk2Yc.toString());
			KeyboardHero.addStatus(CANT_CHECK_CLIENTS);
		}
	}

}