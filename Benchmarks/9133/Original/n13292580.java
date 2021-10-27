class n13292580{
    public Node external_open_url(Node startAt) throws Exception {
        if (inUse) {
            throw new InterpreterException(StdErrors.extend(StdErrors.Already_used, "File already open"));
        }
        inUse = true;
        startAt.isGoodArgsLength(false, 2);
        ExtURL url = new ExtURL(startAt.getSubNode(1, Node.TYPE_STRING).getString());
        String protocol = url.getProtocol();
        String mode = null;
        Node props = null;
        Node datas = null;
        byte[] buffer = null;
        String old_c = null;
        String old_r = null;
        int max_i = startAt.size() - 1;
        if (startAt.elementAt(max_i).getSymbolicValue_undestructive().isVList()) {
            props = startAt.getSubNode(max_i--, Node.TYPE_LIST);
        }
        int i_ = 2;
        if (i_ <= max_i) {
            mode = startAt.getSubNode(i_++, Node.TYPE_STRING).getString().toUpperCase().trim();
            if (protocol.equalsIgnoreCase("http") || protocol.equalsIgnoreCase("https")) {
                if (!(mode.equals("GET") || mode.equals("POST") || mode.equals("PUT"))) {
                    throw new InterpreterException(128010, "Unsupported request methode");
                }
            } else if (protocol.equalsIgnoreCase("ftp") || protocol.equalsIgnoreCase("file")) {
                if (!(mode.equalsIgnoreCase("r") || mode.equalsIgnoreCase("w"))) {
                    throw new InterpreterException(128015, "Unsupported access methode");
                }
            } else if (protocol.equalsIgnoreCase("jar") || protocol.equalsIgnoreCase("stdin")) {
                if (!(mode.equalsIgnoreCase("r"))) {
                    throw new InterpreterException(128015, "Unsupported access methode");
                }
            } else if (protocol.equalsIgnoreCase("tcp") || protocol.equalsIgnoreCase("ssl+tcp")) {
                if (!(mode.equalsIgnoreCase("rw"))) {
                    throw new InterpreterException(128015, "Unsupported access methode");
                }
            } else if (protocol.equalsIgnoreCase("stdout") || protocol.equalsIgnoreCase("stderr")) {
                if (!(mode.equalsIgnoreCase("w"))) {
                    throw new InterpreterException(128015, "Unsupported access methode");
                }
            } else {
                throw new InterpreterException(128011, "Unsupported protocol");
            }
        }
        if (i_ <= max_i) {
            if (!protocol.equalsIgnoreCase("http") && !protocol.equalsIgnoreCase("https")) {
                throw new InterpreterException(128016, "Unsupported request datas");
            }
            datas = startAt.getSubNode(i_++, Node.TYPE_STRING | Node.TYPE_OBJECT);
            if (datas.isVObject()) {
                Object obj = datas.getVObjectExternalInstance();
                if (External_Buffer.class.isInstance(obj)) {
                    Buffer bbuffer = ((External_Buffer) obj).getBuffer();
                    buffer = bbuffer.read_bytes();
                } else {
                    throw new InterpreterException(StdErrors.extend(StdErrors.Invalid_parameter, "Object (" + obj.getClass().getName() + ") required " + External_Buffer.class.getName()));
                }
            } else {
                buffer = datas.getString().getBytes();
            }
        }
        if (datas != null && mode != null && mode.equals("GET")) {
            throw new InterpreterException(128012, "GET request with data body");
        }
        if (props != null && (!protocol.equalsIgnoreCase("http") && !protocol.equalsIgnoreCase("https"))) {
            throw new InterpreterException(128013, "Cannot handle header properties in request");
        }
        try {
            if (protocol.equalsIgnoreCase("file") && mode != null && mode.equalsIgnoreCase("w")) {
                File f = new File(url.toURI());
                outputStream = new FileOutputStream(f);
                outputBuffer = new BufferedOutputStream(outputStream);
                output = new DataOutputStream(outputBuffer);
            } else if (protocol.equalsIgnoreCase("tcp")) {
                tcpHost = url.getHost();
                tcpPort = url.getPort();
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
            } else if (protocol.equalsIgnoreCase("ssl+tcp")) {
                tcpHost = url.getHost();
                tcpPort = url.getPort();
                if (tcpPort < 0 || tcpPort > 65535) {
                    throw new InterpreterException(StdErrors.extend(StdErrors.Out_of_range, "" + tcpPort));
                }
                SocketFactory socketFactory = SSLSocketFactory.getDefault();
                socket = socketFactory.createSocket(tcpHost, tcpPort);
                if (readTimeOut > 0) {
                    socket.setSoTimeout(readTimeOut);
                }
                inputStream = socket.getInputStream();
                inputBuffer = new BufferedInputStream(inputStream);
                input = new DataInputStream(inputBuffer);
                outputStream = socket.getOutputStream();
                outputBuffer = new BufferedOutputStream(outputStream);
                output = new DataOutputStream(outputBuffer);
            } else if (protocol.equalsIgnoreCase("stdout")) {
                setBufOut(System.out);
            } else if (protocol.equalsIgnoreCase("stderr")) {
                setBufOut(System.err);
            } else if (protocol.equalsIgnoreCase("stdin")) {
                setBufIn(System.in);
            } else {
                urlConnection = url.openConnection();
                if (connectTimeOut > 0) {
                    urlConnection.setConnectTimeout(connectTimeOut);
                }
                if (readTimeOut > 0) {
                    urlConnection.setReadTimeout(readTimeOut);
                }
                urlConnection.setUseCaches(false);
                urlConnection.setDoInput(true);
                if (urlConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpCon = (HttpURLConnection) urlConnection;
                    if (props != null) {
                        for (int i = 0; i < props.size(); i++) {
                            Node pnode = props.getSubNode(i, Node.TYPE_DICO);
                            String header_s = Node.getPairKey(pnode);
                            String value_s = Node.node2VString(Node.getPairValue(pnode)).getString();
                            Interpreter.Log("   HTTP-Header: " + header_s + " : " + value_s);
                            httpCon.setRequestProperty(header_s, value_s);
                        }
                    }
                    if (mode != null && (mode.equals("POST") || mode.equals("PUT"))) {
                        if (mode.equals("PUT")) {
                            Interpreter.Log("   HTTP PUT: " + url.toString());
                        } else {
                            Interpreter.Log("   HTTP POST: " + url.toString());
                        }
                        urlConnection.setDoOutput(true);
                        httpCon.setRequestMethod(mode);
                        outputStream = urlConnection.getOutputStream();
                        outputBuffer = new BufferedOutputStream(outputStream);
                        output = new DataOutputStream(outputBuffer);
                        output.write(buffer);
                        output.flush();
                    }
                    inputStream = urlConnection.getInputStream();
                    inputBuffer = new BufferedInputStream(inputStream);
                    input = new DataInputStream(inputBuffer);
                } else {
                    if (mode == null || (mode != null && mode.equalsIgnoreCase("r"))) {
                        Interpreter.Log("   " + protocol + " read : " + url.toString());
                        inputStream = urlConnection.getInputStream();
                        inputBuffer = new BufferedInputStream(inputStream);
                        input = new DataInputStream(inputBuffer);
                    } else {
                        Interpreter.Log("   " + protocol + " write : " + url.toString());
                        outputStream = urlConnection.getOutputStream();
                        outputBuffer = new BufferedOutputStream(outputStream);
                        output = new DataOutputStream(outputBuffer);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        bytePos = 0;
        putHook();
        return null;
    }

}