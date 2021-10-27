    public void open(String openStr) throws IOException {
        String commProtocol = "comm:";
        String rxtxProtocol = "rxtx:";
        String netProtocol = "net:";
        if (openStr.startsWith(commProtocol)) {
            CommConnection commConnection = CommConnection.open(openStr.substring(commProtocol.length()));
            this.setInputStream(commConnection.getInputStream());
            this.setOutputStream(commConnection.getOutputStream());
        } else if (openStr.startsWith(rxtxProtocol)) {
            RXTXConnection rxtxConnection = RXTXConnection.open(openStr.substring(commProtocol.length()));
            this.setInputStream(rxtxConnection.getInputStream());
            this.setOutputStream(rxtxConnection.getOutputStream());
        } else if (openStr.startsWith(netProtocol)) {
            SocketConnection socketConn = SocketConnection.open(openStr.substring(netProtocol.length()));
            this.setInputStream(socketConn.getInputStream());
            this.setOutputStream(socketConn.getOutputStream());
        } else {
            URL url = new URL(openStr);
            URLConnection urlConn = url.openConnection();
            this.setInputStream(urlConn.getInputStream());
            try {
                this.setOutputStream(urlConn.getOutputStream());
            } catch (UnknownServiceException e) {
            }
        }
    }
