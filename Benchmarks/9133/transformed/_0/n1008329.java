class n1008329 {
	public long copyFile(String bS8r0BCU, String xIpFuZw2, String xrHcif5p) throws Exception {
		long cIL70Bgy = 0;
		if (!bS8r0BCU.endsWith(sep)) {
			bS8r0BCU += sep;
		}
		BufferedInputStream i9LNazXO = null;
		BufferedOutputStream qc3u5fwQ = null;
		byte v4Eztr1t[] = new byte[bufferSize];
		String K9kP4Inw = new String(bS8r0BCU + xIpFuZw2);
		if (!K9kP4Inw.equalsIgnoreCase(xrHcif5p)) {
			File grKq72RH = new File(K9kP4Inw);
			if (grKq72RH.exists() && (grKq72RH.isFile())) {
				File dR6VBovc = new File(xrHcif5p);
				if (dR6VBovc.exists()) {
					cIL70Bgy -= dR6VBovc.length();
					dR6VBovc.delete();
				}
				FileUtils.getInstance().createDirectory(dR6VBovc.getParent());
				i9LNazXO = new BufferedInputStream(new FileInputStream(K9kP4Inw), bufferSize);
				qc3u5fwQ = new BufferedOutputStream(new FileOutputStream(xrHcif5p), bufferSize);
				int Rtb1LJsU;
				while ((Rtb1LJsU = i9LNazXO.read(v4Eztr1t)) > 0) {
					qc3u5fwQ.write(v4Eztr1t, 0, Rtb1LJsU);
					cIL70Bgy += Rtb1LJsU;
				}
				qc3u5fwQ.flush();
				i9LNazXO.close();
				qc3u5fwQ.close();
			} else {
				throw new Exception("Source file not exist ! file1FullPath = (" + K9kP4Inw + ")");
			}
		}
		return cIL70Bgy;
	}

}