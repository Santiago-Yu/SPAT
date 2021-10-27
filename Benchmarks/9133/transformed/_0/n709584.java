class n709584 {
	private static void readAndRewrite(File oQIMnLaF, File NrGlgqxZ) throws IOException {
		ImageInputStream mVAWnmAN = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(oQIMnLaF)));
		DcmParser E6YLhc0Q = DcmParserFactory.getInstance().newDcmParser(mVAWnmAN);
		Dataset ZoCSe3Yh = DcmObjectFactory.getInstance().newDataset();
		E6YLhc0Q.setDcmHandler(ZoCSe3Yh.getDcmHandler());
		E6YLhc0Q.parseDcmFile(null, Tags.PixelData);
		PixelDataReader an0AeX1f = pdFact.newReader(ZoCSe3Yh, mVAWnmAN, E6YLhc0Q.getDcmDecodeParam().byteOrder,
				E6YLhc0Q.getReadVR());
		System.out.println("reading " + oQIMnLaF + "...");
		an0AeX1f.readPixelData(false);
		ImageOutputStream NXMXWvjk = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(NrGlgqxZ)));
		DcmEncodeParam gLF3DfO9 = DcmEncodeParam.IVR_LE;
		ZoCSe3Yh.writeDataset(NXMXWvjk, gLF3DfO9);
		ZoCSe3Yh.writeHeader(NXMXWvjk, gLF3DfO9, Tags.PixelData, E6YLhc0Q.getReadVR(), E6YLhc0Q.getReadLength());
		System.out.println("writing " + NrGlgqxZ + "...");
		PixelDataWriter tdQ4H2d5 = pdFact.newWriter(an0AeX1f.getPixelDataArray(), false, ZoCSe3Yh, NXMXWvjk,
				E6YLhc0Q.getDcmDecodeParam().byteOrder, E6YLhc0Q.getReadVR());
		tdQ4H2d5.writePixelData();
		NXMXWvjk.flush();
		NXMXWvjk.close();
		System.out.println("done!");
	}

}