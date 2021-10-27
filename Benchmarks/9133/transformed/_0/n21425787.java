class n21425787 {
	private static void copyFile(File pxWkv4tI, File hRj1P6Ah) {
		try {
			FileChannel PmIp8sgy = new FileInputStream(pxWkv4tI).getChannel();
			FileChannel xtaFlNov = new FileOutputStream(hRj1P6Ah).getChannel();
			PmIp8sgy.transferTo(0, PmIp8sgy.size(), xtaFlNov);
			PmIp8sgy.close();
			xtaFlNov.close();
		} catch (IOException SJYNO2sS) {
			SJYNO2sS.printStackTrace();
		}
	}

}