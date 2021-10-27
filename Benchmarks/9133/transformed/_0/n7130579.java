class n7130579 {
	public void copyFile(String HeVodXZ6, String R5pq6Arw) {
		try {
			int d17a8EPI = 0;
			int jb1ypPl1 = 0;
			File GNXeqT5c = new File(HeVodXZ6);
			if (GNXeqT5c.exists()) {
				InputStream VykUYKa9 = new FileInputStream(HeVodXZ6);
				FileOutputStream pspj4QZd = new FileOutputStream(R5pq6Arw);
				byte[] SE4ZY5yU = new byte[1444];
				while ((jb1ypPl1 = VykUYKa9.read(SE4ZY5yU)) != -1) {
					d17a8EPI += jb1ypPl1;
					pspj4QZd.write(SE4ZY5yU, 0, jb1ypPl1);
				}
				VykUYKa9.close();
				pspj4QZd.close();
			}
		} catch (Exception iqSnjFJP) {
			iqSnjFJP.printStackTrace();
		}
	}

}