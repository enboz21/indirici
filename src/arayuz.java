
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;


public class arayuz implements Runnable{
    static JTextField link=new JTextField();
    static indirici in=new indirici();
    static JButton indir=new JButton();
    static String q;
    static String deyer;
    static String b;
    static boolean sırada=false;
    static JTextArea sonuc=new JTextArea();
    //static  JProgressBar bar=new JProgressBar(0, 100);
    static JTextPane barStr=new JTextPane();
    static boolean yolvar;
    static JComboBox cb=new JComboBox();
    public static void main(String[] args) throws IOException {
        
        File yazma = new File("kayıtlıyol.txt");
        if (yazma.exists()) {
            FileReader file = new FileReader("kayıtlıyol.txt");
            BufferedReader input = new BufferedReader(file);
            String line = input.readLine();
            yol = line;
            input.close();
            input.close();
            file.close();
            System.out.println(yol);
        }
        
        
        
        
        
        
        
        
        
        
        //arayüz başlangıcı
        JFrame jf=new JFrame();
        
        
        JLabel progad=new JLabel();
        
        JMenuBar menal=new JMenuBar();
        JMenuItem menit=new JMenuItem();
        JMenu men=new JMenu();
        JButton start=new JButton();
        menal.setBounds(0, 0, 1,1);
        men.setText("menü");
        menit.setText("dosya seçim");
        men.add(menit);
        menal.add(men);
        jf.setJMenuBar(menal);
        progad.setVisible(true);
        progad.setText("İNDİRİCİ");
        progad.setBounds(200, -75, 200, 200);
        progad.setFont(new Font("", 0, 36));
        jf.add(progad);
        link.setBounds(1, 40, 580, 50);
        jf.add(link);
        start.setFont(new Font("", 0, 20));
        start.setText("start");
        start.setBounds(0, 100, 100, 50);
        jf.add(start);
        /*bar.setBounds(110, 100, 450, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("", 0, 20));
        jf.add(bar);*/
        barStr.setBounds(110, 100, 80, 30);
        barStr.setFont(new Font("", 0, 20));
        jf.add(barStr);
        sonuc.setBounds(1, 200, 580, 200);
        jf.add(sonuc);
        cb.setBounds(200, 100, 350, 20);
        jf.add(cb);
        indir.setBounds(0, 150, 100, 50);
        indir.setText("indir");
        indir.setFont(new Font("", 0, 20));
        jf.add(indir);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600, 500);
        jf.setLayout(null);
        jf.setVisible(true);
        //arayüz sonu
        //https://www.youtube.com/watch?v=Km1F_H3_90U
        
        
        //iventler başlangıcı
        //menü ayarı
        menit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int den = file.showOpenDialog(null);
        if (den == JFileChooser.APPROVE_OPTION) {
            yol = file.getSelectedFile().getAbsolutePath();
        }
        try {
            // TODO add your handling code here:
            String str = yol;
            File yazma = new File("kayıtlıyol.txt");
            if (!yazma.exists()) {
                try {
                    yazma.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(arayuz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try (FileWriter fileWriter = new FileWriter(yazma, false)) {
                BufferedWriter bWriter = new BufferedWriter(fileWriter);
                bWriter.write(str);
                bWriter.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(arayuz.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        });
        //menü ayarı bitti
        //buton işelevleri ayarlanır
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yazma.exists()) {
                    try {
                        FileReader file = new FileReader("kayıtlıyol.txt");
                        BufferedReader input = new BufferedReader(file);
                        String line = input.readLine();
                        yol = line;
                        input.close();
                        input.close();
                        file.close();
                        System.out.println(yol);
                    } catch (IOException ex) {
                        Logger.getLogger(arayuz.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
                  if (yol==null) {
                      if (link.getText().charAt(0)=='h') {
                          yolvar=false;
                              /*String b=link.getText();
                              indirici in=new indirici();
                              String a=in.format(b);
                              String secim = (JOptionPane.showInputDialog(this, a));
                              in.indirme(secim, b);*/
                              
                              Thread t1 = new Thread((Runnable) new arayuz());
                              t1.start();
                              
                          
                          
                      }
                      else{
                          String a="girdi link deyil";
                      JOptionPane.showInputDialog(a);
                              }
                }
                  else{
                      if (link.getText().charAt(0)=='h') {
                          yolvar =true;
                          Thread t1 = new Thread((Runnable) new arayuz());
                              t1.start();
                      }
                      else{
                          String a="girdi link deyil";
                      JOptionPane.showInputDialog(a);
                              }
                  }
                  
                  
                  
            }
        });
        //buton ilevleri sonu
        //buton işlevi
        indir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    q =(String)cb.getSelectedItem();
                    String[] böl = q.split(" ");
                    Thread t2 = new Thread((Runnable) new arayuz());
                    deyer=böl[0];
                    sırada=true;
                              t2.start();
                    
                }
            });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
    static String yol;
    
