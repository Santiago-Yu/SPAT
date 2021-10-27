class n6282214 {
	public static boolean Copy(String __from, String __to) {
		try {
			int bytesum = 0;
			int byteread = -1;
			java.io.File oldfile = new java.io.File(__from);
			if (!(oldfile.exists())) {
				return false;
			} else {
				InputStream inStream = new FileInputStream(__from);
				FileOutputStream fs = new FileOutputStream(__to);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			System.out.println("processFile.copyFile()?????????????????? " + e.getMessage());
			return false;
		}
		return true;
	}

}