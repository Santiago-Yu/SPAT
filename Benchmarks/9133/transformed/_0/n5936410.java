class n5936410 {
	public void run() {
		try {
			String S2q5tQyD = null;
			String FJ84EWrn, EBQ6uaMX = "", uzLv5kKL = "";
			int YsTV7IM5 = 80;
			while (true) {
				FJ84EWrn = fromBrowser.readLine();
				if (FJ84EWrn.startsWith("GET") || FJ84EWrn.startsWith("DESCRIBE") || FJ84EWrn.startsWith("POST")
						|| FJ84EWrn.startsWith("HEAD")) {
					S2q5tQyD = FJ84EWrn;
				}
				if (FJ84EWrn.startsWith("Accept-Encoding: gzip")) {
					FJ84EWrn = "Accept-Encoding: identity";
				}
				uzLv5kKL += FJ84EWrn + "\r\n";
				if (FJ84EWrn.startsWith("Host: ")) {
					EBQ6uaMX = FJ84EWrn.substring(6);
				} else if (FJ84EWrn.startsWith("DESCRIBE")) {
					YsTV7IM5 = 554;
					EBQ6uaMX = FJ84EWrn.substring(FJ84EWrn.indexOf("//") + 2);
					EBQ6uaMX = EBQ6uaMX.substring(0, EBQ6uaMX.indexOf("/"));
				}
				if (FJ84EWrn.length() == 0) {
					break;
				}
			}
			String KtoVg9Hd = EBQ6uaMX;
			if (EBQ6uaMX.indexOf(":") > -1) {
				try {
					YsTV7IM5 = Integer.parseInt(EBQ6uaMX.substring(EBQ6uaMX.indexOf(":") + 1));
				} catch (NumberFormatException Br0KRErO) {
				}
				KtoVg9Hd = EBQ6uaMX.substring(0, EBQ6uaMX.indexOf(":"));
			}
			logger.trace("[PROXY] Connect to: " + KtoVg9Hd + " and port: " + YsTV7IM5);
			socketToWeb = new Socket(InetAddress.getByName(KtoVg9Hd), YsTV7IM5);
			InputStream nOxnI1Ku = socketToWeb.getInputStream();
			toWeb = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketToWeb.getOutputStream())), true);
			toWeb.println(uzLv5kKL);
			toWeb.flush();
			StringTokenizer eijffUHj = new StringTokenizer(S2q5tQyD, " ");
			eijffUHj.nextToken();
			String ROyqLVOO = eijffUHj.nextToken();
			ROyqLVOO = ROyqLVOO.substring(ROyqLVOO.indexOf(EBQ6uaMX) + EBQ6uaMX.length());
			logger.trace("[PROXY] Asked resource: " + ROyqLVOO);
			String KZQPkx9x = ROyqLVOO.substring(0, ROyqLVOO.lastIndexOf("/"));
			KZQPkx9x = getWritableFileName(KZQPkx9x);
			String Chp5FzSv = ROyqLVOO.substring(ROyqLVOO.lastIndexOf("/") + 1);
			Chp5FzSv = getWritableFileName(Chp5FzSv);
			Chp5FzSv = Chp5FzSv + ".cached";
			String fLo3il5u = "proxycache/" + KtoVg9Hd + "/" + KZQPkx9x;
			File sg8s1iYw = new File(fLo3il5u);
			if (writeCache) {
				sg8s1iYw.mkdirs();
			}
			File arRRiK0k = new File(sg8s1iYw, Chp5FzSv);
			byte[] P2mZw94r = new byte[8192];
			boolean denyp7Dw = arRRiK0k.exists() || this.getClass().getResource("/" + fLo3il5u) != null;
			boolean sQCxNrnF = writeCache && !denyp7Dw;
			FileOutputStream vTW9sgs4 = null;
			if (denyp7Dw) {
				logger.trace("[PROXY] File is cached: " + arRRiK0k.getAbsolutePath());
				nOxnI1Ku.close();
				if (arRRiK0k.exists()) {
					nOxnI1Ku = new FileInputStream(arRRiK0k);
				} else {
					nOxnI1Ku = this.getClass().getResourceAsStream("/" + fLo3il5u);
				}
			} else if (writeCache) {
				logger.trace("[PROXY] File is not cached / Writing in it: " + arRRiK0k.getAbsolutePath());
				vTW9sgs4 = new FileOutputStream(arRRiK0k, false);
			}
			OutputStream KBQokZeV = null;
			if (sQCxNrnF) {
				KBQokZeV = new ByteArrayOutputStream();
			} else {
				KBQokZeV = toBrowser;
			}
			long xsue4RBL = 0;
			int gbpXGxTO;
			long va4AEdwu = 10000000000L;
			while (xsue4RBL < va4AEdwu && (gbpXGxTO = nOxnI1Ku.read(P2mZw94r)) != -1) {
				if (!denyp7Dw) {
					if (10000000000L == va4AEdwu) {
						String LuXjLGRj = new String(P2mZw94r, 0, gbpXGxTO);
						int yaCyd7OU = LuXjLGRj.indexOf("Content-Length: ");
						if (yaCyd7OU > -1) {
							va4AEdwu = Integer.parseInt(
									LuXjLGRj.substring(yaCyd7OU + 16, LuXjLGRj.indexOf("\n", yaCyd7OU)).trim());
							logger.trace("Found Content Length: " + va4AEdwu);
						}
					}
					if (gbpXGxTO >= 7) {
						byte arYhGrMZ[] = new byte[7];
						System.arraycopy(P2mZw94r, gbpXGxTO - 7, arYhGrMZ, 0, 7);
						if (new String(arYhGrMZ).equals("\r\n0\r\n\r\n")) {
							System.out.println("end of transfer chunked");
							va4AEdwu = -1;
						}
					}
					if (writeCache) {
						vTW9sgs4.write(P2mZw94r, 0, gbpXGxTO);
					}
				}
				KBQokZeV.write(P2mZw94r, 0, gbpXGxTO);
				xsue4RBL += gbpXGxTO;
			}
			if (sQCxNrnF) {
				KBQokZeV.close();
				toBrowser.write(((ByteArrayOutputStream) KBQokZeV).toByteArray());
			}
			if (writeCache && vTW9sgs4 != null) {
				vTW9sgs4.close();
			}
			socketToWeb.close();
			toBrowser.close();
		} catch (IOException OzgY7puQ) {
		} finally {
			try {
				if (toWeb != null) {
					toWeb.close();
				}
				if (toBrowser != null) {
					toBrowser.close();
				}
				socket.close();
			} catch (IOException PinpP0kv) {
			}
		}
	}

}