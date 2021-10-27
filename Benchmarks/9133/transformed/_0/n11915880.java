class n11915880 {
	private static void cut() {
		File YLoDME9K = new File(inputFileName);
		BufferedReader EV0SdkUL = null;
		try {
			EV0SdkUL = new BufferedReader(new InputStreamReader(new FileInputStream(YLoDME9K), inputCharSet));
		} catch (FileNotFoundException A5bnIHnE) {
			System.err.print("Invalid File Name!");
			System.err.flush();
			System.exit(1);
		} catch (UnsupportedEncodingException NMBVG4zn) {
			System.err.print("Invalid Char Set Name!");
			System.err.flush();
			System.exit(1);
		}
		switch (cutMode) {
		case charMode: {
			int eHBn8CbJ = 1;
			char[] u2xZLn5M = new char[charPerFile];
			while (true) {
				int PHl08CmB = 0;
				try {
					PHl08CmB = EV0SdkUL.read(u2xZLn5M);
				} catch (IOException M3InpWYT) {
					System.err.println("Read IO Error!");
					System.err.flush();
					System.exit(1);
				}
				if (-1 == PHl08CmB)
					break;
				else {
					try {
						int FLFyeQrm = inputFileName.lastIndexOf(".");
						String EhM1m00B = inputFileName.substring(0, FLFyeQrm);
						String Lnj47kqj = "html";
						DecimalFormat kOOKLHyK = new DecimalFormat("0000");
						File uxgUMmhx = new File(EhM1m00B + "-" + kOOKLHyK.format(eHBn8CbJ) + "." + Lnj47kqj);
						BufferedWriter ePskWElV = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(uxgUMmhx), outputCharSet));
						ePskWElV.write(u2xZLn5M, 0, PHl08CmB);
						ePskWElV.flush();
						ePskWElV.close();
						eHBn8CbJ++;
					} catch (IOException uwM08Xit) {
						System.err.println("Write IO Error!");
						System.err.flush();
						System.exit(1);
					}
				}
			}
			break;
		}
		case lineMode: {
			boolean dxAgCYzx = false;
			int bfqq80ol = 1;
			while (!dxAgCYzx) {
				try {
					int UzkCAXxu = inputFileName.lastIndexOf(".");
					String sCyg1EKi = inputFileName.substring(0, UzkCAXxu);
					String h9p6rPAw = inputFileName.substring(UzkCAXxu + 1);
					DecimalFormat iN4MTr6d = new DecimalFormat("0000");
					File oS07ogMj = new File(sCyg1EKi + iN4MTr6d.format(bfqq80ol) + "." + h9p6rPAw);
					PrintStream ZpHcLZ1J = new PrintStream(new FileOutputStream(oS07ogMj), false, outputCharSet);
					int EwQD2ikA = 0;
					while (EwQD2ikA < linePerFile) {
						String RvY0U3XN = EV0SdkUL.readLine();
						if (null == RvY0U3XN) {
							dxAgCYzx = true;
							break;
						}
						ZpHcLZ1J.println(RvY0U3XN);
						++EwQD2ikA;
					}
					ZpHcLZ1J.flush();
					ZpHcLZ1J.close();
				} catch (IOException BwBePurw) {
					System.err.println("Write IO Error!");
					System.err.flush();
					System.exit(1);
				}
				++bfqq80ol;
			}
			break;
		}
		case htmlMode: {
			boolean TxebKgOf = false;
			int BfdeEqzL = 1;
			int JanvMkHR = inputFileName.lastIndexOf(".");
			String WVYngdxI = inputFileName.substring(0, JanvMkHR);
			String wSi7J3Fw = "html";
			DecimalFormat mf5sHVn9 = new DecimalFormat("0000");
			while (!TxebKgOf) {
				try {
					File GfVME2K0 = new File(WVYngdxI + "-" + mf5sHVn9.format(BfdeEqzL) + "." + wSi7J3Fw);
					PrintStream aiRjIbZk = new PrintStream(new FileOutputStream(GfVME2K0), false, outputCharSet);
					aiRjIbZk.println("<html><head><title>" + WVYngdxI + "-" + mf5sHVn9.format(BfdeEqzL) + "</title>"
							+ "<meta http-equiv=\"Content-Type\"" + " content=\"text/html; " + "charset="
							+ outputCharSet + "\" />" + "<link rel =\"stylesheet\" " + "type=\"text/css\" "
							+ "href=\"stylesheet.css\" />" + "</head><body><div id=\"content\">");
					int XSHQj0EF = 0;
					while (XSHQj0EF < pPerFile) {
						String m0aGaPiN = EV0SdkUL.readLine();
						if (null == m0aGaPiN) {
							TxebKgOf = true;
							break;
						}
						if (m0aGaPiN.length() > 0)
							aiRjIbZk.println("<p>" + m0aGaPiN + "</p>");
						++XSHQj0EF;
					}
					aiRjIbZk.println("</div><a href=\"" + WVYngdxI + "-" + mf5sHVn9.format(BfdeEqzL + 1) + "."
							+ wSi7J3Fw + "\">NEXT</a></body></html>");
					aiRjIbZk.flush();
					aiRjIbZk.close();
				} catch (IOException KjV5HZxP) {
					System.err.println("Write IO Error!");
					System.err.flush();
					System.exit(1);
				}
				++BfdeEqzL;
			}
			try {
				File pElrDUrj = new File("index.html");
				PrintStream zZz4eY5c = new PrintStream(new FileOutputStream(pElrDUrj), false, outputCharSet);
				zZz4eY5c.println("<html><head><title>" + "Index" + "</title>" + "<meta http-equiv=\"Content-Type\""
						+ " content=\"text/html; " + "charset=" + outputCharSet + "\" />" + "<link rel =\"stylesheet\" "
						+ "type=\"text/css\" " + "href=\"stylesheet.css\" />" + "</head><body><h2>" + htmlTitle
						+ "</h2><div id=\"content\"><ul>");
				for (int xy0fV7QP = 1; xy0fV7QP < BfdeEqzL; xy0fV7QP++) {
					zZz4eY5c.println("<li><a href=\"" + WVYngdxI + "-" + mf5sHVn9.format(xy0fV7QP) + "." + wSi7J3Fw
							+ "\">" + mf5sHVn9.format(xy0fV7QP) + "</a></li>");
				}
				zZz4eY5c.println("</ul></body></html>");
				zZz4eY5c.flush();
				zZz4eY5c.close();
			} catch (IOException larBX6IY) {
				System.err.println("Write IO Error!");
				System.err.flush();
				System.exit(1);
			}
			break;
		}
		}
	}

}