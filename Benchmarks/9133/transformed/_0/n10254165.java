class n10254165 {
	public void zipFile(String zBeO2xTI, String RkeJ55oR, boolean e0dc6rqq) throws Exception {
		List nNYWAPlX = getSubFiles(new File(zBeO2xTI));
		ZipOutputStream C0qV5G6Z = new ZipOutputStream(new FileOutputStream(RkeJ55oR + ".temp"));
		ZipEntry xv6qww0L = null;
		byte[] VXf53qbY = new byte[BUFFER];
		byte[] auKb33jn = new byte[encrypLength];
		int hktMvmui = 0;
		for (int Pq9W8eXC = 0; Pq9W8eXC < nNYWAPlX.size(); Pq9W8eXC++) {
			if (stopZipFile) {
				C0qV5G6Z.close();
				File pm25EEnl = new File(RkeJ55oR + ".temp");
				if (pm25EEnl.exists())
					pm25EEnl.delete();
				break;
			}
			File faorOCWt = (File) nNYWAPlX.get(Pq9W8eXC);
			if (faorOCWt.getAbsoluteFile().equals(RkeJ55oR + ".temp"))
				continue;
			xv6qww0L = new ZipEntry(getAbsFileName(zBeO2xTI, faorOCWt));
			xv6qww0L.setSize(faorOCWt.length());
			xv6qww0L.setTime(faorOCWt.lastModified());
			C0qV5G6Z.putNextEntry(xv6qww0L);
			InputStream J5ODnDYW = new BufferedInputStream(new FileInputStream(faorOCWt));
			hktMvmui = J5ODnDYW.read(VXf53qbY, 0, BUFFER);
			if (e0dc6rqq) {
				if (hktMvmui >= encrypLength) {
					System.arraycopy(VXf53qbY, 0, auKb33jn, 0, encrypLength);
				} else if (hktMvmui > 0) {
					Arrays.fill(auKb33jn, (byte) 0);
					System.arraycopy(VXf53qbY, 0, auKb33jn, 0, hktMvmui);
					hktMvmui = encrypLength;
				}
				byte[] KV7P92tu = CryptionControl.getInstance().encryptoECB(auKb33jn, rootKey);
				System.arraycopy(KV7P92tu, 0, VXf53qbY, 0, encrypLength);
			}
			while (hktMvmui != -1) {
				C0qV5G6Z.write(VXf53qbY, 0, hktMvmui);
				hktMvmui = J5ODnDYW.read(VXf53qbY, 0, BUFFER);
			}
			J5ODnDYW.close();
		}
		C0qV5G6Z.close();
		File OBnGnwgA = new File(RkeJ55oR + ".temp");
		if (OBnGnwgA.exists())
			OBnGnwgA.renameTo(new File(RkeJ55oR + ".zip"));
	}

}