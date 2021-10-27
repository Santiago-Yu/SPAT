class n19029279 {
	public static boolean copy(File Oos9o2rM, File eTU1FPy8, Override Kdgop97A) throws IOException {
		FileInputStream wgEeC4ru = null;
		FileOutputStream HiGqML1f = null;
		FileChannel BAY3UisC = null;
		FileChannel JgUkNlEE = null;
		if (Kdgop97A == null)
			Kdgop97A = Override.NEWER;
		switch (Kdgop97A) {
		case NEVER:
			if (eTU1FPy8.isFile())
				return false;
			break;
		case NEWER:
			if (eTU1FPy8.isFile() && (Oos9o2rM.lastModified() - LASTMODIFIED_DIFF_MILLIS) < eTU1FPy8.lastModified())
				return false;
			break;
		}
		eTU1FPy8.getParentFile().mkdirs();
		try {
			wgEeC4ru = new FileInputStream(Oos9o2rM);
			HiGqML1f = new FileOutputStream(eTU1FPy8);
			BAY3UisC = wgEeC4ru.getChannel();
			JgUkNlEE = HiGqML1f.getChannel();
			long U0meVipx = 0L;
			long CyiYUnfs = BAY3UisC.size();
			while (U0meVipx < CyiYUnfs) {
				long ELv8gJ5B = Math.min(MAX_IO_CHUNK_SIZE, CyiYUnfs - U0meVipx);
				U0meVipx += JgUkNlEE.transferFrom(BAY3UisC, U0meVipx, ELv8gJ5B);
			}
			eTU1FPy8.setLastModified(Oos9o2rM.lastModified());
			return true;
		} finally {
			CommonUtils.close(BAY3UisC);
			CommonUtils.close(JgUkNlEE);
			CommonUtils.close(HiGqML1f);
			CommonUtils.close(wgEeC4ru);
		}
	}

}