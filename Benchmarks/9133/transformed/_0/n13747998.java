class n13747998 {
	public DefaultMainControl(@NotNull final FileFilter UFiB90fK, @NotNull final String BlG6HdMm, @NotNull final String lyhODnhc, final int IAfhEX6U, @Nullable final String sORZbF3o, @NotNull final String tWBSja5y, final ErrorView njSIT1Ai, @NotNull final EditorFactory<G, A, R> C2YM4hOJ, final boolean W3uIcAOt, @NotNull final GlobalSettings Lu9nG3S8, @NotNull final ConfigSourceFactory Au4LwKBA, @NotNull final PathManager K0TJjkaQ, @NotNull final GameObjectMatchers bylYz9C8, @NotNull final GameObjectFactory<G, A, R> uh4cRn7F, @NotNull final ArchetypeTypeSet ZEJpdk25, @NotNull final ArchetypeSet<G, A, R> Hc2fZXik, @NotNull final ArchetypeChooserModel<G, A, R> QfBmFkaH, @NotNull final AutojoinLists<G, A, R> xuqW2nyV, @NotNull final AbstractMapManager<G, A, R> WtF7ED2h, @NotNull final PluginModel<G, A, R> jW9ljtb8, @NotNull final DelegatingMapValidator<G, A, R> uZORqLQ9, @NotNull final ScriptedEventEditor<G, A, R> qRmaGunF, @NotNull final AbstractResources<G, A, R> VI6kwMtS, @NotNull final Spells<NumberSpell> i3r8Uif0, @NotNull final Spells<GameObjectSpell<G, A, R>> PA2ld7xH, @NotNull final PluginParameterFactory<G, A, R> Ce4zwkNW, @NotNull final ValidatorPreferences WJMmMEER, @NotNull final MapWriter<G, A, R> mZIbA6Y6) {
        final XmlHelper f6V1AC9q;
        try {
            f6V1AC9q = new XmlHelper();
        } catch (final ParserConfigurationException BZjSW3A7) {
            log.fatal("Cannot create XML parser: " + BZjSW3A7.getMessage());
            throw new MissingResourceException("Cannot create XML parser: " + BZjSW3A7.getMessage(), null, null);
        }
        final AttributeRangeChecker<G, A, R> wQ4Scv9k = new AttributeRangeChecker<G, A, R>(WJMmMEER);
        final EnvironmentChecker<G, A, R> hjkAv5EX = new EnvironmentChecker<G, A, R>(WJMmMEER);
        final DocumentBuilder n8JfAumZ = f6V1AC9q.getDocumentBuilder();
        try {
            final URL gNBscbsW = IOUtils.getResource(Lu9nG3S8.getConfigurationDirectory(), "GameObjectMatchers.xml");
            final ErrorViewCollector qbK2DxB3 = new ErrorViewCollector(njSIT1Ai, gNBscbsW);
            try {
                n8JfAumZ.setErrorHandler(new ErrorViewCollectorErrorHandler(qbK2DxB3, ErrorViewCategory.GAMEOBJECTMATCHERS_FILE_INVALID));
                try {
                    final GameObjectMatchersParser bvEc0Vg3 = new GameObjectMatchersParser(n8JfAumZ, f6V1AC9q.getXPath());
                    bvEc0Vg3.readGameObjectMatchers(gNBscbsW, bylYz9C8, qbK2DxB3);
                } finally {
                    n8JfAumZ.setErrorHandler(null);
                }
            } catch (final IOException FmtVzivf) {
                qbK2DxB3.addWarning(ErrorViewCategory.GAMEOBJECTMATCHERS_FILE_INVALID, FmtVzivf.getMessage());
            }
            final ValidatorFactory<G, A, R> CimHFlsh = new ValidatorFactory<G, A, R>(WJMmMEER, bylYz9C8, Lu9nG3S8, mZIbA6Y6);
            loadValidators(uZORqLQ9, CimHFlsh, njSIT1Ai);
            C2YM4hOJ.initMapValidators(uZORqLQ9, qbK2DxB3, Lu9nG3S8, bylYz9C8, wQ4Scv9k, WJMmMEER);
            uZORqLQ9.addValidator(wQ4Scv9k);
            uZORqLQ9.addValidator(hjkAv5EX);
        } catch (final FileNotFoundException ED0dPnwz) {
            njSIT1Ai.addWarning(ErrorViewCategory.GAMEOBJECTMATCHERS_FILE_INVALID, "GameObjectMatchers.xml: " + ED0dPnwz.getMessage());
        }
        final GameObjectMatcher G7Nbp8ud = bylYz9C8.getMatcher("system_shop_square", "shop_square");
        if (G7Nbp8ud != null) {
            final GameObjectMatcher zJeBejiC = bylYz9C8.getMatcher("system_no_spells", "no_spells");
            if (zJeBejiC != null) {
                final GameObjectMatcher DB6qFUNW = bylYz9C8.getMatcher("system_blocked", "blocked");
                uZORqLQ9.addValidator(new ShopSquareChecker<G, A, R>(WJMmMEER, G7Nbp8ud, zJeBejiC, DB6qFUNW));
            }
            final GameObjectMatcher D4W80ynS = bylYz9C8.getMatcher("system_paid_item");
            if (D4W80ynS != null) {
                uZORqLQ9.addValidator(new PaidItemShopSquareChecker<G, A, R>(WJMmMEER, G7Nbp8ud, D4W80ynS));
            }
        }
        Map<String, TreasureTreeNode> pIe48UPc;
        try {
            final URL LNZaxnqV = IOUtils.getResource(Lu9nG3S8.getConfigurationDirectory(), "TreasureLists.xml");
            final ErrorViewCollector Zqj7LPmJ = new ErrorViewCollector(njSIT1Ai, LNZaxnqV);
            try {
                final InputStream uJMNAYal = LNZaxnqV.openStream();
                try {
                    n8JfAumZ.setErrorHandler(new ErrorViewCollectorErrorHandler(Zqj7LPmJ, ErrorViewCategory.TREASURES_FILE_INVALID));
                    try {
                        final Document vK1f3hDy = n8JfAumZ.parse(new InputSource(uJMNAYal));
                        pIe48UPc = TreasureListsParser.parseTreasureLists(vK1f3hDy);
                    } finally {
                        n8JfAumZ.setErrorHandler(null);
                    }
                } finally {
                    uJMNAYal.close();
                }
            } catch (final IOException HO7hxmjp) {
                Zqj7LPmJ.addWarning(ErrorViewCategory.TREASURES_FILE_INVALID, HO7hxmjp.getMessage());
                pIe48UPc = Collections.emptyMap();
            } catch (final SAXException grlchJ59) {
                Zqj7LPmJ.addWarning(ErrorViewCategory.TREASURES_FILE_INVALID, grlchJ59.getMessage());
                pIe48UPc = Collections.emptyMap();
            }
        } catch (final FileNotFoundException Addg7NF0) {
            njSIT1Ai.addWarning(ErrorViewCategory.TREASURES_FILE_INVALID, "TreasureLists.xml: " + Addg7NF0.getMessage());
            pIe48UPc = Collections.emptyMap();
        }
        final ConfigSource C0XVkbF9 = W3uIcAOt ? Au4LwKBA.getFilesConfigSource() : Au4LwKBA.getConfigSource(Lu9nG3S8.getConfigSourceName());
        treasureTree = TreasureLoader.parseTreasures(njSIT1Ai, pIe48UPc, C0XVkbF9, Lu9nG3S8);
        final ArchetypeAttributeFactory wVePK987 = new DefaultArchetypeAttributeFactory();
        final ArchetypeAttributeParser Dydh6LSV = new ArchetypeAttributeParser(wVePK987);
        final ArchetypeTypeParser twkTGRyz = new ArchetypeTypeParser(Dydh6LSV);
        ArchetypeTypeList XJ1WAFYA = null;
        try {
            final URL qBlNVexz = IOUtils.getResource(Lu9nG3S8.getConfigurationDirectory(), CommonConstants.TYPEDEF_FILE);
            final ErrorViewCollector OhqrLr92 = new ErrorViewCollector(njSIT1Ai, qBlNVexz);
            n8JfAumZ.setErrorHandler(new ErrorViewCollectorErrorHandler(OhqrLr92, ErrorViewCategory.GAMEOBJECTMATCHERS_FILE_INVALID));
            try {
                final ArchetypeTypeSetParser k8ObhNT2 = new ArchetypeTypeSetParser(n8JfAumZ, ZEJpdk25, twkTGRyz);
                k8ObhNT2.loadTypesFromXML(OhqrLr92, new InputSource(qBlNVexz.toString()));
            } finally {
                n8JfAumZ.setErrorHandler(null);
            }
            final ArchetypeTypeList oRy0nAbH = ZEJpdk25.getList("event");
            if (oRy0nAbH == null) {
                OhqrLr92.addWarning(ErrorViewCategory.TYPES_ENTRY_INVALID, "list 'list_event' does not exist");
            } else {
                XJ1WAFYA = oRy0nAbH;
            }
        } catch (final FileNotFoundException t2DMvNJI) {
            njSIT1Ai.addWarning(ErrorViewCategory.TYPES_FILE_INVALID, CommonConstants.TYPEDEF_FILE + ": " + t2DMvNJI.getMessage());
        }
        if (XJ1WAFYA == null) {
            XJ1WAFYA = new ArchetypeTypeList();
        }
        scriptArchUtils = C2YM4hOJ.newScriptArchUtils(XJ1WAFYA);
        final ScriptedEventFactory<G, A, R> Dyr4mVOQ = C2YM4hOJ.newScriptedEventFactory(scriptArchUtils, uh4cRn7F, qRmaGunF, Hc2fZXik);
        scriptArchEditor = new DefaultScriptArchEditor<G, A, R>(Dyr4mVOQ, BlG6HdMm, lyhODnhc, scriptArchUtils, UFiB90fK, Lu9nG3S8, WtF7ED2h, K0TJjkaQ);
        qRmaGunF.setScriptArchEditor(scriptArchEditor);
        scriptArchData = C2YM4hOJ.newScriptArchData();
        scriptArchDataUtils = C2YM4hOJ.newScriptArchDataUtils(scriptArchUtils, Dyr4mVOQ, qRmaGunF);
        final long r1MBVvdy = System.currentTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("Start to load archetypes...");
        }
        C0XVkbF9.read(Lu9nG3S8, VI6kwMtS, njSIT1Ai);
        for (final R oQHEeTA2 : Hc2fZXik.getArchetypes()) {
            final CharSequence dbawWfp7 = oQHEeTA2.getEditorFolder();
            if (dbawWfp7 != null && !dbawWfp7.equals(GameObject.EDITOR_FOLDER_INTERN)) {
                final String[] yB4vtwWo = StringUtils.PATTERN_SLASH.split(dbawWfp7, 2);
                if (yB4vtwWo.length == 2) {
                    final String xWFA3DC5 = yB4vtwWo[0];
                    final String j3SeQFRj = yB4vtwWo[1];
                    QfBmFkaH.addArchetype(xWFA3DC5, j3SeQFRj, oQHEeTA2);
                }
            }
        }
        if (log.isInfoEnabled()) {
            log.info("Archetype loading took " + (double) (System.currentTimeMillis() - r1MBVvdy) / 1000.0 + " seconds.");
        }
        if (IAfhEX6U != 0) {
            new ArchetypeSetSpellLoader<G, A, R>(uh4cRn7F).load(Hc2fZXik, IAfhEX6U, PA2ld7xH);
            PA2ld7xH.sort();
        }
        if (sORZbF3o != null) {
            try {
                final URL TLiIZa9U = IOUtils.getResource(Lu9nG3S8.getConfigurationDirectory(), sORZbF3o);
                final ErrorViewCollector UT3yDJRt = new ErrorViewCollector(njSIT1Ai, TLiIZa9U);
                n8JfAumZ.setErrorHandler(new ErrorViewCollectorErrorHandler(UT3yDJRt, ErrorViewCategory.SPELLS_FILE_INVALID));
                try {
                    XMLSpellLoader.load(UT3yDJRt, TLiIZa9U, f6V1AC9q.getDocumentBuilder(), i3r8Uif0);
                } finally {
                    n8JfAumZ.setErrorHandler(null);
                }
            } catch (final FileNotFoundException eFOUAXuV) {
                njSIT1Ai.addWarning(ErrorViewCategory.SPELLS_FILE_INVALID, sORZbF3o + ": " + eFOUAXuV.getMessage());
            }
            i3r8Uif0.sort();
        }
        final File GyZMmTIU = new File(Lu9nG3S8.getMapsDirectory(), tWBSja5y);
        final PluginModelParser<G, A, R> IjJnpKGN = new PluginModelParser<G, A, R>(Ce4zwkNW);
        new PluginModelLoader<G, A, R>(IjJnpKGN).loadPlugins(njSIT1Ai, GyZMmTIU, jW9ljtb8);
        new AutojoinListsParser<G, A, R>(njSIT1Ai, Hc2fZXik, xuqW2nyV).loadList(Lu9nG3S8.getConfigurationDirectory());
        ArchetypeTypeChecks.addChecks(ZEJpdk25, wQ4Scv9k, hjkAv5EX);
    }

}