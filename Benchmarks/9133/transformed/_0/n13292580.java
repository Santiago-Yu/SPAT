class n13292580 {
	public Node external_open_url(Node c8AFVI7n) throws Exception {
		if (inUse) {
			throw new InterpreterException(StdErrors.extend(StdErrors.Already_used, "File already open"));
		}
		inUse = true;
		c8AFVI7n.isGoodArgsLength(false, 2);
		ExtURL saRAL40f = new ExtURL(c8AFVI7n.getSubNode(1, Node.TYPE_STRING).getString());
		String FBPczYYh = saRAL40f.getProtocol();
		String ksIin5Q5 = null;
		Node vHum45a0 = null;
		Node zLo68aQT = null;
		byte[] wigMWQ7P = null;
		String zSyI4Iuy = null;
		String Ir1joclD = null;
		int G5BKijhe = c8AFVI7n.size() - 1;
		if (c8AFVI7n.elementAt(G5BKijhe).getSymbolicValue_undestructive().isVList()) {
			vHum45a0 = c8AFVI7n.getSubNode(G5BKijhe--, Node.TYPE_LIST);
		}
		int vyOZCVLK = 2;
		if (vyOZCVLK <= G5BKijhe) {
			ksIin5Q5 = c8AFVI7n.getSubNode(vyOZCVLK++, Node.TYPE_STRING).getString().toUpperCase().trim();
			if (FBPczYYh.equalsIgnoreCase("http") || FBPczYYh.equalsIgnoreCase("https")) {
				if (!(ksIin5Q5.equals("GET") || ksIin5Q5.equals("POST") || ksIin5Q5.equals("PUT"))) {
					throw new InterpreterException(128010, "Unsupported request methode");
				}
			} else if (FBPczYYh.equalsIgnoreCase("ftp") || FBPczYYh.equalsIgnoreCase("file")) {
				if (!(ksIin5Q5.equalsIgnoreCase("r") || ksIin5Q5.equalsIgnoreCase("w"))) {
					throw new InterpreterException(128015, "Unsupported access methode");
				}
			} else if (FBPczYYh.equalsIgnoreCase("jar") || FBPczYYh.equalsIgnoreCase("stdin")) {
				if (!(ksIin5Q5.equalsIgnoreCase("r"))) {
					throw new InterpreterException(128015, "Unsupported access methode");
				}
			} else if (FBPczYYh.equalsIgnoreCase("tcp") || FBPczYYh.equalsIgnoreCase("ssl+tcp")) {
				if (!(ksIin5Q5.equalsIgnoreCase("rw"))) {
					throw new InterpreterException(128015, "Unsupported access methode");
				}
			} else if (FBPczYYh.equalsIgnoreCase("stdout") || FBPczYYh.equalsIgnoreCase("stderr")) {
				if (!(ksIin5Q5.equalsIgnoreCase("w"))) {
					throw new InterpreterException(128015, "Unsupported access methode");
				}
			} else {
				throw new InterpreterException(128011, "Unsupported protocol");
			}
		}
		if (vyOZCVLK <= G5BKijhe) {
			if (!FBPczYYh.equalsIgnoreCase("http") && !FBPczYYh.equalsIgnoreCase("https")) {
				throw new InterpreterException(128016, "Unsupported request datas");
			}
			zLo68aQT = c8AFVI7n.getSubNode(vyOZCVLK++, Node.TYPE_STRING | Node.TYPE_OBJECT);
			if (zLo68aQT.isVObject()) {
				Object elA8FPbZ = zLo68aQT.getVObjectExternalInstance();
				if (External_Buffer.class.isInstance(elA8FPbZ)) {
					Buffer CjvbZ58O = ((External_Buffer) elA8FPbZ).getBuffer();
					wigMWQ7P = CjvbZ58O.read_bytes();
				} else {
					throw new InterpreterException(StdErrors.extend(StdErrors.Invalid_parameter, "Object ("
							+ elA8FPbZ.getClass().getName() + ") required " + External_Buffer.class.getName()));
				}
			} else {
				wigMWQ7P = zLo68aQT.getString().getBytes();
			}
		}
		if (zLo68aQT != null && ksIin5Q5 != null && ksIin5Q5.equals("GET")) {
			throw new InterpreterException(128012, "GET request with data body");
		}
		if (vHum45a0 != null && (!FBPczYYh.equalsIgnoreCase("http") && !FBPczYYh.equalsIgnoreCase("https"))) {
			throw new InterpreterException(128013, "Cannot handle header properties in request");
		}
		try {
			if (FBPczYYh.equalsIgnoreCase("file") && ksIin5Q5 != null && ksIin5Q5.equalsIgnoreCase("w")) {
				File RfdeWopx = new File(saRAL40f.toURI());
				outputStream = new FileOutputStream(RfdeWopx);
				outputBuffer = new BufferedOutputStream(outputStream);
				output = new DataOutputStream(outputBuffer);
			} else if (FBPczYYh.equalsIgnoreCase("tcp")) {
				tcpHost = saRAL40f.getHost();
				tcpPort = saRAL40f.getPort();
				if (tcpPort < 0 || tcpPort > 65535) {
					throw new InterpreterException(StdErrors.extend(StdErrors.Out_of_range, "" + tcpPort));
				}
				socket = new Socket(tcpHost, tcpPort);
				if (readTimeOut > 0) {
					socket.setSoTimeout(readTimeOut);
				}
				inputStream = socket.getInputStream();
				inputBuffer = new BufferedInputStream(inputStream);
				input = new DataInputStream(inputBuffer);
				outputStream = socket.getOutputStream();
				outputBuffer = new BufferedOutputStream(outputStream);
				output = new DataOutputStream(outputBuffer);
			} else if (FBPczYYh.equalsIgnoreCase("ssl+tcp")) {
				tcpHost = saRAL40f.getHost();
				tcpPort = saRAL40f.getPort();
				if (tcpPort < 0 || tcpPort > 65535) {
					throw new InterpreterException(StdErrors.extend(StdErrors.Out_of_range, "" + tcpPort));
				}
				SocketFactory moV71DV3 = SSLSocketFactory.getDefault();
				socket = moV71DV3.createSocket(tcpHost, tcpPort);
				if (readTimeOut > 0) {
					socket.setSoTimeout(readTimeOut);
				}
				inputStream = socket.getInputStream();
				inputBuffer = new BufferedInputStream(inputStream);
				input = new DataInputStream(inputBuffer);
				outputStream = socket.getOutputStream();
				outputBuffer = new BufferedOutputStream(outputStream);
				output = new DataOutputStream(outputBuffer);
			} else if (FBPczYYh.equalsIgnoreCase("stdout")) {
				setBufOut(System.out);
			} else if (FBPczYYh.equalsIgnoreCase("stderr")) {
				setBufOut(System.err);
			} else if (FBPczYYh.equalsIgnoreCase("stdin")) {
				setBufIn(System.in);
			} else {
				urlConnection = saRAL40f.openConnection();
				if (connectTimeOut > 0) {
					urlConnection.setConnectTimeout(connectTimeOut);
				}
				if (readTimeOut > 0) {
					urlConnection.setReadTimeout(readTimeOut);
				}
				urlConnection.setUseCaches(false);
				urlConnection.setDoInput(true);
				if (urlConnection instanceof HttpURLConnection) {
					HttpURLConnection XimOpmh5 = (HttpURLConnection) urlConnection;
					if (vHum45a0 != null) {
						for (int XZtkeuQQ = 0; XZtkeuQQ < vHum45a0.size(); XZtkeuQQ++) {
							Node q4BU4ucx = vHum45a0.getSubNode(XZtkeuQQ, Node.TYPE_DICO);
							String zeNl1wFn = Node.getPairKey(q4BU4ucx);
							String sHRfa7Sl = Node.node2VString(Node.getPairValue(q4BU4ucx)).getString();
							Interpreter.Log("   HTTP-Header: " + zeNl1wFn + " : " + sHRfa7Sl);
							XimOpmh5.setRequestProperty(zeNl1wFn, sHRfa7Sl);
						}
					}
					if (ksIin5Q5 != null && (ksIin5Q5.equals("POST") || ksIin5Q5.equals("PUT"))) {
						if (ksIin5Q5.equals("PUT")) {
							Interpreter.Log("   HTTP PUT: " + saRAL40f.toString());
						} else {
							Interpreter.Log("   HTTP POST: " + saRAL40f.toString());
						}
						urlConnection.setDoOutput(true);
						XimOpmh5.setRequestMethod(ksIin5Q5);
						outputStream = urlConnection.getOutputStream();
						outputBuffer = new BufferedOutputStream(outputStream);
						output = new DataOutputStream(outputBuffer);
						output.write(wigMWQ7P);
						output.flush();
					}
					inputStream = urlConnection.getInputStream();
					inputBuffer = new BufferedInputStream(inputStream);
					input = new DataInputStream(inputBuffer);
				} else {
					if (ksIin5Q5 == null || (ksIin5Q5 != null && ksIin5Q5.equalsIgnoreCase("r"))) {
						Interpreter.Log("   " + FBPczYYh + " read : " + saRAL40f.toString());
						inputStream = urlConnection.getInputStream();
						inputBuffer = new BufferedInputStream(inputStream);
						input = new DataInputStream(inputBuffer);
					} else {
						Interpreter.Log("   " + FBPczYYh + " write : " + saRAL40f.toString());
						outputStream = urlConnection.getOutputStream();
						outputBuffer = new BufferedOutputStream(outputStream);
						output = new DataOutputStream(outputBuffer);
					}
				}
			}
		} catch (Exception ZfOzgzh0) {
			throw ZfOzgzh0;
		}
		bytePos = 0;
		putHook();
		return null;
	}

}