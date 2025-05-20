package com.mycompany.proyectopoquer.gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PokerGUI extends JFrame {
    
    private final JPanel panelPrincipal;
    private final JLabel labelTitulo;
    private final JLabel labelPot;
    private final JPanel panelJugadores;
    private final JPanel panelCartasUsuario;
    private final JPanel panelBotones;
    private final JPanel panelApuesta;
    private JSlider sliderApuesta;
    private JLabel labelCantidad;
    private JButton btnApostar;
    private final JButton btnDescartar;
    
    private JButton btnPasar;
    private JButton btnIgualar;
    private JButton btnSubir;
    private JButton btnRetirarse;
    
    private final Color colorFondo = new Color(0, 102, 51);
    private final Color colorBotonVerde = new Color(0, 153, 76);
    private final Color colorBotonRojo = new Color(217, 83, 79);
    private final Color colorBotonAmarillo = new Color(240, 173, 78);
    
    private final Map<String, String> cartasJugador = new HashMap<>();
    
    public PokerGUI(String tipoJuego) {
        setTitle(tipoJuego);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBackground(colorFondo);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setOpaque(false);
        
        labelTitulo = new JLabel(tipoJuego);
        labelTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.WHITE);
        
        JLabel labelMonto = new JLabel("$1000");
        labelMonto.setHorizontalAlignment(SwingConstants.RIGHT);
        labelMonto.setFont(new Font("Arial", Font.BOLD, 20));
        labelMonto.setForeground(Color.WHITE);
        
        panelSuperior.add(labelTitulo, BorderLayout.WEST);
        panelSuperior.add(labelMonto, BorderLayout.EAST);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(10, 20));
        panelCentral.setBackground(colorFondo);
        panelCentral.setBorder(BorderFactory.createLineBorder(colorFondo.darker(), 2, true));
        
        panelJugadores = crearPanelJugadores();
        
        JPanel panelPot = new JPanel();
        panelPot.setOpaque(false);
        labelPot = new JLabel("POT: $300");
        labelPot.setForeground(Color.WHITE);
        labelPot.setFont(new Font("Arial", Font.BOLD, 16));
        panelPot.add(labelPot);
        
        panelCartasUsuario = crearPanelCartasUsuario();
        
        panelCentral.add(panelJugadores, BorderLayout.NORTH);
        panelCentral.add(panelPot, BorderLayout.CENTER);
        panelCentral.add(panelCartasUsuario, BorderLayout.SOUTH);
        
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout(0, 10));
        panelInferior.setOpaque(false);
        
        panelBotones = crearPanelBotones();
        
        btnDescartar = crearBoton("DESCARTAR", colorBotonVerde);
        
        panelApuesta = crearPanelApuesta();
        
        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(btnDescartar, BorderLayout.CENTER);
        panelInferior.add(panelApuesta, BorderLayout.SOUTH);
        
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private JPanel crearPanelJugadores() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
        panel.setOpaque(false);
        
        JPanel jugador1 = crearCirculoJugador("J1");
        JPanel jugador2 = crearCirculoJugador("J2");
        JPanel jugador3 = crearCirculoJugador("J3");
        JPanel jugador4 = crearCirculoJugador("J4");
        JPanel jugador5 = crearCirculoJugador("J5");
        JPanel jugador6 = crearCirculoJugador("J6");
        
        panel.add(jugador1);
        panel.add(jugador2);
        panel.add(jugador3);
        panel.add(jugador4);
        panel.add(jugador5);
        panel.add(jugador6);
        
        return panel;
    }
    
    private JPanel crearCirculoJugador(String nombre) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillOval(0, 0, getWidth(), getHeight());
                g.setColor(Color.GRAY);
                g.fillOval(2, 2, getWidth()-4, getHeight()-4);
            }
        };
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(50, 50));
        panel.setOpaque(false);
        
        JLabel label = new JLabel(nombre);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label);
        
        return panel;
    }
    
    private JPanel crearPanelCartasUsuario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 10));
        panel.setOpaque(false);
        
        JLabel labelTusCartas = new JLabel("Tus Cartas");
        labelTusCartas.setForeground(Color.WHITE);
        labelTusCartas.setHorizontalAlignment(SwingConstants.CENTER);
        labelTusCartas.setFont(new Font("Arial", Font.BOLD, 14));
        
        JPanel panelCartas = new JPanel();
        panelCartas.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelCartas.setOpaque(false);
        
        for (int i = 0; i < 5; i++) {
            JPanel carta = crearCarta();
            JCheckBox checkbox = new JCheckBox();
            checkbox.setOpaque(false);
            checkbox.setHorizontalAlignment(SwingConstants.CENTER);
            
            JPanel panelCarta = new JPanel();
            panelCarta.setLayout(new BorderLayout());
            panelCarta.setOpaque(false);
            panelCarta.add(carta, BorderLayout.CENTER);
            panelCarta.add(checkbox, BorderLayout.SOUTH);
            
            panelCartas.add(panelCarta);
        }
        
        panel.add(labelTusCartas, BorderLayout.NORTH);
        panel.add(panelCartas, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearCarta() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(70, 100));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/AsC1.png"));
            Image imagen = icon.getImage().getScaledInstance(70, 90, Image.SCALE_SMOOTH);
            JLabel labelCarta = new JLabel(new ImageIcon(imagen));
            panel.add(labelCarta);
        } catch (Exception e) {
            System.err.println("No se pudo cargar la imagen.");
        }
        
        return panel;
    }
    
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4, 5, 0));
        panel.setOpaque(false);
        
        btnPasar = crearBoton("PASAR", colorBotonVerde);
        btnIgualar = crearBoton("IGUALAR", colorBotonVerde);
        btnSubir = crearBoton("SUBIR", colorBotonVerde);
        btnRetirarse = crearBoton("RETIRARSE", colorBotonRojo);
        
        panel.add(btnPasar);
        panel.add(btnIgualar);
        panel.add(btnSubir);
        panel.add(btnRetirarse);
        
        return panel;
    }
    
    private JPanel crearPanelApuesta() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 0));
        panel.setOpaque(false);
        
        labelCantidad = new JLabel("CANTIDAD: $50");
        labelCantidad.setForeground(Color.WHITE);
        labelCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
        
        sliderApuesta = new JSlider(JSlider.HORIZONTAL, 0, 1000, 50);
        sliderApuesta.setOpaque(false);
        sliderApuesta.setForeground(Color.WHITE);
        sliderApuesta.setPaintTicks(true);
        sliderApuesta.setMajorTickSpacing(200);
        sliderApuesta.setMinorTickSpacing(50);
        
        sliderApuesta.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = sliderApuesta.getValue();
                labelCantidad.setText("CANTIDAD: $" + valor);
            }
        });
        
        btnApostar = new JButton("APOSTAR");
        btnApostar.setBackground(colorBotonAmarillo);
        btnApostar.setForeground(Color.BLACK);
        btnApostar.setBorderPainted(false);
        btnApostar.setFocusPainted(false);
        
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setOpaque(false);
        panelSur.add(labelCantidad, BorderLayout.WEST);
        panelSur.add(btnApostar, BorderLayout.EAST);
        
        JLabel labelSel = new JLabel("SEL");
        labelSel.setForeground(Color.BLACK);
        labelSel.setHorizontalAlignment(SwingConstants.CENTER);
        labelSel.setFont(new Font("Arial", Font.BOLD, 12));
        
        panel.add(sliderApuesta, BorderLayout.CENTER);
        panel.add(panelSur, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        return boton;
    }
    
    public void actualizarCartas(String[] valoresCartas) {
        System.out.println("Cartas actualizadas:");
        for (String carta : valoresCartas) {
            System.out.println(carta);
        }
    }
    
    public void cambiarTipoJuego(String tipoJuego) {
        labelTitulo.setText(tipoJuego);
    }
    
    public void actualizarPot(int cantidad) {
        labelPot.setText("POT: $" + cantidad);
    }
    
    public String pedirCantidadJugadores() {
        return JOptionPane.showInputDialog(
            this,                                 
            "Ingrese la cantidad de jugadores: ",
            "Farkle - Configuración de jugadores",
            JOptionPane.QUESTION_MESSAGE
        );
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PokerGUI juego = new PokerGUI("5 Card Draw");
            juego.setVisible(true);
            
            String[] cartas = {"A♠", "K♥", "Q♦", "J♣", "10♠"};
            juego.actualizarCartas(cartas);
        });
    }
}