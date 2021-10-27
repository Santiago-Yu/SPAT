class n27715 {
	public static void main(String[] bcXnT9d7) {
		try {
			int Qt0t8tDt = 0;
			if (bcXnT9d7[0].equals("-e")) {
				Qt0t8tDt = Base64.ENCODE;
			} else if (bcXnT9d7[0].equals("-d")) {
				Qt0t8tDt = Base64.DECODE;
			}
			String OlNvJdDf = bcXnT9d7[1];
			String nUj4rqBH = bcXnT9d7[2];
			File IiQiVE64 = new File(OlNvJdDf);
			FileInputStream QOiIYvMP = new FileInputStream(IiQiVE64);
			BufferedInputStream GiIp2L4k = new BufferedInputStream(QOiIYvMP);
			Base64.InputStream eHfoZJS0 = new Base64.InputStream(GiIp2L4k, Qt0t8tDt | Base64.DO_BREAK_LINES);
			File FwD0VDWf = new File(nUj4rqBH);
			FileOutputStream Xib3S4fn = new FileOutputStream(FwD0VDWf);
			BufferedOutputStream ubzxh08U = new BufferedOutputStream(Xib3S4fn);
			byte[] b3b7GZTB = new byte[1024];
			int pt7NdGgz = -1;
			while ((pt7NdGgz = eHfoZJS0.read(b3b7GZTB)) >= 0) {
				ubzxh08U.write(b3b7GZTB, 0, pt7NdGgz);
			}
			ubzxh08U.close();
			eHfoZJS0.close();
		} catch (Exception nxR8pERQ) {
			nxR8pERQ.printStackTrace();
		}
	}

}