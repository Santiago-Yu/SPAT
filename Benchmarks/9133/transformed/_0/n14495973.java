class n14495973 {
	public static int copy(File nmZ4QtWj, int x3fhVPmQ, File u6emLftu) {
		final int lUIOy4Sv = 1024;
		int XDiG54DW = x3fhVPmQ;
		InputStream nutSM3uu = null;
		OutputStream B55QP9ES = null;
		try {
			nutSM3uu = new BufferedInputStream(new FileInputStream(nmZ4QtWj));
			B55QP9ES = new BufferedOutputStream(new FileOutputStream(u6emLftu));
			byte[] TFBBCAUr = new byte[lUIOy4Sv];
			while (XDiG54DW > 0) {
				int eDsr31MC = nutSM3uu.read(TFBBCAUr, 0, Math.min(lUIOy4Sv, XDiG54DW));
				if (eDsr31MC == -1)
					break;
				XDiG54DW -= eDsr31MC;
				B55QP9ES.write(TFBBCAUr, 0, eDsr31MC);
			}
		} catch (IOException borqX6eT) {
		} finally {
			if (nutSM3uu != null)
				try {
					nutSM3uu.close();
				} catch (IOException Cvm7Y3eY) {
				}
			if (B55QP9ES != null) {
				try {
					B55QP9ES.flush();
				} catch (IOException jiboH6DP) {
				}
				try {
					B55QP9ES.close();
				} catch (IOException T4WiV7oL) {
				}
			}
		}
		return x3fhVPmQ - XDiG54DW;
	}

}