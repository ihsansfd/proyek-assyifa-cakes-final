/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assyifacake.controllers.LaporanPenjualan;

import static com.assyifacake.db.KoneksiDatabase.getConnection;
import com.assyifacake.utils.FindGreatestInHashMap;
import com.assyifacake.views.LaporanPenjualan.LaporanPenjualanInternalView;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author user
 */
public class LaporanPenjualanController {
    
    private LaporanPenjualanInternalView view;
    private JTabbedPane tabbedPane;
    private JPanel panelPenjualanProduk;
    private JPanel panelLaba;
    private DatePicker toDate;
    private DatePicker fromDate;
    
    private String toDateFromDatePicker;
    private String fromDateFromDatePicker;
    
    public LaporanPenjualanController(LaporanPenjualanInternalView view) {
     this.view = view;
     this.tabbedPane = view.getTabbedPane();
     this.panelPenjualanProduk = view.getPanelPenjualanProduk();
     this.panelLaba = view.getPanelLaba();
     
    }
    
    public void setTanggal() {
        this.fromDateFromDatePicker = fromDate.getDateStringOrEmptyString();
        this.toDateFromDatePicker = toDate.getDateStringOrEmptyString();
        if(tabbedPane.getSelectedIndex() == 1) {
            tampilDataLaba(fromDateFromDatePicker,toDateFromDatePicker);
        } else {
            tampilDataProduk(fromDateFromDatePicker,toDateFromDatePicker);
        }
    }
    
    public void myComponents() {
       JPanel panelToDate = view.getToDate();
       JPanel panelFromDate = view.getFromDate();        
        
        // toDate
        DatePickerSettings datePickerSettings1 = new DatePickerSettings();
        datePickerSettings1.setFormatForDatesBeforeCommonEra("dd-MM-yyyy");
        datePickerSettings1.setFormatForDatesCommonEra("dd-MM-yyyy");
        TimePickerSettings timePickerSettings1 = new TimePickerSettings();
        timePickerSettings1.use24HourClockFormat();
        
        toDate = new DatePicker(datePickerSettings1);
        datePickerSettings1.setDateRangeLimits(LocalDate.MIN, LocalDate.now());

        panelToDate.repaint();
        panelToDate.setPreferredSize(new Dimension(135,30));
        panelToDate.add(toDate);
        toDate.setSize(135,30);
        toDate.setDateToToday();
        toDate.setVisible(true);
        
        DatePickerSettings datePickerSettings = new DatePickerSettings();
        datePickerSettings.setFormatForDatesBeforeCommonEra("dd-MM-yyyy");
        datePickerSettings.setFormatForDatesCommonEra("dd-MM-yyyy");
        TimePickerSettings timePickerSettings = new TimePickerSettings();
        timePickerSettings.use24HourClockFormat();
        
        // fromDate
        fromDate = new DatePicker(datePickerSettings);
        datePickerSettings.setDateRangeLimits(LocalDate.MIN, LocalDate.now());
//        datePickerSettings.setDateRangeLimits(LocalDate.now(), LocalDate.now().plusDays(365));
        panelFromDate.repaint();
        panelFromDate.setPreferredSize(new Dimension(135,30));
        panelFromDate.add(fromDate);
        fromDate.setSize(135,30);
        fromDate.setDate(LocalDate.now().minusDays(30));
        fromDate.setVisible(true);
        
        // set changelistener tabbedPane
        tabbedPane.addChangeListener(new ChangeListener() {

           @Override
           public void stateChanged(ChangeEvent e) {
                if(tabbedPane.getSelectedIndex() == 0) {
                    tampilDataProduk(fromDateFromDatePicker,toDateFromDatePicker);
                } else {
                    
                    tampilDataLaba(fromDateFromDatePicker,toDateFromDatePicker);

                }
           }
    });
       
    }
    
    public void tampilDataProduk(String fromDate, String toDate) {
        
        // penjualan produk
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        HashMap<String, Integer> dataTerbesar = new HashMap<String, Integer>();
        String sql = "SELECT transaksi_detail.kuantitas, transaksi_detail.nama_produk from transaksi_detail INNER JOIN transaksi "
                + "on (transaksi_detail.id_transaksi = transaksi.id) WHERE transaksi.tanggal_transaksi BETWEEN '"+fromDate+"' AND '"+toDate+"' AND status = 'Selesai'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while(rs.next()) {
                String produk = rs.getString("transaksi_detail.nama_produk");
                int kuantitas = rs.getInt("transaksi_detail.kuantitas");

                if(!data.containsKey(produk)) {
                    data.put(produk, kuantitas);
                } else {
                    data.put(produk, data.get(produk) + kuantitas);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
           final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // mencari top 5 produk 
        List<Entry<String, Integer>> greatest = FindGreatestInHashMap.findGreatest(data, 5);
        for (Entry<String, Integer> entry : greatest)
        {
            if(data.containsKey(entry.getKey())) {
                data.remove(entry.getKey());
            }
            dataset.addValue(entry.getValue(), "Penjualan/produk", entry.getKey());
        }
        
        if(data.size() != 0) {
            int kuantitasProdukLainnya = 0;
            for(HashMap.Entry<String, Integer> set :
                data.entrySet()) {
                kuantitasProdukLainnya += set.getValue();

            }
            dataset.addValue(kuantitasProdukLainnya, "Penjualan/produk", "Produk Lainnya");
            
        }

            
            final JFreeChart chart = ChartFactory.createBarChart(
                            "",
                            "Produk",
                            "Penjualan",
                            dataset,
                            PlotOrientation.VERTICAL,
                            true,
                            true,
                            false
                    );
                    final ChartPanel chartPanel = new ChartPanel(chart);
                    chartPanel.setSize(491,330);
                    chartPanel.setPreferredSize(new Dimension(491, 330));
                    panelPenjualanProduk.removeAll();
                    panelPenjualanProduk.add(chartPanel);
                    chartPanel.setVisible(true);
                
    }
            
            
    
    public void tampilDataLaba(String fromDate, String toDate) {
        
        // laba
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        String sql = "SELECT tanggal_transaksi, total_laba from transaksi WHERE tanggal_transaksi BETWEEN '"+fromDate+"' AND '"+toDate+"' AND status = 'Selesai'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()) {
                String tanggal = rs.getString("tanggal_transaksi");
                int laba = rs.getInt("total_laba");
                
                if(!data.containsKey(tanggal)) {
                    data.put(tanggal, laba);
                } else {
                    data.put(tanggal, data.get(tanggal) + laba);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                conn.close();
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(LaporanPenjualanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            String series = "Laba/Waktu";
            
            for (String tanggal : data.keySet()) {
                 dataset.addValue(data.get(tanggal), series, tanggal);
            }
            
//            JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn,sql);
            JFreeChart chart = ChartFactory.createLineChart(null, "Tanggal", "Laba", dataset, 
                 PlotOrientation.VERTICAL, false, true, true);
            final ChartPanel chartPanel = new ChartPanel(chart);
            BarRenderer barRenderer = null;
            CategoryPlot plot = null;
            barRenderer = new BarRenderer();
            chartPanel.setSize(491,330);
            chartPanel.setPreferredSize(new Dimension(491, 330));
            panelLaba.removeAll();
            panelLaba.revalidate();
            panelLaba.add(chartPanel);
            chartPanel.setVisible(true);
        }
        
                       
            
    
    
    
}
