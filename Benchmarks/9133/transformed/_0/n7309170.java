class n7309170 {
	private void zip(File x8iQ4ZB3, File h8vs6Vx2) {
		OutputStream GcZFRZE0 = null;
		InputStream M2m3tt6I = null;
		try {
			GcZFRZE0 = new GZIPOutputStream(new FileOutputStream(h8vs6Vx2));
			M2m3tt6I = new FileInputStream(x8iQ4ZB3);
			byte[] nrpMdiTq = new byte[8192];
			for (int bA0aJW2l; (bA0aJW2l = M2m3tt6I.read(nrpMdiTq)) != -1;)
				GcZFRZE0.write(nrpMdiTq, 0, bA0aJW2l);
		} catch (IOException Sxvxn6Y0) {
			Sxvxn6Y0.printStackTrace();
		} finally {
			if (M2m3tt6I != null) {
				try {
					M2m3tt6I.close();
				} catch (IOException YMUXCKX3) {
					YMUXCKX3.printStackTrace();
				}
			}
			if (GcZFRZE0 != null) {
				try {
					GcZFRZE0.close();
				} catch (IOException SRgU6lvq) {
					SRgU6lvq.printStackTrace();
				}
			}
		}
	}

}