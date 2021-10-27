class n10330989 {
	public DialogueSymbole(final JFrame HcM1cY9y, final Element Sdz0aiLE, final String I5T65kez) {
        super(HcM1cY9y, JaxeResourceBundle.getRB().getString("symbole.Insertion"), true);
        this.jframe = HcM1cY9y;
        this.el = Sdz0aiLE;
        final String JyBNQyGZ = Sdz0aiLE.getAttribute(I5T65kez);
        boolean MV2eXKNq = false;
        try {
            final File LzDgfUOm = new File("symboles");
            if (!LzDgfUOm.exists()) {
                JOptionPane.showMessageDialog(HcM1cY9y, JaxeResourceBundle.getRB().getString("erreur.SymbolesNonTrouve"), JaxeResourceBundle.getRB().getString("erreur.Erreur"), JOptionPane.ERROR_MESSAGE);
                return;
            }
            liste = chercherImages(LzDgfUOm);
        } catch (AccessControlException lt8MBVQV) {
            MV2eXKNq = true;
            try {
                final URL dGSxTzbC = DialogueSymbole.class.getClassLoader().getResource("symboles/liste.txt");
                BufferedReader GSEPAxzO = new BufferedReader(new InputStreamReader(dGSxTzbC.openStream()));
                final ArrayList<File> aL36qep9 = new ArrayList<File>();
                String voCObd3J = null;
                while ((voCObd3J = GSEPAxzO.readLine()) != null) {
                    if (!"".equals(voCObd3J.trim())) aL36qep9.add(new File("symboles/" + voCObd3J.trim()));
                }
                liste = aL36qep9.toArray(new File[aL36qep9.size()]);
            } catch (IOException mWuNkHCZ) {
                LOG.error(mWuNkHCZ);
            }
        }
        final JPanel vPbgotzZ = new JPanel(new BorderLayout());
        setContentPane(vPbgotzZ);
        final GridLayout BuMKKtzB = new GridLayout((int) Math.ceil(liste.length / 13.0), 13, 10, 10);
        final JPanel vqbG5sfl = new JPanel(BuMKKtzB);
        vPbgotzZ.add(vqbG5sfl, BorderLayout.CENTER);
        ichoix = 0;
        final MyMouseListener lDJywWlc = new MyMouseListener();
        labels = new JLabel[liste.length];
        for (int u6vZWwY0 = 0; u6vZWwY0 < liste.length; u6vZWwY0++) {
            if (JyBNQyGZ != null && !"".equals(JyBNQyGZ) && JyBNQyGZ.equals(liste[u6vZWwY0].getPath())) ichoix = u6vZWwY0;
            URL eGLMGa0C;
            try {
                if (MV2eXKNq) {
                    final URL KUJKtTxm = DialogueSymbole.class.getClassLoader().getResource("symboles/liste.txt");
                    final String WwGixQpH = KUJKtTxm.toString().substring(0, KUJKtTxm.toString().indexOf("symboles/liste.txt"));
                    eGLMGa0C = new URL(WwGixQpH + liste[u6vZWwY0].getPath());
                } else eGLMGa0C = liste[u6vZWwY0].toURL();
            } catch (MalformedURLException yw3jQX0e) {
                LOG.error(yw3jQX0e);
                break;
            }
            final Icon Y10mRGmU = new ImageIcon(eGLMGa0C);
            final JLabel vB0l5i1t = new JLabel(Y10mRGmU);
            vB0l5i1t.addMouseListener(lDJywWlc);
            labels[u6vZWwY0] = vB0l5i1t;
            vqbG5sfl.add(vB0l5i1t);
        }
        final JPanel PJlmhn7d = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        final JButton XMHp4cI9 = new JButton(JaxeResourceBundle.getRB().getString("bouton.Annuler"));
        XMHp4cI9.addActionListener(this);
        XMHp4cI9.setActionCommand("Annuler");
        PJlmhn7d.add(XMHp4cI9);
        final JButton dVilbW66 = new JButton(JaxeResourceBundle.getRB().getString("bouton.OK"));
        dVilbW66.addActionListener(this);
        dVilbW66.setActionCommand("OK");
        PJlmhn7d.add(dVilbW66);
        vPbgotzZ.add(PJlmhn7d, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(dVilbW66);
        choix(ichoix);
        pack();
        if (HcM1cY9y != null) {
            final Rectangle OCvz1T3i = HcM1cY9y.getBounds();
            setLocation(OCvz1T3i.x + OCvz1T3i.width / 4, OCvz1T3i.y + OCvz1T3i.height / 4);
        } else {
            final Dimension M9fnINwA = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation((M9fnINwA.width - getSize().width) / 3, (M9fnINwA.height - getSize().height) / 3);
        }
    }

}