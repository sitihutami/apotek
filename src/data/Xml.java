/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Analisis.data;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author ai
 */
@SuppressWarnings("StaticNonFinalUsedInInitialization")
public class Xml {
    public static java.io.File f=new java.io.File(System.getProperty("user.home")+"/.analyzed/temp.xml");

    public static void addData(data data) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        javax.xml.parsers.DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document d;if(f.exists()){
            d=db.parse(f);
            edit(d,data);
        }else{
            f.createNewFile();
            d=db.newDocument();
            add(d,data);
        }save(d);
    }

    private static void save(Document d) throws TransformerConfigurationException, TransformerException {
        javax.xml.transform.Transformer t=javax.xml.transform.TransformerFactory.newInstance().newTransformer();
        javax.xml.transform.dom.DOMSource dom=new javax.xml.transform.dom.DOMSource(d);
        javax.xml.transform.stream.StreamResult s=new javax.xml.transform.stream.StreamResult(f);
        t.transform(dom, s);
    }

    public static void hindar(Exception z) {
        java.util.Date d=new java.util.Date();
        java.io.File berkas=new java.io.File(System.getProperty("user.home")+"/.formaya/"+d.toString()+".log");
        if(!berkas.getParentFile().exists())berkas.getParentFile().mkdirs();
        try {
            berkas.createNewFile();
            java.io.PrintWriter o=new java.io.PrintWriter(berkas);
            z.printStackTrace(o);
            o.close();
        } catch (IOException ex) {
            Xml.hindar(ex);
        }
    }

    private static void edit(Document d, data data) {
        org.w3c.dom.Element root=d.getDocumentElement(),sub=d.createElement("data");
        org.w3c.dom.NodeList n=d.getElementsByTagName("data");
        sub.setAttribute("kode", data.getKode_item());
        sub.setAttribute("nama", data.getNama_item());
        sub.setAttribute("nilai", ""+data.getNilai());
        sub.setAttribute("index", ""+n.getLength());
        root.appendChild(sub);
    }

    private static void add(Document d, data data) {
        org.w3c.dom.Element root=d.createElement("datas"),sub=d.createElement("data");
        d.appendChild(root);
        sub.setAttribute("kode", data.getKode_item());
        sub.setAttribute("nama", data.getNama_item());
        sub.setAttribute("nilai", ""+data.getNilai());
        sub.setAttribute("index", "0");
        root.appendChild(sub);
    }

    public static int getLength() throws ParserConfigurationException, SAXException, IOException {
        javax.xml.parsers.DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document d=db.parse(f);
        org.w3c.dom.NodeList n=d.getElementsByTagName("data");
        return n.getLength();
    }

    public static data getItem(int z) throws SAXException, IOException, ParserConfigurationException {
        javax.xml.parsers.DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document d=db.parse(f);
        d.getDocumentElement().normalize();
        org.w3c.dom.NodeList nl=d.getElementsByTagName("data");
        data data=new data();
        for(int x=0;x<nl.getLength();x++){
            org.w3c.dom.Node n=nl.item(x);
            if(n.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE){
                org.w3c.dom.Element e=(org.w3c.dom.Element) n;
                if(z==Integer.parseInt(e.getAttribute("index"))){
                    data.setKode_item(e.getAttribute("kode"));
                    data.setNama_item(e.getAttribute("nama"));
                    data.setNilai(Integer.parseInt(e.getAttribute("nilai")));
                }
            }
        }return data;
    }

    public static float c2(String a, String b) throws SQLException {
        Sql.Koneksi k=new Sql.Koneksi();
        k.konek();
        java.sql.ResultSet rs=k.stat.executeQuery("select count(no_nota)as ddd from penjualan where no_nota "
                + "in(select no_nota from penjualan_det where kode_item='"+a+"')"
                + "and no_nota in(select no_nota from penjualan_det where kode_item='"+b+"')");
        float f=0;
        if(rs.next())f=rs.getInt("ddd");
        rs.close();
        k.stat.close();
        k.con.close();
        return f;
    }

    public static int c22(String a, String b) {
        int i=0;
        Sql.Koneksi k=new Sql.Koneksi();
        k.konek();
        return i;
    }

    public static void init(int i) throws IOException, ParserConfigurationException, TransformerException {
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.analyzed/temp/"+i);
        if(!f.getParentFile().exists())f.getParentFile().mkdirs();
        Document d=javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        org.w3c.dom.Element e=d.createElement("etl");
        d.appendChild(e);
        save(d,i);
    }

    private static void save(Document d, int i) throws TransformerException {
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.analyzed/temp/"+i);
        javax.xml.transform.Transformer t=javax.xml.transform.TransformerFactory.newInstance().newTransformer();
        javax.xml.transform.dom.DOMSource dom=new javax.xml.transform.dom.DOMSource(d);
        javax.xml.transform.stream.StreamResult s=new javax.xml.transform.stream.StreamResult(f);
        t.transform(dom, s);
    }

    public static void addTrans(String a, String b, int i, float confe, float supe) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.analyzed/temp/"+i);
        Document d=javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
        org.w3c.dom.Element root=(org.w3c.dom.Element) d.getElementsByTagName("etl").item(0),e=d.createElement("trans");
        e.setAttribute("a", a);
        e.setAttribute("b", b);
        e.setAttribute("conf", ""+confe);
        e.setAttribute("sup", ""+supe);
        root.appendChild(e);
        save(d,i);
    }

    public static void hapusSemua() {
        java.io.File d=new java.io.File(System.getProperty("user.home")+"/.analyzed");
        for(java.io.File f:d.listFiles()){
            if(f.isDirectory())lanjut(f.getAbsolutePath());
            else f.delete();
        }
    }

    private static void lanjut(String p) {
        java.io.File d=new java.io.File(p);
        for(java.io.File f:d.listFiles()){
            if(f.isDirectory())lanjut(f.getAbsolutePath());
            else f.delete();
        }
    }

    public static void fillData(int x, JTable data) throws ParserConfigurationException, SAXException, IOException {
        java.io.File f=new java.io.File(System.getProperty("user.home")+"/.analyzed/temp/"+x);
        Document d=javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
        org.w3c.dom.NodeList nl=d.getElementsByTagName("trans");
        for(int i=0;i<nl.getLength();i++)if(nl.item(i).getNodeType()==org.w3c.dom.Node.ELEMENT_NODE){
            org.w3c.dom.Element e=(org.w3c.dom.Element) nl.item(i);
            if(oleh(data,e.getAttribute("a"),e.getAttribute("b"))){
                javax.swing.table.DefaultTableModel m=(javax.swing.table.DefaultTableModel) data.getModel();
                m.addRow(new String[]{e.getAttribute("a"),e.getAttribute("b"),e.getAttribute("sup"),e.getAttribute("conf")});
            }
        }
    }

    private static boolean oleh(JTable data, String a, String b) {
        boolean o=true;
        for(int x=0;x<data.getRowCount();x++){
            if(a.equals(data.getValueAt(x, 0))&&b.equals(data.getValueAt(x, 1))){
                o=false;
                break;
            }
        }return o;
    }
}