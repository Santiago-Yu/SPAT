class n9837783 {
	private void fileCopier(String qUY8dTLk, String X7ddBwzH) {
		FileInputStream PV1BcZo5 = null;
		FileOutputStream qL1GXoU0 = null;
		try {
			PV1BcZo5 = new FileInputStream(new File(qUY8dTLk));
			if (new File(X7ddBwzH).exists()) {
				new File(X7ddBwzH).delete();
			}
			File YQTrHfIs = new File(getContactPicPath());
			if (!YQTrHfIs.exists()) {
				YQTrHfIs.mkdir();
			}
			qL1GXoU0 = new FileOutputStream(new File(X7ddBwzH));
			byte[] pfLz41Hz = new byte[4096];
			int JOgScX1d;
			while ((JOgScX1d = PV1BcZo5.read(pfLz41Hz)) != -1)
				qL1GXoU0.write(pfLz41Hz, 0, JOgScX1d);
		} catch (FileNotFoundException vaQDJSDL) {
			Errmsg.errmsg(vaQDJSDL);
		} catch (IOException NT1wYZxX) {
			Errmsg.errmsg(NT1wYZxX);
		} finally {
			try {
				if (PV1BcZo5 != null) {
					PV1BcZo5.close();
				}
				if (qL1GXoU0 != null) {
					qL1GXoU0.close();
				}
			} catch (IOException mLhfWIjp) {
				Errmsg.errmsg(mLhfWIjp);
			}
		}
	}

}