class n383058 {
	public static boolean getFile(String s, String name) {
		try {
			URL url = new URL(s);
			File f = new File("D:\\buttons\\data\\sounds\\" + name);
			URLConnection conn = url.openConnection();
			int ch;
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
			while ((ch = bis.read()) != -1) {
				bos.write(ch);
			}
			System.out.println("wrote audio url: " + s + " \nto file " + f);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}