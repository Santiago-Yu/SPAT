class n14840321 {
	public static void copy(FileInputStream ocFcXFG9, FileOutputStream r0a4Gifh) throws IOException {
		FileChannel xjedRVuG = null, jTsDcEZB = null;
		try {
			xjedRVuG = ocFcXFG9.getChannel();
			jTsDcEZB = r0a4Gifh.getChannel();
			long mvmsw7Md = xjedRVuG.size();
			MappedByteBuffer PnR54cIV = xjedRVuG.map(FileChannel.MapMode.READ_ONLY, 0, mvmsw7Md);
			jTsDcEZB.write(PnR54cIV);
		} finally {
			if (xjedRVuG != null)
				xjedRVuG.close();
			if (jTsDcEZB != null)
				jTsDcEZB.close();
		}
	}

}