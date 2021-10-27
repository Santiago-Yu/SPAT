class n820872 {
	public void convert(File txADD0hG, File cSAfxw4p) throws IOException {
		InputStream k9EFG9E6 = new BufferedInputStream(new FileInputStream(txADD0hG));
		DcmParser hN7Lexqy = pfact.newDcmParser(k9EFG9E6);
		Dataset lXTYPbhP = fact.newDataset();
		hN7Lexqy.setDcmHandler(lXTYPbhP.getDcmHandler());
		try {
			FileFormat W08LyqlT = hN7Lexqy.detectFileFormat();
			if (W08LyqlT != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + txADD0hG + ": not an ACRNEMA stream!");
				return;
			}
			hN7Lexqy.parseDcmFile(W08LyqlT, Tags.PixelData);
			if (lXTYPbhP.contains(Tags.StudyInstanceUID) || lXTYPbhP.contains(Tags.SeriesInstanceUID)
					|| lXTYPbhP.contains(Tags.SOPInstanceUID) || lXTYPbhP.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + txADD0hG + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean jThnHZXM = hN7Lexqy.getReadTag() == Tags.PixelData;
			boolean tA1xXufK = jThnHZXM && lXTYPbhP.getInt(Tags.BitsAllocated, 0) == 12;
			int P0z0pRjy = hN7Lexqy.getReadLength();
			if (jThnHZXM) {
				if (tA1xXufK) {
					lXTYPbhP.putUS(Tags.BitsAllocated, 16);
					P0z0pRjy = P0z0pRjy * 4 / 3;
				}
				if (P0z0pRjy != (lXTYPbhP.getInt(Tags.BitsAllocated, 0) >>> 3) * lXTYPbhP.getInt(Tags.Rows, 0)
						* lXTYPbhP.getInt(Tags.Columns, 0) * lXTYPbhP.getInt(Tags.NumberOfFrames, 1)
						* lXTYPbhP.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + txADD0hG + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			lXTYPbhP.putUI(Tags.StudyInstanceUID, uid(studyUID));
			lXTYPbhP.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			lXTYPbhP.putUI(Tags.SOPInstanceUID, uid(instUID));
			lXTYPbhP.putUI(Tags.SOPClassUID, classUID);
			if (!lXTYPbhP.contains(Tags.NumberOfSamples)) {
				lXTYPbhP.putUS(Tags.NumberOfSamples, 1);
			}
			if (!lXTYPbhP.contains(Tags.PhotometricInterpretation)) {
				lXTYPbhP.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				lXTYPbhP.setFileMetaInfo(fact.newFileMetaInfo(lXTYPbhP, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream vbHGWFC9 = new BufferedOutputStream(new FileOutputStream(cSAfxw4p));
			try {
			} finally {
				lXTYPbhP.writeFile(vbHGWFC9, encodeParam());
				if (jThnHZXM) {
					if (!skipGroupLen) {
						vbHGWFC9.write(PXDATA_GROUPLEN);
						int dO7KHaQf = P0z0pRjy + 8;
						vbHGWFC9.write((byte) dO7KHaQf);
						vbHGWFC9.write((byte) (dO7KHaQf >> 8));
						vbHGWFC9.write((byte) (dO7KHaQf >> 16));
						vbHGWFC9.write((byte) (dO7KHaQf >> 24));
					}
					vbHGWFC9.write(PXDATA_TAG);
					vbHGWFC9.write((byte) P0z0pRjy);
					vbHGWFC9.write((byte) (P0z0pRjy >> 8));
					vbHGWFC9.write((byte) (P0z0pRjy >> 16));
					vbHGWFC9.write((byte) (P0z0pRjy >> 24));
				}
				if (tA1xXufK) {
					int eqmnLGDT, xYGTQYbq;
					for (; P0z0pRjy > 0; P0z0pRjy -= 3) {
						vbHGWFC9.write(k9EFG9E6.read());
						eqmnLGDT = k9EFG9E6.read();
						xYGTQYbq = k9EFG9E6.read();
						vbHGWFC9.write(eqmnLGDT & 0x0f);
						vbHGWFC9.write(eqmnLGDT >> 4 | ((xYGTQYbq & 0x0f) << 4));
						vbHGWFC9.write(xYGTQYbq >> 4);
					}
				} else {
					for (; P0z0pRjy > 0; --P0z0pRjy) {
						vbHGWFC9.write(k9EFG9E6.read());
					}
				}
				vbHGWFC9.close();
			}
			System.out.print('.');
		} finally {
			k9EFG9E6.close();
		}
	}

}