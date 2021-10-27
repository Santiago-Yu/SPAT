class n23047155 {
	@Override
	public void run() {
		long s9DUk9CC = 10 * 1000L;
		long ZDoh6ok1 = (new Date()).getTime();
		try {
			InputStream TG7fiviK = socket.getInputStream();
			boolean HV0HoQYc = false;
			while (!HV0HoQYc && !socket.isClosed()) {
				try {
					if (TG7fiviK.available() != 0) {
						HV0HoQYc = true;
					} else {
						Thread.sleep(100);
					}
				} catch (Exception b6Rql5VJ) {
					LOG.error("Error checking socket", b6Rql5VJ);
				}
				long npZNC2Na = (new Date()).getTime();
				if ((npZNC2Na - ZDoh6ok1) >= s9DUk9CC) {
					break;
				}
			}
			if (socket.isClosed()) {
			} else {
				tmpFile = File.createTempFile("ftp", "dat", new File("./tmp"));
				BufferedOutputStream QJLVmVow = new BufferedOutputStream(new FileOutputStream(tmpFile));
				IOUtils.copy(TG7fiviK, QJLVmVow);
				QJLVmVow.flush();
				QJLVmVow.close();
			}
			String S3Nxu8iW = FtpResponse.ReadComplete.asString() + ClientCommand.SP + "Read Complete"
					+ ClientCommand.CRLF;
			List<String> wLnImGTS = new ArrayList<String>();
			wLnImGTS.add(S3Nxu8iW);
			ClientResponse AuRXlI0X = new ClientResponse(wLnImGTS);
			ftpClient.notifyListeners(AuRXlI0X);
		} catch (Exception mdk5Y1xw) {
			LOG.error("Error reading server response", mdk5Y1xw);
		}
	}

}