class n16993715 {
	public static boolean copyFile(String fromfile, String tofile) {
		File to = new File(tofile);
		File from = new File(fromfile);
		if (!from.exists())
			return false;
		BufferedInputStream in = null;
		if (to.exists()) {
			log.error(tofile + "exists already");
			return false;
		}
		FileInputStream fis = null;
		BufferedOutputStream out = null;
		boolean flag = true;
		FileOutputStream ois = null;
		try {
			to.createNewFile();
			ois = new FileOutputStream(to);
			fis = new FileInputStream(from);
			out = new BufferedOutputStream(ois);
			in = new BufferedInputStream(fis);
			int readBytes = 0;
			byte[] buf = new byte[2048];
			while ((readBytes = in.read(buf, 0, buf.length)) != -1) {
				out.write(buf, 0, readBytes);
			}
		} catch (IOException e) {
			log.error(e);
			flag = false;
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				log.error(e);
				flag = false;
			}
		}
		return flag;
	}

}