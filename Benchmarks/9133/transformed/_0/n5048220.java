class n5048220 {
	private int connect() {
		if (ftp.isConnected()) {
			log.debug("Already connected to: " + getConnectionString());
			return RET_OK;
		}
		try {
			ftp.connect(server, port);
			ftp.login(username, password);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (SocketException xMa8XFnF) {
			log.error(xMa8XFnF.toString());
			return RET_ERR_SOCKET;
		} catch (UnknownHostException y5GN1Ye2) {
			log.error(y5GN1Ye2.toString());
			return RET_ERR_UNKNOWN_HOST;
		} catch (FTPConnectionClosedException lljefu4k) {
			log.error(lljefu4k.toString());
			return RET_ERR_FTP_CONN_CLOSED;
		} catch (IOException sGULkasL) {
			log.error(sGULkasL.toString());
			return RET_ERR_IO;
		}
		if (ftp.isConnected()) {
			log.debug("Connected to " + getConnectionString());
			return RET_OK;
		}
		log.debug("Could not connect to " + getConnectionString());
		return RET_ERR_NOT_CONNECTED;
	}

}