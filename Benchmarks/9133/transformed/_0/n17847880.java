class n17847880 {
	public static boolean saveToTempFile(Context A5XjVNZI, String US0fBNs4, DirType xiFWfq4C, String FpbO1TiZ,
			boolean LOrDUFOz) {
		FileOutputStream sDWITMj7 = null;
		InputStream a2BYThnL = null;
		byte[] kAP0uq8r = new byte[1024];
		int cNQDVQkK = 0;
		boolean BnyhewFw = false;
		try {
			try {
				File t1U7CNpL = new File(A5XjVNZI.getFilesDir().getAbsolutePath() + File.separator + FpbO1TiZ);
				if (t1U7CNpL.exists()) {
					A5XjVNZI.deleteFile(FpbO1TiZ);
				}
			} catch (Exception MacoMIDH) {
				MacoMIDH.printStackTrace();
			}
			sDWITMj7 = A5XjVNZI.openFileOutput(FpbO1TiZ, Context.MODE_WORLD_READABLE);
			logger.error("tempfile:" + FpbO1TiZ);
			if (xiFWfq4C == DirType.assets) {
				AssetManager lATBRa5x = A5XjVNZI.getAssets();
				a2BYThnL = lATBRa5x.open(US0fBNs4);
			} else if (xiFWfq4C == DirType.file && Constant.getUpdateDataPath() != null) {
				a2BYThnL = new FileInputStream(Constant.getUpdateDataPath() + File.separator + US0fBNs4);
			} else if (xiFWfq4C == DirType.sd && Constant.getSdPath() != null) {
				a2BYThnL = new FileInputStream(Constant.getSdPath() + File.separator + US0fBNs4);
			} else if (xiFWfq4C == DirType.extSd && Constant.getExtSdPath() != null) {
				a2BYThnL = new FileInputStream(Constant.getExtSdPath() + File.separator + US0fBNs4);
			}
			if (a2BYThnL == null) {
				return false;
			}
			cNQDVQkK = a2BYThnL.read(kAP0uq8r);
			if (cNQDVQkK >= ZipToFile.encrypLength && LOrDUFOz) {
				byte[] t2ZZlCn0 = new byte[ZipToFile.encrypLength];
				System.arraycopy(kAP0uq8r, 0, t2ZZlCn0, 0, ZipToFile.encrypLength);
				byte[] ujgCgsis = CryptionControl.getInstance().decryptECB(t2ZZlCn0, ZipToFile.rootKey);
				System.arraycopy(ujgCgsis, 0, kAP0uq8r, 0, ZipToFile.encrypLength);
			}
			while (cNQDVQkK > 0) {
				sDWITMj7.write(kAP0uq8r, 0, cNQDVQkK);
				sDWITMj7.flush();
				cNQDVQkK = a2BYThnL.read(kAP0uq8r);
			}
			BnyhewFw = true;
		} catch (Exception NQlzXV0a) {
			NQlzXV0a.printStackTrace();
		} finally {
			if (sDWITMj7 != null) {
				try {
					sDWITMj7.flush();
					sDWITMj7.close();
				} catch (Exception qjaeFv94) {
				}
			}
			if (a2BYThnL != null) {
				try {
					a2BYThnL.close();
				} catch (Exception VtH3zYIl) {
				}
			}
		}
		return BnyhewFw;
	}

}