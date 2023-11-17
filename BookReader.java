import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class sistemalivros {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();
        JLabel sexoLabel = new JLabel("Sexo:");
        JComboBox<String> sexoComboBox = new JComboBox<>(new String[]{"", "Masculino", "Feminino"});

        JLabel generoLabel = new JLabel("Gêneros dos Livros:");
        JComboBox<String> generoComboBox1 = new JComboBox<>(new String[]{"", "Ação", "Romance", "Aventura", "Infantil", "Terror", "Estudos"});
        JComboBox<String> generoComboBox2 = new JComboBox<>(new String[]{"", "Ação", "Romance", "Aventura", "Infantil", "Terror", "Estudos"}); 
        

        JButton cadastrarUsuarioButton = new JButton("Cadastrar Usuário");
        cadastrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int idade = Integer.parseInt(idadeField.getText());

                cadastrarUsuario(nome, idade);

                nomeField.setText("");
                idadeField.setText("");
                panel.add(sexoLabel);
                panel.add(sexoComboBox);
                panel.add(generoLabel);
                panel.add(generoComboBox1);
                panel.add(generoComboBox2);
            }

            private void cadastrarUsuario(String nome, int idade) {
            }
        });

        JLabel tituloLabel = new JLabel("Título do Livro:");
        JTextField tituloField = new JTextField();

        JLabel autorLabel = new JLabel("Autor:");
        JTextField autorField = new JTextField();

        JButton cadastrarLivroButton = new JButton("Cadastrar Livro");
        cadastrarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String autor = autorField.getText();

                cadastrarLivro(titulo, autor);

                tituloField.setText("");
                autorField.setText("");
            }
        });

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(idadeLabel);
        panel.add(idadeField);
        panel.add(cadastrarUsuarioButton);
        panel.add(tituloLabel);
        panel.add(tituloField);
        panel.add(autorLabel);
        panel.add(autorField);
        panel.add(cadastrarLivroButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void cadastrarLivro(String titulo, String autor) {
        try {
            String url = "C:\\Users\\gustavo.santos\\OneDrive\\BookReader\\BookReader.sql";
            String usuario = "seu_usuario";
            String senha = "sua_senha";
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            

            String query = "INSERT INTO livros (titulo, autor) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, titulo);
            stmt.setString(2, autor);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro");
        }
    }



public class HTMLViewer extends JFrame {
    public HTMLViewer() {
        setTitle("HTMLViewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);

        try {
            URL url = new URL("C:\\Users\\gustavo.santos\\OneDrive\\BookReader\\BookReader.html");
            editorPane.setPage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HTMLViewer htmlViewer = new htmlViewer();
            htmlViewer.setVisible(true);
        });
    }
}



}

