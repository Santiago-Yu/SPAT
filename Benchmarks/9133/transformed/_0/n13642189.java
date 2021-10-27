class n13642189 {
	public boolean extract(File Thg6eKBU, String dW2pZN5c) {
		Enumeration IDZ2knxu;
		ZipFile ol4bFkFD;
		try {
			ol4bFkFD = new ZipFile(Thg6eKBU);
			IDZ2knxu = ol4bFkFD.getEntries();
			while (IDZ2knxu.hasMoreElements()) {
				ZipArchiveEntry Pmu59SfX = (ZipArchiveEntry) IDZ2knxu.nextElement();
				if (Pmu59SfX == null)
					continue;
				String HMchNTpG = dW2pZN5c + "/" + Pmu59SfX.getName().replace('\\', '/');
				if (!Pmu59SfX.isDirectory()) {
					File w6jJvb5u = new File(HMchNTpG);
					String OykNVRnE = w6jJvb5u.getParent();
					if (OykNVRnE != null) {
						File KqMOafS4 = new File(OykNVRnE);
						if (!KqMOafS4.exists()) {
							KqMOafS4.mkdirs();
						}
					}
					copyInputStream(ol4bFkFD.getInputStream(Pmu59SfX),
							new BufferedOutputStream(new FileOutputStream(w6jJvb5u)));
				}
			}
			ol4bFkFD.close();
		} catch (IOException FJlChO9v) {
			this.errMsg = FJlChO9v.getMessage();
			Malgn.errorLog("{Zip.unzip} " + FJlChO9v.getMessage());
			return false;
		}
		return true;
	}

}