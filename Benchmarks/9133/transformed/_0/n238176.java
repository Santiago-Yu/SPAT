class n238176 {
	public void convert(File DfRkVA89, File WjkQqqHy) throws IOException {
		InputStream ut5ZF4XG = new BufferedInputStream(new FileInputStream(DfRkVA89));
		DcmParser xlrjS60h = pfact.newDcmParser(ut5ZF4XG);
		Dataset okZsCmjh = fact.newDataset();
		xlrjS60h.setDcmHandler(okZsCmjh.getDcmHandler());
		try {
			FileFormat TJ3y5I8z = xlrjS60h.detectFileFormat();
			if (TJ3y5I8z != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + DfRkVA89 + ": not an ACRNEMA stream!");
				return;
			}
			xlrjS60h.parseDcmFile(TJ3y5I8z, Tags.PixelData);
			if (okZsCmjh.contains(Tags.StudyInstanceUID) || okZsCmjh.contains(Tags.SeriesInstanceUID)
					|| okZsCmjh.contains(Tags.SOPInstanceUID) || okZsCmjh.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + DfRkVA89 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean ZxysSQS1 = xlrjS60h.getReadTag() == Tags.PixelData;
			boolean FgJsLRHU = ZxysSQS1 && okZsCmjh.getInt(Tags.BitsAllocated, 0) == 12;
			int LGHGUZjf = xlrjS60h.getReadLength();
			if (ZxysSQS1) {
				if (FgJsLRHU) {
					okZsCmjh.putUS(Tags.BitsAllocated, 16);
					LGHGUZjf = LGHGUZjf * 4 / 3;
				}
				if (LGHGUZjf != (okZsCmjh.getInt(Tags.BitsAllocated, 0) >>> 3) * okZsCmjh.getInt(Tags.Rows, 0)
						* okZsCmjh.getInt(Tags.Columns, 0) * okZsCmjh.getInt(Tags.NumberOfFrames, 1)
						* okZsCmjh.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + DfRkVA89 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			okZsCmjh.putUI(Tags.StudyInstanceUID, uid(studyUID));
			okZsCmjh.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			okZsCmjh.putUI(Tags.SOPInstanceUID, uid(instUID));
			okZsCmjh.putUI(Tags.SOPClassUID, classUID);
			if (!okZsCmjh.contains(Tags.NumberOfSamples)) {
				okZsCmjh.putUS(Tags.NumberOfSamples, 1);
			}
			if (!okZsCmjh.contains(Tags.PhotometricInterpretation)) {
				okZsCmjh.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				okZsCmjh.setFileMetaInfo(fact.newFileMetaInfo(okZsCmjh, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream tcyhYTWB = new BufferedOutputStream(new FileOutputStream(WjkQqqHy));
			try {
			} finally {
				okZsCmjh.writeFile(tcyhYTWB, encodeParam());
				if (ZxysSQS1) {
					if (!skipGroupLen) {
						tcyhYTWB.write(PXDATA_GROUPLEN);
						int VoxoPtNi = LGHGUZjf + 8;
						tcyhYTWB.write((byte) VoxoPtNi);
						tcyhYTWB.write((byte) (VoxoPtNi >> 8));
						tcyhYTWB.write((byte) (VoxoPtNi >> 16));
						tcyhYTWB.write((byte) (VoxoPtNi >> 24));
					}
					tcyhYTWB.write(PXDATA_TAG);
					tcyhYTWB.write((byte) LGHGUZjf);
					tcyhYTWB.write((byte) (LGHGUZjf >> 8));
					tcyhYTWB.write((byte) (LGHGUZjf >> 16));
					tcyhYTWB.write((byte) (LGHGUZjf >> 24));
				}
				if (FgJsLRHU) {
					int GGgKU69F, EMiMLKWA;
					for (; LGHGUZjf > 0; LGHGUZjf -= 3) {
						tcyhYTWB.write(ut5ZF4XG.read());
						GGgKU69F = ut5ZF4XG.read();
						EMiMLKWA = ut5ZF4XG.read();
						tcyhYTWB.write(GGgKU69F & 0x0f);
						tcyhYTWB.write(GGgKU69F >> 4 | ((EMiMLKWA & 0x0f) << 4));
						tcyhYTWB.write(EMiMLKWA >> 4);
					}
				} else {
					for (; LGHGUZjf > 0; --LGHGUZjf) {
						tcyhYTWB.write(ut5ZF4XG.read());
					}
				}
				tcyhYTWB.close();
			}
			System.out.print('.');
		} finally {
			ut5ZF4XG.close();
		}
	}

}