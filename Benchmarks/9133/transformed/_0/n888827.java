class n888827 {
	public void convert(File eCn4hetY, File DUBcLF4O) throws IOException {
		InputStream c50jvPsT = new BufferedInputStream(new FileInputStream(eCn4hetY));
		DcmParser u19KwuZH = pfact.newDcmParser(c50jvPsT);
		Dataset NE4JzAlP = fact.newDataset();
		u19KwuZH.setDcmHandler(NE4JzAlP.getDcmHandler());
		try {
			FileFormat fdLAsUra = u19KwuZH.detectFileFormat();
			if (fdLAsUra != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + eCn4hetY + ": not an ACRNEMA stream!");
				return;
			}
			u19KwuZH.parseDcmFile(fdLAsUra, Tags.PixelData);
			if (NE4JzAlP.contains(Tags.StudyInstanceUID) || NE4JzAlP.contains(Tags.SeriesInstanceUID)
					|| NE4JzAlP.contains(Tags.SOPInstanceUID) || NE4JzAlP.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + eCn4hetY + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean MbLjFwqR = u19KwuZH.getReadTag() == Tags.PixelData;
			boolean QdzkWGv8 = MbLjFwqR && NE4JzAlP.getInt(Tags.BitsAllocated, 0) == 12;
			int uCrbCZwG = u19KwuZH.getReadLength();
			if (MbLjFwqR) {
				if (QdzkWGv8) {
					NE4JzAlP.putUS(Tags.BitsAllocated, 16);
					uCrbCZwG = uCrbCZwG * 4 / 3;
				}
				if (uCrbCZwG != (NE4JzAlP.getInt(Tags.BitsAllocated, 0) >>> 3) * NE4JzAlP.getInt(Tags.Rows, 0)
						* NE4JzAlP.getInt(Tags.Columns, 0) * NE4JzAlP.getInt(Tags.NumberOfFrames, 1)
						* NE4JzAlP.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + eCn4hetY + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			NE4JzAlP.putUI(Tags.StudyInstanceUID, uid(studyUID));
			NE4JzAlP.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			NE4JzAlP.putUI(Tags.SOPInstanceUID, uid(instUID));
			NE4JzAlP.putUI(Tags.SOPClassUID, classUID);
			if (!NE4JzAlP.contains(Tags.NumberOfSamples)) {
				NE4JzAlP.putUS(Tags.NumberOfSamples, 1);
			}
			if (!NE4JzAlP.contains(Tags.PhotometricInterpretation)) {
				NE4JzAlP.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				NE4JzAlP.setFileMetaInfo(fact.newFileMetaInfo(NE4JzAlP, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream SbryAvuo = new BufferedOutputStream(new FileOutputStream(DUBcLF4O));
			try {
			} finally {
				NE4JzAlP.writeFile(SbryAvuo, encodeParam());
				if (MbLjFwqR) {
					if (!skipGroupLen) {
						SbryAvuo.write(PXDATA_GROUPLEN);
						int EGsv8Swz = uCrbCZwG + 8;
						SbryAvuo.write((byte) EGsv8Swz);
						SbryAvuo.write((byte) (EGsv8Swz >> 8));
						SbryAvuo.write((byte) (EGsv8Swz >> 16));
						SbryAvuo.write((byte) (EGsv8Swz >> 24));
					}
					SbryAvuo.write(PXDATA_TAG);
					SbryAvuo.write((byte) uCrbCZwG);
					SbryAvuo.write((byte) (uCrbCZwG >> 8));
					SbryAvuo.write((byte) (uCrbCZwG >> 16));
					SbryAvuo.write((byte) (uCrbCZwG >> 24));
				}
				if (QdzkWGv8) {
					int daJTZOR7, w9UkHYmy;
					for (; uCrbCZwG > 0; uCrbCZwG -= 3) {
						SbryAvuo.write(c50jvPsT.read());
						daJTZOR7 = c50jvPsT.read();
						w9UkHYmy = c50jvPsT.read();
						SbryAvuo.write(daJTZOR7 & 0x0f);
						SbryAvuo.write(daJTZOR7 >> 4 | ((w9UkHYmy & 0x0f) << 4));
						SbryAvuo.write(w9UkHYmy >> 4);
					}
				} else {
					for (; uCrbCZwG > 0; --uCrbCZwG) {
						SbryAvuo.write(c50jvPsT.read());
					}
				}
				SbryAvuo.close();
			}
			System.out.print('.');
		} finally {
			c50jvPsT.close();
		}
	}

}