class n4147982 {
	public static void fixEol(File J5MnY9b5) throws IOException {
		File iUp7jfqw = File.createTempFile(J5MnY9b5.getName(), ".fixEol", J5MnY9b5.getParentFile());
		FileChannel J6Ke2x7g = new FileInputStream(J5MnY9b5).getChannel();
		if (0 != J6Ke2x7g.size()) {
			FileChannel x75CstV6 = new FileOutputStream(iUp7jfqw).getChannel();
			byte[] vQqljlXy = AStringUtilities.systemNewLine.getBytes();
			ByteBuffer lcv56IQm = ByteBuffer.allocateDirect(1024 * vQqljlXy.length);
			boolean IVYMcYKy = false;
			ByteBuffer pLl7jPm2 = ByteBuffer.allocateDirect(1024);
			while (J6Ke2x7g.read(pLl7jPm2) > 0) {
				pLl7jPm2.limit(pLl7jPm2.position());
				pLl7jPm2.position(0);
				while (pLl7jPm2.remaining() > 0) {
					byte uKbOK0rL = pLl7jPm2.get();
					if (uKbOK0rL == '\r') {
						IVYMcYKy = true;
						lcv56IQm.put(vQqljlXy);
					} else {
						if (uKbOK0rL == '\n') {
							if (!IVYMcYKy)
								lcv56IQm.put(vQqljlXy);
						} else
							lcv56IQm.put(uKbOK0rL);
						IVYMcYKy = false;
					}
				}
				lcv56IQm.limit(lcv56IQm.position());
				lcv56IQm.position(0);
				x75CstV6.write(lcv56IQm);
				lcv56IQm.clear();
				pLl7jPm2.clear();
			}
			x75CstV6.close();
		}
		J6Ke2x7g.close();
		J5MnY9b5.delete();
		iUp7jfqw.renameTo(J5MnY9b5);
	}

}