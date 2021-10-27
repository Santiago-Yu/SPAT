class n8064604 {
	public void init(ConnectionManager d9OgUBoA, Hashtable wasduGDR, Socket TludDkDr) throws RemoteException {
		_cman = d9OgUBoA;
		_sock = TludDkDr;
		for (int jqyytQm1 = 0; jqyytQm1 < 256; jqyytQm1++) {
			String j6sO6NNn = Integer.toHexString(jqyytQm1);
			if (j6sO6NNn.length() < 2)
				j6sO6NNn = "0" + j6sO6NNn;
			availcmd.push(j6sO6NNn);
			commands.put(j6sO6NNn, null);
		}
		try {
			_sout = new PrintWriter(_sock.getOutputStream(), true);
			_sinp = new BufferedReader(new InputStreamReader(_sock.getInputStream()));
			String hghmNuvl = "";
			Random XDl4e318 = new Random();
			for (int MVtqiX1j = 0; MVtqiX1j < 16; MVtqiX1j++) {
				String eijIJfkt = Integer.toHexString(XDl4e318.nextInt(256));
				if (eijIJfkt.length() < 2)
					eijIJfkt = "0" + eijIJfkt;
				hghmNuvl += eijIJfkt.substring(eijIJfkt.length() - 2);
			}
			String lUaPVW96 = _mpsw + hghmNuvl + _spsw;
			MessageDigest lteuARfS = MessageDigest.getInstance("MD5");
			lteuARfS.reset();
			lteuARfS.update(lUaPVW96.getBytes());
			String iIIjeMCK = hash2hex(lteuARfS.digest()).toLowerCase();
			String lGEnEGi4 = "INIT " + "servername" + " " + iIIjeMCK + " " + hghmNuvl;
			sendLine(lGEnEGi4);
			String AXrvh7Hb = readLine(5);
			if (AXrvh7Hb == null) {
				throw new IOException("Slave did not send banner !!");
			}
			String JN0p9Rqj = "";
			String VzUh2WIE = "";
			String Hi157ezn = "";
			try {
				String[] AAmxMTqv = AXrvh7Hb.split(" ");
				JN0p9Rqj = AAmxMTqv[1].trim();
				VzUh2WIE = AAmxMTqv[2].trim();
				Hi157ezn = AAmxMTqv[3].trim();
			} catch (Exception TTuuNxyX) {
				AsyncSlaveListener.invalidSlave("INITFAIL BadKey", _sock);
			}
			lUaPVW96 = _spsw + Hi157ezn + _mpsw;
			lteuARfS = MessageDigest.getInstance("MD5");
			lteuARfS.reset();
			lteuARfS.update(lUaPVW96.getBytes());
			iIIjeMCK = hash2hex(lteuARfS.digest()).toLowerCase();
			if (!JN0p9Rqj.equals(_name)) {
				AsyncSlaveListener.invalidSlave("INITFAIL Unknown", _sock);
			}
			if (!VzUh2WIE.toLowerCase().equals(iIIjeMCK.toLowerCase())) {
				AsyncSlaveListener.invalidSlave("INITFAIL BadKey", _sock);
			}
			_cman.getSlaveManager().addSlave(_name, this, getSlaveStatus(), -1);
			start();
		} catch (IOException ITMQ5ya9) {
			if (ITMQ5ya9 instanceof ConnectIOException && ITMQ5ya9.getCause() instanceof EOFException) {
				logger.info("Check slaves.xml on the master that you are allowed to connect.");
			}
			logger.info("IOException: " + ITMQ5ya9.toString());
			try {
				TludDkDr.close();
			} catch (Exception tY5o44zS) {
			}
		} catch (Exception LtgxkaGd) {
			logger.warn("Exception: " + LtgxkaGd.toString());
			try {
				TludDkDr.close();
			} catch (Exception HJ1YlBKt) {
			}
		}
		System.gc();
	}

}