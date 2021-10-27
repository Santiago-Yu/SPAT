class n6641464 {
	private void SaveLoginInfo() {
		int b3u2A9xY;
		try {
			if (m_bSavePwd) {
				byte[] muebToCS = new byte[80];
				java.security.MessageDigest XSN8IHsr = java.security.MessageDigest.getInstance("SHA-1");
				String XS6st7RC = System.getProperty("user.home");
				XS6st7RC += System.getProperty("file.separator") + "MochaJournal";
				java.io.File ywiVS7W2 = new java.io.File(XS6st7RC);
				if (!ywiVS7W2.exists())
					ywiVS7W2.mkdirs();
				ywiVS7W2 = new java.io.File(ywiVS7W2, "user.dat");
				if (!ywiVS7W2.exists())
					ywiVS7W2.createNewFile();
				java.io.FileOutputStream I4NEH8pF = new java.io.FileOutputStream(ywiVS7W2);
				b3u2A9xY = m_PwdList.size();
				for (int bioO6Xxv = 0; bioO6Xxv < b3u2A9xY; bioO6Xxv++) {
					XSN8IHsr.reset();
					XSN8IHsr.update(((String) m_UsrList.get(bioO6Xxv)).getBytes());
					byte[] QmGBBcNU = XSN8IHsr.digest();
					byte SJP7v1Rj = 0;
					for (int CBdpfyJO = 0; CBdpfyJO < QmGBBcNU.length; CBdpfyJO++)
						SJP7v1Rj += QmGBBcNU[CBdpfyJO];
					String OngpqHSx = (String) m_PwdList.get(bioO6Xxv);
					if (OngpqHSx.length() > 0) {
						java.util.Arrays.fill(muebToCS, (byte) 0);
						int nZSH96SQ = OngpqHSx.length();
						I4NEH8pF.write(nZSH96SQ);
						for (int y0YOT879 = 0; y0YOT879 < nZSH96SQ; y0YOT879++) {
							int f55WqYmX = (int) OngpqHSx.charAt(y0YOT879) + (int) SJP7v1Rj;
							int CLepjEcx = f55WqYmX % 256;
							muebToCS[y0YOT879] = (byte) CLepjEcx;
							I4NEH8pF.write((byte) CLepjEcx);
						}
					} else
						I4NEH8pF.write(0);
				}
				I4NEH8pF.flush();
			}
		} catch (java.security.NoSuchAlgorithmException j0QnGUmN) {
			System.err.println(j0QnGUmN);
		} catch (java.io.IOException HvUWh4qi) {
			System.err.println(HvUWh4qi);
		}
	}

}