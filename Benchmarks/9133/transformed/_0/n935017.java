class n935017 {
	public void convert(File nMjqnqVl, File zLIp59IH) throws IOException {
		InputStream fcoA5EJF = new BufferedInputStream(new FileInputStream(nMjqnqVl));
		DcmParser r663NWa6 = pfact.newDcmParser(fcoA5EJF);
		Dataset o8ZlZtts = fact.newDataset();
		r663NWa6.setDcmHandler(o8ZlZtts.getDcmHandler());
		try {
			FileFormat SViqtm0v = r663NWa6.detectFileFormat();
			if (SViqtm0v != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + nMjqnqVl + ": not an ACRNEMA stream!");
				return;
			}
			r663NWa6.parseDcmFile(SViqtm0v, Tags.PixelData);
			if (o8ZlZtts.contains(Tags.StudyInstanceUID) || o8ZlZtts.contains(Tags.SeriesInstanceUID)
					|| o8ZlZtts.contains(Tags.SOPInstanceUID) || o8ZlZtts.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + nMjqnqVl + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean bKHkZXTH = r663NWa6.getReadTag() == Tags.PixelData;
			boolean e7jQMN8j = bKHkZXTH && o8ZlZtts.getInt(Tags.BitsAllocated, 0) == 12;
			int V2jfscGU = r663NWa6.getReadLength();
			if (bKHkZXTH) {
				if (e7jQMN8j) {
					o8ZlZtts.putUS(Tags.BitsAllocated, 16);
					V2jfscGU = V2jfscGU * 4 / 3;
				}
				if (V2jfscGU != (o8ZlZtts.getInt(Tags.BitsAllocated, 0) >>> 3) * o8ZlZtts.getInt(Tags.Rows, 0)
						* o8ZlZtts.getInt(Tags.Columns, 0) * o8ZlZtts.getInt(Tags.NumberOfFrames, 1)
						* o8ZlZtts.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + nMjqnqVl + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			o8ZlZtts.putUI(Tags.StudyInstanceUID, uid(studyUID));
			o8ZlZtts.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			o8ZlZtts.putUI(Tags.SOPInstanceUID, uid(instUID));
			o8ZlZtts.putUI(Tags.SOPClassUID, classUID);
			if (!o8ZlZtts.contains(Tags.NumberOfSamples)) {
				o8ZlZtts.putUS(Tags.NumberOfSamples, 1);
			}
			if (!o8ZlZtts.contains(Tags.PhotometricInterpretation)) {
				o8ZlZtts.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				o8ZlZtts.setFileMetaInfo(fact.newFileMetaInfo(o8ZlZtts, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream EmUIVq2z = new BufferedOutputStream(new FileOutputStream(zLIp59IH));
			try {
			} finally {
				o8ZlZtts.writeFile(EmUIVq2z, encodeParam());
				if (bKHkZXTH) {
					if (!skipGroupLen) {
						EmUIVq2z.write(PXDATA_GROUPLEN);
						int xTMsgW0Y = V2jfscGU + 8;
						EmUIVq2z.write((byte) xTMsgW0Y);
						EmUIVq2z.write((byte) (xTMsgW0Y >> 8));
						EmUIVq2z.write((byte) (xTMsgW0Y >> 16));
						EmUIVq2z.write((byte) (xTMsgW0Y >> 24));
					}
					EmUIVq2z.write(PXDATA_TAG);
					EmUIVq2z.write((byte) V2jfscGU);
					EmUIVq2z.write((byte) (V2jfscGU >> 8));
					EmUIVq2z.write((byte) (V2jfscGU >> 16));
					EmUIVq2z.write((byte) (V2jfscGU >> 24));
				}
				if (e7jQMN8j) {
					int I01tw1Tt, QzfACEt1;
					for (; V2jfscGU > 0; V2jfscGU -= 3) {
						EmUIVq2z.write(fcoA5EJF.read());
						I01tw1Tt = fcoA5EJF.read();
						QzfACEt1 = fcoA5EJF.read();
						EmUIVq2z.write(I01tw1Tt & 0x0f);
						EmUIVq2z.write(I01tw1Tt >> 4 | ((QzfACEt1 & 0x0f) << 4));
						EmUIVq2z.write(QzfACEt1 >> 4);
					}
				} else {
					for (; V2jfscGU > 0; --V2jfscGU) {
						EmUIVq2z.write(fcoA5EJF.read());
					}
				}
				EmUIVq2z.close();
			}
			System.out.print('.');
		} finally {
			fcoA5EJF.close();
		}
	}

}