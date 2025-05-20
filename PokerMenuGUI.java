/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectopoquer.gui;

import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author cgmel
 */
public class PokerMenuGUI extends javax.swing.JFrame {
    
    private String juegoSeleccionado = null;

    public PokerMenuGUI() {
        inicializarComponentes();
        
        getContentPane().setLayout(new CardLayout());
        getContentPane().add(menuPrincipalPanel, "menu");
        getContentPane().add(reglas, "reglas");
        
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void inicializarComponentes() {
        java.awt.GridBagConstraints gridBagConstraints;

        menuPrincipalPanel = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        textoSeleccion = new javax.swing.JLabel();
        fiveCardSeleccion = new javax.swing.JPanel();
        fiveCardsImagen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        texasHoldemSeleccion = new javax.swing.JPanel();
        texasHoldemImagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReglas = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnInformacion = new javax.swing.JButton();
        reglas = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoReglas = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoReglas1 = new javax.swing.JTextArea();
        titulo2 = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        btnVolverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PÓQUER - Proyecto Final POO");
        setBackground(new java.awt.Color(10, 59, 36));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logoPoquer.png")));
        setName("panelPrincipal");
        setResizable(false);
        setSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new java.awt.CardLayout());

        menuPrincipalPanel.setBackground(new java.awt.Color(10, 95, 56));
        menuPrincipalPanel.setForeground(new java.awt.Color(255, 255, 255));
        menuPrincipalPanel.setMinimumSize(new java.awt.Dimension(600, 500));
        menuPrincipalPanel.setName("menuPrincipalPanel");
        menuPrincipalPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        menuPrincipalPanel.setLayout(new java.awt.GridBagLayout());

        titulo.setBackground(new java.awt.Color(6, 62, 35));
        titulo.setFont(new java.awt.Font("Arial Black", 1, 36));
        titulo.setForeground(new java.awt.Color(212, 175, 55));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("PÓQUER");
        titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo.setName("titulo");
        titulo.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 423;
        gridBagConstraints.ipady = -2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        menuPrincipalPanel.add(titulo, gridBagConstraints);
        titulo.getAccessibleContext().setAccessibleName("");

        textoSeleccion.setFont(new java.awt.Font("Arial", 1, 20));
        textoSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        textoSeleccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoSeleccion.setText("Selecciona un juego");
        textoSeleccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 410;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 0);
        menuPrincipalPanel.add(textoSeleccion, gridBagConstraints);

