class n2897046 {
	public boolean execute_check() {
		FTPClient jScy5KrS = new FTPClient();
		File sgAH3f9R = null;
		FileChannel D3k3QCEF;
		InputStream hqoapOyb;
		OutputStream Owl71Tdb;
		int oK0fzhLE;
		if (super.verbose > 0)
			verbose = true;
		jScy5KrS.setDefaultPort(port);
		jScy5KrS.setDefaultTimeout(timeout);
		if (verbose) {
			System.out.println("Using FTP Server: " + hostname);
			System.out.println("Using FTP Port: " + port);
			System.out.println("Using Timeout of: " + timeout);
		}
		if (passive) {
			jScy5KrS.enterLocalPassiveMode();
			if (verbose)
				System.out.println("Using Passive Mode");
		}
		try {
			sgAH3f9R = new File(file);
			D3k3QCEF = new RandomAccessFile(sgAH3f9R, "rw").getChannel();
			if (verbose)
				System.out.println("Attempting FTP Connection to " + hostname);
			jScy5KrS.connect(hostname);
			oK0fzhLE = jScy5KrS.getReplyCode();
			if (!FTPReply.isPositiveCompletion(oK0fzhLE)) {
				if (verbose)
					System.out.println("FTP Connection to " + hostname + " failed");
				check_state = common_h.STATE_CRITICAL;
				check_message = jScy5KrS.getReplyString();
				sgAH3f9R.delete();
				jScy5KrS.disconnect();
				return true;
			}
			if (username != null && password != null) {
				if (verbose)
					System.out.println("Attempting to log in into FTP Server " + hostname);
				if (!jScy5KrS.login(username, password)) {
					if (verbose)
						System.out.println("Unable to log in to FTP Server " + hostname);
					check_state = common_h.STATE_CRITICAL;
					check_message = jScy5KrS.getReplyString();
					jScy5KrS.disconnect();
					sgAH3f9R.delete();
					return true;
				}
			}
			if (verbose)
				System.out.println("Attempting to change to required directory");
			if (!jScy5KrS.changeWorkingDirectory(directory)) {
				if (verbose)
					System.out.println("Required directory cannot be found!");
				check_state = common_h.STATE_WARNING;
				check_message = jScy5KrS.getReplyString();
				jScy5KrS.disconnect();
				sgAH3f9R.delete();
				return true;
			}
			if (verbose)
				System.out.println("Attempting to retrieve specified file!");
			hqoapOyb = jScy5KrS.retrieveFileStream(file);
			if (hqoapOyb == null) {
				if (verbose)
					System.out.println("Unable to locate required file.");
				check_state = common_h.STATE_WARNING;
				check_message = jScy5KrS.getReplyString();
				jScy5KrS.disconnect();
				sgAH3f9R.delete();
				return true;
			}
			Owl71Tdb = Channels.newOutputStream(D3k3QCEF);
			byte[] xCVphDOJ = new byte[4096];
			if (verbose)
				System.out.println("Beginning File transfer...");
			for (int MyEjxPU0 = -1; (MyEjxPU0 = hqoapOyb.read(xCVphDOJ)) != -1;)
				Owl71Tdb.write(xCVphDOJ, 0, MyEjxPU0);
			if (verbose) {
				System.out.println("...transfer complete.");
				System.out.println("Attempting to finalise Command");
			}
			if (!jScy5KrS.completePendingCommand()) {
				if (verbose)
					System.out.println("Unable to finalise command");
				check_state = common_h.STATE_WARNING;
				check_message = jScy5KrS.getReplyString();
				jScy5KrS.disconnect();
				sgAH3f9R.delete();
				return true;
			}
			if (verbose)
				System.out.println("Check Completed.");
			check_state = common_h.STATE_OK;
			check_message = jScy5KrS.getReplyString();
			hqoapOyb.close();
			Owl71Tdb.close();
			D3k3QCEF.close();
			sgAH3f9R.delete();
		} catch (IOException qiMapQCK) {
			check_state = common_h.STATE_CRITICAL;
			check_message = qiMapQCK.getMessage();
			if (sgAH3f9R != null)
				sgAH3f9R.delete();
		} finally {
			if (jScy5KrS.isConnected()) {
				try {
					jScy5KrS.logout();
					jScy5KrS.disconnect();
				} catch (Exception IrOXFEYk) {
				}
			}
		}
		return true;
	}

}