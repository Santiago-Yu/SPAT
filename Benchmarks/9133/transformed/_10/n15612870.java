class n15612870 {
	public static void main(String[] args) {
		FileOutputStream fw = null;
		FileInputStream fr = null;
		BufferedOutputStream bw = null;
		BufferedInputStream br = null;
		try {
			fw = new FileOutputStream("c:/Dxw.java");
			fr = new FileInputStream("D:/5.xls");
			bw = new BufferedOutputStream(fw);
			br = new BufferedInputStream(fr);
			int read = br.read();
			while (read != -1) {
				bw.write(read);
				read = br.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}