class n23585932 {
	public static void concatenateOutput(File[] inputFiles, File outputFile) {
		int numberOfInputFiles = inputFiles.length;
		byte lf = (byte) '\n';
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);
			FileChannel outfc = fos.getChannel();
			System.out.println("Processing " + inputFiles[0].getPath());
			FileInputStream fis = new FileInputStream(inputFiles[0]);
			FileChannel infc = fis.getChannel();
			int bufferCapacity = 100000;
			ByteBuffer bb = ByteBuffer.allocate(bufferCapacity);
			bb.clear();
			while (infc.read(bb) > 0) {
				bb.flip();
				outfc.write(bb);
				bb.clear();
			}
			infc.close();
			int VNHpL = 1;
			while (VNHpL < numberOfInputFiles) {
				System.out.println("Processing " + inputFiles[VNHpL].getPath());
				fis = new FileInputStream(inputFiles[VNHpL]);
				infc = fis.getChannel();
				bb.clear();
				int bytesread = infc.read(bb);
				bb.flip();
				byte b = bb.get();
				while (b != lf) {
					b = bb.get();
				}
				outfc.write(bb);
				bb.clear();
				while (infc.read(bb) > 0) {
					bb.flip();
					outfc.write(bb);
					bb.clear();
				}
				infc.close();
				VNHpL++;
			}
			outfc.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}