class n7327832 {
	@Override
	protected File doInBackground(String... R7EBxcWv) {
		try {
			String HfbxgoKM = R7EBxcWv[0];
			final String bjYdr7oC = R7EBxcWv[1];
			if (!HfbxgoKM.endsWith("/")) {
				HfbxgoKM += "/";
			}
			HfbxgoKM += "apk/" + bjYdr7oC;
			URL KKzKdKm3 = new URL(HfbxgoKM);
			URLConnection QiDEDhwu = KKzKdKm3.openConnection();
			QiDEDhwu.connect();
			File DWyxmthz = new File(Environment.getExternalStorageDirectory(), "imogenemarket");
			DWyxmthz.mkdirs();
			File yyPFn32J = new File(DWyxmthz, bjYdr7oC);
			if (yyPFn32J.exists()) {
				yyPFn32J.delete();
			}
			yyPFn32J.createNewFile();
			InputStream PKXcNQB7 = new BufferedInputStream(KKzKdKm3.openStream());
			OutputStream UFmDs4rd = new FileOutputStream(yyPFn32J);
			byte MnqD51Ok[] = new byte[1024];
			int jkJPHkSi;
			int Z0dHPfB4 = 0;
			while ((jkJPHkSi = PKXcNQB7.read(MnqD51Ok)) != -1) {
				if (isCancelled()) {
					break;
				}
				Z0dHPfB4 += jkJPHkSi;
				if (!mLocker.isLocked()) {
					publishProgress(Z0dHPfB4);
					Z0dHPfB4 = 0;
					mLocker.lock();
				}
				UFmDs4rd.write(MnqD51Ok, 0, jkJPHkSi);
			}
			mLocker.cancel();
			publishProgress(Z0dHPfB4);
			UFmDs4rd.flush();
			UFmDs4rd.close();
			PKXcNQB7.close();
			if (isCancelled()) {
				yyPFn32J.delete();
				return null;
			}
			return yyPFn32J;
		} catch (Exception r3mffCzH) {
			r3mffCzH.printStackTrace();
		}
		return null;
	}

}