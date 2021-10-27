class n120707 {
	public void convert(File lBfK5C6a, File gBhCDsff) throws IOException {
		InputStream DWWQMLm8 = new BufferedInputStream(new FileInputStream(lBfK5C6a));
		DcmParser a8eHcg0H = pfact.newDcmParser(DWWQMLm8);
		Dataset FenCDDDn = fact.newDataset();
		a8eHcg0H.setDcmHandler(FenCDDDn.getDcmHandler());
		try {
			FileFormat TMLailtL = a8eHcg0H.detectFileFormat();
			if (TMLailtL != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + lBfK5C6a + ": not an ACRNEMA stream!");
				return;
			}
			a8eHcg0H.parseDcmFile(TMLailtL, Tags.PixelData);
			if (FenCDDDn.contains(Tags.StudyInstanceUID) || FenCDDDn.contains(Tags.SeriesInstanceUID)
					|| FenCDDDn.contains(Tags.SOPInstanceUID) || FenCDDDn.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + lBfK5C6a + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean QdQuLLUD = a8eHcg0H.getReadTag() == Tags.PixelData;
			boolean fYRUNbgq = QdQuLLUD && FenCDDDn.getInt(Tags.BitsAllocated, 0) == 12;
			int lmEu5VP9 = a8eHcg0H.getReadLength();
			if (QdQuLLUD) {
				if (fYRUNbgq) {
					FenCDDDn.putUS(Tags.BitsAllocated, 16);
					lmEu5VP9 = lmEu5VP9 * 4 / 3;
				}
				if (lmEu5VP9 != (FenCDDDn.getInt(Tags.BitsAllocated, 0) >>> 3) * FenCDDDn.getInt(Tags.Rows, 0)
						* FenCDDDn.getInt(Tags.Columns, 0) * FenCDDDn.getInt(Tags.NumberOfFrames, 1)
						* FenCDDDn.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + lBfK5C6a + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			FenCDDDn.putUI(Tags.StudyInstanceUID, uid(studyUID));
			FenCDDDn.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			FenCDDDn.putUI(Tags.SOPInstanceUID, uid(instUID));
			FenCDDDn.putUI(Tags.SOPClassUID, classUID);
			if (!FenCDDDn.contains(Tags.NumberOfSamples)) {
				FenCDDDn.putUS(Tags.NumberOfSamples, 1);
			}
			if (!FenCDDDn.contains(Tags.PhotometricInterpretation)) {
				FenCDDDn.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				FenCDDDn.setFileMetaInfo(fact.newFileMetaInfo(FenCDDDn, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream kDxgpOmT = new BufferedOutputStream(new FileOutputStream(gBhCDsff));
			try {
			} finally {
				FenCDDDn.writeFile(kDxgpOmT, encodeParam());
				if (QdQuLLUD) {
					if (!skipGroupLen) {
						kDxgpOmT.write(PXDATA_GROUPLEN);
						int xjz1pxHH = lmEu5VP9 + 8;
						kDxgpOmT.write((byte) xjz1pxHH);
						kDxgpOmT.write((byte) (xjz1pxHH >> 8));
						kDxgpOmT.write((byte) (xjz1pxHH >> 16));
						kDxgpOmT.write((byte) (xjz1pxHH >> 24));
					}
					kDxgpOmT.write(PXDATA_TAG);
					kDxgpOmT.write((byte) lmEu5VP9);
					kDxgpOmT.write((byte) (lmEu5VP9 >> 8));
					kDxgpOmT.write((byte) (lmEu5VP9 >> 16));
					kDxgpOmT.write((byte) (lmEu5VP9 >> 24));
				}
				if (fYRUNbgq) {
					int jXNNQSqh, xGvWKKWd;
					for (; lmEu5VP9 > 0; lmEu5VP9 -= 3) {
						kDxgpOmT.write(DWWQMLm8.read());
						jXNNQSqh = DWWQMLm8.read();
						xGvWKKWd = DWWQMLm8.read();
						kDxgpOmT.write(jXNNQSqh & 0x0f);
						kDxgpOmT.write(jXNNQSqh >> 4 | ((xGvWKKWd & 0x0f) << 4));
						kDxgpOmT.write(xGvWKKWd >> 4);
					}
				} else {
					for (; lmEu5VP9 > 0; --lmEu5VP9) {
						kDxgpOmT.write(DWWQMLm8.read());
					}
				}
				kDxgpOmT.close();
			}
			System.out.print('.');
		} finally {
			DWWQMLm8.close();
		}
	}

}