class n310580 {
	public void convert(File NCzMwOdh, File eOSoovjY) throws IOException {
		InputStream wwITcGdP = new BufferedInputStream(new FileInputStream(NCzMwOdh));
		DcmParser geN4RUhr = pfact.newDcmParser(wwITcGdP);
		Dataset jrWBqXtl = fact.newDataset();
		geN4RUhr.setDcmHandler(jrWBqXtl.getDcmHandler());
		try {
			FileFormat WvRtQeoA = geN4RUhr.detectFileFormat();
			if (WvRtQeoA != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + NCzMwOdh + ": not an ACRNEMA stream!");
				return;
			}
			geN4RUhr.parseDcmFile(WvRtQeoA, Tags.PixelData);
			if (jrWBqXtl.contains(Tags.StudyInstanceUID) || jrWBqXtl.contains(Tags.SeriesInstanceUID)
					|| jrWBqXtl.contains(Tags.SOPInstanceUID) || jrWBqXtl.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + NCzMwOdh + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean PZReRuxn = geN4RUhr.getReadTag() == Tags.PixelData;
			boolean GacXq7SG = PZReRuxn && jrWBqXtl.getInt(Tags.BitsAllocated, 0) == 12;
			int D1oLeMO7 = geN4RUhr.getReadLength();
			if (PZReRuxn) {
				if (GacXq7SG) {
					jrWBqXtl.putUS(Tags.BitsAllocated, 16);
					D1oLeMO7 = D1oLeMO7 * 4 / 3;
				}
				if (D1oLeMO7 != (jrWBqXtl.getInt(Tags.BitsAllocated, 0) >>> 3) * jrWBqXtl.getInt(Tags.Rows, 0)
						* jrWBqXtl.getInt(Tags.Columns, 0) * jrWBqXtl.getInt(Tags.NumberOfFrames, 1)
						* jrWBqXtl.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + NCzMwOdh + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			jrWBqXtl.putUI(Tags.StudyInstanceUID, uid(studyUID));
			jrWBqXtl.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			jrWBqXtl.putUI(Tags.SOPInstanceUID, uid(instUID));
			jrWBqXtl.putUI(Tags.SOPClassUID, classUID);
			if (!jrWBqXtl.contains(Tags.NumberOfSamples)) {
				jrWBqXtl.putUS(Tags.NumberOfSamples, 1);
			}
			if (!jrWBqXtl.contains(Tags.PhotometricInterpretation)) {
				jrWBqXtl.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				jrWBqXtl.setFileMetaInfo(fact.newFileMetaInfo(jrWBqXtl, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream rSruDyDd = new BufferedOutputStream(new FileOutputStream(eOSoovjY));
			try {
			} finally {
				jrWBqXtl.writeFile(rSruDyDd, encodeParam());
				if (PZReRuxn) {
					if (!skipGroupLen) {
						rSruDyDd.write(PXDATA_GROUPLEN);
						int NF6Ht5Wj = D1oLeMO7 + 8;
						rSruDyDd.write((byte) NF6Ht5Wj);
						rSruDyDd.write((byte) (NF6Ht5Wj >> 8));
						rSruDyDd.write((byte) (NF6Ht5Wj >> 16));
						rSruDyDd.write((byte) (NF6Ht5Wj >> 24));
					}
					rSruDyDd.write(PXDATA_TAG);
					rSruDyDd.write((byte) D1oLeMO7);
					rSruDyDd.write((byte) (D1oLeMO7 >> 8));
					rSruDyDd.write((byte) (D1oLeMO7 >> 16));
					rSruDyDd.write((byte) (D1oLeMO7 >> 24));
				}
				if (GacXq7SG) {
					int ojSaNkGR, AuXIjyEp;
					for (; D1oLeMO7 > 0; D1oLeMO7 -= 3) {
						rSruDyDd.write(wwITcGdP.read());
						ojSaNkGR = wwITcGdP.read();
						AuXIjyEp = wwITcGdP.read();
						rSruDyDd.write(ojSaNkGR & 0x0f);
						rSruDyDd.write(ojSaNkGR >> 4 | ((AuXIjyEp & 0x0f) << 4));
						rSruDyDd.write(AuXIjyEp >> 4);
					}
				} else {
					for (; D1oLeMO7 > 0; --D1oLeMO7) {
						rSruDyDd.write(wwITcGdP.read());
					}
				}
				rSruDyDd.close();
			}
			System.out.print('.');
		} finally {
			wwITcGdP.close();
		}
	}

}