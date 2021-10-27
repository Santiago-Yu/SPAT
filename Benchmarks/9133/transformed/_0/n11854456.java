class n11854456 {
	public static int copy(File zjO4FW1T, int l7yXqENl, File CgXGEfVa) {
		final int lgEbkh4e = 1024;
		int EwRHc0tI = l7yXqENl;
		boolean onF8oXrn = true;
		InputStream G5F15Qr8 = null;
		OutputStream IUwrIK96 = null;
		try {
			G5F15Qr8 = new BufferedInputStream(new FileInputStream(zjO4FW1T));
			IUwrIK96 = new BufferedOutputStream(new FileOutputStream(CgXGEfVa));
			byte[] bCPjfqvy = new byte[lgEbkh4e];
			while (EwRHc0tI > 0) {
				int OktRWpZK = G5F15Qr8.read(bCPjfqvy, 0, Math.min(lgEbkh4e, EwRHc0tI));
				if (OktRWpZK == -1)
					break;
				EwRHc0tI -= OktRWpZK;
				IUwrIK96.write(bCPjfqvy, 0, OktRWpZK);
			}
		} catch (IOException nPPACdKm) {
		} finally {
			if (G5F15Qr8 != null)
				try {
					G5F15Qr8.close();
				} catch (IOException zw8T1VOv) {
				}
			if (IUwrIK96 != null) {
				try {
					IUwrIK96.flush();
				} catch (IOException q2zpW8z7) {
				}
				try {
					IUwrIK96.close();
				} catch (IOException CVWB9Nr7) {
				}
			}
		}
		return l7yXqENl - EwRHc0tI;
	}

}