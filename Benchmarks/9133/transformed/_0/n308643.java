class n308643 {
	public void convert(File Wyn9T4wb, File bLNIXuef) throws IOException {
		InputStream EJZM1iL7 = new BufferedInputStream(new FileInputStream(Wyn9T4wb));
		DcmParser G5aZ1LmW = pfact.newDcmParser(EJZM1iL7);
		Dataset XcMLzf46 = fact.newDataset();
		G5aZ1LmW.setDcmHandler(XcMLzf46.getDcmHandler());
		try {
			FileFormat Qu2FwyTE = G5aZ1LmW.detectFileFormat();
			if (Qu2FwyTE != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + Wyn9T4wb + ": not an ACRNEMA stream!");
				return;
			}
			G5aZ1LmW.parseDcmFile(Qu2FwyTE, Tags.PixelData);
			if (XcMLzf46.contains(Tags.StudyInstanceUID) || XcMLzf46.contains(Tags.SeriesInstanceUID)
					|| XcMLzf46.contains(Tags.SOPInstanceUID) || XcMLzf46.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + Wyn9T4wb + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean er2BZvkv = G5aZ1LmW.getReadTag() == Tags.PixelData;
			boolean p1TbMPKn = er2BZvkv && XcMLzf46.getInt(Tags.BitsAllocated, 0) == 12;
			int EZ3TiKAB = G5aZ1LmW.getReadLength();
			if (er2BZvkv) {
				if (p1TbMPKn) {
					XcMLzf46.putUS(Tags.BitsAllocated, 16);
					EZ3TiKAB = EZ3TiKAB * 4 / 3;
				}
				if (EZ3TiKAB != (XcMLzf46.getInt(Tags.BitsAllocated, 0) >>> 3) * XcMLzf46.getInt(Tags.Rows, 0)
						* XcMLzf46.getInt(Tags.Columns, 0) * XcMLzf46.getInt(Tags.NumberOfFrames, 1)
						* XcMLzf46.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + Wyn9T4wb + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			XcMLzf46.putUI(Tags.StudyInstanceUID, uid(studyUID));
			XcMLzf46.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			XcMLzf46.putUI(Tags.SOPInstanceUID, uid(instUID));
			XcMLzf46.putUI(Tags.SOPClassUID, classUID);
			if (!XcMLzf46.contains(Tags.NumberOfSamples)) {
				XcMLzf46.putUS(Tags.NumberOfSamples, 1);
			}
			if (!XcMLzf46.contains(Tags.PhotometricInterpretation)) {
				XcMLzf46.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				XcMLzf46.setFileMetaInfo(fact.newFileMetaInfo(XcMLzf46, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream rCCWd3at = new BufferedOutputStream(new FileOutputStream(bLNIXuef));
			try {
			} finally {
				XcMLzf46.writeFile(rCCWd3at, encodeParam());
				if (er2BZvkv) {
					if (!skipGroupLen) {
						rCCWd3at.write(PXDATA_GROUPLEN);
						int RgwJtCyg = EZ3TiKAB + 8;
						rCCWd3at.write((byte) RgwJtCyg);
						rCCWd3at.write((byte) (RgwJtCyg >> 8));
						rCCWd3at.write((byte) (RgwJtCyg >> 16));
						rCCWd3at.write((byte) (RgwJtCyg >> 24));
					}
					rCCWd3at.write(PXDATA_TAG);
					rCCWd3at.write((byte) EZ3TiKAB);
					rCCWd3at.write((byte) (EZ3TiKAB >> 8));
					rCCWd3at.write((byte) (EZ3TiKAB >> 16));
					rCCWd3at.write((byte) (EZ3TiKAB >> 24));
				}
				if (p1TbMPKn) {
					int UQfoVMI1, ukD0RPRo;
					for (; EZ3TiKAB > 0; EZ3TiKAB -= 3) {
						rCCWd3at.write(EJZM1iL7.read());
						UQfoVMI1 = EJZM1iL7.read();
						ukD0RPRo = EJZM1iL7.read();
						rCCWd3at.write(UQfoVMI1 & 0x0f);
						rCCWd3at.write(UQfoVMI1 >> 4 | ((ukD0RPRo & 0x0f) << 4));
						rCCWd3at.write(ukD0RPRo >> 4);
					}
				} else {
					for (; EZ3TiKAB > 0; --EZ3TiKAB) {
						rCCWd3at.write(EJZM1iL7.read());
					}
				}
				rCCWd3at.close();
			}
			System.out.print('.');
		} finally {
			EJZM1iL7.close();
		}
	}

}