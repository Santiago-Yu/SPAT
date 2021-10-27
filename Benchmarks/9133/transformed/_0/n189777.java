class n189777 {
	public void convert(File AxOpFudm, File C2AVYle4) throws IOException {
		InputStream K27B3LhV = new BufferedInputStream(new FileInputStream(AxOpFudm));
		DcmParser gskreaUN = pfact.newDcmParser(K27B3LhV);
		Dataset ZRUm6Gl9 = fact.newDataset();
		gskreaUN.setDcmHandler(ZRUm6Gl9.getDcmHandler());
		try {
			FileFormat QckQRQiI = gskreaUN.detectFileFormat();
			if (QckQRQiI != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + AxOpFudm + ": not an ACRNEMA stream!");
				return;
			}
			gskreaUN.parseDcmFile(QckQRQiI, Tags.PixelData);
			if (ZRUm6Gl9.contains(Tags.StudyInstanceUID) || ZRUm6Gl9.contains(Tags.SeriesInstanceUID)
					|| ZRUm6Gl9.contains(Tags.SOPInstanceUID) || ZRUm6Gl9.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + AxOpFudm + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean iO9afJKB = gskreaUN.getReadTag() == Tags.PixelData;
			boolean JmPcjurS = iO9afJKB && ZRUm6Gl9.getInt(Tags.BitsAllocated, 0) == 12;
			int aj8WJLnE = gskreaUN.getReadLength();
			if (iO9afJKB) {
				if (JmPcjurS) {
					ZRUm6Gl9.putUS(Tags.BitsAllocated, 16);
					aj8WJLnE = aj8WJLnE * 4 / 3;
				}
				if (aj8WJLnE != (ZRUm6Gl9.getInt(Tags.BitsAllocated, 0) >>> 3) * ZRUm6Gl9.getInt(Tags.Rows, 0)
						* ZRUm6Gl9.getInt(Tags.Columns, 0) * ZRUm6Gl9.getInt(Tags.NumberOfFrames, 1)
						* ZRUm6Gl9.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + AxOpFudm + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			ZRUm6Gl9.putUI(Tags.StudyInstanceUID, uid(studyUID));
			ZRUm6Gl9.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			ZRUm6Gl9.putUI(Tags.SOPInstanceUID, uid(instUID));
			ZRUm6Gl9.putUI(Tags.SOPClassUID, classUID);
			if (!ZRUm6Gl9.contains(Tags.NumberOfSamples)) {
				ZRUm6Gl9.putUS(Tags.NumberOfSamples, 1);
			}
			if (!ZRUm6Gl9.contains(Tags.PhotometricInterpretation)) {
				ZRUm6Gl9.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				ZRUm6Gl9.setFileMetaInfo(fact.newFileMetaInfo(ZRUm6Gl9, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream tf9ImQmc = new BufferedOutputStream(new FileOutputStream(C2AVYle4));
			try {
			} finally {
				ZRUm6Gl9.writeFile(tf9ImQmc, encodeParam());
				if (iO9afJKB) {
					if (!skipGroupLen) {
						tf9ImQmc.write(PXDATA_GROUPLEN);
						int RxdIPRLk = aj8WJLnE + 8;
						tf9ImQmc.write((byte) RxdIPRLk);
						tf9ImQmc.write((byte) (RxdIPRLk >> 8));
						tf9ImQmc.write((byte) (RxdIPRLk >> 16));
						tf9ImQmc.write((byte) (RxdIPRLk >> 24));
					}
					tf9ImQmc.write(PXDATA_TAG);
					tf9ImQmc.write((byte) aj8WJLnE);
					tf9ImQmc.write((byte) (aj8WJLnE >> 8));
					tf9ImQmc.write((byte) (aj8WJLnE >> 16));
					tf9ImQmc.write((byte) (aj8WJLnE >> 24));
				}
				if (JmPcjurS) {
					int bXGtx98U, zVnzbqA6;
					for (; aj8WJLnE > 0; aj8WJLnE -= 3) {
						tf9ImQmc.write(K27B3LhV.read());
						bXGtx98U = K27B3LhV.read();
						zVnzbqA6 = K27B3LhV.read();
						tf9ImQmc.write(bXGtx98U & 0x0f);
						tf9ImQmc.write(bXGtx98U >> 4 | ((zVnzbqA6 & 0x0f) << 4));
						tf9ImQmc.write(zVnzbqA6 >> 4);
					}
				} else {
					for (; aj8WJLnE > 0; --aj8WJLnE) {
						tf9ImQmc.write(K27B3LhV.read());
					}
				}
				tf9ImQmc.close();
			}
			System.out.print('.');
		} finally {
			K27B3LhV.close();
		}
	}

}