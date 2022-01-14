package com.assyifacake.controllers.Produk;

import com.assyifacake.controllers.KontrakLihatProdukDanResep;
import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.helpers.validations.NumbersValidation;
import com.assyifacake.utils.ByteToIcon;
import com.assyifacake.utils.IndonesiaCurrency;
import com.assyifacake.utils.OnChangeListener;
import com.assyifacake.views.Produk.DetailProdukInternalView;
import com.assyifacake.views.Produk.LihatProdukInternalView;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LihatProdukController implements KontrakLihatProdukDanResep {

    
    private LihatProdukInternalView view;
    
    private int offSet = 0;
    
    private Map<Integer,JLabel> image = new HashMap<>();
    private Map<Integer,JLabel> namaProduk = new HashMap<>();
    private Map<Integer,JLabel> hargaProduk = new HashMap<>();
    private SwingWorker<String, Object[]> thread;

//    public int getOffset() {
//        return offset;
//    }
//
//    public void setOffset(int offset) {
//        this.offset = offset;
//    }
    
    
    public LihatProdukController(LihatProdukInternalView view) {
        this.view = view;
    }
    
    
    @Override
    public void myComponents() {
        
        // register event search onchange
            search();
            image.put(1, view.getImage1());
            image.put(2, view.getImage2());
            image.put(3, view.getImage3());
            image.put(4, view.getImage4());
            image.put(5, view.getImage5());
            image.put(6, view.getImage6());
            namaProduk.put(1, view.getNamaProduk1());
            namaProduk.put(2, view.getNamaProduk2());
            namaProduk.put(3, view.getNamaProduk3());
            namaProduk.put(4, view.getNamaProduk4());
            namaProduk.put(5, view.getNamaProduk5());
            namaProduk.put(6, view.getNamaProduk6());
            hargaProduk.put(1, view.getHargaProduk1());
            hargaProduk.put(2, view.getHargaProduk2());
            hargaProduk.put(3, view.getHargaProduk3());
            hargaProduk.put(4, view.getHargaProduk4());
            hargaProduk.put(5, view.getHargaProduk5());
            hargaProduk.put(6, view.getHargaProduk6());  
            
//            // set cursor hand
//            for(int i=1; i <= image.size(); i++) {
//                image.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));
//            } 
            view.getPrev().setCursor(new Cursor(Cursor.HAND_CURSOR));
            view.getNext().setCursor(new Cursor(Cursor.HAND_CURSOR));
            String sql = "SELECT * FROM produk ORDER BY updated_at DESC LIMIT 6";
            tampilGambar(sql);     
    }

    @Override
    public void kosonginGambar() {
        for(int i=1; i <= image.size(); i++) {
            for (MouseListener listener : image.get(i).getMouseListeners()) {
            image.get(i).removeMouseListener(listener);
        };
            image.get(i).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            image.get(i).revalidate();
            image.get(i).setIcon(null);
            image.get(i).setBorder(BorderFactory.createEmptyBorder());
            namaProduk.get(i).setText("");
            hargaProduk.get(i).setText("");
            
        }
    }

    @Override
    public void tampilGambar(String sql) {
       kosonginGambar();
       // kalo ada thread lain running, stop
       if(thread != null) {
        thread.cancel(true);           
       }
       thread = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
        Connection conn = null;
        PreparedStatement pS = null;
        ResultSet rS = null; 
        try {
            if(offSet == 0) {
                view.getPrev().setEnabled(false);
            } else{
                view.getPrev().setEnabled(true);
            }
            conn = getConnection();
            pS = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rS = pS.executeQuery();
            rS.last();
            if(rS.getRow()<6) {
                view.getNext().setEnabled(false);
            } else {
                view.getNext().setEnabled(true);
            }

            rS.beforeFirst();
            int i =1;
            while(rS.next()) {
                if(isCancelled()) {
//                    System.out.println("canceled");
                    return "Canceled";
                }
                byte[] getBytes = rS.getBytes("gambar");
                String namaDariDb = rS.getString("nama");
                String hargaDariDb = IndonesiaCurrency.format(rS.getInt("harga"));
                String labaDariDb = IndonesiaCurrency.format(rS.getInt("laba"));
                int idDariDb = rS.getInt("id");
                ImageIcon iconBelumResized = null;
                if(rS.getBytes("gambar") == null) {
                    iconBelumResized = new ImageIcon(getClass().getResource("/img/defaultImage.png"));
                } else {
                    iconBelumResized = ByteToIcon.decode(rS.getBytes("gambar"));
                }
                Image resizedImage = iconBelumResized.getImage().getScaledInstance(150, 150, SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                
                Object[] hasil = new Object[7];
                hasil[0] = i; // ke berapa
                hasil[1] = icon;
                hasil[2] = namaDariDb;
                hasil[3] = hargaDariDb;
                hasil[4] = iconBelumResized;
                hasil[5] = labaDariDb;
                hasil[6] = idDariDb;
//                image.get(i).setIcon(icon);
//                image.get(i).setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
//                namaProduk.get(i).setText(namaDariDb);
//                hargaProduk.get(i).setText(hargaDariDb);
//                
//                // registering event handler onclick
//                onClickImage(image.get(i), iconBelumResized, namaDariDb,hargaDariDb, labaDariDb);
                if(isCancelled()) {
//                    System.out.println("canceled");
                    return "Canceled";
                }
                publish(hasil);
                
                i++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(LihatProdukInternalView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(rS != null) {
                    rS.close();
                }
                if(conn != null) {

                    conn.close();
                }
                if(pS != null) {

                    pS.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LihatProdukInternalView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Sukses";

            }
            
            @Override
            protected void process(List<Object[]> chunks) {
                for (Object[] chunk : chunks) {
                    int i = (Integer) chunk[0];
                    ImageIcon icon = (ImageIcon) chunk[1];
                    String namaDariDb = (String) chunk[2];
                    String hargaDariDb = (String) chunk[3];
                    ImageIcon iconBelumResized = (ImageIcon) chunk[4];
                    String labaDariDb = (String) chunk[5];
                    int idDariDb = (Integer) chunk[6];
                    image.get(i).setIcon(icon);
                    image.get(i).setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    namaProduk.get(i).setText(namaDariDb);
                    hargaProduk.get(i).setText(hargaDariDb);

                    // registering event handler onclick
                    onClickImage(image.get(i), iconBelumResized, idDariDb, namaDariDb,hargaDariDb, labaDariDb);
                }
            }
            
        };
        thread.execute();
    }

    @Override
    public void search() {
        OnChangeListener.addChangeListener(view.getSearch(), new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
        
                offSet = 0;

                String ketikan = view.getSearch().getText();
                    String sql = "";
                    if(new NumbersValidation().check(ketikan)) {
                        sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' OR id = "+Integer.parseInt(ketikan)+" ORDER BY updated_at desc LIMIT 6 OFFSET " +offSet;                 
                    } else {
                        sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' ORDER BY updated_at desc LIMIT 6 OFFSET " +offSet;                  
                    }
                tampilGambar(sql);
                }
            }
                    );
    }

    @Override
    public void prevBT() {
         if(!view.getNext().isEnabled()){
            view.getNext().setEnabled(true);
        }
        
        offSet-= 6;        
        if(view.getSearch().getText().isBlank()) {

            String sql =  "SELECT * FROM produk ORDER BY updated_at DESC LIMIT 6 OFFSET " + offSet;    
            tampilGambar(sql);
            
        } else {
            String ketikan = view.getSearch().getText();
            
            String sql = "";
            if(new NumbersValidation().check(ketikan)) {
                sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' OR id = "+Integer.parseInt(ketikan)+" ORDER BY updated_at desc LIMIT 6 OFFSET " +offSet;                 
            } else {
                sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' ORDER BY updated_at desc LIMIT 6 OFFSET " +offSet;                  
            }
            tampilGambar(sql);

        }   
    }

    @Override
    public void nextBT() {

        if(!view.getPrev().isEnabled()){
        view.getPrev().setEnabled(true);
        }    
        offSet+= 6;        
        if(view.getSearch().getText().isBlank()) {

            String sql =  "SELECT * FROM produk ORDER BY updated_at DESC LIMIT 6 OFFSET " + offSet;    
            tampilGambar(sql);
            
        } else {
            String ketikan = view.getSearch().getText();
            
            String sql = "";
            if(new NumbersValidation().check(ketikan)) {
                sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' OR id = "+Integer.parseInt(ketikan)+" ORDER BY updated_at desc LIMIT 6 OFFSET " +offSet;                 
            } else {
                sql =  "SELECT * FROM produk WHERE nama like '%"+ketikan+"%' ORDER BY updated_at DESC LIMIT 6 OFFSET " +offSet;                  
            }
            tampilGambar(sql);

        }
    }

    private void onClickImage(JLabel image, ImageIcon icon, int idProduk, String namaProduk, String hargaProduk, String labaProduk) {
       
        MouseAdapter mouseAdapter = new MouseAdapter() {
                public void mouseClicked(MouseEvent e)  
        {  
            Container container = SwingUtilities.getAncestorOfClass(JDesktopPane.class, (Component) e.getSource());
            if (container != null)
            {
                Image resizedImage = icon.getImage().getScaledInstance(300, 300, SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resizedImage);
                
                JDesktopPane desktop = (JDesktopPane) container;
                DetailProdukInternalView detail = new DetailProdukInternalView();
                detail.setIdProduk(idProduk);
                detail.getNamaProduk().setText(namaProduk);
                detail.getHargaProduk().setText(hargaProduk);
                detail.getLaba().setText(labaProduk);
                detail.getGambarProduk().setIcon(icon);
                
                Connection conn = null;
                Statement stat = null;
                ResultSet rs = null;
                
                String sql = "SELECT bahan_bahan, cara_pembuatan FROM resep WHERE id_produk = '" +idProduk+"' LIMIT 1";
                try {
                   conn = getConnection();
                   stat = conn.createStatement();
                   rs = stat.executeQuery(sql);
                   
                   if(rs.next()) {
                       detail.getBahanBahan().setText(rs.getString("bahan_bahan"));
                       detail.getLangkahLangkah().setText(rs.getString("cara_pembuatan"));
                   }
                   if(detail.getBahanBahan().getText().isBlank() || detail.getBahanBahan().getText().isEmpty()) {
                       detail.getBahanBahan().setVisible(false);
                   }
                   
                   if(detail.getLangkahLangkah().getText().isBlank() || detail.getLangkahLangkah().getText().isEmpty()) {
                       detail.getLangkahLangkah().setVisible(false);
                   }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(LihatProdukController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        conn.close();
                        rs.close();
                        stat.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(LihatProdukController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              
                
                desktop.removeAll();
                desktop.add( detail );
                detail.setVisible(true);
            } 
        }
        };
        image.setCursor(new Cursor(Cursor.HAND_CURSOR));
        image.revalidate();
        image.addMouseListener(mouseAdapter);
    }
    
}
