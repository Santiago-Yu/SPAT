class n2069219 {
	public static void copieFichier(File zVJS2LQl, File TEgnWCds) {
		FileChannel xEY5aLXo = null;
		FileChannel lTeGnDxv = null;
		try {
			xEY5aLXo = new FileInputStream(zVJS2LQl).getChannel();
			lTeGnDxv = new FileOutputStream(TEgnWCds).getChannel();
			xEY5aLXo.transferTo(0, xEY5aLXo.size(), lTeGnDxv);
		} catch (Exception sLsvAKLH) {
			sLsvAKLH.printStackTrace();
		} finally {
			if (xEY5aLXo != null) {
				try {
					xEY5aLXo.close();
				} catch (IOException chnxT7ps) {
				}
			}
			if (lTeGnDxv != null) {
				try {
					lTeGnDxv.close();
				} catch (IOException mtJurixm) {
				}
			}
		}
	}

}