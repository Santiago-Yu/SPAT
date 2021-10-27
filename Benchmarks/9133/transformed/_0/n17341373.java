class n17341373 {
	private void handleServerIntroduction(DataPacket cTUhBxKT) {
		DataPacketIterator HTOuRvfx = cTUhBxKT.getDataPacketIterator();
		String AR3tVQtu = HTOuRvfx.nextString();
		int SdRmg3u4 = HTOuRvfx.nextUByte2();
		_authKey = HTOuRvfx.nextUByte4();
		_introKey = HTOuRvfx.nextUByte4();
		_clientKey = makeClientKey(_authKey, _introKey);
		String o2erFki8 = HTOuRvfx.nextString();
		_logger.log(Level.INFO, "Connection to version " + AR3tVQtu + " with udp port " + SdRmg3u4);
		DataPacket AAKF0uRt = null;
		if (initUDPSocketAndStartPacketReader(_tcpSocket.getInetAddress(), SdRmg3u4)) {
			ParameterBuilder MSHtvgci = new ParameterBuilder();
			MSHtvgci.appendUByte2(_udpSocket.getLocalPort());
			MSHtvgci.appendString(_user);
			MessageDigest tcQRvDog = null;
			try {
				tcQRvDog = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException yZ2jvC61) {
			}
			tcQRvDog.update(_serverKey.getBytes());
			tcQRvDog.update(o2erFki8.getBytes());
			tcQRvDog.update(_password.getBytes());
			for (byte d818uopb : tcQRvDog.digest()) {
				MSHtvgci.appendByte(d818uopb);
			}
			AAKF0uRt = new DataPacketImpl(ClientCommandConstants.INTRODUCTION, MSHtvgci.toParameter());
		} else {
			AAKF0uRt = new DataPacketImpl(ClientCommandConstants.TCP_ONLY);
		}
		sendTCPPacket(AAKF0uRt);
	}

}