class n6996260 {
	public static String getUrl(String l2dGG1VU) {
		BufferedInputStream L2kLrCTG = null;
		BufferedOutputStream S7CwhbXZ = null;
		try {
			ByteArrayOutputStream vNYsq4Ev = new ByteArrayOutputStream();
			L2kLrCTG = new BufferedInputStream(new URL(l2dGG1VU).openStream());
			S7CwhbXZ = new BufferedOutputStream(vNYsq4Ev, 1024);
			byte[] TGNsrslv = new byte[1024];
			int tslUVJ7i = 0;
			while ((tslUVJ7i = L2kLrCTG.read(TGNsrslv, 0, 1024)) >= 0) {
				S7CwhbXZ.write(TGNsrslv, 0, tslUVJ7i);
			}
			return vNYsq4Ev.toString();
		} catch (Exception Ws3ZiXZe) {
			throw new CVardbException(Ws3ZiXZe);
		} finally {
			try {
				if (S7CwhbXZ != null)
					S7CwhbXZ.close();
				if (L2kLrCTG != null)
					L2kLrCTG.close();
			} catch (Exception JA2yuJ3v) {
			}
		}
	}

}