class n6413929 {
	public HogsCustomizer() {
        m_filename = PathFinder.getCustsFile();
        m_currenttaunts = new String[10];
        m_textfields = new JTextField[10];
        m_color = new Color(255, 255, 255);
        boolean PVtsGSSr = (new File(m_filename)).exists();
        m_inverted = false;
        m_chooser = new JColorChooser();
        AbstractColorChooserPanel[] GFANjAHq = m_chooser.getChooserPanels();
        m_chooser.removeChooserPanel(GFANjAHq[0]);
        m_chooser.removeChooserPanel(GFANjAHq[2]);
        m_chooser.setPreviewPanel(new JPanel());
        Reader CB2t9YQd = null;
        if (PVtsGSSr) {
            try {
                CB2t9YQd = new FileReader(m_filename);
            } catch (FileNotFoundException WsuIOykW) {
                WsuIOykW.printStackTrace();
            }
        } else {
            Object[] yUYw79ml = { "Yes", "No, Thanks" };
            int jkeljYsG = JOptionPane.showOptionDialog(this, "You do not have a customization file in your home directory.\n                 " + "Would you like to create one?", "Hogs Customization", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, yUYw79ml, yUYw79ml[1]);
            if (jkeljYsG == 0) {
                try {
                    FileChannel YycyH8LH = new FileInputStream(HogsConstants.CUSTS_TEMPLATE).getChannel();
                    FileChannel IOh2flDC = new FileOutputStream(m_filename).getChannel();
                    IOh2flDC.transferFrom(YycyH8LH, 0, YycyH8LH.size());
                    YycyH8LH.close();
                    IOh2flDC.close();
                } catch (IOException Oo2rjgom) {
                    Oo2rjgom.printStackTrace();
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
            try {
                CB2t9YQd = new FileReader(m_filename);
            } catch (FileNotFoundException LGk5JBvU) {
                LGk5JBvU.printStackTrace();
                System.exit(0);
            }
        }
        try {
            readFromFile(CB2t9YQd);
        } catch (Exception rXFLbnWZ) {
            rXFLbnWZ.printStackTrace();
            System.exit(0);
        }
        Box h81yKKGi = Box.createVerticalBox();
        h81yKKGi.add(buildTauntsPanel());
        h81yKKGi.add(buildMouseStylePanel());
        h81yKKGi.add(Box.createVerticalStrut(10));
        h81yKKGi.add(buildColorPanel());
        h81yKKGi.add(Box.createVerticalStrut(10));
        h81yKKGi.add(buildButtonsPanel());
        h81yKKGi.add(Box.createVerticalStrut(10));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(h81yKKGi);
        this.pack();
        Dimension HNWOoD9U = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(HNWOoD9U.width / 2 - (this.getWidth() / 2), HNWOoD9U.height / 2 - (this.getHeight() / 2));
        this.setTitle("Hogs Customizer");
        this.setVisible(true);
    }

}