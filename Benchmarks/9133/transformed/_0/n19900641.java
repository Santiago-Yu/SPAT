class n19900641 {
	public static boolean copyFile(String TRVA1v1B, String FlEnttsK) {
		FileChannel nl08wkbD = null;
		FileChannel TK7ciXVx = null;
		try {
			nl08wkbD = new FileInputStream(new File(TRVA1v1B)).getChannel();
			TK7ciXVx = new FileOutputStream(new File(FlEnttsK)).getChannel();
			nl08wkbD.transferTo(0, nl08wkbD.size(), TK7ciXVx);
		} catch (FileNotFoundException Htq9ib0x) {
			Htq9ib0x.printStackTrace();
			MessageGenerator.briefError("ERROR could not find/access file(s): " + TRVA1v1B + " and/or " + FlEnttsK);
			return false;
		} catch (IOException vk2AAL2m) {
			MessageGenerator.briefError("ERROR copying file: " + TRVA1v1B + " to " + FlEnttsK);
			return false;
		} finally {
			try {
				if (nl08wkbD != null)
					nl08wkbD.close();
				if (TK7ciXVx != null)
					TK7ciXVx.close();
			} catch (IOException YREMLpPx) {
				MessageGenerator
						.briefError("Error closing files involved in copying: " + TRVA1v1B + " and " + FlEnttsK);
				return false;
			}
		}
		return true;
	}

}