class n859157 {
	public void convert(File OuVLbJzS, File SNAZLkUf) throws IOException {
		InputStream UmzbKTnW = new BufferedInputStream(new FileInputStream(OuVLbJzS));
		DcmParser VS6cKYEn = pfact.newDcmParser(UmzbKTnW);
		Dataset UPc3F5H9 = fact.newDataset();
		VS6cKYEn.setDcmHandler(UPc3F5H9.getDcmHandler());
		try {
			FileFormat mWTNqcAh = VS6cKYEn.detectFileFormat();
			if (mWTNqcAh != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + OuVLbJzS + ": not an ACRNEMA stream!");
				return;
			}
			VS6cKYEn.parseDcmFile(mWTNqcAh, Tags.PixelData);
			if (UPc3F5H9.contains(Tags.StudyInstanceUID) || UPc3F5H9.contains(Tags.SeriesInstanceUID)
					|| UPc3F5H9.contains(Tags.SOPInstanceUID) || UPc3F5H9.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + OuVLbJzS + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean eq9XMyxF = VS6cKYEn.getReadTag() == Tags.PixelData;
			boolean j63EQl9p = eq9XMyxF && UPc3F5H9.getInt(Tags.BitsAllocated, 0) == 12;
			int mjgLPapD = VS6cKYEn.getReadLength();
			if (eq9XMyxF) {
				if (j63EQl9p) {
					UPc3F5H9.putUS(Tags.BitsAllocated, 16);
					mjgLPapD = mjgLPapD * 4 / 3;
				}
				if (mjgLPapD != (UPc3F5H9.getInt(Tags.BitsAllocated, 0) >>> 3) * UPc3F5H9.getInt(Tags.Rows, 0)
						* UPc3F5H9.getInt(Tags.Columns, 0) * UPc3F5H9.getInt(Tags.NumberOfFrames, 1)
						* UPc3F5H9.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + OuVLbJzS + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			UPc3F5H9.putUI(Tags.StudyInstanceUID, uid(studyUID));
			UPc3F5H9.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			UPc3F5H9.putUI(Tags.SOPInstanceUID, uid(instUID));
			UPc3F5H9.putUI(Tags.SOPClassUID, classUID);
			if (!UPc3F5H9.contains(Tags.NumberOfSamples)) {
				UPc3F5H9.putUS(Tags.NumberOfSamples, 1);
			}
			if (!UPc3F5H9.contains(Tags.PhotometricInterpretation)) {
				UPc3F5H9.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				UPc3F5H9.setFileMetaInfo(fact.newFileMetaInfo(UPc3F5H9, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Q4eC0TfR = new BufferedOutputStream(new FileOutputStream(SNAZLkUf));
			try {
			} finally {
				UPc3F5H9.writeFile(Q4eC0TfR, encodeParam());
				if (eq9XMyxF) {
					if (!skipGroupLen) {
						Q4eC0TfR.write(PXDATA_GROUPLEN);
						int fkNO3fcQ = mjgLPapD + 8;
						Q4eC0TfR.write((byte) fkNO3fcQ);
						Q4eC0TfR.write((byte) (fkNO3fcQ >> 8));
						Q4eC0TfR.write((byte) (fkNO3fcQ >> 16));
						Q4eC0TfR.write((byte) (fkNO3fcQ >> 24));
					}
					Q4eC0TfR.write(PXDATA_TAG);
					Q4eC0TfR.write((byte) mjgLPapD);
					Q4eC0TfR.write((byte) (mjgLPapD >> 8));
					Q4eC0TfR.write((byte) (mjgLPapD >> 16));
					Q4eC0TfR.write((byte) (mjgLPapD >> 24));
				}
				if (j63EQl9p) {
					int gmqyaHpT, glUqzGj8;
					for (; mjgLPapD > 0; mjgLPapD -= 3) {
						Q4eC0TfR.write(UmzbKTnW.read());
						gmqyaHpT = UmzbKTnW.read();
						glUqzGj8 = UmzbKTnW.read();
						Q4eC0TfR.write(gmqyaHpT & 0x0f);
						Q4eC0TfR.write(gmqyaHpT >> 4 | ((glUqzGj8 & 0x0f) << 4));
						Q4eC0TfR.write(glUqzGj8 >> 4);
					}
				} else {
					for (; mjgLPapD > 0; --mjgLPapD) {
						Q4eC0TfR.write(UmzbKTnW.read());
					}
				}
				Q4eC0TfR.close();
			}
			System.out.print('.');
		} finally {
			UmzbKTnW.close();
		}
	}

}