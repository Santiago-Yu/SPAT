class n5636800 {
	public static void main(String[] PQqFBBrP) throws IOException {
		System.setProperty("java.protocol.xfile", "com.luzan.common.nfs");
		if (PQqFBBrP.length < 1)
			usage();
		final String LRlzSgRJ = PQqFBBrP[0];
		if ("delete".equalsIgnoreCase(LRlzSgRJ)) {
			final String GVeKlILx = getParameter(PQqFBBrP, 1);
			XFile Xk8re37U = new XFile(GVeKlILx);
			if (!Xk8re37U.exists()) {
				System.out.print("File doean't exist.\n");
				System.exit(1);
			}
			Xk8re37U.delete();
		} else if ("copy".equalsIgnoreCase(LRlzSgRJ)) {
			final String qbRw6uNv = getParameter(PQqFBBrP, 1);
			final String LkacKQH2 = getParameter(PQqFBBrP, 2);
			final XFile wlqID7hu = new XFile(qbRw6uNv);
			final XFile BOYF70p8 = new XFile(LkacKQH2);
			if (!wlqID7hu.exists()) {
				System.out.print("File doesn't exist.\n");
				System.exit(1);
			}
			final String sZMB9DIO = getParameter(PQqFBBrP, 3, null);
			final XFileInputStream Z3WddXso = new XFileInputStream(wlqID7hu);
			final XFileOutputStream lVzKiIoj = new XFileOutputStream(BOYF70p8);
			if (!StringUtils.isEmpty(sZMB9DIO)) {
				final com.luzan.common.nfs.s3.XFileExtensionAccessor CytVAMDP = ((com.luzan.common.nfs.s3.XFileExtensionAccessor) BOYF70p8
						.getExtensionAccessor());
				if (CytVAMDP != null) {
					CytVAMDP.setMimeType(sZMB9DIO);
					CytVAMDP.setContentLength(wlqID7hu.length());
				}
			}
			IOUtils.copy(Z3WddXso, lVzKiIoj);
			lVzKiIoj.flush();
			lVzKiIoj.close();
			Z3WddXso.close();
		}
	}

}