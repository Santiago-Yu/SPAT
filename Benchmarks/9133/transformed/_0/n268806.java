class n268806 {
	public void convert(File VaBV2EzO, File nKCSrnTs) throws IOException {
		InputStream pGK96RBK = new BufferedInputStream(new FileInputStream(VaBV2EzO));
		DcmParser Jven9OHT = pfact.newDcmParser(pGK96RBK);
		Dataset ursptbd3 = fact.newDataset();
		Jven9OHT.setDcmHandler(ursptbd3.getDcmHandler());
		try {
			FileFormat v0sNOOs0 = Jven9OHT.detectFileFormat();
			if (v0sNOOs0 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + VaBV2EzO + ": not an ACRNEMA stream!");
				return;
			}
			Jven9OHT.parseDcmFile(v0sNOOs0, Tags.PixelData);
			if (ursptbd3.contains(Tags.StudyInstanceUID) || ursptbd3.contains(Tags.SeriesInstanceUID)
					|| ursptbd3.contains(Tags.SOPInstanceUID) || ursptbd3.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + VaBV2EzO + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean myNTsEh9 = Jven9OHT.getReadTag() == Tags.PixelData;
			boolean x21bL6Il = myNTsEh9 && ursptbd3.getInt(Tags.BitsAllocated, 0) == 12;
			int VLMRRV12 = Jven9OHT.getReadLength();
			if (myNTsEh9) {
				if (x21bL6Il) {
					ursptbd3.putUS(Tags.BitsAllocated, 16);
					VLMRRV12 = VLMRRV12 * 4 / 3;
				}
				if (VLMRRV12 != (ursptbd3.getInt(Tags.BitsAllocated, 0) >>> 3) * ursptbd3.getInt(Tags.Rows, 0)
						* ursptbd3.getInt(Tags.Columns, 0) * ursptbd3.getInt(Tags.NumberOfFrames, 1)
						* ursptbd3.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + VaBV2EzO + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			ursptbd3.putUI(Tags.StudyInstanceUID, uid(studyUID));
			ursptbd3.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			ursptbd3.putUI(Tags.SOPInstanceUID, uid(instUID));
			ursptbd3.putUI(Tags.SOPClassUID, classUID);
			if (!ursptbd3.contains(Tags.NumberOfSamples)) {
				ursptbd3.putUS(Tags.NumberOfSamples, 1);
			}
			if (!ursptbd3.contains(Tags.PhotometricInterpretation)) {
				ursptbd3.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				ursptbd3.setFileMetaInfo(fact.newFileMetaInfo(ursptbd3, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Io2WwSJr = new BufferedOutputStream(new FileOutputStream(nKCSrnTs));
			try {
			} finally {
				ursptbd3.writeFile(Io2WwSJr, encodeParam());
				if (myNTsEh9) {
					if (!skipGroupLen) {
						Io2WwSJr.write(PXDATA_GROUPLEN);
						int PCXCng9e = VLMRRV12 + 8;
						Io2WwSJr.write((byte) PCXCng9e);
						Io2WwSJr.write((byte) (PCXCng9e >> 8));
						Io2WwSJr.write((byte) (PCXCng9e >> 16));
						Io2WwSJr.write((byte) (PCXCng9e >> 24));
					}
					Io2WwSJr.write(PXDATA_TAG);
					Io2WwSJr.write((byte) VLMRRV12);
					Io2WwSJr.write((byte) (VLMRRV12 >> 8));
					Io2WwSJr.write((byte) (VLMRRV12 >> 16));
					Io2WwSJr.write((byte) (VLMRRV12 >> 24));
				}
				if (x21bL6Il) {
					int poFOZGbK, KiUl0yU4;
					for (; VLMRRV12 > 0; VLMRRV12 -= 3) {
						Io2WwSJr.write(pGK96RBK.read());
						poFOZGbK = pGK96RBK.read();
						KiUl0yU4 = pGK96RBK.read();
						Io2WwSJr.write(poFOZGbK & 0x0f);
						Io2WwSJr.write(poFOZGbK >> 4 | ((KiUl0yU4 & 0x0f) << 4));
						Io2WwSJr.write(KiUl0yU4 >> 4);
					}
				} else {
					for (; VLMRRV12 > 0; --VLMRRV12) {
						Io2WwSJr.write(pGK96RBK.read());
					}
				}
				Io2WwSJr.close();
			}
			System.out.print('.');
		} finally {
			pGK96RBK.close();
		}
	}

}