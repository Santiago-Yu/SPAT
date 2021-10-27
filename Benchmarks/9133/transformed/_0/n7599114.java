class n7599114 {
	private static byte[] readBytes(URL LSBUB6QS) throws IOException {
		ByteArrayOutputStream MAifmACi = new ByteArrayOutputStream();
		byte[] vd8ROcBm = new byte[8192];
		InputStream DirPHdkt = LSBUB6QS.openStream();
		try {
			int Puepl5Ho;
			while ((Puepl5Ho = DirPHdkt.read(vd8ROcBm)) > 0)
				MAifmACi.write(vd8ROcBm, 0, Puepl5Ho);
		} finally {
			DirPHdkt.close();
		}
		return MAifmACi.toByteArray();
	}

}