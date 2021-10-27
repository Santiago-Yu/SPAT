class n823074 {
	public void convert(File zkOj61re, File ypUMRRPR) throws IOException {
		InputStream wIRziomP = new BufferedInputStream(new FileInputStream(zkOj61re));
		DcmParser OOBDWDz8 = pfact.newDcmParser(wIRziomP);
		Dataset Kk4nm7rS = fact.newDataset();
		OOBDWDz8.setDcmHandler(Kk4nm7rS.getDcmHandler());
		try {
			FileFormat xl8qgVua = OOBDWDz8.detectFileFormat();
			if (xl8qgVua != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + zkOj61re + ": not an ACRNEMA stream!");
				return;
			}
			OOBDWDz8.parseDcmFile(xl8qgVua, Tags.PixelData);
			if (Kk4nm7rS.contains(Tags.StudyInstanceUID) || Kk4nm7rS.contains(Tags.SeriesInstanceUID)
					|| Kk4nm7rS.contains(Tags.SOPInstanceUID) || Kk4nm7rS.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + zkOj61re + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Lgth8ovH = OOBDWDz8.getReadTag() == Tags.PixelData;
			boolean OvhcKuQe = Lgth8ovH && Kk4nm7rS.getInt(Tags.BitsAllocated, 0) == 12;
			int amQvgSYP = OOBDWDz8.getReadLength();
			if (Lgth8ovH) {
				if (OvhcKuQe) {
					Kk4nm7rS.putUS(Tags.BitsAllocated, 16);
					amQvgSYP = amQvgSYP * 4 / 3;
				}
				if (amQvgSYP != (Kk4nm7rS.getInt(Tags.BitsAllocated, 0) >>> 3) * Kk4nm7rS.getInt(Tags.Rows, 0)
						* Kk4nm7rS.getInt(Tags.Columns, 0) * Kk4nm7rS.getInt(Tags.NumberOfFrames, 1)
						* Kk4nm7rS.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + zkOj61re + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Kk4nm7rS.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Kk4nm7rS.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Kk4nm7rS.putUI(Tags.SOPInstanceUID, uid(instUID));
			Kk4nm7rS.putUI(Tags.SOPClassUID, classUID);
			if (!Kk4nm7rS.contains(Tags.NumberOfSamples)) {
				Kk4nm7rS.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Kk4nm7rS.contains(Tags.PhotometricInterpretation)) {
				Kk4nm7rS.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Kk4nm7rS.setFileMetaInfo(fact.newFileMetaInfo(Kk4nm7rS, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream F1IfiVl4 = new BufferedOutputStream(new FileOutputStream(ypUMRRPR));
			try {
			} finally {
				Kk4nm7rS.writeFile(F1IfiVl4, encodeParam());
				if (Lgth8ovH) {
					if (!skipGroupLen) {
						F1IfiVl4.write(PXDATA_GROUPLEN);
						int BXDUtKx5 = amQvgSYP + 8;
						F1IfiVl4.write((byte) BXDUtKx5);
						F1IfiVl4.write((byte) (BXDUtKx5 >> 8));
						F1IfiVl4.write((byte) (BXDUtKx5 >> 16));
						F1IfiVl4.write((byte) (BXDUtKx5 >> 24));
					}
					F1IfiVl4.write(PXDATA_TAG);
					F1IfiVl4.write((byte) amQvgSYP);
					F1IfiVl4.write((byte) (amQvgSYP >> 8));
					F1IfiVl4.write((byte) (amQvgSYP >> 16));
					F1IfiVl4.write((byte) (amQvgSYP >> 24));
				}
				if (OvhcKuQe) {
					int UZOWchgX, DnzSFjay;
					for (; amQvgSYP > 0; amQvgSYP -= 3) {
						F1IfiVl4.write(wIRziomP.read());
						UZOWchgX = wIRziomP.read();
						DnzSFjay = wIRziomP.read();
						F1IfiVl4.write(UZOWchgX & 0x0f);
						F1IfiVl4.write(UZOWchgX >> 4 | ((DnzSFjay & 0x0f) << 4));
						F1IfiVl4.write(DnzSFjay >> 4);
					}
				} else {
					for (; amQvgSYP > 0; --amQvgSYP) {
						F1IfiVl4.write(wIRziomP.read());
					}
				}
				F1IfiVl4.close();
			}
			System.out.print('.');
		} finally {
			wIRziomP.close();
		}
	}

}