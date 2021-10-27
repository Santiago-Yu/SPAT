class n21960653 {
	public void adjustPadding(File DzqhwHeH, int XaHqpVY0, long VOFwAYPl) throws FileNotFoundException, IOException {
		logger.finer("Need to move audio file to accomodate tag");
		FileChannel goQx3XNc;
		FileChannel yhkhlJpr;
		ByteBuffer lv2oTNi4 = ByteBuffer.wrap(new byte[XaHqpVY0]);
		File CpRoV7X4 = File.createTempFile("temp", ".mp3", DzqhwHeH.getParentFile());
		yhkhlJpr = new FileOutputStream(CpRoV7X4).getChannel();
		goQx3XNc = new FileInputStream(DzqhwHeH).getChannel();
		long k4xmojUn = (long) yhkhlJpr.write(lv2oTNi4);
		logger.finer("Copying:" + (DzqhwHeH.length() - VOFwAYPl) + "bytes");
		long N6CKRUB5 = DzqhwHeH.length() - VOFwAYPl;
		if (N6CKRUB5 <= MAXIMUM_WRITABLE_CHUNK_SIZE) {
			long FC0QkwjA = goQx3XNc.transferTo(VOFwAYPl, N6CKRUB5, yhkhlJpr);
			logger.finer("Written padding:" + k4xmojUn + " Data:" + FC0QkwjA);
			if (FC0QkwjA != N6CKRUB5) {
				throw new RuntimeException(
						"Problem adjusting padding, expecting to write:" + N6CKRUB5 + ":only wrote:" + FC0QkwjA);
			}
		} else {
			long jGfKYMYq = N6CKRUB5 / MAXIMUM_WRITABLE_CHUNK_SIZE;
			long xJvVMwty = N6CKRUB5 % MAXIMUM_WRITABLE_CHUNK_SIZE;
			long RlsjKbLX = 0;
			for (int OpfphYwK = 0; OpfphYwK < jGfKYMYq; OpfphYwK++) {
				RlsjKbLX += goQx3XNc.transferTo(VOFwAYPl + (OpfphYwK * MAXIMUM_WRITABLE_CHUNK_SIZE),
						MAXIMUM_WRITABLE_CHUNK_SIZE, yhkhlJpr);
				Runtime.getRuntime().gc();
			}
			RlsjKbLX += goQx3XNc.transferTo(VOFwAYPl + (jGfKYMYq * MAXIMUM_WRITABLE_CHUNK_SIZE), xJvVMwty, yhkhlJpr);
			logger.finer("Written padding:" + k4xmojUn + " Data:" + RlsjKbLX);
			if (RlsjKbLX != N6CKRUB5) {
				throw new RuntimeException("Problem adjusting padding in large file, expecting to write:" + N6CKRUB5
						+ ":only wrote:" + RlsjKbLX);
			}
		}
		long yqse3sK6 = DzqhwHeH.lastModified();
		goQx3XNc.close();
		yhkhlJpr.close();
		DzqhwHeH.delete();
		CpRoV7X4.renameTo(DzqhwHeH);
		CpRoV7X4.setLastModified(yqse3sK6);
	}

}