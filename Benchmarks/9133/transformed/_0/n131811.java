class n131811 {
	public void convert(File VYV5VgFz, File VNU02ASm) throws IOException {
		InputStream G4W0uTLO = new BufferedInputStream(new FileInputStream(VYV5VgFz));
		DcmParser RhcvdVJ2 = pfact.newDcmParser(G4W0uTLO);
		Dataset GESJR78U = fact.newDataset();
		RhcvdVJ2.setDcmHandler(GESJR78U.getDcmHandler());
		try {
			FileFormat uWVsEraR = RhcvdVJ2.detectFileFormat();
			if (uWVsEraR != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + VYV5VgFz + ": not an ACRNEMA stream!");
				return;
			}
			RhcvdVJ2.parseDcmFile(uWVsEraR, Tags.PixelData);
			if (GESJR78U.contains(Tags.StudyInstanceUID) || GESJR78U.contains(Tags.SeriesInstanceUID)
					|| GESJR78U.contains(Tags.SOPInstanceUID) || GESJR78U.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + VYV5VgFz + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean qXgPMw3k = RhcvdVJ2.getReadTag() == Tags.PixelData;
			boolean ujZLtpfe = qXgPMw3k && GESJR78U.getInt(Tags.BitsAllocated, 0) == 12;
			int lMqaJvTw = RhcvdVJ2.getReadLength();
			if (qXgPMw3k) {
				if (ujZLtpfe) {
					GESJR78U.putUS(Tags.BitsAllocated, 16);
					lMqaJvTw = lMqaJvTw * 4 / 3;
				}
				if (lMqaJvTw != (GESJR78U.getInt(Tags.BitsAllocated, 0) >>> 3) * GESJR78U.getInt(Tags.Rows, 0)
						* GESJR78U.getInt(Tags.Columns, 0) * GESJR78U.getInt(Tags.NumberOfFrames, 1)
						* GESJR78U.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + VYV5VgFz + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			GESJR78U.putUI(Tags.StudyInstanceUID, uid(studyUID));
			GESJR78U.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			GESJR78U.putUI(Tags.SOPInstanceUID, uid(instUID));
			GESJR78U.putUI(Tags.SOPClassUID, classUID);
			if (!GESJR78U.contains(Tags.NumberOfSamples)) {
				GESJR78U.putUS(Tags.NumberOfSamples, 1);
			}
			if (!GESJR78U.contains(Tags.PhotometricInterpretation)) {
				GESJR78U.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				GESJR78U.setFileMetaInfo(fact.newFileMetaInfo(GESJR78U, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream cRquUCvL = new BufferedOutputStream(new FileOutputStream(VNU02ASm));
			try {
			} finally {
				GESJR78U.writeFile(cRquUCvL, encodeParam());
				if (qXgPMw3k) {
					if (!skipGroupLen) {
						cRquUCvL.write(PXDATA_GROUPLEN);
						int BKstXNhp = lMqaJvTw + 8;
						cRquUCvL.write((byte) BKstXNhp);
						cRquUCvL.write((byte) (BKstXNhp >> 8));
						cRquUCvL.write((byte) (BKstXNhp >> 16));
						cRquUCvL.write((byte) (BKstXNhp >> 24));
					}
					cRquUCvL.write(PXDATA_TAG);
					cRquUCvL.write((byte) lMqaJvTw);
					cRquUCvL.write((byte) (lMqaJvTw >> 8));
					cRquUCvL.write((byte) (lMqaJvTw >> 16));
					cRquUCvL.write((byte) (lMqaJvTw >> 24));
				}
				if (ujZLtpfe) {
					int ULjPfJxg, uwWP941K;
					for (; lMqaJvTw > 0; lMqaJvTw -= 3) {
						cRquUCvL.write(G4W0uTLO.read());
						ULjPfJxg = G4W0uTLO.read();
						uwWP941K = G4W0uTLO.read();
						cRquUCvL.write(ULjPfJxg & 0x0f);
						cRquUCvL.write(ULjPfJxg >> 4 | ((uwWP941K & 0x0f) << 4));
						cRquUCvL.write(uwWP941K >> 4);
					}
				} else {
					for (; lMqaJvTw > 0; --lMqaJvTw) {
						cRquUCvL.write(G4W0uTLO.read());
					}
				}
				cRquUCvL.close();
			}
			System.out.print('.');
		} finally {
			G4W0uTLO.close();
		}
	}

}