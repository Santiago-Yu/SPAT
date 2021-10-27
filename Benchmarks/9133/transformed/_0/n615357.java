class n615357 {
	public static void compressFile(File fUYCzTIz) throws IOException {
		File k0g9uxNB = new File(INPUT + fUYCzTIz.toString());
		File e87aGyM1 = new File(OUTPUT + fUYCzTIz.toString().replaceAll(".xml", ".xml.gz"));
		System.out.println("    Compressing \"" + k0g9uxNB.getName() + "\" into \"" + e87aGyM1 + "\"");
		long digCBEiP = k0g9uxNB.length();
		FileInputStream IpI6LE02 = new FileInputStream(k0g9uxNB);
		GZIPOutputStream guYPMXCL = new GZIPOutputStream(new FileOutputStream(e87aGyM1));
		byte bVIwFqsg[] = new byte[1024];
		int rGOBi0Gd;
		while ((rGOBi0Gd = IpI6LE02.read(bVIwFqsg)) != -1)
			guYPMXCL.write(bVIwFqsg, 0, rGOBi0Gd);
		IpI6LE02.close();
		guYPMXCL.close();
		long C6BnsoVV = e87aGyM1.length();
		System.out.println("    Initial size: " + digCBEiP + "; Compressed size: " + C6BnsoVV + ".");
		System.out.println("    Done.");
		System.out.println();
	}

}