class n11752189 {
	public static void main(String[] ZEY4vOlG) {
		FileDialog DnWFwx8Q = new FileDialog(new Frame(), "Find a .def file", FileDialog.LOAD);
		boolean WuUhNgcv = true;
		String r5blH0Pb = "";
		DataInputStream AXCr6l3d;
		OutputStream HEmi3Ejn;
		InputStream vhdx5WkA;
		File cRSsIBKn, as8x312v;
		byte[] k8nsIeA9 = new byte[2048];
		int isqCnEg8;
		while (WuUhNgcv) {
			DnWFwx8Q.show();
			if (DnWFwx8Q.getFile() != null) {
				try {
					as8x312v = new File(DnWFwx8Q.getDirectory(), DnWFwx8Q.getFile());
					cRSsIBKn = new File(DnWFwx8Q.getDirectory(), DnWFwx8Q.getFile() + ".out");
					HEmi3Ejn = new FileOutputStream(cRSsIBKn);
					vhdx5WkA = new MSZipInputStream(new FileInputStream(as8x312v));
					while ((isqCnEg8 = vhdx5WkA.read(k8nsIeA9)) != -1)
						HEmi3Ejn.write(k8nsIeA9, 0, isqCnEg8);
					vhdx5WkA.close();
					HEmi3Ejn.close();
				} catch (IOException EG3EgioV) {
					EG3EgioV.printStackTrace();
				}
			}
			System.out.println("Do another (y/n)?");
			AXCr6l3d = new DataInputStream(System.in);
			try {
				r5blH0Pb = AXCr6l3d.readLine();
			} catch (Exception SugPfZSW) {
			}
			if (r5blH0Pb.toLowerCase().startsWith("n"))
				WuUhNgcv = false;
		}
	}

}