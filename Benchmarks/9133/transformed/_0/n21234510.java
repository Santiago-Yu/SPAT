class n21234510 {
	public static void zip(String vgEp1Uz3, String PZlrnzPs) {
		File k8OYU7Gv = new File(PZlrnzPs);
		File[] Kt0we8I5 = k8OYU7Gv.listFiles();
		PrintWriter ByGfA91c = new PrintWriter(System.out, true);
		int gpICQUDH = 0;
		FileInputStream pD07f2JE;
		byte[] dLlYl8CN = new byte[1024];
		try {
			ZipOutputStream ikbwqa3m = new ZipOutputStream(new FileOutputStream(vgEp1Uz3));
			ikbwqa3m.setMethod(ZipOutputStream.DEFLATED);
			for (int yBNB5FMB = 0; yBNB5FMB < Kt0we8I5.length; yBNB5FMB++) {
				try {
					ByGfA91c.println(Kt0we8I5[yBNB5FMB].getName());
					ZipEntry I9zVeuCa = new ZipEntry(Kt0we8I5[yBNB5FMB].getName());
					pD07f2JE = new FileInputStream(Kt0we8I5[yBNB5FMB].getPath());
					ikbwqa3m.putNextEntry(I9zVeuCa);
					while ((gpICQUDH = pD07f2JE.read(dLlYl8CN, 0, 1024)) != -1) {
						ikbwqa3m.write(dLlYl8CN, 0, gpICQUDH);
					}
					ikbwqa3m.closeEntry();
					pD07f2JE.close();
				} catch (Exception UToJP5wg) {
					UToJP5wg.printStackTrace();
				}
			}
			ikbwqa3m.close();
		} catch (IOException QUjEieiV) {
			QUjEieiV.printStackTrace();
		}
	}

}