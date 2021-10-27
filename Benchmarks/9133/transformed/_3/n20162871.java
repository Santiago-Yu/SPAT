class n20162871 {
	public static void copyFile(String f_in, String f_out, boolean remove) throws FileNotFoundException, IOException {
		if (!(remove)) {
			FileInputStream fid = new FileInputStream(f_in);
			FileOutputStream fidout = new FileOutputStream(f_out);
			int nb = fid.available();
			byte[] inStr = new byte[nb];
			if (fid.read(inStr) > 0)
				fidout.write(inStr);
			fid.close();
			fidout.close();
		} else {
			PogoString readcode = new PogoString(PogoUtil.readFile(f_in));
			readcode = PogoUtil.removeLogMessages(readcode);
			PogoUtil.writeFile(f_out, readcode.str);
		}
	}

}