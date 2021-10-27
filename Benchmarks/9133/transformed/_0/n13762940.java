class n13762940 {
	public static File downloadFile(Proxy H61nBBIZ, URL BchgfuBF, File Y2YNAMns) throws IOException {
		URLConnection uSfqTO5a = null;
		if (null == H61nBBIZ) {
			uSfqTO5a = BchgfuBF.openConnection();
		} else {
			uSfqTO5a = BchgfuBF.openConnection(H61nBBIZ);
		}
		uSfqTO5a.connect();
		File yqtVTrHP = null;
		if (uSfqTO5a instanceof HttpURLConnection) {
			HttpURLConnection HICA33Sa = (HttpURLConnection) uSfqTO5a;
			String vQDfmCPf = null;
			String guNtWMzA = HICA33Sa.getHeaderField("Content-Disposition");
			if (null == guNtWMzA) {
				String rGlWcPMC = BchgfuBF.toString();
				int M4XPYToV = rGlWcPMC.lastIndexOf("/");
				vQDfmCPf = rGlWcPMC.substring(M4XPYToV + 1);
			} else {
				int qg4JCuRv = guNtWMzA.indexOf("filename=");
				vQDfmCPf = guNtWMzA.substring(qg4JCuRv).replace("\"", "").trim();
			}
			yqtVTrHP = new File(Y2YNAMns, vQDfmCPf);
		} else {
			yqtVTrHP = new File(Y2YNAMns, "downloadfile" + BchgfuBF.toString().hashCode());
		}
		if (yqtVTrHP.exists()) {
			return yqtVTrHP;
		}
		FileOutputStream oILb846Q = new FileOutputStream(yqtVTrHP);
		byte[] PjWPnzmm = new byte[2048];
		try {
			while (true) {
				int x7x6nGHr = uSfqTO5a.getInputStream().read(PjWPnzmm);
				if (x7x6nGHr < 0) {
					break;
				} else {
					oILb846Q.write(PjWPnzmm, 0, x7x6nGHr);
				}
			}
			oILb846Q.close();
		} catch (IOException hpp2aWZV) {
			yqtVTrHP.delete();
			throw hpp2aWZV;
		}
		return yqtVTrHP;
	}

}