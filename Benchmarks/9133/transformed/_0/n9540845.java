class n9540845 {
	static void copy(String rxWo1YeV, String mWOUWf9F) throws IOException {
		InputStream XLvqzZe0 = null;
		OutputStream v2p7gwu3 = null;
		try {
			XLvqzZe0 = new FileInputStream(rxWo1YeV);
			v2p7gwu3 = new FileOutputStream(mWOUWf9F);
			byte[] DpeiJYoY = new byte[1024];
			int xDt01haT;
			while ((xDt01haT = XLvqzZe0.read(DpeiJYoY)) >= 0)
				v2p7gwu3.write(DpeiJYoY, 0, xDt01haT);
		} finally {
			closeIgnoringException(XLvqzZe0);
			closeIgnoringException(v2p7gwu3);
		}
	}

}