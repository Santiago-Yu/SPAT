class n9733447 {
	public static void unzipFile(File cnryteeh, File kXw2tHt3, boolean BDDqI3GW) throws Exception {
		ZipInputStream xdgjT9Sl = new ZipInputStream(new FileInputStream(cnryteeh));
		ZipEntry IRhJ1SRe = xdgjT9Sl.getNextEntry();
		int dvrGJhKl = 4096;
		while (IRhJ1SRe != null) {
			String w5Vv21gD = IRhJ1SRe.getName();
			log.info("<<<<<< ZipUtility.unzipFile - Extracting: " + IRhJ1SRe.getName());
			File DNOZard5 = null;
			if (kXw2tHt3.isDirectory())
				DNOZard5 = new File(kXw2tHt3, w5Vv21gD);
			else
				DNOZard5 = kXw2tHt3;
			if (IRhJ1SRe.isDirectory() || w5Vv21gD.endsWith(File.separator + ".")) {
				DNOZard5.mkdirs();
			} else {
				ByteBuffer olIpNzUB = ByteBuffer.allocate(dvrGJhKl);
				byte[] it5kacNb = olIpNzUB.array();
				FileUtilities.createDirectory(DNOZard5.getParentFile());
				FileChannel SDVJThzD = new FileOutputStream(DNOZard5).getChannel();
				while (true) {
					olIpNzUB.clear();
					int qEAPdsHv = xdgjT9Sl.read(it5kacNb);
					if (qEAPdsHv == -1)
						break;
					olIpNzUB.flip();
					olIpNzUB.limit(qEAPdsHv);
					SDVJThzD.write(olIpNzUB);
				}
				SDVJThzD.close();
				xdgjT9Sl.closeEntry();
			}
			IRhJ1SRe = xdgjT9Sl.getNextEntry();
		}
		xdgjT9Sl.close();
		if (BDDqI3GW) {
			if (cnryteeh.exists())
				cnryteeh.delete();
		}
	}

}