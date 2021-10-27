    public void handleHandshake(Packet2Handshake par1Packet2Handshake) {
        boolean flag = true;
        String s = par1Packet2Handshake.username;
        if (s == null || s.trim().length() == 0) {
            flag = false;
        } else if (!s.equals("-")) {
            try {
                Long.parseLong(s, 16);
            } catch (NumberFormatException numberformatexception) {
                flag = false;
            }
        }
        if (!flag) {
            netManager.networkShutdown("disconnect.genericReason", new Object[] { "The server responded with an invalid server key" });
        } else if (par1Packet2Handshake.username.equals("-")) {
            addToSendQueue(new Packet1Login(mc.session.username, 29));
        } else {
            try {
                URL url = new URL((new StringBuilder()).append("http://session.minecraft.net/game/joinserver.jsp?user=").append(mc.session.username).append("&sessionId=").append(mc.session.sessionId).append("&serverId=").append(par1Packet2Handshake.username).toString());
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
                String s1 = bufferedreader.readLine();
                bufferedreader.close();
                if (s1.equalsIgnoreCase("ok")) {
                    addToSendQueue(new Packet1Login(mc.session.username, 29));
                } else {
                    netManager.networkShutdown("disconnect.loginFailedInfo", new Object[] { s1 });
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                netManager.networkShutdown("disconnect.genericReason", new Object[] { (new StringBuilder()).append("Internal client error: ").append(exception.toString()).toString() });
            }
        }
    }
