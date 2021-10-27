class n20508693 {
	private void zip(FileHolder VblKiqPA, int CZnJdCTL) {
		byte[] snmQJVnb = new byte[BUFFER_SIZE];
		int WmIJsYXa;
		if (VblKiqPA.selectedFileList.size() == 0) {
			return;
		}
		File kH6Tz24o = new File(VblKiqPA.destFiles[0]);
		try {
			ZipOutputStream r1yxD1yW = new ZipOutputStream(new FileOutputStream(kH6Tz24o));
			for (int Gd5ABhnc = 0; Gd5ABhnc < VblKiqPA.selectedFileList.size(); Gd5ABhnc++) {
				File OoE0Mst1 = VblKiqPA.selectedFileList.get(Gd5ABhnc);
				super.currentObjBeingProcessed = OoE0Mst1;
				this.inStream = new FileInputStream(OoE0Mst1);
				ZipEntry VNSHdsgz = new ZipEntry(OoE0Mst1.getName());
				r1yxD1yW.setLevel(CZnJdCTL);
				r1yxD1yW.putNextEntry(VNSHdsgz);
				while ((WmIJsYXa = this.inStream.read(snmQJVnb)) != -1) {
					r1yxD1yW.write(snmQJVnb, 0, WmIJsYXa);
				}
				r1yxD1yW.closeEntry();
				this.inStream.close();
			}
			r1yxD1yW.close();
		} catch (IOException WzXyzxji) {
			errEntry.setThrowable(WzXyzxji);
			errEntry.setAppContext("gzip()");
			errEntry.setAppMessage("Error zipping: " + kH6Tz24o);
			logger.logError(errEntry);
		}
		return;
	}

}