class n431827 {
	public void convert(File NOL6N2j8, File nKJoNfSN) throws IOException {
		InputStream NKaBgwH4 = new BufferedInputStream(new FileInputStream(NOL6N2j8));
		DcmParser PoWWWKpb = pfact.newDcmParser(NKaBgwH4);
		Dataset JkKH89lJ = fact.newDataset();
		PoWWWKpb.setDcmHandler(JkKH89lJ.getDcmHandler());
		try {
			FileFormat Yy2TuqjC = PoWWWKpb.detectFileFormat();
			if (Yy2TuqjC != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + NOL6N2j8 + ": not an ACRNEMA stream!");
				return;
			}
			PoWWWKpb.parseDcmFile(Yy2TuqjC, Tags.PixelData);
			if (JkKH89lJ.contains(Tags.StudyInstanceUID) || JkKH89lJ.contains(Tags.SeriesInstanceUID)
					|| JkKH89lJ.contains(Tags.SOPInstanceUID) || JkKH89lJ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + NOL6N2j8 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean KKGOzogu = PoWWWKpb.getReadTag() == Tags.PixelData;
			boolean UwQ3bBkY = KKGOzogu && JkKH89lJ.getInt(Tags.BitsAllocated, 0) == 12;
			int VFHoSpG2 = PoWWWKpb.getReadLength();
			if (KKGOzogu) {
				if (UwQ3bBkY) {
					JkKH89lJ.putUS(Tags.BitsAllocated, 16);
					VFHoSpG2 = VFHoSpG2 * 4 / 3;
				}
				if (VFHoSpG2 != (JkKH89lJ.getInt(Tags.BitsAllocated, 0) >>> 3) * JkKH89lJ.getInt(Tags.Rows, 0)
						* JkKH89lJ.getInt(Tags.Columns, 0) * JkKH89lJ.getInt(Tags.NumberOfFrames, 1)
						* JkKH89lJ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + NOL6N2j8 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			JkKH89lJ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			JkKH89lJ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			JkKH89lJ.putUI(Tags.SOPInstanceUID, uid(instUID));
			JkKH89lJ.putUI(Tags.SOPClassUID, classUID);
			if (!JkKH89lJ.contains(Tags.NumberOfSamples)) {
				JkKH89lJ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!JkKH89lJ.contains(Tags.PhotometricInterpretation)) {
				JkKH89lJ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				JkKH89lJ.setFileMetaInfo(fact.newFileMetaInfo(JkKH89lJ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream n4SgFun1 = new BufferedOutputStream(new FileOutputStream(nKJoNfSN));
			try {
			} finally {
				JkKH89lJ.writeFile(n4SgFun1, encodeParam());
				if (KKGOzogu) {
					if (!skipGroupLen) {
						n4SgFun1.write(PXDATA_GROUPLEN);
						int yWsJzVaC = VFHoSpG2 + 8;
						n4SgFun1.write((byte) yWsJzVaC);
						n4SgFun1.write((byte) (yWsJzVaC >> 8));
						n4SgFun1.write((byte) (yWsJzVaC >> 16));
						n4SgFun1.write((byte) (yWsJzVaC >> 24));
					}
					n4SgFun1.write(PXDATA_TAG);
					n4SgFun1.write((byte) VFHoSpG2);
					n4SgFun1.write((byte) (VFHoSpG2 >> 8));
					n4SgFun1.write((byte) (VFHoSpG2 >> 16));
					n4SgFun1.write((byte) (VFHoSpG2 >> 24));
				}
				if (UwQ3bBkY) {
					int P58KSmhC, zDy2SCoR;
					for (; VFHoSpG2 > 0; VFHoSpG2 -= 3) {
						n4SgFun1.write(NKaBgwH4.read());
						P58KSmhC = NKaBgwH4.read();
						zDy2SCoR = NKaBgwH4.read();
						n4SgFun1.write(P58KSmhC & 0x0f);
						n4SgFun1.write(P58KSmhC >> 4 | ((zDy2SCoR & 0x0f) << 4));
						n4SgFun1.write(zDy2SCoR >> 4);
					}
				} else {
					for (; VFHoSpG2 > 0; --VFHoSpG2) {
						n4SgFun1.write(NKaBgwH4.read());
					}
				}
				n4SgFun1.close();
			}
			System.out.print('.');
		} finally {
			NKaBgwH4.close();
		}
	}

}