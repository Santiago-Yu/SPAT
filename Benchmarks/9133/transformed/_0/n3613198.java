class n3613198 {
	public static void copyFile(File bBS68S15, File UMG9UKh2) throws IOException {
		FileChannel gGA9eEc7 = new FileInputStream(bBS68S15).getChannel();
		FileChannel yiNqqk0H = new FileOutputStream(UMG9UKh2).getChannel();
		try {
			gGA9eEc7.transferTo(0, gGA9eEc7.size(), yiNqqk0H);
		} catch (IOException kgsAoEMp) {
			throw kgsAoEMp;
		} finally {
			if (gGA9eEc7 != null)
				gGA9eEc7.close();
			if (yiNqqk0H != null)
				yiNqqk0H.close();
		}
	}

}