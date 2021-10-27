class n1824914 {
	public static void copyFile(File ApFymfrm, File k3hPFjya) throws IOException {
		k3hPFjya.getParentFile().mkdirs();
		BufferedInputStream IauGwSa9 = new BufferedInputStream(new FileInputStream(ApFymfrm));
		BufferedOutputStream hYaPRdGl = new BufferedOutputStream(new FileOutputStream(k3hPFjya));
		byte[] iWqRitip = new byte[4096];
		int toEK6Vr1 = -1;
		while ((toEK6Vr1 = IauGwSa9.read(iWqRitip)) != -1) {
			hYaPRdGl.write(iWqRitip, 0, toEK6Vr1);
		}
		hYaPRdGl.flush();
		hYaPRdGl.close();
		IauGwSa9.close();
	}

}