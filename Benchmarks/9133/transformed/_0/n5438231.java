class n5438231 {
	public int extract() throws Exception {
		int e9AVFptx = 0;
		if (VERBOSE)
			System.out.println("IAAE:Extractr.extract: getting ready to extract " + getArtDir().toString());
		ITCFileFilter xz0Mqc7q = new ITCFileFilter();
		RecursiveFileIterator AbengZsE = new RecursiveFileIterator(getArtDir(), xz0Mqc7q);
		FileTypeDeterminer O5TXid9U = new FileTypeDeterminer();
		File A1Da6pVB = null;
		File aG3uBULQ = null;
		broadcastStart();
		while (AbengZsE.hasMoreElements()) {
			A1Da6pVB = (File) AbengZsE.nextElement();
			aG3uBULQ = getTargetFile(A1Da6pVB);
			if (VERBOSE)
				System.out.println("IAAE:Extractr.extract: working ont " + A1Da6pVB.toString());
			BufferedInputStream kgvbbGYJ = null;
			BufferedOutputStream xrc7gCNY = null;
			try {
				kgvbbGYJ = new BufferedInputStream((new FileInputStream(A1Da6pVB)));
				xrc7gCNY = new BufferedOutputStream((new FileOutputStream(aG3uBULQ)));
				byte[] e9QLhj7Y = new byte[10240];
				int kzzqIxlZ = 0;
				int oBxfmDpL = 0;
				kzzqIxlZ = kgvbbGYJ.read(e9QLhj7Y);
				while (kzzqIxlZ != -1) {
					if ((oBxfmDpL <= 491) && (kzzqIxlZ > 491)) {
						xrc7gCNY.write(e9QLhj7Y, 492, (kzzqIxlZ - 492));
					} else if ((oBxfmDpL <= 491) && (kzzqIxlZ <= 491)) {
					} else {
						xrc7gCNY.write(e9QLhj7Y, 0, kzzqIxlZ);
					}
					oBxfmDpL = oBxfmDpL + kzzqIxlZ;
					kzzqIxlZ = kgvbbGYJ.read(e9QLhj7Y);
				}
			} catch (Exception coWYDXBQ) {
				coWYDXBQ.printStackTrace();
				broadcastFail();
			} finally {
				kgvbbGYJ.close();
				xrc7gCNY.close();
			}
			broadcastSuccess();
			e9AVFptx++;
		}
		broadcastDone();
		return e9AVFptx;
	}

}