        fiveCardSeleccion.setBackground(new java.awt.Color(6, 62, 35));
        fiveCardSeleccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(212, 175, 55), 2, true));
        fiveCardSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        fiveCardSeleccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fiveCardSeleccion.setLayout(new java.awt.BorderLayout());

        fiveCardsImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5card.png")));
        fiveCardsImagen.setName("fiveCardsImagen");
        fiveCardsImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveCardsImagenMouseClicked(evt);
            }
        });
        fiveCardSeleccion.add(fiveCardsImagen, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(126, 24, 24));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 255, 225));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("5 Card Draw");
        jLabel1.setOpaque(true);
        fiveCardSeleccion.add(jLabel1, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -4;
        gridBagConstraints.ipady = -21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 30, 0, 0);
        menuPrincipalPanel.add(fiveCardSeleccion, gridBagConstraints);

        texasHoldemSeleccion.setBackground(new java.awt.Color(6, 62, 35));
        texasHoldemSeleccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(212, 175, 55), 2, true));
        texasHoldemSeleccion.setForeground(new java.awt.Color(255, 255, 255));
        texasHoldemSeleccion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        texasHoldemSeleccion.setLayout(new java.awt.BorderLayout());

        texasHoldemImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texasHoldem.png")));
        texasHoldemImagen.setName("texasHoldemImagen");
        texasHoldemImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                texasHoldemImagenMouseClicked(evt);
            }
        });
        texasHoldemSeleccion.add(texasHoldemImagen, java.awt.BorderLayout.CENTER);

        jLabel2.setBackground(new java.awt.Color(126, 24, 24));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 225));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Texas Hold'em ");
        jLabel2.setOpaque(true);
        texasHoldemSeleccion.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = -4;
        gridBagConstraints.ipady = -21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 40, 0, 0);
        menuPrincipalPanel.add(texasHoldemSeleccion, gridBagConstraints);

        btnReglas.setBackground(new java.awt.Color(5, 40, 24));
        btnReglas.setFont(new java.awt.Font("Arial", 1, 14));
        btnReglas.setForeground(new java.awt.Color(255, 255, 255));
        btnReglas.setText("REGLAS");
        btnReglas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReglas.setBorderPainted(false);
        btnReglas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReglas.setFocusPainted(false);
        btnReglas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReglas.setName("btnReglas");
        btnReglas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReglasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 70, 26, 0);
        menuPrincipalPanel.add(btnReglas, gridBagConstraints);

        btnJugar.setBackground(new java.awt.Color(126, 24, 24));
        btnJugar.setFont(new java.awt.Font("Arial", 1, 14));
        btnJugar.setForeground(new java.awt.Color(255, 255, 255));
        btnJugar.setText("INICIAR JUEGO");
        btnJugar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnJugar.setBorderPainted(false);
        btnJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugar.setFocusPainted(false);
        btnJugar.setName("btnIniciar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 50, 26, 0);
        menuPrincipalPanel.add(btnJugar, gridBagConstraints);

        btnInformacion.setBackground(new java.awt.Color(5, 40, 24));
        btnInformacion.setFont(new java.awt.Font("Arial", 1, 14));
        btnInformacion.setForeground(new java.awt.Color(255, 255, 255));
        btnInformacion.setText("ACERCA DE");
        btnInformacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnInformacion.setBorderPainted(false);
        btnInformacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInformacion.setFocusPainted(false);
        btnInformacion.setName("btnInformacion");
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 50, 26, 0);
        menuPrincipalPanel.add(btnInformacion, gridBagConstraints);
        btnInformacion.getAccessibleContext().setAccessibleName("");

        getContentPane().add(menuPrincipalPanel, "card2");

        reglas.setBackground(new java.awt.Color(10, 95, 56));
        reglas.setForeground(new java.awt.Color(255, 255, 255));
        reglas.setPreferredSize(new java.awt.Dimension(600, 500));
        reglas.setLayout(null);

        titulo1.setBackground(new java.awt.Color(6, 62, 35));
        titulo1.setFont(new java.awt.Font("Arial Black", 1, 20));
        titulo1.setForeground(new java.awt.Color(212, 175, 55));
        titulo1.setText("Texas Hold'em");
        titulo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo1.setName("titulo");
        reglas.add(titulo1);
        titulo1.setBounds(30, 270, 180, 50);

        textoReglas.setEditable(false);
        textoReglas.setBackground(new java.awt.Color(13, 138, 82));
        textoReglas.setColumns(20);
        textoReglas.setFont(new java.awt.Font("Arial", 0, 14));
        textoReglas.setForeground(new java.awt.Color(255, 255, 255));
        textoReglas.setLineWrap(true);
        textoReglas.setRows(5);
        textoReglas.setText("Objetivo: Formar la mejor mano de póquer de cinco cartas posible para ganar el bote. \nJugadores: Generalmente de 2 a 7 jugadores. \n\nReparto: \nCada jugador recibe cinco cartas boca abajo, una a la vez. \nNo se muestran las cartas a los demás jugadores. \n\nApuestas (Primera Ronda): \nComienza con un jugador designado (a menudo a la izquierda del repartidor o la ciega grande). \nLos jugadores pueden: \n     ○ Pasar (Check): Si no ha habido apuestas previas en la ronda actual. \n     ○ Apostar (Bet): Colocar fichas en el bote. \n     ○ Igualar (Call): Igualar la apuesta actual. \n     ○ Subir (Raise): Aumentar la apuesta actual.\n     ○ Retirarse (Fold): Abandonar la mano y perder cualquier ficha apostada. \nLa ronda de apuestas continúa hasta que todos los jugadores activos hayan igualado la apuesta más alta. \n\nEl Descarte (The Draw): \nDespués de la primera ronda de apuestas, cada jugador tiene la opción de descartar ninguna, algunas o todas sus cinco cartas. \nEn su turno, un jugador indica cuántas cartas desea descartar y las coloca boca abajo en el centro de la mesa. \nEl repartidor entrega al jugador el mismo número de cartas nuevas del mazo. \n\nApuestas (Segunda Ronda): \nDespués del descarte, comienza una segunda ronda de apuestas. \nLa acción generalmente comienza con el primer jugador activo a la izquierda del repartidor (o del jugador que abrió la primera ronda de apuestas, si aplica). \nLas opciones de apuesta son las mismas que en la primera ronda (pasar, apostar, igualar, subir, retirarse). \n\nEl Enfrentamiento (The Showdown): \nSi quedan dos o más jugadores después de la segunda ronda de apuestas, ocurre el enfrentamiento. \nLos jugadores restantes revelan sus cinco cartas. \nLa mano de póquer de mayor valor gana el bote. \n\nRanking de Manos (de mayor a menor valor): \nEscalera Real (Royal Flush): As, Rey, Reina, Jota y Diez del mismo palo. (A♡, K♡,Q♡,J♡,10♡) \nEscalera de Color (Straight Flush): Cinco cartas consecutivas del mismo palo (ejemplo: 7♢,8♢,9♢,10♢,J♢). \nPóquer (Four of a Kind): Cuatro cartas del mismo rango (ejemplo: 9♣,9♢,9♡,9♠,2♡). \nFull (Full House): Tres cartas del mismo rango y un par (ejemplo: 3♣,3♢,3♠,K♡,K♠). \nColor (Flush): Cinco cartas del mismo palo, no consecutivas (ejemplo: 2♡,5♡,8♡,J♡,A♡). \nEscalera (Straight): Cinco cartas consecutivas de cualquier palo (ejemplo: 4♣,5♢,6♡,7♠,8♣). \nTrío (Three of a Kind): Tres cartas del mismo rango (ejemplo: Q♣,Q♢,Q♡,7♠,2♢).\nDoble Par (Two Pair): Dos cartas de un rango y dos cartas de otro rango (ejemplo: 10♣,10♢,5♡,5♠,A♣). \nPar (One Pair): Dos cartas del mismo rango (ejemplo: 7♣,7♢,K♡,3♠,2♣). \nCarta Alta (High Card): Si ningún jugador tiene una de las manos anteriores, la mano con la carta de mayor valor gana (ejemplo: A♣,10♢,7♡,5♠,2♢ - As alto).");
        textoReglas.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textoReglas);

        reglas.add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 540, 130);

        textoReglas1.setEditable(false);
        textoReglas1.setBackground(new java.awt.Color(13, 138, 82));
        textoReglas1.setColumns(20);
        textoReglas1.setFont(new java.awt.Font("Arial", 0, 14));
        textoReglas1.setForeground(new java.awt.Color(255, 255, 255));
        textoReglas1.setLineWrap(true);
        textoReglas1.setRows(5);
        textoReglas1.setText("Objetivo: Formar la mejor mano de póquer de cinco cartas posible utilizando una combinación  de tus dos cartas privadas (\"hole cards\") y las cinco cartas comunitarias (\"community cards\")  que se revelan en el centro de la mesa, para ganar el bote. \nJugadores: Generalmente de 2 a 10 jugadores.  \n\nLas Ciegas (The Blinds):  \n1. Antes de que se repartan las cartas, dos jugadores colocan apuestas forzadas llamadas  \"ciegas\". \n2. El jugador inmediatamente a la izquierda del repartidor coloca la \"ciega pequeña\" (small  blind).  \n3. El jugador a la izquierda de la ciega pequeña coloca la \"ciega grande\" (big blind), que  generalmente es el doble del valor de la ciega pequeña.  \n4. Las ciegas rotan alrededor de la mesa con cada nueva mano, de modo que todos los  jugadores eventualmente pagan ambas ciegas.  \n\nReparto: \n1. El repartidor entrega dos cartas boca abajo a cada jugador. Estas son las \"hole cards\" o  cartas privadas de cada jugador. \n\nPrimera Ronda de Apuestas (Pre-Flop):  \n1. La acción comienza con el jugador a la izquierda de la ciega grande. Este jugador tiene  las opciones de:  \n     ○ Pasar (Fold): Abandonar la mano y perder cualquier ficha apostada (las ciegas  son apuestas).  \n     ○ Igualar (Call): Igualar la apuesta actual (la ciega grande).  \n     ○ Subir (Raise): Aumentar la apuesta actual.  \n2. La acción continúa en sentido horario alrededor de la mesa hasta que todos los  jugadores activos hayan igualado la apuesta más alta. La ciega grande tiene la opción  de \"pasar\" si no ha habido subidas.  \n\nEl Flop: \n1. El repartidor quema una carta (la primera carta del mazo se descarta boca abajo).  \n2. Luego, se revelan tres cartas comunitarias boca arriba en el centro de la mesa. Estas  cartas pueden ser utilizadas por todos los jugadores 1 en combinación con sus dos  cartas privadas.   \n3. Comienza la segunda ronda de apuestas. La acción comienza con el primer jugador  activo a la izquierda del repartidor (que no haya pasado). Los jugadores pueden:  \n     ○ Pasar (Check): Si no ha habido apuestas previas en la ronda actual. \n     ○ Apostar (Bet): Colocar fichas en el bote.  \n     ○ Igualar (Call): Igualar la apuesta actual.  \n     ○ Subir (Raise): Aumentar la apuesta actual.  \n     ○ Retirarse (Fold): Abandonar la mano. \n4. La ronda de apuestas continúa hasta que todos los jugadores activos hayan igualado la  apuesta más alta.  \n\nEl Turn (o Fourth Street):  \n1. El repartidor quema otra carta.  \n2. Luego, se revela una cuarta carta comunitaria boca arriba junto a las tres del flop.  \n3. Comienza la tercera ronda de apuestas. La acción comienza con el primer jugador  activo a la izquierda del repartidor. Las opciones de apuesta son las mismas que en el  Flop.  \n\nEl River (o Fifth Street):  \n1. El repartidor quema una última carta.  \n2. Luego, se revela la quinta y última carta comunitaria boca arriba junto a las otras cuatro.  \n3. Comienza la cuarta y última ronda de apuestas. La acción comienza con el primer  jugador activo a la izquierda del repartidor. Las opciones de apuesta son las mismas  que en las rondas anteriores.  \n\nEl Enfrentamiento (The Showdown):  \n1. Si quedan dos o más jugadores después de la ronda final de apuestas, ocurre el  enfrentamiento. \n2. Cada jugador utiliza sus dos cartas privadas y las cinco cartas comunitarias para formar  la mejor mano de póquer de cinco cartas posible. Pueden usar ambas cartas privadas,  una carta privada y cuatro comunitarias, o ninguna carta privada y las cinco  comunitarias (aunque esto es raro).  \n3. Los jugadores revelan sus cartas privadas. \n4. La mano de póquer de mayor valor gana el bote. Si hay un empate en la mejor mano, el  bote se divide entre los jugadores con la mano igual de alta. ");
        textoReglas1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(textoReglas1);

        reglas.add(jScrollPane2);
        jScrollPane2.setBounds(30, 320, 540, 130);

        titulo2.setBackground(new java.awt.Color(6, 62, 35));
        titulo2.setFont(new java.awt.Font("Arial Black", 1, 36));
        titulo2.setForeground(new java.awt.Color(212, 175, 55));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("REGLAS");
        titulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo2.setName("titulo");
        titulo2.setOpaque(true);
        reglas.add(titulo2);
        titulo2.setBounds(0, 20, 600, 50);

        titulo3.setBackground(new java.awt.Color(6, 62, 35));
        titulo3.setFont(new java.awt.Font("Arial Black", 1, 20));
        titulo3.setForeground(new java.awt.Color(212, 175, 55));
        titulo3.setText("5 Card Draw");
        titulo3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titulo3.setName("titulo");
        reglas.add(titulo3);
        titulo3.setBounds(30, 80, 150, 50);

        btnVolverMenu.setBackground(new java.awt.Color(126, 24, 24));
        btnVolverMenu.setFont(new java.awt.Font("Arial", 1, 14));
        btnVolverMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverMenu.setText("VOLVER AL MENÚ");
        btnVolverMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnVolverMenu.setBorderPainted(false);
        btnVolverMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverMenu.setFocusPainted(false);
        btnVolverMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMenuMouseClicked(evt);
            }
        });
        reglas.add(btnVolverMenu);
        btnVolverMenu.setBounds(230, 460, 140, 21);

        getContentPane().add(reglas, "card3");

        pack();
    }                      

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {                                               
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAcercaDe();
            }
        });
    }                                              
    
    private void btnReglasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        btnReglas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPanelReglas();
            }
        });
    }                                         

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (juegoSeleccionado != null) {
            PokerGUI juegoGUI = new PokerGUI(juegoSeleccionado);
            juegoGUI.setVisible(true);

            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Debes seleccionar un juego antes de comenzar.", 
                "Selección de Juego", 
                JOptionPane.WARNING_MESSAGE);
        }
    }                                        

    private void fiveCardsImagenMouseClicked(java.awt.event.MouseEvent evt) {                                             
        juegoSeleccionado = "5 Card Draw";
    }                                            

    private void texasHoldemImagenMouseClicked(java.awt.event.MouseEvent evt) {                                               
        juegoSeleccionado = "Texas Hold'em";
    }                                              

    private void btnVolverMenuMouseClicked(java.awt.event.MouseEvent evt) {                                           
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPanelMenuPrincipal();
            }
        });
    }                                          
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    
    private void mostrarPanelReglas() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "reglas");
    }
    
    private void mostrarPanelMenuPrincipal() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "menu");
    }
    
    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this, """
            Proyecto P\u00f3quer
            Desarrollado por: Andre Dominguez Pereyra y Melany Cornejo Garc\u00eda
            Versi\u00f3n: 1.0
            Curso: POO""",
            "Acerca del Proyecto",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private javax.swing.JButton btnInformacion;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnReglas;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JPanel fiveCardSeleccion;
    private javax.swing.JLabel fiveCardsImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menuPrincipalPanel;
    private javax.swing.JPanel reglas;
    private javax.swing.JLabel texasHoldemImagen;
    private javax.swing.JPanel texasHoldemSeleccion;
    private javax.swing.JTextArea textoReglas;
    private javax.swing.JTextArea textoReglas1;
    private javax.swing.JLabel textoSeleccion;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
}