class n223631 {
	private static void readAndRewrite(File nHbrdyei, File gVCMIIBx) throws IOException {
		ImageInputStream Ul62iU8Z = ImageIO
				.createImageInputStream(new BufferedInputStream(new FileInputStream(nHbrdyei)));
		DcmParser Bh0TUnSC = DcmParserFactory.getInstance().newDcmParser(Ul62iU8Z);
		Dataset ExTAekjJ = DcmObjectFactory.getInstance().newDataset();
		Bh0TUnSC.setDcmHandler(ExTAekjJ.getDcmHandler());
		Bh0TUnSC.parseDcmFile(null, Tags.PixelData);
		PixelDataReader ijl0KYUf = pdFact.newReader(ExTAekjJ, Ul62iU8Z, Bh0TUnSC.getDcmDecodeParam().byteOrder,
				Bh0TUnSC.getReadVR());
		System.out.println("reading " + nHbrdyei + "...");
		ijl0KYUf.readPixelData(false);
		ImageOutputStream LGrhLNbj = ImageIO
				.createImageOutputStream(new BufferedOutputStream(new FileOutputStream(gVCMIIBx)));
		DcmEncodeParam NEGIrnAy = DcmEncodeParam.IVR_LE;
		ExTAekjJ.writeDataset(LGrhLNbj, NEGIrnAy);
		ExTAekjJ.writeHeader(LGrhLNbj, NEGIrnAy, Tags.PixelData, Bh0TUnSC.getReadVR(), Bh0TUnSC.getReadLength());
		System.out.println("writing " + gVCMIIBx + "...");
		PixelDataWriter wKS8U77W = pdFact.newWriter(ijl0KYUf.getPixelDataArray(), false, ExTAekjJ, LGrhLNbj,
				Bh0TUnSC.getDcmDecodeParam().byteOrder, Bh0TUnSC.getReadVR());
		wKS8U77W.writePixelData();
		LGrhLNbj.flush();
		LGrhLNbj.close();
		System.out.println("done!");
	}

}