class n7872662 {
	private static boolean prepareProbeFile(String completePath, String outputFile) {
		try {
			File inFile = new File(completePath + fSep + "probe.txt");
			FileChannel inC = new FileInputStream(inFile).getChannel();
			File outFile = new File(completePath + fSep + "SmartGRAPE" + fSep + outputFile);
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			boolean endOfFile = true;
			FileChannel outC = new FileOutputStream(outFile, true).getChannel();
			int customer = 0;
			short movieName = 0;
			while (endOfFile) {
				String line = br.readLine();
				if (line != null) {
					if (line.indexOf(":") >= 0) {
						movieName = new Short(line.substring(0, line.length() - 1)).shortValue();
					} else {
						ByteBuffer outBuf = ByteBuffer.allocate(6);
						customer = new Integer(line).intValue();
						outBuf.putShort(movieName);
						outBuf.putInt(customer);
						outBuf.flip();
						outC.write(outBuf);
					}
				} else
					endOfFile = false;
			}
			br.close();
			outC.close();
			return true;
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
	}

}