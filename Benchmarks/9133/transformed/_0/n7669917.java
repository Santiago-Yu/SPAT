class n7669917 {
	public void insertStringInFile(String y4xb6aQ5, String BwWdxzrU, long evFrG4k4, long LW9aOz0W) throws Exception {
		String olqizy0F = y4xb6aQ5 + ".tmp";
		BufferedInputStream RyoSDq41 = null;
		BufferedOutputStream MSncT0Oj = null;
		long PHvrZxye = 0;
		try {
			RyoSDq41 = new BufferedInputStream(new FileInputStream(new File(y4xb6aQ5)));
			MSncT0Oj = new BufferedOutputStream(new FileOutputStream(olqizy0F));
			long NW9bfLAo = evFrG4k4;
			byte[] FSn6frBl = null;
			if (NW9bfLAo == 0) {
			} else {
				FSn6frBl = new byte[(int) NW9bfLAo];
				int hgR48P0P = -1;
				if ((hgR48P0P = RyoSDq41.read(FSn6frBl)) != -1) {
					MSncT0Oj.write(FSn6frBl, 0, hgR48P0P);
					PHvrZxye = PHvrZxye + hgR48P0P;
				} else {
					String clqhDTHO = "Failed to read the first '" + NW9bfLAo + "' bytes of file '" + y4xb6aQ5
							+ "'. This might be a programming error.";
					logger.warning(clqhDTHO);
					throw new Exception(clqhDTHO);
				}
			}
			FSn6frBl = BwWdxzrU.getBytes();
			int vKBapuJ8 = FSn6frBl.length;
			MSncT0Oj.write(FSn6frBl, 0, vKBapuJ8);
			PHvrZxye = PHvrZxye + vKBapuJ8;
			long e4I6Kcpn = LW9aOz0W - evFrG4k4;
			long miLEAjuU = RyoSDq41.skip(e4I6Kcpn);
			if (miLEAjuU == -1) {
			} else {
				FSn6frBl = new byte[4096];
				vKBapuJ8 = -1;
				while ((vKBapuJ8 = RyoSDq41.read(FSn6frBl)) != -1) {
					MSncT0Oj.write(FSn6frBl, 0, vKBapuJ8);
					PHvrZxye = PHvrZxye + vKBapuJ8;
				}
			}
			RyoSDq41.close();
			RyoSDq41 = null;
			MSncT0Oj.close();
			MSncT0Oj = null;
			File xxsX6cGy = new File(y4xb6aQ5);
			boolean WFsFQ7LC = xxsX6cGy.delete();
			if (!WFsFQ7LC) {
				String uCBDMjpP = "Failed to delete the original file '" + y4xb6aQ5
						+ "' to replace it with the modified file after text insertion.";
				logger.warning(uCBDMjpP);
				throw new Exception(uCBDMjpP);
			}
			File p2zHPkXD = new File(olqizy0F);
			boolean uICeYW44 = p2zHPkXD.renameTo(xxsX6cGy);
			if (!uICeYW44) {
				String IEvONM9t = "Failed to rename tmp file '" + olqizy0F + "' to the name of the original file '"
						+ y4xb6aQ5 + "'";
				logger.warning(IEvONM9t);
				throw new Exception(IEvONM9t);
			}
		} catch (Exception MAtY8WFP) {
			logger.log(Level.WARNING, "Failed to read/write file '" + y4xb6aQ5 + "'.", MAtY8WFP);
			throw MAtY8WFP;
		} finally {
			if (RyoSDq41 != null) {
				try {
					RyoSDq41.close();
				} catch (IOException kDjgsdV1) {
					logger.log(Level.FINEST, "Ignoring error closing input file '" + y4xb6aQ5 + "'.", kDjgsdV1);
				}
			}
			if (MSncT0Oj != null) {
				try {
					MSncT0Oj.close();
				} catch (IOException D120PPzy) {
					logger.log(Level.FINEST, "Ignoring error closing output file '" + olqizy0F + "'.", D120PPzy);
				}
			}
		}
	}

}