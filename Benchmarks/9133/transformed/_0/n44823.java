class n44823 {
	public void convert(File dELULFaC, File ATLDrTvK) throws IOException {
		InputStream dDRn1kpc = new BufferedInputStream(new FileInputStream(dELULFaC));
		DcmParser eH4s0gpS = pfact.newDcmParser(dDRn1kpc);
		Dataset t1eQfN0U = fact.newDataset();
		eH4s0gpS.setDcmHandler(t1eQfN0U.getDcmHandler());
		try {
			FileFormat aP61Mdyg = eH4s0gpS.detectFileFormat();
			if (aP61Mdyg != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + dELULFaC + ": not an ACRNEMA stream!");
				return;
			}
			eH4s0gpS.parseDcmFile(aP61Mdyg, Tags.PixelData);
			if (t1eQfN0U.contains(Tags.StudyInstanceUID) || t1eQfN0U.contains(Tags.SeriesInstanceUID)
					|| t1eQfN0U.contains(Tags.SOPInstanceUID) || t1eQfN0U.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + dELULFaC + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean bsXPRIh7 = eH4s0gpS.getReadTag() == Tags.PixelData;
			boolean yFocf4Y5 = bsXPRIh7 && t1eQfN0U.getInt(Tags.BitsAllocated, 0) == 12;
			int dCjW0IWj = eH4s0gpS.getReadLength();
			if (bsXPRIh7) {
				if (yFocf4Y5) {
					t1eQfN0U.putUS(Tags.BitsAllocated, 16);
					dCjW0IWj = dCjW0IWj * 4 / 3;
				}
				if (dCjW0IWj != (t1eQfN0U.getInt(Tags.BitsAllocated, 0) >>> 3) * t1eQfN0U.getInt(Tags.Rows, 0)
						* t1eQfN0U.getInt(Tags.Columns, 0) * t1eQfN0U.getInt(Tags.NumberOfFrames, 1)
						* t1eQfN0U.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + dELULFaC + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			t1eQfN0U.putUI(Tags.StudyInstanceUID, uid(studyUID));
			t1eQfN0U.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			t1eQfN0U.putUI(Tags.SOPInstanceUID, uid(instUID));
			t1eQfN0U.putUI(Tags.SOPClassUID, classUID);
			if (!t1eQfN0U.contains(Tags.NumberOfSamples)) {
				t1eQfN0U.putUS(Tags.NumberOfSamples, 1);
			}
			if (!t1eQfN0U.contains(Tags.PhotometricInterpretation)) {
				t1eQfN0U.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				t1eQfN0U.setFileMetaInfo(fact.newFileMetaInfo(t1eQfN0U, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream SsmBRhFF = new BufferedOutputStream(new FileOutputStream(ATLDrTvK));
			try {
			} finally {
				t1eQfN0U.writeFile(SsmBRhFF, encodeParam());
				if (bsXPRIh7) {
					if (!skipGroupLen) {
						SsmBRhFF.write(PXDATA_GROUPLEN);
						int VZSQZ42X = dCjW0IWj + 8;
						SsmBRhFF.write((byte) VZSQZ42X);
						SsmBRhFF.write((byte) (VZSQZ42X >> 8));
						SsmBRhFF.write((byte) (VZSQZ42X >> 16));
						SsmBRhFF.write((byte) (VZSQZ42X >> 24));
					}
					SsmBRhFF.write(PXDATA_TAG);
					SsmBRhFF.write((byte) dCjW0IWj);
					SsmBRhFF.write((byte) (dCjW0IWj >> 8));
					SsmBRhFF.write((byte) (dCjW0IWj >> 16));
					SsmBRhFF.write((byte) (dCjW0IWj >> 24));
				}
				if (yFocf4Y5) {
					int Wxei5FSZ, ilkrA5da;
					for (; dCjW0IWj > 0; dCjW0IWj -= 3) {
						SsmBRhFF.write(dDRn1kpc.read());
						Wxei5FSZ = dDRn1kpc.read();
						ilkrA5da = dDRn1kpc.read();
						SsmBRhFF.write(Wxei5FSZ & 0x0f);
						SsmBRhFF.write(Wxei5FSZ >> 4 | ((ilkrA5da & 0x0f) << 4));
						SsmBRhFF.write(ilkrA5da >> 4);
					}
				} else {
					for (; dCjW0IWj > 0; --dCjW0IWj) {
						SsmBRhFF.write(dDRn1kpc.read());
					}
				}
				SsmBRhFF.close();
			}
			System.out.print('.');
		} finally {
			dDRn1kpc.close();
		}
	}

}