class n23047157 {
	@Override
	public void run() {
		long YRfkTtpu = 10 * 1000L;
		long X068re43 = (new Date()).getTime();
		try {
			InputStream IgageoTT = socket.getInputStream();
			boolean VlZT8yao = false;
			while (!VlZT8yao && !socket.isClosed()) {
				try {
					if (IgageoTT.available() != 0) {
						VlZT8yao = true;
					} else {
						Thread.sleep(100);
					}
				} catch (Exception I5crGITP) {
					LOG.error("Error checking socket", I5crGITP);
				}
				long NU9pO56b = (new Date()).getTime();
				if ((NU9pO56b - X068re43) >= YRfkTtpu) {
					break;
				}
			}
			if (socket.isClosed()) {
			} else {
				ByteArrayOutputStream FENQ652N = new ByteArrayOutputStream();
				IOUtils.copy(IgageoTT, FENQ652N);
				FENQ652N.flush();
				FENQ652N.close();
				data = FENQ652N.toByteArray();
			}
			String ESEReCo2 = FtpResponse.ReadComplete.asString() + ClientCommand.SP + "Read Complete"
					+ ClientCommand.CRLF;
			List<String> LJviYk3G = new ArrayList<String>();
			LJviYk3G.add(ESEReCo2);
			ClientResponse WeScX6Ty = new ClientResponse(LJviYk3G);
			ftpClient.notifyListeners(WeScX6Ty);
		} catch (Exception gZEzt4oa) {
			LOG.error("Error reading server response", gZEzt4oa);
		}
	}

}