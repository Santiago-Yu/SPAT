class n1985677 {
	public SRWGuiClient(String VvVH1fSG) {
        super("Simple Swing Browser");
        this.initialURL = VvVH1fSG;
        addWindowListener(new ExitListener());
        WindowUtilities.setNativeLookAndFeel();
        JPanel SUTQfBc1 = new JPanel();
        SUTQfBc1.setBackground(Color.lightGray);
        homeButton = new JIconButton("home.gif");
        homeButton.addActionListener(this);
        JLabel zv2uevjI = new JLabel("URL:");
        urlField = new JTextField(30);
        urlField.setText(VvVH1fSG);
        urlField.addActionListener(this);
        SUTQfBc1.add(homeButton);
        SUTQfBc1.add(zv2uevjI);
        SUTQfBc1.add(urlField);
        getContentPane().add(SUTQfBc1, BorderLayout.NORTH);
        try {
            URL zjvFznbM = new URL(VvVH1fSG);
            BufferedReader ahwf8oLQ = new BufferedReader(new InputStreamReader(zjvFznbM.openStream()));
            boolean jddyLXYQ = true;
            String ceruIJbV;
            StringBuffer BfB39aOU = new StringBuffer(), Q67rfLTW = null;
            Transformer M7LjK9QQ = null;
            ceruIJbV = ahwf8oLQ.readLine();
            if (ceruIJbV == null) {
                System.out.println("No input read from URL: " + VvVH1fSG);
                return;
            }
            if (!ceruIJbV.startsWith("<?xml ")) {
                jddyLXYQ = false;
                BfB39aOU.append(ceruIJbV);
            }
            if (jddyLXYQ) {
                ceruIJbV = ahwf8oLQ.readLine();
                if (ceruIJbV.startsWith("<?xml-stylesheet ")) {
                    int m1IkPPvR = ceruIJbV.indexOf("href=");
                    String REe80uUt = (ceruIJbV.substring(ceruIJbV.indexOf("href=") + 6));
                    REe80uUt = REe80uUt.substring(0, REe80uUt.indexOf('"'));
                    System.out.println("href=" + REe80uUt);
                    zjvFznbM = new URL(zjvFznbM, REe80uUt);
                    String UXE1szNt = zjvFznbM.toString();
                    System.out.println("stylesheet URL=" + zjvFznbM.toString());
                    M7LjK9QQ = (Transformer) transformers.get(UXE1szNt);
                    if (M7LjK9QQ == null) {
                        BufferedReader OCzwZIHS = new BufferedReader(new InputStreamReader(zjvFznbM.openStream()));
                        OCzwZIHS.readLine();
                        Q67rfLTW = new StringBuffer();
                        while ((ceruIJbV = OCzwZIHS.readLine()) != null) Q67rfLTW.append(ceruIJbV).append('\n');
                        System.out.println(Q67rfLTW.toString());
                        TransformerFactory v9X5ZghN = TransformerFactory.newInstance();
                        StreamSource y7cBA1rx = new StreamSource(new StringReader(Q67rfLTW.toString()));
                        M7LjK9QQ = v9X5ZghN.newTransformer(y7cBA1rx);
                        transformers.put(UXE1szNt, M7LjK9QQ);
                    }
                }
            }
            while ((ceruIJbV = ahwf8oLQ.readLine()) != null) BfB39aOU.append(ceruIJbV).append('\n');
            htmlPane = new JEditorPane();
            if (M7LjK9QQ != null) {
                StringReader CvGwZ0Vi = new StringReader(BfB39aOU.toString());
                StringWriter ugKFIfS2 = new StringWriter();
                StreamSource hq63e44z = new StreamSource(CvGwZ0Vi);
                M7LjK9QQ.transform(hq63e44z, new StreamResult(ugKFIfS2));
                String xcE6YD6n = ugKFIfS2.toString();
                int NsXX6Plj = xcE6YD6n.indexOf('>');
                xcE6YD6n = "<html>" + xcE6YD6n.substring(xcE6YD6n.indexOf('>') + 1);
                System.out.println(xcE6YD6n);
                htmlPane.setContentType("text/html");
                htmlPane.setText("<html><head><META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>GSAFD Thesaurus</title></head><body><center><h2>GSAFD Thesaurus</h2></center><p>A thesaurus of genre terms to support the \"Guidelines on Subject Access to Individual Works of Fiction , Drama\" (GSAFD)</p><table cellspacing=\"5\" width=\"100%\"><tr><td><h3>Search</h3><p></p></td><td valign=\"top\"><h3>Browse</h3></td></tr></table></body></html>");
            } else htmlPane.setText(BfB39aOU.toString());
            htmlPane.setEditable(false);
            htmlPane.addHyperlinkListener(this);
            JScrollPane BWnUdzL9 = new JScrollPane(htmlPane);
            getContentPane().add(BWnUdzL9, BorderLayout.CENTER);
        } catch (IOException HRnXwDsj) {
            warnUser("Can't build HTML pane for " + VvVH1fSG + ": " + HRnXwDsj);
        } catch (TransformerException RLS8O5Zn) {
        }
        Dimension Up6biwr9 = getToolkit().getScreenSize();
        int SWACYedP = Up6biwr9.width * 8 / 10;
        int gmJD6cHS = Up6biwr9.height * 8 / 10;
        setBounds(SWACYedP / 8, gmJD6cHS / 8, SWACYedP, gmJD6cHS);
        setVisible(true);
    }

}