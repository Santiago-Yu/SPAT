class n413237 {
	public void convert(File jydSAp4I, File B0J8zexs) throws IOException {
		InputStream A8RJ0c4G = new BufferedInputStream(new FileInputStream(jydSAp4I));
		DcmParser ncz0vwdX = pfact.newDcmParser(A8RJ0c4G);
		Dataset vHDI62AB = fact.newDataset();
		ncz0vwdX.setDcmHandler(vHDI62AB.getDcmHandler());
		try {
			FileFormat cjG5yDKo = ncz0vwdX.detectFileFormat();
			if (cjG5yDKo != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + jydSAp4I + ": not an ACRNEMA stream!");
				return;
			}
			ncz0vwdX.parseDcmFile(cjG5yDKo, Tags.PixelData);
			if (vHDI62AB.contains(Tags.StudyInstanceUID) || vHDI62AB.contains(Tags.SeriesInstanceUID)
					|| vHDI62AB.contains(Tags.SOPInstanceUID) || vHDI62AB.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + jydSAp4I + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean pPBkk5ND = ncz0vwdX.getReadTag() == Tags.PixelData;
			boolean nOGkBFJF = pPBkk5ND && vHDI62AB.getInt(Tags.BitsAllocated, 0) == 12;
			int f60NEaT5 = ncz0vwdX.getReadLength();
			if (pPBkk5ND) {
				if (nOGkBFJF) {
					vHDI62AB.putUS(Tags.BitsAllocated, 16);
					f60NEaT5 = f60NEaT5 * 4 / 3;
				}
				if (f60NEaT5 != (vHDI62AB.getInt(Tags.BitsAllocated, 0) >>> 3) * vHDI62AB.getInt(Tags.Rows, 0)
						* vHDI62AB.getInt(Tags.Columns, 0) * vHDI62AB.getInt(Tags.NumberOfFrames, 1)
						* vHDI62AB.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + jydSAp4I + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			vHDI62AB.putUI(Tags.StudyInstanceUID, uid(studyUID));
			vHDI62AB.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			vHDI62AB.putUI(Tags.SOPInstanceUID, uid(instUID));
			vHDI62AB.putUI(Tags.SOPClassUID, classUID);
			if (!vHDI62AB.contains(Tags.NumberOfSamples)) {
				vHDI62AB.putUS(Tags.NumberOfSamples, 1);
			}
			if (!vHDI62AB.contains(Tags.PhotometricInterpretation)) {
				vHDI62AB.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				vHDI62AB.setFileMetaInfo(fact.newFileMetaInfo(vHDI62AB, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream l5NtFMeE = new BufferedOutputStream(new FileOutputStream(B0J8zexs));
			try {
			} finally {
				vHDI62AB.writeFile(l5NtFMeE, encodeParam());
				if (pPBkk5ND) {
					if (!skipGroupLen) {
						l5NtFMeE.write(PXDATA_GROUPLEN);
						int tvRhEhPW = f60NEaT5 + 8;
						l5NtFMeE.write((byte) tvRhEhPW);
						l5NtFMeE.write((byte) (tvRhEhPW >> 8));
						l5NtFMeE.write((byte) (tvRhEhPW >> 16));
						l5NtFMeE.write((byte) (tvRhEhPW >> 24));
					}
					l5NtFMeE.write(PXDATA_TAG);
					l5NtFMeE.write((byte) f60NEaT5);
					l5NtFMeE.write((byte) (f60NEaT5 >> 8));
					l5NtFMeE.write((byte) (f60NEaT5 >> 16));
					l5NtFMeE.write((byte) (f60NEaT5 >> 24));
				}
				if (nOGkBFJF) {
					int Bp5tq2gH, x1PGAaX9;
					for (; f60NEaT5 > 0; f60NEaT5 -= 3) {
						l5NtFMeE.write(A8RJ0c4G.read());
						Bp5tq2gH = A8RJ0c4G.read();
						x1PGAaX9 = A8RJ0c4G.read();
						l5NtFMeE.write(Bp5tq2gH & 0x0f);
						l5NtFMeE.write(Bp5tq2gH >> 4 | ((x1PGAaX9 & 0x0f) << 4));
						l5NtFMeE.write(x1PGAaX9 >> 4);
					}
				} else {
					for (; f60NEaT5 > 0; --f60NEaT5) {
						l5NtFMeE.write(A8RJ0c4G.read());
					}
				}
				l5NtFMeE.close();
			}
			System.out.print('.');
		} finally {
			A8RJ0c4G.close();
		}
	}

}