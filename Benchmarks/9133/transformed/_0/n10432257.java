class n10432257 {
	private void createImageArchive() throws Exception {
		imageArchive = new File(resoutFolder, "images.CrAr");
		DataOutputStream IXmbNzHE = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(imageArchive)));
		IXmbNzHE.writeInt(toNativeEndian(imageFiles.size()));
		for (int URmSGNek = 0; URmSGNek < imageFiles.size(); URmSGNek++) {
			File rqt4XOIZ = imageFiles.get(URmSGNek);
			IXmbNzHE.writeLong(toNativeEndian(rqt4XOIZ.length()));
			IXmbNzHE.writeLong(toNativeEndian(
					new File(resFolder, rqt4XOIZ.getName().substring(0, rqt4XOIZ.getName().length() - 5)).length()));
		}
		for (int dLvsAt4a = 0; dLvsAt4a < imageFiles.size(); dLvsAt4a++) {
			BufferedInputStream NwWj1lej = new BufferedInputStream(new FileInputStream(imageFiles.get(dLvsAt4a)));
			int yS9O5FfV;
			while ((yS9O5FfV = NwWj1lej.read()) != -1) {
				IXmbNzHE.write(yS9O5FfV);
			}
			NwWj1lej.close();
		}
		IXmbNzHE.close();
	}

}