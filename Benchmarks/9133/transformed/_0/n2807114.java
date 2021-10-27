class n2807114 {
	public Controller(String MMNqasxP, String v4ef8LQ0, boolean jvFkStRp) throws InternalException {
        m_received_messages = new ConcurrentLinkedQueue<ReceivedMessage>();
        m_fragmsgs = new ArrayList<String>();
        m_customizedtaunts = new HashMap<Integer, String>();
        m_nethandler = new CachingNetHandler();
        m_drawingpanel = GLDrawableFactory.getFactory().createGLCanvas(new GLCapabilities());
        m_user = System.getProperty("user.name");
        m_chatbuffer = new StringBuffer();
        this.m_shouldexit = jvFkStRp;
        isChatPaused = false;
        isRunning = true;
        m_lastbullet = 0;
        try {
            BufferedReader l2h2CJ3T = new BufferedReader(new FileReader(HogsConstants.FRAGMSGS_FILE));
            String tmA7TY9m;
            while ((tmA7TY9m = l2h2CJ3T.readLine()) != null) {
                m_fragmsgs.add(tmA7TY9m);
            }
            l2h2CJ3T.close();
        } catch (IOException wssd1iaU) {
            wssd1iaU.printStackTrace();
        }
        String WyWekmkx = PathFinder.getCustsFile();
        boolean SKwkaWqt = (new File(WyWekmkx)).exists();
        Reader bqQX7lBK = null;
        if (SKwkaWqt) {
            try {
                bqQX7lBK = new FileReader(WyWekmkx);
            } catch (FileNotFoundException O9NcqpZA) {
                O9NcqpZA.printStackTrace();
            }
        } else {
            Object[] lrIvAX3b = { "Yes, create a .hogsrc file", "No, use default taunts" };
            int seFZuyPm = JOptionPane.showOptionDialog(m_window, "You do not have customized taunts in your home\n " + "directory.  Would you like to create a customizable file?", "Hogs Customization", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, lrIvAX3b, lrIvAX3b[1]);
            if (seFZuyPm == 0) {
                try {
                    FileChannel GkfkPyev = new FileInputStream(HogsConstants.CUSTS_TEMPLATE).getChannel();
                    FileChannel vlGMPU5h;
                    vlGMPU5h = new FileOutputStream(WyWekmkx).getChannel();
                    vlGMPU5h.transferFrom(GkfkPyev, 0, GkfkPyev.size());
                    GkfkPyev.close();
                    vlGMPU5h.close();
                    bqQX7lBK = new FileReader(WyWekmkx);
                } catch (FileNotFoundException pPn0vHe0) {
                    pPn0vHe0.printStackTrace();
                } catch (IOException Ue4cPzZm) {
                    Ue4cPzZm.printStackTrace();
                }
            } else {
                try {
                    bqQX7lBK = new FileReader(HogsConstants.CUSTS_TEMPLATE);
                } catch (FileNotFoundException QWTFDCeN) {
                    QWTFDCeN.printStackTrace();
                }
            }
        }
        try {
            m_netengine = NetEngine.forHost(m_user, MMNqasxP, 1820, m_nethandler);
            m_netengine.start();
        } catch (UnknownHostException wjA7MTQm) {
            wjA7MTQm.printStackTrace();
        } catch (NetException KsRxFw7q) {
            KsRxFw7q.printStackTrace();
        }
        m_gamestate = m_netengine.getCurrentState();
        m_gamestate.setInChatMode(false);
        m_gamestate.setController(this);
        try {
            readFromFile(bqQX7lBK);
        } catch (NumberFormatException RD10jsy4) {
            RD10jsy4.printStackTrace();
        } catch (IOException S8mijsBY) {
            S8mijsBY.printStackTrace();
        } catch (InternalException HsXZkX5k) {
            HsXZkX5k.printStackTrace();
        }
        GraphicsEnvironment o7x04RK1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice RSMSsRMm = o7x04RK1.getDefaultScreenDevice();
        m_window = new GuiFrame(m_drawingpanel, m_gamestate);
        m_graphics = null;
        try {
            m_graphics = new GraphicsEngine(m_drawingpanel, m_gamestate);
        } catch (InternalException BDV9N9rI) {
            BDV9N9rI.printStackTrace();
            System.exit(0);
        }
        m_drawingpanel.addGLEventListener(m_graphics);
        m_physics = new Physics();
        if (v4ef8LQ0 == null) {
            v4ef8LQ0 = HogsConstants.TEAM_NONE;
        }
        if (!(v4ef8LQ0.toLowerCase().equals(HogsConstants.TEAM_NONE) || v4ef8LQ0.toLowerCase().equals(HogsConstants.TEAM_RED) || v4ef8LQ0.toLowerCase().equals(HogsConstants.TEAM_BLUE))) {
            throw new InternalException("Invalid team name!");
        }
        String UXmqkLvo = v4ef8LQ0;
        Craft YOYFpiwV = m_gamestate.getLocalCraft();
        if (m_gamestate.getNumCrafts() == 0) {
            YOYFpiwV.setTeamname(v4ef8LQ0);
        } else if (m_gamestate.isInTeamMode()) {
            if (v4ef8LQ0 == HogsConstants.TEAM_NONE) {
                int VCnNDKBq = m_gamestate.getNumOnTeam(HogsConstants.TEAM_RED);
                int xdUiG3Pr = m_gamestate.getNumOnTeam(HogsConstants.TEAM_BLUE);
                String zanyA7Rb;
                if (VCnNDKBq > xdUiG3Pr) {
                    zanyA7Rb = HogsConstants.TEAM_BLUE;
                } else if (VCnNDKBq < xdUiG3Pr) {
                    zanyA7Rb = HogsConstants.TEAM_RED;
                } else {
                    zanyA7Rb = Math.random() > 0.5 ? HogsConstants.TEAM_BLUE : HogsConstants.TEAM_RED;
                }
                m_gamestate.getLocalCraft().setTeamname(zanyA7Rb);
            } else {
                YOYFpiwV.setTeamname(v4ef8LQ0);
            }
        } else {
            YOYFpiwV.setTeamname(HogsConstants.TEAM_NONE);
            if (UXmqkLvo != null) {
                m_window.displayText("You cannot join a team, this is an individual game.");
            }
        }
        if (!YOYFpiwV.getTeamname().equals(HogsConstants.TEAM_NONE)) {
            m_window.displayText("You are joining the " + YOYFpiwV.getTeamname() + " team.");
        }
        m_drawingpanel.setSize(m_drawingpanel.getWidth(), m_drawingpanel.getHeight());
        m_middlepos = new java.awt.Point(m_drawingpanel.getWidth() / 2, m_drawingpanel.getHeight() / 2);
        m_curpos = new java.awt.Point(m_drawingpanel.getWidth() / 2, m_drawingpanel.getHeight() / 2);
        GuiKeyListener YA3G66Eu = new GuiKeyListener();
        GuiMouseListener qxfEKslY = new GuiMouseListener();
        m_window.addKeyListener(YA3G66Eu);
        m_drawingpanel.addKeyListener(YA3G66Eu);
        m_window.addMouseListener(qxfEKslY);
        m_drawingpanel.addMouseListener(qxfEKslY);
        m_window.addMouseMotionListener(qxfEKslY);
        m_drawingpanel.addMouseMotionListener(qxfEKslY);
        m_drawingpanel.addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent fqmRi24l) {
                m_window.setMouseTrapped(false);
                m_window.returnMouseToCenter();
            }
        });
        m_window.addFocusListener(new FocusAdapter() {

            public void focusLost(FocusEvent ufGmOXe2) {
                m_window.setMouseTrapped(false);
                m_window.returnMouseToCenter();
            }
        });
        m_window.requestFocus();
    }

}