package ba.unsa.etf.rpr;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class GradoviReport extends JFrame {

    public void showReport(Connection conn) throws JRException {
        String reportSrcFile = getClass().getResource("C:\\Users\\User\\Desktop\\rpr-t10\\gradovi.jrxml").getFile();
        String reportsDir = getClass().getResource("C:\\Users\\User\\Desktop\\rpr-t10").getFile();

        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("reportsDirPath", reportsDir);
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        list.add(parameters);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
    }

    public void saveAs(String ekstenzija){

    }
}
