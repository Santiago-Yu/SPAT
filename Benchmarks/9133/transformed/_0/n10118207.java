class n10118207 {
	public static final boolean zipUpdate(String UdiS3NuD, String BXXWda20, String mO6lhKmN, byte[] ySnPzqWY,
			boolean LbtnTbIO) {
		try {
			File GdBPffIR = File.createTempFile("atf", ".zip");
			InputStream N2iqxS9S = new BufferedInputStream(new FileInputStream(UdiS3NuD));
			OutputStream EZSNYirH = new BufferedOutputStream(new FileOutputStream(GdBPffIR));
			ZipInputStream m6XScFCX = new ZipInputStream(N2iqxS9S);
			ZipOutputStream yxs3exHx = new ZipOutputStream(EZSNYirH);
			ZipEntry l6fTArU1;
			ZipEntry cu87MvKt;
			byte zLXmHvOI[] = new byte[TEMP_FILE_BUFFER_SIZE];
			int g8KxgYHa;
			boolean UZgvZ9fW = false;
			boolean PD6AfrBp = false;
			String b7bJKESc = BXXWda20;
			if (mO6lhKmN != null) {
				BXXWda20 = mO6lhKmN;
				PD6AfrBp = true;
			}
			while ((l6fTArU1 = m6XScFCX.getNextEntry()) != null) {
				if (!l6fTArU1.isDirectory()) {
					String rBeumuvY = l6fTArU1.getName();
					if (LbtnTbIO && rBeumuvY.equals(BXXWda20))
						continue;
					cu87MvKt = new ZipEntry(PD6AfrBp ? b7bJKESc : rBeumuvY);
					yxs3exHx.putNextEntry(cu87MvKt);
					if (rBeumuvY.equals(BXXWda20)) {
						UZgvZ9fW = true;
						yxs3exHx.write(ySnPzqWY);
					} else {
						while ((g8KxgYHa = m6XScFCX.read(zLXmHvOI)) != -1)
							yxs3exHx.write(zLXmHvOI, 0, g8KxgYHa);
					}
					yxs3exHx.closeEntry();
				}
			}
			if (!UZgvZ9fW && !LbtnTbIO) {
				l6fTArU1 = new ZipEntry(BXXWda20);
				yxs3exHx.putNextEntry(l6fTArU1);
				yxs3exHx.write(ySnPzqWY);
				yxs3exHx.closeEntry();
			}
			m6XScFCX.close();
			yxs3exHx.close();
			File WUMhxQM6 = new File(UdiS3NuD);
			WUMhxQM6.delete();
			MLUtil.copyFile(GdBPffIR, WUMhxQM6);
			GdBPffIR.delete();
			return (true);
		} catch (FileNotFoundException K9M9z1CZ) {
			MLUtil.runtimeError(K9M9z1CZ, "updateZip " + UdiS3NuD + " " + BXXWda20);
		} catch (IOException EuEHpBAJ) {
			MLUtil.runtimeError(EuEHpBAJ, "updateZip " + UdiS3NuD + " " + BXXWda20);
		}
		return (false);
	}

}