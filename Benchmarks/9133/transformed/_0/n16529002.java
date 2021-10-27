class n16529002 {
	public static boolean copy(File CxZiNRvO, File hJCwxBDD) {
		FileChannel z6unfW7i = null, kM9Jv4z4 = null;
		try {
			z6unfW7i = new FileInputStream(CxZiNRvO).getChannel();
			kM9Jv4z4 = new FileOutputStream(hJCwxBDD).getChannel();
			long GF0plaFe = z6unfW7i.size();
			MappedByteBuffer HXb6znoh = z6unfW7i.map(FileChannel.MapMode.READ_ONLY, 0, GF0plaFe);
			kM9Jv4z4.write(HXb6znoh);
			if (z6unfW7i != null)
				z6unfW7i.close();
			if (kM9Jv4z4 != null)
				kM9Jv4z4.close();
		} catch (IOException TRUNli8a) {
			TRUNli8a.printStackTrace();
			return false;
		}
		return true;
	}

}