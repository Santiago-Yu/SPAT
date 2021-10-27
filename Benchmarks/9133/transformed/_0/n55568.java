class n55568 {
	public static void httpOnLoad(String JHFZVqgC, String SoQKramU) throws Exception {
		URL VyF2P3dk = new URL(SoQKramU);
		HttpURLConnection ZiquA6DO = (HttpURLConnection) VyF2P3dk.openConnection();
		ZiquA6DO.setRequestMethod("GET");
		ZiquA6DO.connect();
		int GVDaJ6Nz = ZiquA6DO.getResponseCode();
		System.err.println("Code : " + GVDaJ6Nz);
		System.err.println("getResponseMessage : " + ZiquA6DO.getResponseMessage());
		if (GVDaJ6Nz >= 400) {
			return;
		}
		int rvej5ujF = 3;
		int PVRx5qS3 = ZiquA6DO.getContentLength();
		System.out.println("fileLength:" + PVRx5qS3);
		int m1cSzvIf = PVRx5qS3 / rvej5ujF;
		int vq3f1Kna = PVRx5qS3 - (m1cSzvIf * (rvej5ujF - 1));
		ZiquA6DO.disconnect();
		File ysk7jYRB = new File(JHFZVqgC);
		RandomAccessFile COukTQL0 = new RandomAccessFile(ysk7jYRB, "rw");
		COukTQL0.setLength(PVRx5qS3);
		COukTQL0.close();
		for (int moxNQvLK = 2; moxNQvLK < 3; moxNQvLK++) {
			int TTbFRc35 = moxNQvLK * m1cSzvIf;
			if (moxNQvLK == rvej5ujF - 1) {
				m1cSzvIf = vq3f1Kna;
			}
			RandomAccessFile JjCLTImb = new RandomAccessFile(ysk7jYRB, "rw");
			JjCLTImb.seek(TTbFRc35);
			new TestDownFile(VyF2P3dk, TTbFRc35, JjCLTImb, m1cSzvIf).start();
		}
	}

}