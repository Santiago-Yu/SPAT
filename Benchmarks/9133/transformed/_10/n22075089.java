class n22075089 {
	public static void executa(String arquivo, String filial, String ip) {
		String drive = arquivo.substring(0, 2);
		Properties p = Util.lerPropriedades(arquivo);
		if (drive.indexOf(":") == -1)
			drive = "";
		String servidor = p.getProperty("servidor");
		String impressora = p.getProperty("fila");
		String arqRel = new String(drive + p.getProperty("arquivo"));
		String copias = p.getProperty("copias");
		if (filial.equalsIgnoreCase(servidor)) {
			int tentativas = 0;
			Socket s = null;
			boolean conectado = false;
			FileInputStream in = null;
			while (!conectado) {
				try {
					tentativas++;
					System.out.println("Tentando conectar " + ip + " (" + tentativas + ")");
					s = new Socket(ip, 7000);
					conectado = s.isConnected();
				} catch (ConnectException ce) {
					System.err.println(ce.getMessage());
					System.err.println(ce.getCause());
				} catch (UnknownHostException uhe) {
					System.err.println(uhe.getMessage());
				} catch (IOException ioe) {
					System.err.println(ioe.getMessage());
				}
			}
			BufferedOutputStream out = null;
			try {
				out = new BufferedOutputStream(new GZIPOutputStream(s.getOutputStream()));
				in = new FileInputStream(new File(arqRel));
			} catch (FileNotFoundException e3) {
				e3.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			String arqtr = arqRel.substring(2);
			System.out.println("Proximo arquivo: " + arqRel + " ->" + arqtr);
			while (arqtr.length() < 30)
				arqtr += " ";
			byte aux[] = new byte[30];
			while (impressora.length() < 30)
				impressora += " ";
			byte cop[] = new byte[2];
			byte b[] = new byte[1024];
			try {
				aux = arqtr.getBytes("UTF8");
				out.write(aux);
				aux = impressora.getBytes("UTF8");
				out.write(aux);
				cop = copias.getBytes("UTF8");
				out.write(cop);
				out.flush();
			} catch (UnsupportedEncodingException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			int nBytes;
			try {
				while ((nBytes = in.read(b)) != -1)
					out.write(b, 0, nBytes);
				out.flush();
				out.close();
				in.close();
				s.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Arquivo " + arqRel + " foi transmitido. \n\n");
			SimpleDateFormat dfArq = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String arqLog = "log" + filial + dfArq.format(new Date()) + ".txt";
			SimpleDateFormat dfLog = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(arqLog, true));
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw.println("Arquivo:  " + arquivo + "  " + dfLog.format(new Date()));
			pw.flush();
			pw.close();
			File f = new File(arquivo);
			while (!f.delete()) {
				System.out.println("Erro apagando " + arquivo);
			}
		}
	}

}