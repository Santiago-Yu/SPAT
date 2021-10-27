class n3567574 {
	@Override
	protected String doInBackground(String... oOKNzdQj) {
		Bitmap qhv13Mk3 = null;
		if (oOKNzdQj.length == 0)
			return null;
		String FgJ5KugP = oOKNzdQj[0];
		url = FgJ5KugP;
		String xwBfjw02 = "";
		try {
			xwBfjw02 = md5(FgJ5KugP);
			File t3ClPZoN = context.getFileStreamPath(xwBfjw02 + FILE_EXT);
			if (t3ClPZoN.exists()) {
				return t3ClPZoN.getAbsolutePath();
			}
		} catch (FileNotFoundException R5vidHu7) {
		} catch (Exception cmprdBMm) {
		}
		InputStream dOHfPBVo = null;
		try {
			if (FgJ5KugP != null && url.indexOf("http://{HOST}:{PORT}") != -1) {
				FgJ5KugP = FgJ5KugP.replace("{HOST}", ConnectionHandler.host);
				FgJ5KugP = FgJ5KugP.replace("{PORT}", ConnectionHandler.port + "");
			}
			URL boHP0cJK = new URL(FgJ5KugP);
			URLConnection Isqlf4Fu = boHP0cJK.openConnection();
			Isqlf4Fu.connect();
			dOHfPBVo = Isqlf4Fu.getInputStream();
			qhv13Mk3 = BitmapFactory.decodeStream(dOHfPBVo);
		} catch (IOException Lt4zc7WA) {
			Log.i(TAG, "Download of image failed: " + Lt4zc7WA.getMessage());
		} finally {
			if (dOHfPBVo != null) {
				try {
					dOHfPBVo.close();
				} catch (IOException kf0B9CoC) {
				}
			}
		}
		if (qhv13Mk3 != null) {
			FileOutputStream c5y0tFOb = null;
			try {
				c5y0tFOb = context.openFileOutput(xwBfjw02 + FILE_EXT, Context.MODE_WORLD_READABLE);
				qhv13Mk3.compress(CompressFormat.JPEG, 90, c5y0tFOb);
			} catch (Exception uUhhqIp9) {
				Log.e(TAG, "Storage of image failed: " + uUhhqIp9.getMessage());
			} finally {
				if (c5y0tFOb != null) {
					try {
						c5y0tFOb.flush();
						c5y0tFOb.close();
					} catch (IOException klbSayXi) {
					}
				}
				if (qhv13Mk3 != null) {
					qhv13Mk3.recycle();
				}
			}
		}
		File wYPNIeTu = context.getFileStreamPath(xwBfjw02 + FILE_EXT);
		if (wYPNIeTu.exists()) {
			return wYPNIeTu.getAbsolutePath();
		}
		return null;
	}

}