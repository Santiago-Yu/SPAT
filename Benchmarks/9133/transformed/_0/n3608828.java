class n3608828 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent gw94yrzk) {
		try {
			String qJI4GFWV = jTextArea1.getText();
			java.net.URL OcCidvx2 = new java.net.URL("http://217.34.8.235:8080/newgenlibctxt/PatronServlet");
			java.net.URLConnection cId6rtTT = (java.net.URLConnection) OcCidvx2.openConnection();
			cId6rtTT.setDoOutput(true);
			cId6rtTT.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
			java.io.OutputStream mWoTgV2T = cId6rtTT.getOutputStream();
			java.util.zip.CheckedOutputStream knwAO4QV = new java.util.zip.CheckedOutputStream(mWoTgV2T,
					new java.util.zip.Adler32());
			java.util.zip.GZIPOutputStream hktPPC2Y = new java.util.zip.GZIPOutputStream(knwAO4QV);
			java.io.OutputStreamWriter NESLoAGi = new java.io.OutputStreamWriter(hktPPC2Y, "UTF-8");
			System.out.println(qJI4GFWV);
			try {
				java.io.FileOutputStream se8OTGfM = new java.io.FileOutputStream("C:/log.txt");
				se8OTGfM.write(qJI4GFWV.getBytes());
				se8OTGfM.flush();
				se8OTGfM.close();
			} catch (Exception a9pqP9oI) {
				a9pqP9oI.printStackTrace();
			}
			NESLoAGi.write(qJI4GFWV);
			NESLoAGi.flush();
			NESLoAGi.close();
			System.out.println("url conn: " + cId6rtTT.getContentEncoding() + "  " + cId6rtTT.getContentType());
			java.io.InputStream Wy2TA64U = cId6rtTT.getInputStream();
			java.util.zip.CheckedInputStream gAGG7GYW = new java.util.zip.CheckedInputStream(Wy2TA64U,
					new java.util.zip.Adler32());
			java.util.zip.GZIPInputStream Vg9PGFX3 = new java.util.zip.GZIPInputStream(gAGG7GYW);
			java.io.BufferedReader zwK3q43A = new java.io.BufferedReader(new java.io.InputStreamReader(Vg9PGFX3));
			String LTVxhrpY = "";
			while (zwK3q43A.ready()) {
				String K2u9zUbR = zwK3q43A.readLine();
				LTVxhrpY += K2u9zUbR;
			}
			try {
				java.io.FileOutputStream K6lfBYBk = new java.io.FileOutputStream("C:/log3.txt");
				K6lfBYBk.write(LTVxhrpY.getBytes());
				K6lfBYBk.flush();
				K6lfBYBk.close();
			} catch (Exception WPgo5Rb9) {
				WPgo5Rb9.printStackTrace();
			}
		} catch (Exception VzMO4kMw) {
			VzMO4kMw.printStackTrace();
		}
	}

}