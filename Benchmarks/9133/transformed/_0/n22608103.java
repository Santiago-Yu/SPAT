class n22608103 {
	public static boolean copyFile(File rc2Z8w9o, File RJOkWLmG) {
		FileChannel nG8UhLwD = null;
		FileChannel p01o5VJF = null;
		try {
			nG8UhLwD = new FileInputStream(rc2Z8w9o).getChannel();
			p01o5VJF = new FileOutputStream(RJOkWLmG).getChannel();
			long Hy6ueXW1 = 0;
			long sjjxNwli = nG8UhLwD.size();
			if (sjjxNwli > MAX_BLOCK_SIZE) {
				sjjxNwli = MAX_BLOCK_SIZE;
			}
			long ikSmSvFn = Long.MAX_VALUE;
			while (ikSmSvFn > 0) {
				ikSmSvFn = p01o5VJF.transferFrom(nG8UhLwD, Hy6ueXW1, sjjxNwli);
				Hy6ueXW1 = ikSmSvFn;
			}
		} catch (IOException V3bMmrnx) {
			return false;
		} finally {
			if (nG8UhLwD != null) {
				try {
					nG8UhLwD.close();
				} catch (IOException ruPcDiLo) {
				}
			}
			if (p01o5VJF != null) {
				try {
					p01o5VJF.close();
				} catch (IOException A6UeG7fD) {
				}
			}
		}
		return true;
	}

}