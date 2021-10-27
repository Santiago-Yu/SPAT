class n849586 {
	public void convert(File xyjH8yRo, File Lj4BbfbH) throws IOException {
		InputStream okxlxZed = new BufferedInputStream(new FileInputStream(xyjH8yRo));
		DcmParser Iomxhs3X = pfact.newDcmParser(okxlxZed);
		Dataset u3pA0SfQ = fact.newDataset();
		Iomxhs3X.setDcmHandler(u3pA0SfQ.getDcmHandler());
		try {
			FileFormat Jm5ab2Qs = Iomxhs3X.detectFileFormat();
			if (Jm5ab2Qs != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + xyjH8yRo + ": not an ACRNEMA stream!");
				return;
			}
			Iomxhs3X.parseDcmFile(Jm5ab2Qs, Tags.PixelData);
			if (u3pA0SfQ.contains(Tags.StudyInstanceUID) || u3pA0SfQ.contains(Tags.SeriesInstanceUID)
					|| u3pA0SfQ.contains(Tags.SOPInstanceUID) || u3pA0SfQ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + xyjH8yRo + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Vwslffh3 = Iomxhs3X.getReadTag() == Tags.PixelData;
			boolean bB5LxUg3 = Vwslffh3 && u3pA0SfQ.getInt(Tags.BitsAllocated, 0) == 12;
			int ljIJ9GLm = Iomxhs3X.getReadLength();
			if (Vwslffh3) {
				if (bB5LxUg3) {
					u3pA0SfQ.putUS(Tags.BitsAllocated, 16);
					ljIJ9GLm = ljIJ9GLm * 4 / 3;
				}
				if (ljIJ9GLm != (u3pA0SfQ.getInt(Tags.BitsAllocated, 0) >>> 3) * u3pA0SfQ.getInt(Tags.Rows, 0)
						* u3pA0SfQ.getInt(Tags.Columns, 0) * u3pA0SfQ.getInt(Tags.NumberOfFrames, 1)
						* u3pA0SfQ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + xyjH8yRo + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			u3pA0SfQ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			u3pA0SfQ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			u3pA0SfQ.putUI(Tags.SOPInstanceUID, uid(instUID));
			u3pA0SfQ.putUI(Tags.SOPClassUID, classUID);
			if (!u3pA0SfQ.contains(Tags.NumberOfSamples)) {
				u3pA0SfQ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!u3pA0SfQ.contains(Tags.PhotometricInterpretation)) {
				u3pA0SfQ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				u3pA0SfQ.setFileMetaInfo(fact.newFileMetaInfo(u3pA0SfQ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream vyxWHChA = new BufferedOutputStream(new FileOutputStream(Lj4BbfbH));
			try {
			} finally {
				u3pA0SfQ.writeFile(vyxWHChA, encodeParam());
				if (Vwslffh3) {
					if (!skipGroupLen) {
						vyxWHChA.write(PXDATA_GROUPLEN);
						int HSs8wQ7E = ljIJ9GLm + 8;
						vyxWHChA.write((byte) HSs8wQ7E);
						vyxWHChA.write((byte) (HSs8wQ7E >> 8));
						vyxWHChA.write((byte) (HSs8wQ7E >> 16));
						vyxWHChA.write((byte) (HSs8wQ7E >> 24));
					}
					vyxWHChA.write(PXDATA_TAG);
					vyxWHChA.write((byte) ljIJ9GLm);
					vyxWHChA.write((byte) (ljIJ9GLm >> 8));
					vyxWHChA.write((byte) (ljIJ9GLm >> 16));
					vyxWHChA.write((byte) (ljIJ9GLm >> 24));
				}
				if (bB5LxUg3) {
					int DAoOfAi9, E2e5DN5b;
					for (; ljIJ9GLm > 0; ljIJ9GLm -= 3) {
						vyxWHChA.write(okxlxZed.read());
						DAoOfAi9 = okxlxZed.read();
						E2e5DN5b = okxlxZed.read();
						vyxWHChA.write(DAoOfAi9 & 0x0f);
						vyxWHChA.write(DAoOfAi9 >> 4 | ((E2e5DN5b & 0x0f) << 4));
						vyxWHChA.write(E2e5DN5b >> 4);
					}
				} else {
					for (; ljIJ9GLm > 0; --ljIJ9GLm) {
						vyxWHChA.write(okxlxZed.read());
					}
				}
				vyxWHChA.close();
			}
			System.out.print('.');
		} finally {
			okxlxZed.close();
		}
	}

}