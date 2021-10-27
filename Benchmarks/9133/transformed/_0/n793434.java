class n793434 {
	byte[] loadUrlByteArray(String Hw22Nx88, int ZKmd9JXo, int MWwZoVya) {
		byte[] qFUROZDf = new byte[MWwZoVya];
		try {
			URL KDADl7TA = new URL(waba.applet.Applet.currentApplet.getCodeBase(), Hw22Nx88);
			try {
				InputStream Mj0OVy6Y = KDADl7TA.openStream();
				if (MWwZoVya == 0) {
					int nyT2ZjjC = Mj0OVy6Y.available();
					qFUROZDf = new byte[nyT2ZjjC - ZKmd9JXo];
				}
				DataInputStream KTikLjPN = new DataInputStream(Mj0OVy6Y);
				try {
					KTikLjPN.skip(ZKmd9JXo);
					KTikLjPN.readFully(qFUROZDf);
				} catch (EOFException kkV2OnqY) {
					System.err.print(kkV2OnqY.getMessage());
				}
				Mj0OVy6Y.close();
			} catch (IOException koVkexYV) {
				System.err.print(koVkexYV.getMessage());
			}
		} catch (MalformedURLException CQAhPXIY) {
			System.err.print(CQAhPXIY.getMessage());
		}
		return qFUROZDf;
	}

}