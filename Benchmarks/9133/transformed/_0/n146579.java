class n146579 {
	public void convert(File YCbav4zB, File N3c4ARLi) throws IOException {
		InputStream D7lIoG1N = new BufferedInputStream(new FileInputStream(YCbav4zB));
		DcmParser HBMlSjqW = pfact.newDcmParser(D7lIoG1N);
		Dataset PKQWW9Tu = fact.newDataset();
		HBMlSjqW.setDcmHandler(PKQWW9Tu.getDcmHandler());
		try {
			FileFormat KI78r2Q8 = HBMlSjqW.detectFileFormat();
			if (KI78r2Q8 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + YCbav4zB + ": not an ACRNEMA stream!");
				return;
			}
			HBMlSjqW.parseDcmFile(KI78r2Q8, Tags.PixelData);
			if (PKQWW9Tu.contains(Tags.StudyInstanceUID) || PKQWW9Tu.contains(Tags.SeriesInstanceUID)
					|| PKQWW9Tu.contains(Tags.SOPInstanceUID) || PKQWW9Tu.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + YCbav4zB + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean oYwyjuJz = HBMlSjqW.getReadTag() == Tags.PixelData;
			boolean Vnrg06nn = oYwyjuJz && PKQWW9Tu.getInt(Tags.BitsAllocated, 0) == 12;
			int Be85e0yy = HBMlSjqW.getReadLength();
			if (oYwyjuJz) {
				if (Vnrg06nn) {
					PKQWW9Tu.putUS(Tags.BitsAllocated, 16);
					Be85e0yy = Be85e0yy * 4 / 3;
				}
				if (Be85e0yy != (PKQWW9Tu.getInt(Tags.BitsAllocated, 0) >>> 3) * PKQWW9Tu.getInt(Tags.Rows, 0)
						* PKQWW9Tu.getInt(Tags.Columns, 0) * PKQWW9Tu.getInt(Tags.NumberOfFrames, 1)
						* PKQWW9Tu.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + YCbav4zB + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			PKQWW9Tu.putUI(Tags.StudyInstanceUID, uid(studyUID));
			PKQWW9Tu.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			PKQWW9Tu.putUI(Tags.SOPInstanceUID, uid(instUID));
			PKQWW9Tu.putUI(Tags.SOPClassUID, classUID);
			if (!PKQWW9Tu.contains(Tags.NumberOfSamples)) {
				PKQWW9Tu.putUS(Tags.NumberOfSamples, 1);
			}
			if (!PKQWW9Tu.contains(Tags.PhotometricInterpretation)) {
				PKQWW9Tu.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				PKQWW9Tu.setFileMetaInfo(fact.newFileMetaInfo(PKQWW9Tu, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream ynB62YH7 = new BufferedOutputStream(new FileOutputStream(N3c4ARLi));
			try {
			} finally {
				PKQWW9Tu.writeFile(ynB62YH7, encodeParam());
				if (oYwyjuJz) {
					if (!skipGroupLen) {
						ynB62YH7.write(PXDATA_GROUPLEN);
						int kZ32FWsa = Be85e0yy + 8;
						ynB62YH7.write((byte) kZ32FWsa);
						ynB62YH7.write((byte) (kZ32FWsa >> 8));
						ynB62YH7.write((byte) (kZ32FWsa >> 16));
						ynB62YH7.write((byte) (kZ32FWsa >> 24));
					}
					ynB62YH7.write(PXDATA_TAG);
					ynB62YH7.write((byte) Be85e0yy);
					ynB62YH7.write((byte) (Be85e0yy >> 8));
					ynB62YH7.write((byte) (Be85e0yy >> 16));
					ynB62YH7.write((byte) (Be85e0yy >> 24));
				}
				if (Vnrg06nn) {
					int HXf1Ync4, aBivYoFc;
					for (; Be85e0yy > 0; Be85e0yy -= 3) {
						ynB62YH7.write(D7lIoG1N.read());
						HXf1Ync4 = D7lIoG1N.read();
						aBivYoFc = D7lIoG1N.read();
						ynB62YH7.write(HXf1Ync4 & 0x0f);
						ynB62YH7.write(HXf1Ync4 >> 4 | ((aBivYoFc & 0x0f) << 4));
						ynB62YH7.write(aBivYoFc >> 4);
					}
				} else {
					for (; Be85e0yy > 0; --Be85e0yy) {
						ynB62YH7.write(D7lIoG1N.read());
					}
				}
				ynB62YH7.close();
			}
			System.out.print('.');
		} finally {
			D7lIoG1N.close();
		}
	}

}