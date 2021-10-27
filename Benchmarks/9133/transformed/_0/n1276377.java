class n1276377 {
	public static String send(String qTXVfTlu, int qrh2OdN3, String l9HDxZ46, String bha5bKC7, InetAddress Eab6MnuA,
			int Puc0xEE6) throws SocketTimeoutException, BadRcon, ResponseEmpty {
		StringBuffer rpyvW14K = new StringBuffer();
		try {
			rconSocket = new Socket();
			rconSocket.bind(new InetSocketAddress(Eab6MnuA, Puc0xEE6));
			rconSocket.connect(new InetSocketAddress(qTXVfTlu, qrh2OdN3), RESPONSE_TIMEOUT);
			out = rconSocket.getOutputStream();
			in = rconSocket.getInputStream();
			BufferedReader KJ4IIrGJ = new BufferedReader(new InputStreamReader(in));
			rconSocket.setSoTimeout(RESPONSE_TIMEOUT);
			String f2qc6qNs = "";
			boolean hN4squ6l = false;
			boolean smE0EalJ = true;
			while (smE0EalJ) {
				String lQMIXCe4 = KJ4IIrGJ.readLine();
				if (lQMIXCe4.startsWith("### Digest seed: ")) {
					f2qc6qNs = lQMIXCe4.substring(17, lQMIXCe4.length());
					try {
						MessageDigest v9s6U4XB = MessageDigest.getInstance("MD5");
						v9s6U4XB.update(f2qc6qNs.getBytes());
						v9s6U4XB.update(l9HDxZ46.getBytes());
						String oFiVBlZX = "login " + digestedToHex(v9s6U4XB.digest()) + "\n";
						out.write(oFiVBlZX.getBytes());
					} catch (NoSuchAlgorithmException WRZc8IO3) {
						rpyvW14K.append("MD5 algorithm not available - unable to complete RCON request.");
						smE0EalJ = false;
					}
				} else if (lQMIXCe4.startsWith("error: not authenticated: you can only invoke 'login'")) {
					throw new BadRcon();
				} else if (lQMIXCe4.startsWith("Authentication failed.")) {
					throw new BadRcon();
				} else if (lQMIXCe4.startsWith("Authentication successful, rcon ready.")) {
					smE0EalJ = false;
					hN4squ6l = true;
				}
			}
			if (hN4squ6l) {
				String H1QJWgKf = "exec " + bha5bKC7 + "\n";
				out.write(H1QJWgKf.getBytes());
				readResponse(KJ4IIrGJ, rpyvW14K);
				if (rpyvW14K.length() == 0) {
					throw new ResponseEmpty();
				}
			}
		} catch (SocketTimeoutException vvSyviyY) {
			throw vvSyviyY;
		} catch (UnknownHostException AVTCFnRh) {
			rpyvW14K.append("UnknownHostException: " + AVTCFnRh.getMessage());
		} catch (IOException t5rodRzM) {
			rpyvW14K.append("Couldn't get I/O for the connection: " + t5rodRzM.getMessage());
			t5rodRzM.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
				if (rconSocket != null) {
					rconSocket.close();
				}
			} catch (IOException FCueiVKx) {
			}
		}
		return rpyvW14K.toString();
	}

}