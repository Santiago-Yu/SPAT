class n704314 {
	public void convert(File rf4ctV0a, File BVXEZGMf) throws IOException {
		InputStream t1kfd3l8 = new BufferedInputStream(new FileInputStream(rf4ctV0a));
		DcmParser viMvUvuj = pfact.newDcmParser(t1kfd3l8);
		Dataset pWp3JRFo = fact.newDataset();
		viMvUvuj.setDcmHandler(pWp3JRFo.getDcmHandler());
		try {
			FileFormat JJ6Zx56m = viMvUvuj.detectFileFormat();
			if (JJ6Zx56m != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + rf4ctV0a + ": not an ACRNEMA stream!");
				return;
			}
			viMvUvuj.parseDcmFile(JJ6Zx56m, Tags.PixelData);
			if (pWp3JRFo.contains(Tags.StudyInstanceUID) || pWp3JRFo.contains(Tags.SeriesInstanceUID)
					|| pWp3JRFo.contains(Tags.SOPInstanceUID) || pWp3JRFo.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + rf4ctV0a + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean NS2Rmx81 = viMvUvuj.getReadTag() == Tags.PixelData;
			boolean QF2gL9G9 = NS2Rmx81 && pWp3JRFo.getInt(Tags.BitsAllocated, 0) == 12;
			int dlkmOvYN = viMvUvuj.getReadLength();
			if (NS2Rmx81) {
				if (QF2gL9G9) {
					pWp3JRFo.putUS(Tags.BitsAllocated, 16);
					dlkmOvYN = dlkmOvYN * 4 / 3;
				}
				if (dlkmOvYN != (pWp3JRFo.getInt(Tags.BitsAllocated, 0) >>> 3) * pWp3JRFo.getInt(Tags.Rows, 0)
						* pWp3JRFo.getInt(Tags.Columns, 0) * pWp3JRFo.getInt(Tags.NumberOfFrames, 1)
						* pWp3JRFo.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + rf4ctV0a + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			pWp3JRFo.putUI(Tags.StudyInstanceUID, uid(studyUID));
			pWp3JRFo.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			pWp3JRFo.putUI(Tags.SOPInstanceUID, uid(instUID));
			pWp3JRFo.putUI(Tags.SOPClassUID, classUID);
			if (!pWp3JRFo.contains(Tags.NumberOfSamples)) {
				pWp3JRFo.putUS(Tags.NumberOfSamples, 1);
			}
			if (!pWp3JRFo.contains(Tags.PhotometricInterpretation)) {
				pWp3JRFo.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				pWp3JRFo.setFileMetaInfo(fact.newFileMetaInfo(pWp3JRFo, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream zGEZ479h = new BufferedOutputStream(new FileOutputStream(BVXEZGMf));
			try {
			} finally {
				pWp3JRFo.writeFile(zGEZ479h, encodeParam());
				if (NS2Rmx81) {
					if (!skipGroupLen) {
						zGEZ479h.write(PXDATA_GROUPLEN);
						int ZPdAn0sx = dlkmOvYN + 8;
						zGEZ479h.write((byte) ZPdAn0sx);
						zGEZ479h.write((byte) (ZPdAn0sx >> 8));
						zGEZ479h.write((byte) (ZPdAn0sx >> 16));
						zGEZ479h.write((byte) (ZPdAn0sx >> 24));
					}
					zGEZ479h.write(PXDATA_TAG);
					zGEZ479h.write((byte) dlkmOvYN);
					zGEZ479h.write((byte) (dlkmOvYN >> 8));
					zGEZ479h.write((byte) (dlkmOvYN >> 16));
					zGEZ479h.write((byte) (dlkmOvYN >> 24));
				}
				if (QF2gL9G9) {
					int XqSJagHu, fMa6EmmB;
					for (; dlkmOvYN > 0; dlkmOvYN -= 3) {
						zGEZ479h.write(t1kfd3l8.read());
						XqSJagHu = t1kfd3l8.read();
						fMa6EmmB = t1kfd3l8.read();
						zGEZ479h.write(XqSJagHu & 0x0f);
						zGEZ479h.write(XqSJagHu >> 4 | ((fMa6EmmB & 0x0f) << 4));
						zGEZ479h.write(fMa6EmmB >> 4);
					}
				} else {
					for (; dlkmOvYN > 0; --dlkmOvYN) {
						zGEZ479h.write(t1kfd3l8.read());
					}
				}
				zGEZ479h.close();
			}
			System.out.print('.');
		} finally {
			t1kfd3l8.close();
		}
	}

}