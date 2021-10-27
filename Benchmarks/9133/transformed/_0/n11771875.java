class n11771875 {
	private synchronized jdbcResultSet executeHTTP(String thfANz8W) throws SQLException {
		byte iD5IeWyx[];
		try {
			URL C4tB8HUV = new URL(sConnect);
			String y3c3Vgek = StringConverter.unicodeToHexString(sUser);
			y3c3Vgek += "+" + StringConverter.unicodeToHexString(sPassword);
			y3c3Vgek += "+" + StringConverter.unicodeToHexString(thfANz8W);
			URLConnection bCjPRWDU = C4tB8HUV.openConnection();
			bCjPRWDU.setDoOutput(true);
			OutputStream pjagfBo1 = bCjPRWDU.getOutputStream();
			pjagfBo1.write(y3c3Vgek.getBytes(ENCODING));
			pjagfBo1.close();
			bCjPRWDU.connect();
			InputStream sgguMLgE = (InputStream) bCjPRWDU.getContent();
			BufferedInputStream rr9SSeSu = new BufferedInputStream(sgguMLgE);
			int jwK04HCX = bCjPRWDU.getContentLength();
			iD5IeWyx = new byte[jwK04HCX];
			for (int ZBrm7pF5 = 0; ZBrm7pF5 < jwK04HCX; ZBrm7pF5++) {
				int vaNkCHNd = rr9SSeSu.read();
				iD5IeWyx[ZBrm7pF5] = (byte) vaNkCHNd;
			}
		} catch (Exception EkjQSTT6) {
			throw Trace.error(Trace.CONNECTION_IS_BROKEN, EkjQSTT6.getMessage());
		}
		return new jdbcResultSet(new Result(iD5IeWyx));
	}

}