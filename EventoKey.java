
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventoKey extends JFrame {

    private String linha1 = "";
    private String linha2 = "";
    private JTextArea areaTexto;
    private String teclasDigitadas = "";

// configura a GUI
    public EventoKey() {
// texto da barra de título
        super("Testando eventos das teclas");

// configura a JTextArea
        areaTexto = new JTextArea(10, 15);

        areaTexto.setFont(new Font("Serif", 1, 20));//tipo, estilo e tamanho
        areaTexto.setText("Pressione qualquer tecla...");
        areaTexto.setEnabled(false);// não vou digitar no JTextArea da interface, digitarei no teclado e o ouvinte receberá o evento
        getContentPane().add(areaTexto);

// registra a janela para processar os eventos de teclas
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evento) {
                linha1 = "Tecla Pressionada: " + evento.getKeyText(evento.getKeyCode());
                configLinha(evento);
                teclasDigitadas = teclasDigitadas + evento.getKeyText(evento.getKeyCode()) + ", ";//aparece as teclas digitadas no teclado na //tela
            }
        }
        );
        setSize(450, 200); // dimensiona a janela
        setVisible( true ); // exibe a janela
    }

    private void configLinha(KeyEvent evento) {

        if (evento.isActionKey()) {
            linha2 = "Esta tecla é uma chave de ação";
        } else {
            linha2 = "Esta tecla NÃO é uma chave de ação";
        }
        areaTexto.setText(linha1 + "\n" + linha2 + "\n" + "Você digitou essa sequencia: " + teclasDigitadas);
    }

// executa a aplicação
    public static void main(String args[]) {
        EventoKey aplicacao = new EventoKey();

// configura o encerramento da aplicação
        aplicacao.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
}
