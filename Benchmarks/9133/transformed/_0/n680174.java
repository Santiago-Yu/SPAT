class n680174 {
	public void convert(File jUjWbFLZ, File dhTqpyPa) throws IOException {
		InputStream KnKCuIIN = new BufferedInputStream(new FileInputStream(jUjWbFLZ));
		DcmParser Swsq9TK0 = pfact.newDcmParser(KnKCuIIN);
		Dataset h9N4wsK6 = fact.newDataset();
		Swsq9TK0.setDcmHandler(h9N4wsK6.getDcmHandler());
		try {
			FileFormat l9PFDknY = Swsq9TK0.detectFileFormat();
			if (l9PFDknY != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + jUjWbFLZ + ": not an ACRNEMA stream!");
				return;
			}
			Swsq9TK0.parseDcmFile(l9PFDknY, Tags.PixelData);
			if (h9N4wsK6.contains(Tags.StudyInstanceUID) || h9N4wsK6.contains(Tags.SeriesInstanceUID)
					|| h9N4wsK6.contains(Tags.SOPInstanceUID) || h9N4wsK6.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + jUjWbFLZ + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean UY8rue7x = Swsq9TK0.getReadTag() == Tags.PixelData;
			boolean N3tAOsmg = UY8rue7x && h9N4wsK6.getInt(Tags.BitsAllocated, 0) == 12;
			int hDIQh6IK = Swsq9TK0.getReadLength();
			if (UY8rue7x) {
				if (N3tAOsmg) {
					h9N4wsK6.putUS(Tags.BitsAllocated, 16);
					hDIQh6IK = hDIQh6IK * 4 / 3;
				}
				if (hDIQh6IK != (h9N4wsK6.getInt(Tags.BitsAllocated, 0) >>> 3) * h9N4wsK6.getInt(Tags.Rows, 0)
						* h9N4wsK6.getInt(Tags.Columns, 0) * h9N4wsK6.getInt(Tags.NumberOfFrames, 1)
						* h9N4wsK6.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + jUjWbFLZ + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			h9N4wsK6.putUI(Tags.StudyInstanceUID, uid(studyUID));
			h9N4wsK6.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			h9N4wsK6.putUI(Tags.SOPInstanceUID, uid(instUID));
			h9N4wsK6.putUI(Tags.SOPClassUID, classUID);
			if (!h9N4wsK6.contains(Tags.NumberOfSamples)) {
				h9N4wsK6.putUS(Tags.NumberOfSamples, 1);
			}
			if (!h9N4wsK6.contains(Tags.PhotometricInterpretation)) {
				h9N4wsK6.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				h9N4wsK6.setFileMetaInfo(fact.newFileMetaInfo(h9N4wsK6, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream ioaOqCPJ = new BufferedOutputStream(new FileOutputStream(dhTqpyPa));
			try {
			} finally {
				h9N4wsK6.writeFile(ioaOqCPJ, encodeParam());
				if (UY8rue7x) {
					if (!skipGroupLen) {
						ioaOqCPJ.write(PXDATA_GROUPLEN);
						int r2NlPfjg = hDIQh6IK + 8;
						ioaOqCPJ.write((byte) r2NlPfjg);
						ioaOqCPJ.write((byte) (r2NlPfjg >> 8));
						ioaOqCPJ.write((byte) (r2NlPfjg >> 16));
						ioaOqCPJ.write((byte) (r2NlPfjg >> 24));
					}
					ioaOqCPJ.write(PXDATA_TAG);
					ioaOqCPJ.write((byte) hDIQh6IK);
					ioaOqCPJ.write((byte) (hDIQh6IK >> 8));
					ioaOqCPJ.write((byte) (hDIQh6IK >> 16));
					ioaOqCPJ.write((byte) (hDIQh6IK >> 24));
				}
				if (N3tAOsmg) {
					int rMhgE5MU, x3Put49g;
					for (; hDIQh6IK > 0; hDIQh6IK -= 3) {
						ioaOqCPJ.write(KnKCuIIN.read());
						rMhgE5MU = KnKCuIIN.read();
						x3Put49g = KnKCuIIN.read();
						ioaOqCPJ.write(rMhgE5MU & 0x0f);
						ioaOqCPJ.write(rMhgE5MU >> 4 | ((x3Put49g & 0x0f) << 4));
						ioaOqCPJ.write(x3Put49g >> 4);
					}
				} else {
					for (; hDIQh6IK > 0; --hDIQh6IK) {
						ioaOqCPJ.write(KnKCuIIN.read());
					}
				}
				ioaOqCPJ.close();
			}
			System.out.print('.');
		} finally {
			KnKCuIIN.close();
		}
	}

}