class n615358 {
	public static void decompressFile(File ilabG9MG) throws IOException {
		File UztwscLz = new File(INPUT + ilabG9MG.toString());
		File yQUpJFxU = new File(OUTPUT + ilabG9MG.toString().replaceAll(".xml.gz", ".xml"));
		System.out.println("    Decompressing \"" + UztwscLz.getName() + "\" into \"" + yQUpJFxU + "\"");
		long QNxG7t5R = UztwscLz.length();
		GZIPInputStream qj2qkUIl = new GZIPInputStream(new FileInputStream(UztwscLz));
		FileOutputStream vhDgKG88 = new FileOutputStream(yQUpJFxU);
		byte uFSfje6R[] = new byte[1024];
		int t7aYQB3U;
		while ((t7aYQB3U = qj2qkUIl.read(uFSfje6R)) != -1)
			vhDgKG88.write(uFSfje6R, 0, t7aYQB3U);
		vhDgKG88.close();
		qj2qkUIl.close();
		long ySsgp748 = yQUpJFxU.length();
		System.out.println("    Initial size: " + QNxG7t5R + "; Decompressed size: " + ySsgp748 + ".");
		System.out.println("    Done.");
		System.out.println();
	}

}