class n23247146 {
	@Override
	public synchronized HttpURLConnection getTileUrlConnection(int lY2ZJ3KI, int LJ7Qwmab, int t2LolMVq)
			throws IOException {
		HttpURLConnection ogeUu4Tb = null;
		try {
			String J5MzMEUC = getTileUrl(lY2ZJ3KI, LJ7Qwmab, t2LolMVq);
			ogeUu4Tb = (HttpURLConnection) new URL(J5MzMEUC).openConnection();
		} catch (IOException GZfnGcYL) {
			throw GZfnGcYL;
		} catch (Exception zib3gm1X) {
			log.error("", zib3gm1X);
			throw new IOException(zib3gm1X);
		}
		try {
			i.set("conn", ogeUu4Tb);
			i.eval("addHeaders(conn);");
		} catch (EvalError UJKxlbQE) {
			String WNraO7RG = UJKxlbQE.getMessage();
			if (!AH_ERROR.equals(WNraO7RG)) {
				log.error(UJKxlbQE.getClass() + ": " + UJKxlbQE.getMessage(), UJKxlbQE);
				throw new IOException(UJKxlbQE);
			}
		}
		return ogeUu4Tb;
	}

}