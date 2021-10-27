class n14899566 {
	public void createZip(File KMwIUcSe, Vector<File> XAmpJNVg) {
		try {
			byte[] eP7HXSrP = new byte[4096];
			ZipOutputStream D5hx7Pwr = new ZipOutputStream(
					new BufferedOutputStream(new FileOutputStream(KMwIUcSe), 8096));
			D5hx7Pwr.setLevel(Deflater.BEST_COMPRESSION);
			D5hx7Pwr.setMethod(ZipOutputStream.DEFLATED);
			for (int JqQYwjXm = 0; JqQYwjXm < XAmpJNVg.size(); JqQYwjXm++) {
				FileInputStream drwgc4uc = new FileInputStream(XAmpJNVg.get(JqQYwjXm));
				String JW44efC0 = XAmpJNVg.get(JqQYwjXm).getPath();
				if (JW44efC0.indexOf("\\") != -1)
					JW44efC0 = JW44efC0.substring(JW44efC0.lastIndexOf(fs) + 1, JW44efC0.length());
				ZipEntry Ep9qbjY2 = new ZipEntry(JW44efC0);
				D5hx7Pwr.putNextEntry(Ep9qbjY2);
				int i3JMgCBX;
				while ((i3JMgCBX = drwgc4uc.read(eP7HXSrP)) > 0)
					D5hx7Pwr.write(eP7HXSrP, 0, i3JMgCBX);
				D5hx7Pwr.closeEntry();
				drwgc4uc.close();
				XAmpJNVg.get(JqQYwjXm).delete();
			}
			D5hx7Pwr.close();
		} catch (IllegalArgumentException WwbucKlw) {
			WwbucKlw.printStackTrace();
		} catch (FileNotFoundException qHgTmj3z) {
			qHgTmj3z.printStackTrace();
		} catch (IOException Xf0Pd35V) {
			Xf0Pd35V.printStackTrace();
		}
	}

}