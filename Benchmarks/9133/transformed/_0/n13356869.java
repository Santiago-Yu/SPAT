class n13356869 {
	public void createZip(File LSyMozzJ, Vector<File> Yy2n0UxD) {
		try {
			byte[] Uf8U3RFu = new byte[4096];
			ZipOutputStream tOV5TACI = new ZipOutputStream(
					new BufferedOutputStream(new FileOutputStream(LSyMozzJ), 8096));
			tOV5TACI.setLevel(Deflater.BEST_COMPRESSION);
			tOV5TACI.setMethod(ZipOutputStream.DEFLATED);
			for (int yNNFbKkL = 0; yNNFbKkL < Yy2n0UxD.size(); yNNFbKkL++) {
				FileInputStream Exe9Yxxp = new FileInputStream(Yy2n0UxD.get(yNNFbKkL));
				String dUad64J5 = Yy2n0UxD.get(yNNFbKkL).getPath();
				if (dUad64J5.indexOf("\\") != -1)
					dUad64J5 = dUad64J5.substring(dUad64J5.lastIndexOf(Options.fs) + 1, dUad64J5.length());
				ZipEntry IZD7qRX8 = new ZipEntry(dUad64J5);
				tOV5TACI.putNextEntry(IZD7qRX8);
				int eoXDLuTT;
				while ((eoXDLuTT = Exe9Yxxp.read(Uf8U3RFu)) > 0)
					tOV5TACI.write(Uf8U3RFu, 0, eoXDLuTT);
				tOV5TACI.closeEntry();
				Exe9Yxxp.close();
				Yy2n0UxD.get(yNNFbKkL).delete();
			}
			tOV5TACI.close();
		} catch (IllegalArgumentException VwYgK2Ol) {
			VwYgK2Ol.printStackTrace();
		} catch (FileNotFoundException Rk3RcYzV) {
			Rk3RcYzV.printStackTrace();
		} catch (IOException v15Wu2VM) {
			v15Wu2VM.printStackTrace();
		}
	}

}