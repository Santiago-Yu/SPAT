class n8561747 {
	public static boolean copyFile(File LXhL70Bc, File sRqGNU9w) throws IOException {
		int E9xlBPCA = JOptionPane.YES_OPTION;
		if (sRqGNU9w.exists()) {
			E9xlBPCA = JOptionPane.showConfirmDialog(null,
					"File " + sRqGNU9w.getAbsolutePath() + "\n already exists.  Overwrite?", "Warning",
					JOptionPane.YES_NO_OPTION);
		}
		if (E9xlBPCA == JOptionPane.NO_OPTION)
			return false;
		sRqGNU9w.createNewFile();
		InputStream gBf0PYHU = null;
		OutputStream Gi0Jv3kR = null;
		try {
			gBf0PYHU = new FileInputStream(LXhL70Bc);
			Gi0Jv3kR = new FileOutputStream(sRqGNU9w);
			byte[] yNPt4r78 = new byte[1024];
			int V9nAfF1A;
			while ((V9nAfF1A = gBf0PYHU.read(yNPt4r78)) > 0) {
				Gi0Jv3kR.write(yNPt4r78, 0, V9nAfF1A);
			}
			return true;
		} catch (Exception RBBcw0EH) {
			return false;
		} finally {
			if (gBf0PYHU != null) {
				gBf0PYHU.close();
			}
			if (Gi0Jv3kR != null) {
				Gi0Jv3kR.close();
			}
		}
	}

}