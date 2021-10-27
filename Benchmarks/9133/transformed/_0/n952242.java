class n952242 {
	public void convert(File tIaMza08, File WQldSyA4) throws IOException {
		InputStream wurvsAWb = new BufferedInputStream(new FileInputStream(tIaMza08));
		DcmParser ki19fx0P = pfact.newDcmParser(wurvsAWb);
		Dataset dA6rZOQI = fact.newDataset();
		ki19fx0P.setDcmHandler(dA6rZOQI.getDcmHandler());
		try {
			FileFormat RsUiHAgC = ki19fx0P.detectFileFormat();
			if (RsUiHAgC != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + tIaMza08 + ": not an ACRNEMA stream!");
				return;
			}
			ki19fx0P.parseDcmFile(RsUiHAgC, Tags.PixelData);
			if (dA6rZOQI.contains(Tags.StudyInstanceUID) || dA6rZOQI.contains(Tags.SeriesInstanceUID)
					|| dA6rZOQI.contains(Tags.SOPInstanceUID) || dA6rZOQI.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + tIaMza08 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean I3yG4pId = ki19fx0P.getReadTag() == Tags.PixelData;
			boolean HT0hikGO = I3yG4pId && dA6rZOQI.getInt(Tags.BitsAllocated, 0) == 12;
			int Mh2A5p6j = ki19fx0P.getReadLength();
			if (I3yG4pId) {
				if (HT0hikGO) {
					dA6rZOQI.putUS(Tags.BitsAllocated, 16);
					Mh2A5p6j = Mh2A5p6j * 4 / 3;
				}
				if (Mh2A5p6j != (dA6rZOQI.getInt(Tags.BitsAllocated, 0) >>> 3) * dA6rZOQI.getInt(Tags.Rows, 0)
						* dA6rZOQI.getInt(Tags.Columns, 0) * dA6rZOQI.getInt(Tags.NumberOfFrames, 1)
						* dA6rZOQI.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + tIaMza08 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			dA6rZOQI.putUI(Tags.StudyInstanceUID, uid(studyUID));
			dA6rZOQI.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			dA6rZOQI.putUI(Tags.SOPInstanceUID, uid(instUID));
			dA6rZOQI.putUI(Tags.SOPClassUID, classUID);
			if (!dA6rZOQI.contains(Tags.NumberOfSamples)) {
				dA6rZOQI.putUS(Tags.NumberOfSamples, 1);
			}
			if (!dA6rZOQI.contains(Tags.PhotometricInterpretation)) {
				dA6rZOQI.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				dA6rZOQI.setFileMetaInfo(fact.newFileMetaInfo(dA6rZOQI, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream p4GnIuBm = new BufferedOutputStream(new FileOutputStream(WQldSyA4));
			try {
			} finally {
				dA6rZOQI.writeFile(p4GnIuBm, encodeParam());
				if (I3yG4pId) {
					if (!skipGroupLen) {
						p4GnIuBm.write(PXDATA_GROUPLEN);
						int eVG5fffL = Mh2A5p6j + 8;
						p4GnIuBm.write((byte) eVG5fffL);
						p4GnIuBm.write((byte) (eVG5fffL >> 8));
						p4GnIuBm.write((byte) (eVG5fffL >> 16));
						p4GnIuBm.write((byte) (eVG5fffL >> 24));
					}
					p4GnIuBm.write(PXDATA_TAG);
					p4GnIuBm.write((byte) Mh2A5p6j);
					p4GnIuBm.write((byte) (Mh2A5p6j >> 8));
					p4GnIuBm.write((byte) (Mh2A5p6j >> 16));
					p4GnIuBm.write((byte) (Mh2A5p6j >> 24));
				}
				if (HT0hikGO) {
					int BsIYMSBD, ILs0YLw4;
					for (; Mh2A5p6j > 0; Mh2A5p6j -= 3) {
						p4GnIuBm.write(wurvsAWb.read());
						BsIYMSBD = wurvsAWb.read();
						ILs0YLw4 = wurvsAWb.read();
						p4GnIuBm.write(BsIYMSBD & 0x0f);
						p4GnIuBm.write(BsIYMSBD >> 4 | ((ILs0YLw4 & 0x0f) << 4));
						p4GnIuBm.write(ILs0YLw4 >> 4);
					}
				} else {
					for (; Mh2A5p6j > 0; --Mh2A5p6j) {
						p4GnIuBm.write(wurvsAWb.read());
					}
				}
				p4GnIuBm.close();
			}
			System.out.print('.');
		} finally {
			wurvsAWb.close();
		}
	}

}