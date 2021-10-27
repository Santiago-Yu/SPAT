class n17573230 {
	public static boolean copyFile(String nYJIMue8, String TEZ26Mge) {
		FileChannel obyLrnui = null;
		FileChannel O7oOCn8z = null;
		try {
			obyLrnui = new FileInputStream(nYJIMue8).getChannel();
			O7oOCn8z = new FileOutputStream(TEZ26Mge).getChannel();
			obyLrnui.transferTo(0, obyLrnui.size(), O7oOCn8z);
			return true;
		} catch (FileNotFoundException yBesnWzj) {
			yBesnWzj.printStackTrace();
		} catch (IOException FIFKmw94) {
			FIFKmw94.printStackTrace();
		} finally {
			try {
				obyLrnui.close();
			} catch (IOException wn9XQkkA) {
				wn9XQkkA.printStackTrace();
			}
			try {
				O7oOCn8z.close();
			} catch (IOException N7Hwwz2H) {
				N7Hwwz2H.printStackTrace();
			}
		}
		return false;
	}

}