class n2103971 {
	@Override
	protected void writeFile() {
		super.writeFile();
		try {
			String GWXVmTM7 = file.toURI().toASCIIString();
			GWXVmTM7 = GWXVmTM7.substring(0, GWXVmTM7.lastIndexOf(FileManager.GLIPS_VIEW_EXTENSION))
					+ FileManager.TAG_LIST_FILE_EXTENSION;
			File AVaE68VN = new File(new URI(GWXVmTM7));
			StringBuffer CqQrAryu = new StringBuffer("");
			for (String qA9k05nP : tags) {
				CqQrAryu.append(qA9k05nP + "\n");
			}
			ByteBuffer bwMJy0ez = ByteBuffer.wrap(CqQrAryu.toString().getBytes("UTF-8"));
			FileOutputStream mU1u60Rb = new FileOutputStream(AVaE68VN);
			FileChannel vODeywA4 = mU1u60Rb.getChannel();
			vODeywA4.write(bwMJy0ez);
			vODeywA4.close();
		} catch (Exception iIqOWec2) {
		}
		try {
			String fXw2v5S5 = file.getParentFile().toURI().toASCIIString();
			if (!fXw2v5S5.endsWith("/")) {
				fXw2v5S5 += "/";
			}
			File k2wa45Ye = null, eTTYVGDW = null;
			byte[] DsdUhEg1 = new byte[1000];
			int XSV9sJQU = 0;
			InputStream tNRuOlJz = null;
			OutputStream bB4Tr2Ho = null;
			for (String E6zRmR8W : dataBaseFiles.keySet()) {
				k2wa45Ye = dataBaseFiles.get(E6zRmR8W);
				if (k2wa45Ye != null) {
					eTTYVGDW = new File(new URI(fXw2v5S5 + E6zRmR8W));
					tNRuOlJz = new BufferedInputStream(new FileInputStream(k2wa45Ye));
					bB4Tr2Ho = new BufferedOutputStream(new FileOutputStream(eTTYVGDW));
					while (tNRuOlJz.available() > 0) {
						XSV9sJQU = tNRuOlJz.read(DsdUhEg1);
						if (XSV9sJQU > 0) {
							bB4Tr2Ho.write(DsdUhEg1, 0, XSV9sJQU);
						}
					}
					tNRuOlJz.close();
					bB4Tr2Ho.flush();
					bB4Tr2Ho.close();
				}
			}
		} catch (Exception rEMpBurn) {
			rEMpBurn.printStackTrace();
		}
	}

}