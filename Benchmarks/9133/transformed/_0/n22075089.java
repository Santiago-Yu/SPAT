class n22075089 {
	public static void executa(String zFu2Wk9J, String otsYPY4J, String C4QmdItt) {
		String mShiE1Fj = zFu2Wk9J.substring(0, 2);
		if (mShiE1Fj.indexOf(":") == -1)
			mShiE1Fj = "";
		Properties br3tbWdJ = Util.lerPropriedades(zFu2Wk9J);
		String urRAPeXg = br3tbWdJ.getProperty("servidor");
		String OLSRFTp7 = br3tbWdJ.getProperty("fila");
		String uqhppa1y = new String(mShiE1Fj + br3tbWdJ.getProperty("arquivo"));
		String Eco1xa4Q = br3tbWdJ.getProperty("copias");
		if (otsYPY4J.equalsIgnoreCase(urRAPeXg)) {
			Socket ukgu23em = null;
			int ashFpIsz = 0;
			boolean IWz5SD2l = false;
			while (!IWz5SD2l) {
				try {
					ashFpIsz++;
					System.out.println("Tentando conectar " + C4QmdItt + " (" + ashFpIsz + ")");
					ukgu23em = new Socket(C4QmdItt, 7000);
					IWz5SD2l = ukgu23em.isConnected();
				} catch (ConnectException jbvjwErN) {
					System.err.println(jbvjwErN.getMessage());
					System.err.println(jbvjwErN.getCause());
				} catch (UnknownHostException iEB76aD6) {
					System.err.println(iEB76aD6.getMessage());
				} catch (IOException BSINtNHD) {
					System.err.println(BSINtNHD.getMessage());
				}
			}
			FileInputStream dwUPYZAY = null;
			BufferedOutputStream tFuabZb8 = null;
			try {
				dwUPYZAY = new FileInputStream(new File(uqhppa1y));
				tFuabZb8 = new BufferedOutputStream(new GZIPOutputStream(ukgu23em.getOutputStream()));
			} catch (FileNotFoundException JYXKKLPh) {
				JYXKKLPh.printStackTrace();
			} catch (IOException QkbhwNDi) {
				QkbhwNDi.printStackTrace();
			}
			String AOpdagWN = uqhppa1y.substring(2);
			System.out.println("Proximo arquivo: " + uqhppa1y + " ->" + AOpdagWN);
			while (AOpdagWN.length() < 30)
				AOpdagWN += " ";
			while (OLSRFTp7.length() < 30)
				OLSRFTp7 += " ";
			byte o9rFjCCJ[] = new byte[30];
			byte b93ODCMv[] = new byte[2];
			try {
				o9rFjCCJ = AOpdagWN.getBytes("UTF8");
				tFuabZb8.write(o9rFjCCJ);
				o9rFjCCJ = OLSRFTp7.getBytes("UTF8");
				tFuabZb8.write(o9rFjCCJ);
				b93ODCMv = Eco1xa4Q.getBytes("UTF8");
				tFuabZb8.write(b93ODCMv);
				tFuabZb8.flush();
			} catch (UnsupportedEncodingException BLdja1bS) {
				BLdja1bS.printStackTrace();
			} catch (IOException XXmDnFCl) {
				XXmDnFCl.printStackTrace();
			}
			byte qrpqHCvW[] = new byte[1024];
			int SBmUVN1z;
			try {
				while ((SBmUVN1z = dwUPYZAY.read(qrpqHCvW)) != -1)
					tFuabZb8.write(qrpqHCvW, 0, SBmUVN1z);
				tFuabZb8.flush();
				tFuabZb8.close();
				dwUPYZAY.close();
				ukgu23em.close();
			} catch (IOException l4ifFcKA) {
				l4ifFcKA.printStackTrace();
			}
			System.out.println("Arquivo " + uqhppa1y + " foi transmitido. \n\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException Cdge020f) {
				Cdge020f.printStackTrace();
			}
			SimpleDateFormat xzCBRWQ8 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat zWehf5Q6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String OwPzQNYM = "log" + otsYPY4J + xzCBRWQ8.format(new Date()) + ".txt";
			PrintWriter arU82iY4 = null;
			try {
				arU82iY4 = new PrintWriter(new FileWriter(OwPzQNYM, true));
			} catch (IOException y1uZ4uev) {
				y1uZ4uev.printStackTrace();
			}
			arU82iY4.println("Arquivo:  " + zFu2Wk9J + "  " + zWehf5Q6.format(new Date()));
			arU82iY4.flush();
			arU82iY4.close();
			File wKaIhVfG = new File(zFu2Wk9J);
			while (!wKaIhVfG.delete()) {
				System.out.println("Erro apagando " + zFu2Wk9J);
			}
		}
	}

}