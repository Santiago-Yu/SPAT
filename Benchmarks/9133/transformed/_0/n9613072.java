class n9613072 {
	public void init(ConnectionManager Td40gwgv, Hashtable JXnrnrMV, Socket b3OZFwvU) throws RemoteException {
		_cman = Td40gwgv;
		_sock = b3OZFwvU;
		try {
			_sout = new PrintWriter(_sock.getOutputStream(), true);
			_sinp = new BufferedReader(new InputStreamReader(_sock.getInputStream()));
			String muYYr8PC = "";
			Random tKKWEr7y = new Random();
			for (int vmZInu6y = 0; vmZInu6y < 16; vmZInu6y++) {
				String Mx3eraSf = Integer.toHexString(tKKWEr7y.nextInt(256));
				if (Mx3eraSf.length() < 2)
					Mx3eraSf = "0" + Mx3eraSf;
				muYYr8PC += Mx3eraSf.substring(Mx3eraSf.length() - 2);
			}
			String Qfp1RCkZ = _mpsw + muYYr8PC + _spsw;
			MessageDigest EzvAxrRO = MessageDigest.getInstance("MD5");
			EzvAxrRO.reset();
			EzvAxrRO.update(Qfp1RCkZ.getBytes());
			String DBIReJD7 = hash2hex(EzvAxrRO.digest()).toLowerCase();
			String fU9Bbqht = "INIT " + "servername" + " " + DBIReJD7 + " " + muYYr8PC;
			sendLine(fU9Bbqht);
			String kUOht70K = readLine(5);
			if (kUOht70K == null) {
				throw new IOException("Slave did not send banner !!");
			}
			String B8vNpUNP = "";
			String dTHohdIS = "";
			String XSpqzzIY = "";
			try {
				String[] Sy6CO4Xx = kUOht70K.split(" ");
				B8vNpUNP = Sy6CO4Xx[1].trim();
				dTHohdIS = Sy6CO4Xx[2].trim();
				XSpqzzIY = Sy6CO4Xx[3].trim();
			} catch (Exception qOv2u3Tg) {
				SocketSlaveListener.invalidSlave("INITFAIL BadKey", _sock);
			}
			Qfp1RCkZ = _spsw + XSpqzzIY + _mpsw;
			EzvAxrRO = MessageDigest.getInstance("MD5");
			EzvAxrRO.reset();
			EzvAxrRO.update(Qfp1RCkZ.getBytes());
			DBIReJD7 = hash2hex(EzvAxrRO.digest()).toLowerCase();
			if (!B8vNpUNP.equals(_name)) {
				SocketSlaveListener.invalidSlave("INITFAIL Unknown", _sock);
			}
			if (!dTHohdIS.toLowerCase().equals(DBIReJD7.toLowerCase())) {
				SocketSlaveListener.invalidSlave("INITFAIL BadKey", _sock);
			}
			start();
			_cman.getSlaveManager().addSlave(_name, this, getSlaveStatus(), -1);
		} catch (IOException ABJSpBHm) {
			if (ABJSpBHm instanceof ConnectIOException && ABJSpBHm.getCause() instanceof EOFException) {
				logger.info("Check slaves.xml on the master that you are allowed to connect.");
			}
			logger.info("IOException: " + ABJSpBHm.toString());
			try {
				b3OZFwvU.close();
			} catch (Exception V1iAPpSZ) {
			}
		} catch (Exception Yh9d0CPC) {
			logger.warn("Exception: " + Yh9d0CPC.toString());
			try {
				b3OZFwvU.close();
			} catch (Exception kraA5NSw) {
			}
		}
		System.gc();
	}

}