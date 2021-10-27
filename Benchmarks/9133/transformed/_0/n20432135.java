class n20432135 {
	public void copyNIO(File Sih166Mx, File kkJgYKyW) throws IOException {
		FileInputStream qR7fe48a = null;
		FileOutputStream fwJnrZKl = null;
		FileChannel VNnLiD4p = null;
		FileChannel WgBR7XlY = null;
		try {
			qR7fe48a = new FileInputStream(Sih166Mx);
			fwJnrZKl = new FileOutputStream(kkJgYKyW);
			VNnLiD4p = qR7fe48a.getChannel();
			WgBR7XlY = fwJnrZKl.getChannel();
			WgBR7XlY.transferFrom(VNnLiD4p, 0, VNnLiD4p.size());
		} finally {
			if (VNnLiD4p != null)
				VNnLiD4p.close();
			if (WgBR7XlY != null)
				WgBR7XlY.close();
			if (qR7fe48a != null)
				qR7fe48a.close();
			if (fwJnrZKl != null)
				fwJnrZKl.close();
		}
	}

}