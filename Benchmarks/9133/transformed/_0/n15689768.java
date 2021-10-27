class n15689768 {
	protected void channelConnected() throws IOException {
		MessageDigest nXVAhJCg = null;
		String CstLjh3E = "";
		try {
			String GlFORXCd = nateon.getUserId();
			if (GlFORXCd.endsWith("@nate.com"))
				GlFORXCd = GlFORXCd.substring(0, GlFORXCd.lastIndexOf('@'));
			nXVAhJCg = MessageDigest.getInstance("MD5");
			nXVAhJCg.update(nateon.getPassword().getBytes());
			nXVAhJCg.update(GlFORXCd.getBytes());
			byte[] tZflIGva = nXVAhJCg.digest();
			StringBuilder DELx5Krc = new StringBuilder();
			for (byte CgoB530T : tZflIGva) {
				int DY12xOS6 = (int) CgoB530T;
				DY12xOS6 = DY12xOS6 < 0 ? DY12xOS6 + 0x100 : DY12xOS6;
				String JDR4T8hL = Integer.toHexString(DY12xOS6);
				if (JDR4T8hL.length() == 1)
					DELx5Krc.append('0');
				DELx5Krc.append(JDR4T8hL);
			}
			CstLjh3E = DELx5Krc.toString();
		} catch (Exception QIDy2eTg) {
			QIDy2eTg.printStackTrace();
		}
		NateOnMessage d0dY0SHr = new NateOnMessage("LSIN");
		d0dY0SHr.add(nateon.getUserId()).add(CstLjh3E).add("MD5").add("3.615");
		d0dY0SHr.setCallback("processAuth");
		writeMessage(d0dY0SHr);
	}

}