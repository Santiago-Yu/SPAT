class n812803 {
	public void convert(File QJ7Xwnwi, File jPneGsEI) throws IOException {
		InputStream dFNDXHvy = new BufferedInputStream(new FileInputStream(QJ7Xwnwi));
		DcmParser Nn1ZRJ62 = pfact.newDcmParser(dFNDXHvy);
		Dataset iN6Ls9Qo = fact.newDataset();
		Nn1ZRJ62.setDcmHandler(iN6Ls9Qo.getDcmHandler());
		try {
			FileFormat jJtHJQaJ = Nn1ZRJ62.detectFileFormat();
			if (jJtHJQaJ != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + QJ7Xwnwi + ": not an ACRNEMA stream!");
				return;
			}
			Nn1ZRJ62.parseDcmFile(jJtHJQaJ, Tags.PixelData);
			if (iN6Ls9Qo.contains(Tags.StudyInstanceUID) || iN6Ls9Qo.contains(Tags.SeriesInstanceUID)
					|| iN6Ls9Qo.contains(Tags.SOPInstanceUID) || iN6Ls9Qo.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + QJ7Xwnwi + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean KsNFzTeb = Nn1ZRJ62.getReadTag() == Tags.PixelData;
			boolean cFiLWral = KsNFzTeb && iN6Ls9Qo.getInt(Tags.BitsAllocated, 0) == 12;
			int H9pg3qGN = Nn1ZRJ62.getReadLength();
			if (KsNFzTeb) {
				if (cFiLWral) {
					iN6Ls9Qo.putUS(Tags.BitsAllocated, 16);
					H9pg3qGN = H9pg3qGN * 4 / 3;
				}
				if (H9pg3qGN != (iN6Ls9Qo.getInt(Tags.BitsAllocated, 0) >>> 3) * iN6Ls9Qo.getInt(Tags.Rows, 0)
						* iN6Ls9Qo.getInt(Tags.Columns, 0) * iN6Ls9Qo.getInt(Tags.NumberOfFrames, 1)
						* iN6Ls9Qo.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + QJ7Xwnwi + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			iN6Ls9Qo.putUI(Tags.StudyInstanceUID, uid(studyUID));
			iN6Ls9Qo.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			iN6Ls9Qo.putUI(Tags.SOPInstanceUID, uid(instUID));
			iN6Ls9Qo.putUI(Tags.SOPClassUID, classUID);
			if (!iN6Ls9Qo.contains(Tags.NumberOfSamples)) {
				iN6Ls9Qo.putUS(Tags.NumberOfSamples, 1);
			}
			if (!iN6Ls9Qo.contains(Tags.PhotometricInterpretation)) {
				iN6Ls9Qo.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				iN6Ls9Qo.setFileMetaInfo(fact.newFileMetaInfo(iN6Ls9Qo, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream nJeWRseU = new BufferedOutputStream(new FileOutputStream(jPneGsEI));
			try {
			} finally {
				iN6Ls9Qo.writeFile(nJeWRseU, encodeParam());
				if (KsNFzTeb) {
					if (!skipGroupLen) {
						nJeWRseU.write(PXDATA_GROUPLEN);
						int vf1aZevo = H9pg3qGN + 8;
						nJeWRseU.write((byte) vf1aZevo);
						nJeWRseU.write((byte) (vf1aZevo >> 8));
						nJeWRseU.write((byte) (vf1aZevo >> 16));
						nJeWRseU.write((byte) (vf1aZevo >> 24));
					}
					nJeWRseU.write(PXDATA_TAG);
					nJeWRseU.write((byte) H9pg3qGN);
					nJeWRseU.write((byte) (H9pg3qGN >> 8));
					nJeWRseU.write((byte) (H9pg3qGN >> 16));
					nJeWRseU.write((byte) (H9pg3qGN >> 24));
				}
				if (cFiLWral) {
					int fYcWwrYu, mwV8PwNp;
					for (; H9pg3qGN > 0; H9pg3qGN -= 3) {
						nJeWRseU.write(dFNDXHvy.read());
						fYcWwrYu = dFNDXHvy.read();
						mwV8PwNp = dFNDXHvy.read();
						nJeWRseU.write(fYcWwrYu & 0x0f);
						nJeWRseU.write(fYcWwrYu >> 4 | ((mwV8PwNp & 0x0f) << 4));
						nJeWRseU.write(mwV8PwNp >> 4);
					}
				} else {
					for (; H9pg3qGN > 0; --H9pg3qGN) {
						nJeWRseU.write(dFNDXHvy.read());
					}
				}
				nJeWRseU.close();
			}
			System.out.print('.');
		} finally {
			dFNDXHvy.close();
		}
	}

}