class n727183 {
	public void convert(File c0GY5YvQ, File z1iOrxlx) throws IOException {
		InputStream xtmPvZHc = new BufferedInputStream(new FileInputStream(c0GY5YvQ));
		DcmParser ivIPOc6B = pfact.newDcmParser(xtmPvZHc);
		Dataset GuOdr62s = fact.newDataset();
		ivIPOc6B.setDcmHandler(GuOdr62s.getDcmHandler());
		try {
			FileFormat WFOSuxUq = ivIPOc6B.detectFileFormat();
			if (WFOSuxUq != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + c0GY5YvQ + ": not an ACRNEMA stream!");
				return;
			}
			ivIPOc6B.parseDcmFile(WFOSuxUq, Tags.PixelData);
			if (GuOdr62s.contains(Tags.StudyInstanceUID) || GuOdr62s.contains(Tags.SeriesInstanceUID)
					|| GuOdr62s.contains(Tags.SOPInstanceUID) || GuOdr62s.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + c0GY5YvQ + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean s79p2nte = ivIPOc6B.getReadTag() == Tags.PixelData;
			boolean fQqryD6V = s79p2nte && GuOdr62s.getInt(Tags.BitsAllocated, 0) == 12;
			int JWXEudic = ivIPOc6B.getReadLength();
			if (s79p2nte) {
				if (fQqryD6V) {
					GuOdr62s.putUS(Tags.BitsAllocated, 16);
					JWXEudic = JWXEudic * 4 / 3;
				}
				if (JWXEudic != (GuOdr62s.getInt(Tags.BitsAllocated, 0) >>> 3) * GuOdr62s.getInt(Tags.Rows, 0)
						* GuOdr62s.getInt(Tags.Columns, 0) * GuOdr62s.getInt(Tags.NumberOfFrames, 1)
						* GuOdr62s.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + c0GY5YvQ + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			GuOdr62s.putUI(Tags.StudyInstanceUID, uid(studyUID));
			GuOdr62s.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			GuOdr62s.putUI(Tags.SOPInstanceUID, uid(instUID));
			GuOdr62s.putUI(Tags.SOPClassUID, classUID);
			if (!GuOdr62s.contains(Tags.NumberOfSamples)) {
				GuOdr62s.putUS(Tags.NumberOfSamples, 1);
			}
			if (!GuOdr62s.contains(Tags.PhotometricInterpretation)) {
				GuOdr62s.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				GuOdr62s.setFileMetaInfo(fact.newFileMetaInfo(GuOdr62s, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Q8gksIeG = new BufferedOutputStream(new FileOutputStream(z1iOrxlx));
			try {
			} finally {
				GuOdr62s.writeFile(Q8gksIeG, encodeParam());
				if (s79p2nte) {
					if (!skipGroupLen) {
						Q8gksIeG.write(PXDATA_GROUPLEN);
						int lLSsXgyd = JWXEudic + 8;
						Q8gksIeG.write((byte) lLSsXgyd);
						Q8gksIeG.write((byte) (lLSsXgyd >> 8));
						Q8gksIeG.write((byte) (lLSsXgyd >> 16));
						Q8gksIeG.write((byte) (lLSsXgyd >> 24));
					}
					Q8gksIeG.write(PXDATA_TAG);
					Q8gksIeG.write((byte) JWXEudic);
					Q8gksIeG.write((byte) (JWXEudic >> 8));
					Q8gksIeG.write((byte) (JWXEudic >> 16));
					Q8gksIeG.write((byte) (JWXEudic >> 24));
				}
				if (fQqryD6V) {
					int YxB2xmNa, rgkKJRmJ;
					for (; JWXEudic > 0; JWXEudic -= 3) {
						Q8gksIeG.write(xtmPvZHc.read());
						YxB2xmNa = xtmPvZHc.read();
						rgkKJRmJ = xtmPvZHc.read();
						Q8gksIeG.write(YxB2xmNa & 0x0f);
						Q8gksIeG.write(YxB2xmNa >> 4 | ((rgkKJRmJ & 0x0f) << 4));
						Q8gksIeG.write(rgkKJRmJ >> 4);
					}
				} else {
					for (; JWXEudic > 0; --JWXEudic) {
						Q8gksIeG.write(xtmPvZHc.read());
					}
				}
				Q8gksIeG.close();
			}
			System.out.print('.');
		} finally {
			xtmPvZHc.close();
		}
	}

}