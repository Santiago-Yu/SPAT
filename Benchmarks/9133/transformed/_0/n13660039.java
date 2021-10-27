class n13660039 {
	public static void main(String[] o2Dz325v) throws Exception {
		if (o2Dz325v.length != 2) {
			PrintUtil.prt("arguments: sourcefile, destfile");
			System.exit(1);
		}
		FileChannel oC0xJ1ku = new FileInputStream(o2Dz325v[0]).getChannel(),
				DxPy7Ehf = new FileOutputStream(o2Dz325v[1]).getChannel();
		oC0xJ1ku.transferTo(0, oC0xJ1ku.size(), DxPy7Ehf);
	}

}