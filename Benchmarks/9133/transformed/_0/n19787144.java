class n19787144 {
	public JTips(String oO35tU1U) {
        super(new BorderLayout());
        BufferedReader lsw88Pu0 = null;
        try {
            URL EHtvA6Rw = getClass().getResource(oO35tU1U);
            if (EHtvA6Rw != null) {
                lsw88Pu0 = new BufferedReader(new InputStreamReader(EHtvA6Rw.openStream()));
                String tl0HQ8Xz = null;
                StringBuffer xA4y69Hy = new StringBuffer();
                while (null != (tl0HQ8Xz = lsw88Pu0.readLine())) {
                    if (sep.equals(tl0HQ8Xz)) {
                        addTip(xA4y69Hy.toString());
                        xA4y69Hy = new StringBuffer();
                    } else {
                        xA4y69Hy.append(tl0HQ8Xz);
                        xA4y69Hy.append("\n");
                    }
                }
                if (xA4y69Hy != null && xA4y69Hy.length() > 1) {
                    addTip(xA4y69Hy.toString());
                }
            } else {
                Activator.log.warn("No tip file: " + oO35tU1U);
            }
        } catch (Exception YmaVTA86) {
            Activator.log.error("Failed to load tips from " + oO35tU1U, YmaVTA86);
        } finally {
            try {
                lsw88Pu0.close();
            } catch (Exception N6xcobEK) {
            }
        }
        if (tips.size() == 0) {
            tips.add(new Tip("", "No tips found", ""));
        } else {
            Activator.log.info("loaded " + tips.size() + " tips");
        }
        html = new JTextPane();
        html.setContentType("text/html");
        html.setEditable(false);
        html.addHyperlinkListener(new HyperlinkListener() {

            public void hyperlinkUpdate(HyperlinkEvent gaYXDdOy) {
                if (gaYXDdOy.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    URL Qe8Qo3IH = gaYXDdOy.getURL();
                    try {
                        Util.openExternalURL(Qe8Qo3IH);
                    } catch (Exception dClJlkMp) {
                        Activator.log.warn("Failed to open external url=" + Qe8Qo3IH, dClJlkMp);
                    }
                }
            }
        });
        scroll = new JScrollPane(html);
        scroll.setPreferredSize(new Dimension(350, 200));
        scroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLoweredBevelBorder()));
        final ActionListener iAa9xP0T = new ActionListener() {

            public void actionPerformed(ActionEvent HxniWW5J) {
                setTip((tipIx + 1) % tips.size());
            }
        };
        JButton dexwByBV = new JButton(Strings.get("close"));
        dexwByBV.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent J2si2MCB) {
                if (frame != null) {
                    frame.setVisible(false);
                }
            }
        });
        nextButton = new JButton(Strings.get("next_tip"));
        nextButton.addActionListener(iAa9xP0T);
        prevButton = new JButton(Strings.get("prev_tip"));
        prevButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent oSZuqSxP) {
                setTip((tipIx + tips.size() - 1) % tips.size());
            }
        });
        JPanel YxiLf0y0 = new JPanel(new BorderLayout());
        JPanel zWDt8ieM = new JPanel(new BorderLayout());
        ctrlPanel = new JPanel(new FlowLayout());
        ctrlPanel.add(dexwByBV);
        ctrlPanel.add(prevButton);
        ctrlPanel.add(nextButton);
        YxiLf0y0.add(ctrlPanel, BorderLayout.EAST);
        JLabel epqx7Hp8 = new JLabel("Did you know that...");
        epqx7Hp8.setFont(new Font("Dialog", Font.BOLD, 15));
        epqx7Hp8.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        zWDt8ieM.add(epqx7Hp8, BorderLayout.WEST);
        JLabel wZvGhJQU = new JLabel(Activator.desktop.tipIcon);
        wZvGhJQU.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent d0v44zRx) {
                iAa9xP0T.actionPerformed(null);
            }
        });
        wZvGhJQU.setToolTipText(nextButton.getText());
        add(wZvGhJQU, BorderLayout.WEST);
        add(scroll, BorderLayout.CENTER);
        add(YxiLf0y0, BorderLayout.SOUTH);
        add(zWDt8ieM, BorderLayout.NORTH);
        setTip((int) (Math.random() * tips.size()));
    }

}