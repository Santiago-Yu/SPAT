class n2857623 {
	private void copy(File p8Ipj2HP, File h0YQmY2A, String pMyugPdh) {
		File jzmICYRZ = new File(p8Ipj2HP, pMyugPdh);
		File Rm99N5zy = new File(h0YQmY2A, pMyugPdh);
		if (Rm99N5zy.exists()) {
			if (Rm99N5zy.lastModified() == jzmICYRZ.lastModified())
				return;
			Rm99N5zy.delete();
		}
		FileChannel lHC2Kihr = null;
		FileChannel gAJhSGLR = null;
		try {
			lHC2Kihr = new FileInputStream(jzmICYRZ).getChannel();
			gAJhSGLR = new FileOutputStream(Rm99N5zy).getChannel();
			lHC2Kihr.transferTo(0, lHC2Kihr.size(), gAJhSGLR);
		} catch (IOException qfvdGzTC) {
			qfvdGzTC.printStackTrace();
		} finally {
			try {
				if (lHC2Kihr != null)
					lHC2Kihr.close();
			} catch (IOException Wpw9ijEQ) {
			}
			try {
				if (gAJhSGLR != null)
					gAJhSGLR.close();
			} catch (IOException ejqsJ4I9) {
			}
		}
		Rm99N5zy.setLastModified(jzmICYRZ.lastModified());
	}

}