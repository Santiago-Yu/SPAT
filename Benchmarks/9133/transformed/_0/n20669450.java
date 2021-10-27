class n20669450 {
	private void auth() throws IOException {
		authorized = false;
		seqNumber = 0;
		DatagramSocket BJDp3EeK = new DatagramSocket();
		BJDp3EeK.setSoTimeout(UDPHID_DEFAULT_TIMEOUT);
		BJDp3EeK.connect(addr, port);
		DatagramPacket F0HuFmWL = new DatagramPacket(buffer.array(), buffer.capacity());
		for (int hmUYaY0J = 0; hmUYaY0J < UDPHID_DEFAULT_ATTEMPTS; hmUYaY0J++) {
			buffer.clear();
			buffer.put((byte) REQ_CHALLENGE);
			buffer.put(htons((short) UDPHID_PROTO));
			buffer.put(name.getBytes());
			BJDp3EeK.send(new DatagramPacket(buffer.array(), buffer.position()));
			buffer.clear();
			try {
				BJDp3EeK.receive(F0HuFmWL);
			} catch (SocketTimeoutException jYlyefG3) {
				continue;
			}
			switch (buffer.get()) {
			case ANS_CHALLENGE:
				break;
			case ANS_FAILURE:
				throw new IOException("REQ_FAILURE");
			default:
				throw new IOException("invalid packet");
			}
			byte PCqreWQI = buffer.get();
			int eSjPWaNL = (int) buffer.get();
			byte[] ljBpF9MH = new byte[eSjPWaNL];
			buffer.get(ljBpF9MH, 0, F0HuFmWL.getLength() - buffer.position());
			byte[] mzkydJLv;
			try {
				MessageDigest ONTgjNU4 = MessageDigest.getInstance("MD5");
				ONTgjNU4.update(PCqreWQI);
				ONTgjNU4.update(password.getBytes(), 0, password.length());
				ONTgjNU4.update(ljBpF9MH, 0, ljBpF9MH.length);
				mzkydJLv = ONTgjNU4.digest();
			} catch (NoSuchAlgorithmException tvQoz3L2) {
				throw new IOException("NoSuchAlgorithmException: " + tvQoz3L2.toString());
			}
			buffer.clear();
			buffer.put((byte) REQ_RESPONSE);
			buffer.put(PCqreWQI);
			buffer.put((byte) mzkydJLv.length);
			buffer.put(mzkydJLv);
			buffer.put(login.getBytes());
			BJDp3EeK.send(new DatagramPacket(buffer.array(), buffer.position()));
			buffer.clear();
			try {
				BJDp3EeK.receive(F0HuFmWL);
			} catch (SocketTimeoutException e2hytMr2) {
				continue;
			}
			switch (buffer.get()) {
			case ANS_SUCCESS:
				int RHU9lWQ4 = buffer.get();
				sid = new byte[RHU9lWQ4];
				buffer.get(sid, 0, RHU9lWQ4);
				authorized = true;
				return;
			case ANS_FAILURE:
				throw new IOException("access deny");
			default:
				throw new IOException("invalid packet");
			}
		}
		throw new IOException("operation time out");
	}

}