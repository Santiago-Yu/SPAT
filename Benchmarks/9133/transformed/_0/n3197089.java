class n3197089 {
	public void insertStringInFile(String dgmvEK8s, String X6sXuFDb, long EzRasSlG, long TzcHSDNI) throws Exception {
		String YGtzK7Ir = dgmvEK8s + ".tmp";
		BufferedInputStream NIlupF37 = null;
		BufferedOutputStream iufPrgV7 = null;
		long OWebWzIC = 0;
		try {
			NIlupF37 = new BufferedInputStream(new FileInputStream(new File(dgmvEK8s)));
			iufPrgV7 = new BufferedOutputStream(new FileOutputStream(YGtzK7Ir));
			long MMqvh8Lm = EzRasSlG;
			byte[] zLoY5KIW = null;
			if (MMqvh8Lm == 0) {
			} else {
				zLoY5KIW = new byte[(int) MMqvh8Lm];
				int mKqfwGMG = -1;
				if ((mKqfwGMG = NIlupF37.read(zLoY5KIW)) != -1) {
					iufPrgV7.write(zLoY5KIW, 0, mKqfwGMG);
					OWebWzIC = OWebWzIC + mKqfwGMG;
				} else {
					String iUTfoR4o = "Failed to read the first '" + MMqvh8Lm + "' bytes of file '" + dgmvEK8s
							+ "'. This might be a programming error.";
					logger.warning(iUTfoR4o);
					throw new Exception(iUTfoR4o);
				}
			}
			zLoY5KIW = X6sXuFDb.getBytes();
			int jCrpZIra = zLoY5KIW.length;
			iufPrgV7.write(zLoY5KIW, 0, jCrpZIra);
			OWebWzIC = OWebWzIC + jCrpZIra;
			long CkcpbkO4 = TzcHSDNI - EzRasSlG;
			long A26SGUY5 = NIlupF37.skip(CkcpbkO4);
			if (A26SGUY5 == -1) {
			} else {
				zLoY5KIW = new byte[4096];
				jCrpZIra = -1;
				while ((jCrpZIra = NIlupF37.read(zLoY5KIW)) != -1) {
					iufPrgV7.write(zLoY5KIW, 0, jCrpZIra);
					OWebWzIC = OWebWzIC + jCrpZIra;
				}
			}
			NIlupF37.close();
			NIlupF37 = null;
			iufPrgV7.close();
			iufPrgV7 = null;
			File lFICejth = new File(dgmvEK8s);
			boolean TLA1a3XB = lFICejth.delete();
			if (!TLA1a3XB) {
				String y45IUmD7 = "Failed to delete the original file '" + dgmvEK8s
						+ "' to replace it with the modified file after text insertion.";
				logger.warning(y45IUmD7);
				throw new Exception(y45IUmD7);
			}
			File nOp9XOMX = new File(YGtzK7Ir);
			boolean TZ8ybZoz = nOp9XOMX.renameTo(lFICejth);
			if (!TZ8ybZoz) {
				String RIEG8sez = "Failed to rename tmp file '" + YGtzK7Ir + "' to the name of the original file '"
						+ dgmvEK8s + "'";
				logger.warning(RIEG8sez);
				throw new Exception(RIEG8sez);
			}
		} catch (Exception ATBIBnj9) {
			logger.log(Level.WARNING, "Failed to read/write file '" + dgmvEK8s + "'.", ATBIBnj9);
			throw ATBIBnj9;
		} finally {
			if (NIlupF37 != null) {
				try {
					NIlupF37.close();
				} catch (IOException e6DMhpb8) {
					logger.log(Level.FINEST, "Ignoring error closing input file '" + dgmvEK8s + "'.", e6DMhpb8);
				}
			}
			if (iufPrgV7 != null) {
				try {
					iufPrgV7.close();
				} catch (IOException BlukmIwk) {
					logger.log(Level.FINEST, "Ignoring error closing output file '" + YGtzK7Ir + "'.", BlukmIwk);
				}
			}
		}
	}

}