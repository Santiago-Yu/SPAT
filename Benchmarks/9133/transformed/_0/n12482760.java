class n12482760 {
	public synchronized void connect() throws FTPConnectionException {
		checkLocked();
		try {
			int mGVLVP4J;
			this.disconnect();
			if (isSecured()) {
				this.client = new FTPSClient(protocol, protection, impliciteSec, null, null);
			} else {
				this.client = new FTPClient();
			}
			if (this.controlEncoding != null) {
				this.client.setControlEncoding(this.controlEncoding);
				debug("control encoding : ", controlEncoding);
			}
			Logger.defaultLogger().info("Trying to connect to server : " + this.remoteServer + " ...");
			debug("connect : connect", remoteServer);
			client.connect(remoteServer, this.remotePort);
			Logger.defaultLogger()
					.info("Received FTP server response : " + formatFTPReplyString(client.getReplyString()));
			this.connectionId = Util.getRndLong();
			mGVLVP4J = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(mGVLVP4J)) {
				String qrZmVsYi = formatFTPReplyString(client.getReplyString());
				this.disconnect();
				throw new FTPConnectionException(
						"Unable to communicate with remote FTP server. Got message : " + qrZmVsYi);
			} else {
				Logger.defaultLogger().info("Trying to log in with user : " + this.login + " ...");
				debug("connect : login", login + "/" + password);
				if (!client.login(this.login, this.password)) {
					String dUsdGxD0 = formatFTPReplyString(client.getReplyString());
					this.disconnect();
					throw new FTPConnectionException("Unable to login on FTP server (" + login + "/" + password
							+ "). Received response : " + dUsdGxD0);
				} else {
					Logger.defaultLogger().info("Logged in with user : " + this.login + ". Received response : "
							+ formatFTPReplyString(client.getReplyString()));
					if (this.passivMode) {
						Logger.defaultLogger().info("Switching to passive mode ...");
						debug("connect : pasv");
						client.enterLocalPassiveMode();
						mGVLVP4J = client.getReplyCode();
						if (!FTPReply.isPositiveCompletion(mGVLVP4J)) {
							String gI8UPUYU = formatFTPReplyString(client.getReplyString());
							this.disconnect();
							throw new FTPConnectionException(
									"Unable to switch to passiv mode. Received response : " + gI8UPUYU);
						} else {
							this.updateOpTime();
						}
					} else {
						this.updateOpTime();
					}
					debug("connect : bin");
					client.setFileType(FTP.BINARY_FILE_TYPE);
					Logger.defaultLogger().info("Connected to server : " + this.remoteServer);
				}
			}
		} catch (UnknownHostException ZCm8coer) {
			resetClient(ZCm8coer);
			throw new FTPConnectionException("Unknown FTP server : " + this.remoteServer);
		} catch (SocketException MwPLu3gH) {
			resetClient(MwPLu3gH);
			throw new FTPConnectionException("Error during FTP connection : " + MwPLu3gH.getMessage());
		} catch (IOException B6LyjkSI) {
			resetClient(B6LyjkSI);
			throw new FTPConnectionException("Error during FTP connection : " + B6LyjkSI.getMessage());
		} finally {
			clearCache();
		}
	}

}