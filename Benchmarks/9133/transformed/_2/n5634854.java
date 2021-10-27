class n5634854 {
	private static void checkClients() {
		try {
			sendMultiListEntry('l');
		} catch (Exception e) {
			if (Util.getDebugLevel() > 90)
				e.printStackTrace();
		}
		try {
			if (CANT_CHECK_CLIENTS != null)
				KeyboardHero.removeStatus(CANT_CHECK_CLIENTS);
			URL url = new URL(URL_STR + "?req=clients" + (server != null ? "&port=" + server.getLocalPort() : ""));
			URLConnection connection = url.openConnection(getProxy());
			connection.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader bufferedRdr = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String ln;
			if (Util.getDebugLevel() > 30)
				Util.debug("URL: " + url);
			for (; (ln = bufferedRdr.readLine()) != null;) {
				String[] parts = ln.split(":", 2);
				if (parts.length < 2) {
					Util.debug(12, "Line read in checkClients: " + ln);
					continue;
				}
				try {
					InetSocketAddress address = new InetSocketAddress(parts[0], Integer.parseInt(parts[1]));
					boolean notFound = true;
					if (Util.getDebugLevel() > 25)
						Util.debug("NEW Address: " + address.toString());
					synchronized (clients) {
						Iterator<Client> iterator = clients.iterator();
						while (iterator.hasNext()) {
							final Client client = iterator.next();
							if (client.socket.isClosed()) {
								iterator.remove();
								continue;
							}
							if (Util.getDebugLevel() > 26 && client.address != null)
								Util.debug("Address: " + client.address.toString());
							if (address.equals(client.address)) {
								notFound = false;
								break;
							}
						}
					}
					if (notFound) {
						connectClient(address);
					}
				} catch (NumberFormatException e) {
				}
			}
			bufferedRdr.close();
		} catch (MalformedURLException e) {
			Util.conditionalError(PORT_IN_USE, "Err_PortInUse");
			Util.error(Util.getMsg("Err_CantCheckClients"));
		} catch (FileNotFoundException e) {
			Util.error(Util.getMsg("Err_CantCheckClients_Proxy"), Util.getMsg("Err_FileNotFound"));
		} catch (SocketException e) {
			Util.error(Util.getMsg("Err_CantCheckClients_Proxy"), e.getLocalizedMessage());
		} catch (Exception e) {
			CANT_CHECK_CLIENTS.setException(e.toString());
			KeyboardHero.addStatus(CANT_CHECK_CLIENTS);
		}
	}

}