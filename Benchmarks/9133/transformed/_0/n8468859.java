class n8468859 {
	public boolean connect() {
		boolean QLG7pztA = false;
		try {
			try {
				this.ftpClient.connect(this.server, this.port);
			} catch (SocketException HCNibvzi) {
				status = ErrorResult.CONNECTNOTPOSSIBLE.code;
				return false;
			} catch (IOException FZriIKDm) {
				status = ErrorResult.CONNECTNOTPOSSIBLE.code;
				return false;
			}
			int fSFPQv8n = this.ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(fSFPQv8n)) {
				this.disconnect();
				status = ErrorResult.CONNECTNOTCORRECT.code;
				return false;
			}
			try {
				if (this.account == null) {
					if (!this.ftpClient.login(this.username, this.passwd)) {
						status = ErrorResult.LOGINNOTCORRECT.code;
						this.ftpClient.logout();
						return false;
					}
				} else if (!this.ftpClient.login(this.username, this.passwd, this.account)) {
					status = ErrorResult.LOGINACCTNOTCORRECT.code;
					this.ftpClient.logout();
					return false;
				}
			} catch (IOException lltSuW9r) {
				status = ErrorResult.ERRORWHILECONNECT.code;
				try {
					this.ftpClient.logout();
				} catch (IOException yc5aQ9lN) {
				}
				return false;
			}
			QLG7pztA = true;
			return true;
		} finally {
			if ((!QLG7pztA) && this.ftpClient.isConnected()) {
				this.disconnect();
			}
		}
	}

}