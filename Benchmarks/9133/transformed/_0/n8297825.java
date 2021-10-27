class n8297825 {
	public void upload(String sMYWvVxZ, String tnlofpuc, String RqzCsIlC, String d3VxmQr3, File jvFoDAwN)
			throws MalformedURLException, IOException {
		if (sMYWvVxZ != null && d3VxmQr3 != null && jvFoDAwN != null) {
			StringBuffer swGixzoO = new StringBuffer("ftp://");
			if (tnlofpuc != null && RqzCsIlC != null) {
				swGixzoO.append(tnlofpuc);
				swGixzoO.append(':');
				swGixzoO.append(RqzCsIlC);
				swGixzoO.append('@');
			}
			swGixzoO.append(sMYWvVxZ);
			swGixzoO.append('/');
			swGixzoO.append(d3VxmQr3);
			swGixzoO.append(";type=i");
			BufferedInputStream ioRBc0vc = null;
			BufferedOutputStream z3vPMGNV = null;
			try {
				URL Uq4mHXb1 = new URL(swGixzoO.toString());
				URLConnection JRGVtJgs = Uq4mHXb1.openConnection();
				z3vPMGNV = new BufferedOutputStream(JRGVtJgs.getOutputStream());
				ioRBc0vc = new BufferedInputStream(new FileInputStream(jvFoDAwN));
				int thThtnW4;
				while ((thThtnW4 = ioRBc0vc.read()) != -1) {
					z3vPMGNV.write(thThtnW4);
				}
			} finally {
				if (ioRBc0vc != null)
					try {
						ioRBc0vc.close();
					} catch (IOException mq0ASEiN) {
						mq0ASEiN.printStackTrace();
					}
				if (z3vPMGNV != null)
					try {
						z3vPMGNV.close();
					} catch (IOException Uel47Xx3) {
						Uel47Xx3.printStackTrace();
					}
			}
		} else {
			System.out.println("Input not available.");
		}
	}

}