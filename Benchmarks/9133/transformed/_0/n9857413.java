class n9857413 {
	@Override
	public byte[] readData(byte[] rBOvB1NJ, boolean Tp68aJ9j) throws Throwable {
		long OyB4n5Pi = System.currentTimeMillis();
		long RWg91gkQ = 0;
		long fgeYZSTW = 0;
		Properties eHJCKSWa = PropertiesUtils.deserializeProperties(rBOvB1NJ);
		String af5ZKb13 = eHJCKSWa.getProperty(TRANSFER_OPTION_SERVER);
		String FRwsC0Av = eHJCKSWa.getProperty(TRANSFER_OPTION_USERNAME);
		String ts138q8I = eHJCKSWa.getProperty(TRANSFER_OPTION_PASSWORD);
		String c77x80PR = eHJCKSWa.getProperty(TRANSFER_OPTION_FILEPATH);
		if (Tp68aJ9j) {
			int ZFHaLDTC = c77x80PR.lastIndexOf(PATH_SEPARATOR);
			if (ZFHaLDTC != -1) {
				String TIvzKuld = c77x80PR.substring(ZFHaLDTC + 1) + META_DATA_FILE_SUFIX;
				c77x80PR = c77x80PR.substring(0, ZFHaLDTC);
				c77x80PR = c77x80PR + PATH_SEPARATOR + TIvzKuld;
			} else {
				c77x80PR += META_DATA_FILE_SUFIX;
			}
		}
		if (!af5ZKb13.contains(PORT_SEPARATOR)) {
			af5ZKb13 += PORT_SEPARATOR + DEFAULT_PORT;
		}
		URL qAFIVaqS = new URL(PROTOCOL_PREFIX + FRwsC0Av + ":" + ts138q8I + "@" + af5ZKb13 + c77x80PR + ";type=i");
		URLConnection GfCK8bID = qAFIVaqS.openConnection(BackEnd.getProxy(Proxy.Type.SOCKS));
		GfCK8bID.setConnectTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		GfCK8bID.setReadTimeout(Preferences.getInstance().preferredTimeOut * 1000);
		ByteArrayOutputStream ko7wrdp3 = null;
		try {
			InputStream eoEWXWgM = GfCK8bID.getInputStream();
			ko7wrdp3 = new ByteArrayOutputStream();
			byte[] jP9ITfTO = new byte[1024];
			int HUUszGDU;
			while ((HUUszGDU = eoEWXWgM.read(jP9ITfTO)) > 0) {
				ko7wrdp3.write(jP9ITfTO, 0, HUUszGDU);
				if (!Tp68aJ9j) {
					RWg91gkQ += HUUszGDU;
					fgeYZSTW = System.currentTimeMillis() - OyB4n5Pi;
					fireOnProgressEvent(RWg91gkQ, fgeYZSTW);
				}
			}
			ko7wrdp3.close();
			eoEWXWgM.close();
		} catch (FileNotFoundException mGZFWm0B) {
		}
		return ko7wrdp3 != null ? ko7wrdp3.toByteArray() : null;
	}

}