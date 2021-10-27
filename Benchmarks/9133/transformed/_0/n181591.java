class n181591 {
	public void convert(File sNO8s1tt, File ilxOhsaX) throws IOException {
		InputStream lHkuJABv = new BufferedInputStream(new FileInputStream(sNO8s1tt));
		DcmParser quOkiVft = pfact.newDcmParser(lHkuJABv);
		Dataset uQW4iZ1h = fact.newDataset();
		quOkiVft.setDcmHandler(uQW4iZ1h.getDcmHandler());
		try {
			FileFormat mOOYAz7p = quOkiVft.detectFileFormat();
			if (mOOYAz7p != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + sNO8s1tt + ": not an ACRNEMA stream!");
				return;
			}
			quOkiVft.parseDcmFile(mOOYAz7p, Tags.PixelData);
			if (uQW4iZ1h.contains(Tags.StudyInstanceUID) || uQW4iZ1h.contains(Tags.SeriesInstanceUID)
					|| uQW4iZ1h.contains(Tags.SOPInstanceUID) || uQW4iZ1h.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + sNO8s1tt + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean IzJTDr2C = quOkiVft.getReadTag() == Tags.PixelData;
			boolean ANMWoS2b = IzJTDr2C && uQW4iZ1h.getInt(Tags.BitsAllocated, 0) == 12;
			int LqECSnCk = quOkiVft.getReadLength();
			if (IzJTDr2C) {
				if (ANMWoS2b) {
					uQW4iZ1h.putUS(Tags.BitsAllocated, 16);
					LqECSnCk = LqECSnCk * 4 / 3;
				}
				if (LqECSnCk != (uQW4iZ1h.getInt(Tags.BitsAllocated, 0) >>> 3) * uQW4iZ1h.getInt(Tags.Rows, 0)
						* uQW4iZ1h.getInt(Tags.Columns, 0) * uQW4iZ1h.getInt(Tags.NumberOfFrames, 1)
						* uQW4iZ1h.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + sNO8s1tt + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			uQW4iZ1h.putUI(Tags.StudyInstanceUID, uid(studyUID));
			uQW4iZ1h.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			uQW4iZ1h.putUI(Tags.SOPInstanceUID, uid(instUID));
			uQW4iZ1h.putUI(Tags.SOPClassUID, classUID);
			if (!uQW4iZ1h.contains(Tags.NumberOfSamples)) {
				uQW4iZ1h.putUS(Tags.NumberOfSamples, 1);
			}
			if (!uQW4iZ1h.contains(Tags.PhotometricInterpretation)) {
				uQW4iZ1h.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				uQW4iZ1h.setFileMetaInfo(fact.newFileMetaInfo(uQW4iZ1h, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream uPWK6qpm = new BufferedOutputStream(new FileOutputStream(ilxOhsaX));
			try {
			} finally {
				uQW4iZ1h.writeFile(uPWK6qpm, encodeParam());
				if (IzJTDr2C) {
					if (!skipGroupLen) {
						uPWK6qpm.write(PXDATA_GROUPLEN);
						int LGb1WkzR = LqECSnCk + 8;
						uPWK6qpm.write((byte) LGb1WkzR);
						uPWK6qpm.write((byte) (LGb1WkzR >> 8));
						uPWK6qpm.write((byte) (LGb1WkzR >> 16));
						uPWK6qpm.write((byte) (LGb1WkzR >> 24));
					}
					uPWK6qpm.write(PXDATA_TAG);
					uPWK6qpm.write((byte) LqECSnCk);
					uPWK6qpm.write((byte) (LqECSnCk >> 8));
					uPWK6qpm.write((byte) (LqECSnCk >> 16));
					uPWK6qpm.write((byte) (LqECSnCk >> 24));
				}
				if (ANMWoS2b) {
					int k7wej0BL, iQUvhNnr;
					for (; LqECSnCk > 0; LqECSnCk -= 3) {
						uPWK6qpm.write(lHkuJABv.read());
						k7wej0BL = lHkuJABv.read();
						iQUvhNnr = lHkuJABv.read();
						uPWK6qpm.write(k7wej0BL & 0x0f);
						uPWK6qpm.write(k7wej0BL >> 4 | ((iQUvhNnr & 0x0f) << 4));
						uPWK6qpm.write(iQUvhNnr >> 4);
					}
				} else {
					for (; LqECSnCk > 0; --LqECSnCk) {
						uPWK6qpm.write(lHkuJABv.read());
					}
				}
				uPWK6qpm.close();
			}
			System.out.print('.');
		} finally {
			lHkuJABv.close();
		}
	}

}