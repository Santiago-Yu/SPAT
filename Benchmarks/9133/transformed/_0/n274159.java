class n274159 {
	public void convert(File vJnl7tsb, File qcirFKic) throws IOException {
		InputStream xTU5rYsr = new BufferedInputStream(new FileInputStream(vJnl7tsb));
		DcmParser OtZfQIQU = pfact.newDcmParser(xTU5rYsr);
		Dataset UWVWhxC4 = fact.newDataset();
		OtZfQIQU.setDcmHandler(UWVWhxC4.getDcmHandler());
		try {
			FileFormat TG5WZvlF = OtZfQIQU.detectFileFormat();
			if (TG5WZvlF != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + vJnl7tsb + ": not an ACRNEMA stream!");
				return;
			}
			OtZfQIQU.parseDcmFile(TG5WZvlF, Tags.PixelData);
			if (UWVWhxC4.contains(Tags.StudyInstanceUID) || UWVWhxC4.contains(Tags.SeriesInstanceUID)
					|| UWVWhxC4.contains(Tags.SOPInstanceUID) || UWVWhxC4.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + vJnl7tsb + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean KaraWg5A = OtZfQIQU.getReadTag() == Tags.PixelData;
			boolean zFiMp69x = KaraWg5A && UWVWhxC4.getInt(Tags.BitsAllocated, 0) == 12;
			int r2ULKyfS = OtZfQIQU.getReadLength();
			if (KaraWg5A) {
				if (zFiMp69x) {
					UWVWhxC4.putUS(Tags.BitsAllocated, 16);
					r2ULKyfS = r2ULKyfS * 4 / 3;
				}
				if (r2ULKyfS != (UWVWhxC4.getInt(Tags.BitsAllocated, 0) >>> 3) * UWVWhxC4.getInt(Tags.Rows, 0)
						* UWVWhxC4.getInt(Tags.Columns, 0) * UWVWhxC4.getInt(Tags.NumberOfFrames, 1)
						* UWVWhxC4.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + vJnl7tsb + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			UWVWhxC4.putUI(Tags.StudyInstanceUID, uid(studyUID));
			UWVWhxC4.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			UWVWhxC4.putUI(Tags.SOPInstanceUID, uid(instUID));
			UWVWhxC4.putUI(Tags.SOPClassUID, classUID);
			if (!UWVWhxC4.contains(Tags.NumberOfSamples)) {
				UWVWhxC4.putUS(Tags.NumberOfSamples, 1);
			}
			if (!UWVWhxC4.contains(Tags.PhotometricInterpretation)) {
				UWVWhxC4.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				UWVWhxC4.setFileMetaInfo(fact.newFileMetaInfo(UWVWhxC4, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream o45nWd9k = new BufferedOutputStream(new FileOutputStream(qcirFKic));
			try {
			} finally {
				UWVWhxC4.writeFile(o45nWd9k, encodeParam());
				if (KaraWg5A) {
					if (!skipGroupLen) {
						o45nWd9k.write(PXDATA_GROUPLEN);
						int fcsTHw80 = r2ULKyfS + 8;
						o45nWd9k.write((byte) fcsTHw80);
						o45nWd9k.write((byte) (fcsTHw80 >> 8));
						o45nWd9k.write((byte) (fcsTHw80 >> 16));
						o45nWd9k.write((byte) (fcsTHw80 >> 24));
					}
					o45nWd9k.write(PXDATA_TAG);
					o45nWd9k.write((byte) r2ULKyfS);
					o45nWd9k.write((byte) (r2ULKyfS >> 8));
					o45nWd9k.write((byte) (r2ULKyfS >> 16));
					o45nWd9k.write((byte) (r2ULKyfS >> 24));
				}
				if (zFiMp69x) {
					int ocyuncXu, t8AtzvjY;
					for (; r2ULKyfS > 0; r2ULKyfS -= 3) {
						o45nWd9k.write(xTU5rYsr.read());
						ocyuncXu = xTU5rYsr.read();
						t8AtzvjY = xTU5rYsr.read();
						o45nWd9k.write(ocyuncXu & 0x0f);
						o45nWd9k.write(ocyuncXu >> 4 | ((t8AtzvjY & 0x0f) << 4));
						o45nWd9k.write(t8AtzvjY >> 4);
					}
				} else {
					for (; r2ULKyfS > 0; --r2ULKyfS) {
						o45nWd9k.write(xTU5rYsr.read());
					}
				}
				o45nWd9k.close();
			}
			System.out.print('.');
		} finally {
			xTU5rYsr.close();
		}
	}

}