class n861011 {
	public void convert(File z3gbATsT, File DJB2V2SC) throws IOException {
		InputStream xaXyiPd6 = new BufferedInputStream(new FileInputStream(z3gbATsT));
		DcmParser ZQqx5vWi = pfact.newDcmParser(xaXyiPd6);
		Dataset r3pHfjeT = fact.newDataset();
		ZQqx5vWi.setDcmHandler(r3pHfjeT.getDcmHandler());
		try {
			FileFormat uI5dmBEn = ZQqx5vWi.detectFileFormat();
			if (uI5dmBEn != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + z3gbATsT + ": not an ACRNEMA stream!");
				return;
			}
			ZQqx5vWi.parseDcmFile(uI5dmBEn, Tags.PixelData);
			if (r3pHfjeT.contains(Tags.StudyInstanceUID) || r3pHfjeT.contains(Tags.SeriesInstanceUID)
					|| r3pHfjeT.contains(Tags.SOPInstanceUID) || r3pHfjeT.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + z3gbATsT + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean WEIJPsPN = ZQqx5vWi.getReadTag() == Tags.PixelData;
			boolean gca9KVsq = WEIJPsPN && r3pHfjeT.getInt(Tags.BitsAllocated, 0) == 12;
			int r9JGQjyU = ZQqx5vWi.getReadLength();
			if (WEIJPsPN) {
				if (gca9KVsq) {
					r3pHfjeT.putUS(Tags.BitsAllocated, 16);
					r9JGQjyU = r9JGQjyU * 4 / 3;
				}
				if (r9JGQjyU != (r3pHfjeT.getInt(Tags.BitsAllocated, 0) >>> 3) * r3pHfjeT.getInt(Tags.Rows, 0)
						* r3pHfjeT.getInt(Tags.Columns, 0) * r3pHfjeT.getInt(Tags.NumberOfFrames, 1)
						* r3pHfjeT.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + z3gbATsT + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			r3pHfjeT.putUI(Tags.StudyInstanceUID, uid(studyUID));
			r3pHfjeT.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			r3pHfjeT.putUI(Tags.SOPInstanceUID, uid(instUID));
			r3pHfjeT.putUI(Tags.SOPClassUID, classUID);
			if (!r3pHfjeT.contains(Tags.NumberOfSamples)) {
				r3pHfjeT.putUS(Tags.NumberOfSamples, 1);
			}
			if (!r3pHfjeT.contains(Tags.PhotometricInterpretation)) {
				r3pHfjeT.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				r3pHfjeT.setFileMetaInfo(fact.newFileMetaInfo(r3pHfjeT, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream s9ebaF1s = new BufferedOutputStream(new FileOutputStream(DJB2V2SC));
			try {
			} finally {
				r3pHfjeT.writeFile(s9ebaF1s, encodeParam());
				if (WEIJPsPN) {
					if (!skipGroupLen) {
						s9ebaF1s.write(PXDATA_GROUPLEN);
						int tncXoa0a = r9JGQjyU + 8;
						s9ebaF1s.write((byte) tncXoa0a);
						s9ebaF1s.write((byte) (tncXoa0a >> 8));
						s9ebaF1s.write((byte) (tncXoa0a >> 16));
						s9ebaF1s.write((byte) (tncXoa0a >> 24));
					}
					s9ebaF1s.write(PXDATA_TAG);
					s9ebaF1s.write((byte) r9JGQjyU);
					s9ebaF1s.write((byte) (r9JGQjyU >> 8));
					s9ebaF1s.write((byte) (r9JGQjyU >> 16));
					s9ebaF1s.write((byte) (r9JGQjyU >> 24));
				}
				if (gca9KVsq) {
					int wSJ1fy0N, FiG5fYqx;
					for (; r9JGQjyU > 0; r9JGQjyU -= 3) {
						s9ebaF1s.write(xaXyiPd6.read());
						wSJ1fy0N = xaXyiPd6.read();
						FiG5fYqx = xaXyiPd6.read();
						s9ebaF1s.write(wSJ1fy0N & 0x0f);
						s9ebaF1s.write(wSJ1fy0N >> 4 | ((FiG5fYqx & 0x0f) << 4));
						s9ebaF1s.write(FiG5fYqx >> 4);
					}
				} else {
					for (; r9JGQjyU > 0; --r9JGQjyU) {
						s9ebaF1s.write(xaXyiPd6.read());
					}
				}
				s9ebaF1s.close();
			}
			System.out.print('.');
		} finally {
			xaXyiPd6.close();
		}
	}

}