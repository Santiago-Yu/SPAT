class n1424647 {
	public static void copy(File xM8TvICH, File fcn46sIp) throws IOException {
		FileChannel JSEe7NDo = null, pDOgm7Ro = null;
		try {
			JSEe7NDo = new FileInputStream(xM8TvICH).getChannel();
			pDOgm7Ro = new FileOutputStream(fcn46sIp).getChannel();
			long wd0OeE9p = JSEe7NDo.size();
			MappedByteBuffer l24jxO5x = JSEe7NDo.map(FileChannel.MapMode.READ_ONLY, 0, wd0OeE9p);
			pDOgm7Ro.write(l24jxO5x);
		} finally {
			if (JSEe7NDo != null)
				JSEe7NDo.close();
			if (pDOgm7Ro != null)
				pDOgm7Ro.close();
		}
	}

}