    //barstr
    public static void barstr(String deyer) throws InterruptedException {
        if (deyer.contains("%")) {

            String[] böl1 = deyer.split("% ", 2);
            String a = "";
            for (int i = böl1[0].length() - 1; i >= 0; i--) {
                a += böl1[0].charAt(i);
            }
            String[] böl2 = a.split(" ", 2);
            a = "";
            for (int i = böl2[0].length() - 1; i >= 0; i--) {
                a += böl2[0].charAt(i);
            }
            float ilerleme = Float.valueOf(a);
            String c = String.valueOf(ilerleme);
            barStr.setText("");
            barStr.setText(c+"%");
            
    }
    }
    
    
    //yükleme barı (çalışmamakta)
    
    /*public void bar(String deyer) throws InterruptedException {
        if (deyer.contains("%")) {

            String[] böl1 = deyer.split("% ", 2);
            String a = "";
            for (int i = böl1[0].length() - 1; i >= 0; i--) {
                a += böl1[0].charAt(i);
            }
            String[] böl2 = a.split(" ", 2);
            a = "";
            for (int i = böl2[0].length() - 1; i >= 0; i--) {
                a += böl2[0].charAt(i);
            }
            float ilerleme = Float.valueOf(a);
            int c = (int) ilerleme;
            int i = c;

            bar = new JProgressBar();
            
            bar.setValue(i);
            bar.update(bar.getGraphics());
            bar.setStringPainted(true);

        }
    }*/
    static boolean canlımı=true;
    public void run(){
        if (sırada ==false) {
            
        
        
             b=link.getText();
            indirici in=new indirici();
            String a=in.format(b);
            ne ne=new ne();
            ne.ne(a);
            String [] sa=ne.formatlar();
            ComboBoxModel illermodel = new DefaultComboBoxModel(sa);
            cb.setModel(illermodel);
            
                
            
            //buton işelevleri ayarlanır
        
            
            
            
            
           // in.indirme(secim, b);
        
    }
        else{
            
            if (yolvar==false) {
                File f=new File(System.getProperty("user.dir"));
                String dosyalar1[] = f.list();
                
                in.indirme(deyer, b);
                String [] dosyalar2 = f.list();
        String fark;
        for (int i = 0; i < dosyalar1.length; i++) {
            if (!dosyalar1[i].equals(dosyalar2[i])) {
                fark=dosyalar2[i];
                String met=sonuc.getText();
                sonuc.setText(met+"\n"+fark);
            }
        }
        fark=dosyalar2[dosyalar2.length-1];
        String met=sonuc.getText();
                sonuc.setText(met+"\n"+fark);
            }
            else{
                File F=new File(yol);
                String dosyalar1[] = F.list();
                
                in.indirme(deyer, b,yol);
                String [] dosyalar2 = F.list();
        String fark;
        for (int i = 0; i < dosyalar1.length; i++) {
            if (!dosyalar1[i].equals(dosyalar2[i])) {
                fark=dosyalar2[i];
                String met=sonuc.getText();
                sonuc.setText(met+"\n"+fark);
            }
        }
        fark=dosyalar2[dosyalar2.length-1];
        String met=sonuc.getText();
                sonuc.setText(met+"\n"+fark);
            }
              sırada=false;  
            
        }
            
    }
}
//https://www.youtube.com/watch?v=Km1F_H3_90U