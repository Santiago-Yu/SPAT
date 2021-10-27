class n38361 {
	public void convert(File vh89jxHK, File KqwH6FOR) throws IOException {
		InputStream pHmbbD0X = new BufferedInputStream(new FileInputStream(vh89jxHK));
		DcmParser mIDx8fkq = pfact.newDcmParser(pHmbbD0X);
		Dataset OXk7ozzm = fact.newDataset();
		mIDx8fkq.setDcmHandler(OXk7ozzm.getDcmHandler());
		try {
			FileFormat bCFahIMZ = mIDx8fkq.detectFileFormat();
			if (bCFahIMZ != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + vh89jxHK + ": not an ACRNEMA stream!");
				return;
			}
			mIDx8fkq.parseDcmFile(bCFahIMZ, Tags.PixelData);
			if (OXk7ozzm.contains(Tags.StudyInstanceUID) || OXk7ozzm.contains(Tags.SeriesInstanceUID)
					|| OXk7ozzm.contains(Tags.SOPInstanceUID) || OXk7ozzm.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + vh89jxHK + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Mv0P57c9 = mIDx8fkq.getReadTag() == Tags.PixelData;
			boolean Gk7ewneI = Mv0P57c9 && OXk7ozzm.getInt(Tags.BitsAllocated, 0) == 12;
			int MOzXMgWX = mIDx8fkq.getReadLength();
			if (Mv0P57c9) {
				if (Gk7ewneI) {
					OXk7ozzm.putUS(Tags.BitsAllocated, 16);
					MOzXMgWX = MOzXMgWX * 4 / 3;
				}
				if (MOzXMgWX != (OXk7ozzm.getInt(Tags.BitsAllocated, 0) >>> 3) * OXk7ozzm.getInt(Tags.Rows, 0)
						* OXk7ozzm.getInt(Tags.Columns, 0) * OXk7ozzm.getInt(Tags.NumberOfFrames, 1)
						* OXk7ozzm.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + vh89jxHK + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			OXk7ozzm.putUI(Tags.StudyInstanceUID, uid(studyUID));
			OXk7ozzm.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			OXk7ozzm.putUI(Tags.SOPInstanceUID, uid(instUID));
			OXk7ozzm.putUI(Tags.SOPClassUID, classUID);
			if (!OXk7ozzm.contains(Tags.NumberOfSamples)) {
				OXk7ozzm.putUS(Tags.NumberOfSamples, 1);
			}
			if (!OXk7ozzm.contains(Tags.PhotometricInterpretation)) {
				OXk7ozzm.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				OXk7ozzm.setFileMetaInfo(fact.newFileMetaInfo(OXk7ozzm, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream C4HNyE3s = new BufferedOutputStream(new FileOutputStream(KqwH6FOR));
			try {
			} finally {
				OXk7ozzm.writeFile(C4HNyE3s, encodeParam());
				if (Mv0P57c9) {
					if (!skipGroupLen) {
						C4HNyE3s.write(PXDATA_GROUPLEN);
						int NWkRSSyl = MOzXMgWX + 8;
						C4HNyE3s.write((byte) NWkRSSyl);
						C4HNyE3s.write((byte) (NWkRSSyl >> 8));
						C4HNyE3s.write((byte) (NWkRSSyl >> 16));
						C4HNyE3s.write((byte) (NWkRSSyl >> 24));
					}
					C4HNyE3s.write(PXDATA_TAG);
					C4HNyE3s.write((byte) MOzXMgWX);
					C4HNyE3s.write((byte) (MOzXMgWX >> 8));
					C4HNyE3s.write((byte) (MOzXMgWX >> 16));
					C4HNyE3s.write((byte) (MOzXMgWX >> 24));
				}
				if (Gk7ewneI) {
					int XiwUFkLd, e1R7SEGZ;
					for (; MOzXMgWX > 0; MOzXMgWX -= 3) {
						C4HNyE3s.write(pHmbbD0X.read());
						XiwUFkLd = pHmbbD0X.read();
						e1R7SEGZ = pHmbbD0X.read();
						C4HNyE3s.write(XiwUFkLd & 0x0f);
						C4HNyE3s.write(XiwUFkLd >> 4 | ((e1R7SEGZ & 0x0f) << 4));
						C4HNyE3s.write(e1R7SEGZ >> 4);
					}
				} else {
					for (; MOzXMgWX > 0; --MOzXMgWX) {
						C4HNyE3s.write(pHmbbD0X.read());
					}
				}
				C4HNyE3s.close();
			}
			System.out.print('.');
		} finally {
			pHmbbD0X.close();
		}
	}

}