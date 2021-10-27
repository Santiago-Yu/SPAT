class n14058237 {
	public boolean renameTo(File mWbdKA6U) throws IOException {
		if (mWbdKA6U == null) {
			throw new NullPointerException("dest");
		}
		if (!file.renameTo(mWbdKA6U)) {
			FileInputStream eAk4ZHq5 = new FileInputStream(file);
			FileOutputStream PzODyNCw = new FileOutputStream(mWbdKA6U);
			FileChannel U7Gd4xqh = eAk4ZHq5.getChannel();
			FileChannel dCjeYMhD = PzODyNCw.getChannel();
			long HmhY9K3L = U7Gd4xqh.transferTo(0, size, dCjeYMhD);
			U7Gd4xqh.close();
			dCjeYMhD.close();
			if (HmhY9K3L == size) {
				file.delete();
				file = mWbdKA6U;
				isRenamed = true;
				return true;
			} else {
				mWbdKA6U.delete();
				return false;
			}
		}
		file = mWbdKA6U;
		isRenamed = true;
		return true;
	}

}