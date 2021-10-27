class n736738 {
	public void convert(File p2F3bB26, File isdAqTpO) throws IOException {
		InputStream VIOg0b3f = new BufferedInputStream(new FileInputStream(p2F3bB26));
		DcmParser WjkOlMpY = pfact.newDcmParser(VIOg0b3f);
		Dataset MS0ccLNI = fact.newDataset();
		WjkOlMpY.setDcmHandler(MS0ccLNI.getDcmHandler());
		try {
			FileFormat RHIpLuZV = WjkOlMpY.detectFileFormat();
			if (RHIpLuZV != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + p2F3bB26 + ": not an ACRNEMA stream!");
				return;
			}
			WjkOlMpY.parseDcmFile(RHIpLuZV, Tags.PixelData);
			if (MS0ccLNI.contains(Tags.StudyInstanceUID) || MS0ccLNI.contains(Tags.SeriesInstanceUID)
					|| MS0ccLNI.contains(Tags.SOPInstanceUID) || MS0ccLNI.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + p2F3bB26 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean B7ELntfs = WjkOlMpY.getReadTag() == Tags.PixelData;
			boolean ygOJqSPb = B7ELntfs && MS0ccLNI.getInt(Tags.BitsAllocated, 0) == 12;
			int sF2fxflR = WjkOlMpY.getReadLength();
			if (B7ELntfs) {
				if (ygOJqSPb) {
					MS0ccLNI.putUS(Tags.BitsAllocated, 16);
					sF2fxflR = sF2fxflR * 4 / 3;
				}
				if (sF2fxflR != (MS0ccLNI.getInt(Tags.BitsAllocated, 0) >>> 3) * MS0ccLNI.getInt(Tags.Rows, 0)
						* MS0ccLNI.getInt(Tags.Columns, 0) * MS0ccLNI.getInt(Tags.NumberOfFrames, 1)
						* MS0ccLNI.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + p2F3bB26 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			MS0ccLNI.putUI(Tags.StudyInstanceUID, uid(studyUID));
			MS0ccLNI.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			MS0ccLNI.putUI(Tags.SOPInstanceUID, uid(instUID));
			MS0ccLNI.putUI(Tags.SOPClassUID, classUID);
			if (!MS0ccLNI.contains(Tags.NumberOfSamples)) {
				MS0ccLNI.putUS(Tags.NumberOfSamples, 1);
			}
			if (!MS0ccLNI.contains(Tags.PhotometricInterpretation)) {
				MS0ccLNI.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				MS0ccLNI.setFileMetaInfo(fact.newFileMetaInfo(MS0ccLNI, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream OGOTD40E = new BufferedOutputStream(new FileOutputStream(isdAqTpO));
			try {
			} finally {
				MS0ccLNI.writeFile(OGOTD40E, encodeParam());
				if (B7ELntfs) {
					if (!skipGroupLen) {
						OGOTD40E.write(PXDATA_GROUPLEN);
						int G6hpCC2B = sF2fxflR + 8;
						OGOTD40E.write((byte) G6hpCC2B);
						OGOTD40E.write((byte) (G6hpCC2B >> 8));
						OGOTD40E.write((byte) (G6hpCC2B >> 16));
						OGOTD40E.write((byte) (G6hpCC2B >> 24));
					}
					OGOTD40E.write(PXDATA_TAG);
					OGOTD40E.write((byte) sF2fxflR);
					OGOTD40E.write((byte) (sF2fxflR >> 8));
					OGOTD40E.write((byte) (sF2fxflR >> 16));
					OGOTD40E.write((byte) (sF2fxflR >> 24));
				}
				if (ygOJqSPb) {
					int DU6jBa1T, M41Obcwu;
					for (; sF2fxflR > 0; sF2fxflR -= 3) {
						OGOTD40E.write(VIOg0b3f.read());
						DU6jBa1T = VIOg0b3f.read();
						M41Obcwu = VIOg0b3f.read();
						OGOTD40E.write(DU6jBa1T & 0x0f);
						OGOTD40E.write(DU6jBa1T >> 4 | ((M41Obcwu & 0x0f) << 4));
						OGOTD40E.write(M41Obcwu >> 4);
					}
				} else {
					for (; sF2fxflR > 0; --sF2fxflR) {
						OGOTD40E.write(VIOg0b3f.read());
					}
				}
				OGOTD40E.close();
			}
			System.out.print('.');
		} finally {
			VIOg0b3f.close();
		}
	}

}