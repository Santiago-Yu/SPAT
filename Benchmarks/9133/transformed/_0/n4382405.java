class n4382405 {
	public static void fileCopy(File uKHpS7J7, File oRYgJ97s) throws IOException {
		FileChannel cjyiazbQ = null, Y8q6w41R = null;
		try {
			cjyiazbQ = new FileInputStream(uKHpS7J7).getChannel();
			Y8q6w41R = new FileOutputStream(oRYgJ97s).getChannel();
			long awPeZfez = cjyiazbQ.size();
			MappedByteBuffer RuMY68Df = cjyiazbQ.map(FileChannel.MapMode.READ_ONLY, 0, awPeZfez);
			Y8q6w41R.write(RuMY68Df);
		} finally {
			if (cjyiazbQ != null) {
				cjyiazbQ.close();
			}
			if (Y8q6w41R != null) {
				Y8q6w41R.close();
			}
		}
	}

}