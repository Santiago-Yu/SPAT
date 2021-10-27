class n14390569 {
	private DialogHelper(String Os4JtWEz, final URL raIYFH9P) {
        jd = new JDialog();
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jd.setAlwaysOnTop(true);
        jd.setLayout(new BoxLayout(jd.getContentPane(), BoxLayout.Y_AXIS));
        jd.setTitle(Os4JtWEz);
        JLabel jtjfUy94 = new JLabel();
        ImageIcon nhkbLQ94 = new ImageIcon(raIYFH9P);
        jtjfUy94.setIcon(nhkbLQ94);
        jd.add(new JScrollPane(jtjfUy94));
        final JFileChooser nEdxrh9c = getSaveImageChooser();
        JPanel aEAXxQrq = new JPanel();
        JButton Z8wDZfKV = new JButton(getMessage("btn_save_as"));
        Z8wDZfKV.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent kMGcgbY0) {
                int oL2pvRhK = nEdxrh9c.showSaveDialog(jd);
                if (oL2pvRhK == JFileChooser.APPROVE_OPTION) {
                    File MbQYDnwA = nEdxrh9c.getSelectedFile();
                    String vftdacPI = MbQYDnwA.getPath();
                    String KFUUvzNU = StringUtil.getLowerExtension(vftdacPI);
                    if (!"png".equals(KFUUvzNU)) {
                        vftdacPI += ".png";
                        MbQYDnwA = new File(vftdacPI);
                    }
                    boolean SiXwpqj5 = true;
                    if (MbQYDnwA.exists()) {
                        int I5A6d6pt = JOptionPane.showConfirmDialog(jd, getMessage("warn_file_exist"));
                        if (I5A6d6pt != JOptionPane.YES_OPTION) SiXwpqj5 = false;
                    } else if (!MbQYDnwA.getParentFile().exists()) {
                        SiXwpqj5 = MbQYDnwA.getParentFile().mkdirs();
                    }
                    if (SiXwpqj5) {
                        FileChannel buRSgLfW = null;
                        FileChannel ndMGtAak = null;
                        try {
                            buRSgLfW = new FileInputStream(raIYFH9P.getPath()).getChannel();
                            ndMGtAak = new FileOutputStream(vftdacPI).getChannel();
                            buRSgLfW.transferTo(0, buRSgLfW.size(), ndMGtAak);
                        } catch (FileNotFoundException GenXCXXr) {
                            warn(jd, getMessage("err_no_source_file"));
                        } catch (IOException MvwbyAE9) {
                            warn(jd, getMessage("err_output_target"));
                        } finally {
                            try {
                                if (buRSgLfW != null) buRSgLfW.close();
                            } catch (IOException tavz7YS5) {
                            }
                            try {
                                if (ndMGtAak != null) ndMGtAak.close();
                            } catch (IOException LgJJ3tXk) {
                            }
                            buRSgLfW = null;
                            ndMGtAak = null;
                        }
                    }
                }
            }
        });
        aEAXxQrq.add(Z8wDZfKV);
        Z8wDZfKV = new JButton(getMessage("btn_close"));
        Z8wDZfKV.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent od5IlBw0) {
                jd.dispose();
            }
        });
        aEAXxQrq.add(Z8wDZfKV);
        jd.add(aEAXxQrq);
        jd.pack();
        setCentral(jd);
    }

}