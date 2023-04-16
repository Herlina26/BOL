package com.mycompany.bad1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PerpustakaanDavid extends JFrame implements ActionListener {
    JLabel lblName, lblNIK, lblDOB, lblAddress;
    JTextField txtName, txtNIK, txtDOB, txtAddress;
    JButton btnAdd, btnUpdate, btnDelete, btnFirst, btnPrev, btnNext, btnLast, btnList, btnExit;
    JTable tblPatients;
    DefaultTableModel model;

    public PerpustakaanDavid() {
        setTitle("Klinik CRUD");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create labels
        lblName = new JLabel("Nama Pasien:");
        lblNIK = new JLabel("NIK:");
        lblDOB = new JLabel("Tanggal Lahir (YYYY-MM-DD):");
        lblAddress = new JLabel("Alamat:");

        // create text fields
        txtName = new JTextField(20);
        txtNIK = new JTextField(15);
        txtDOB = new JTextField(10);
        txtAddress = new JTextField(50);

        // create buttons
        btnAdd = new JButton("Tambah");
        btnUpdate = new JButton("Ubah");
        btnDelete = new JButton("Hapus");
        btnFirst = new JButton("<<");
        btnPrev = new JButton("<");
        btnNext = new JButton(">");
        btnLast = new JButton(">>");
        btnList = new JButton("Daftar Pasien");
        btnExit = new JButton("Keluar");

        // add action listeners to buttons
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnFirst.addActionListener(this);
        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnLast.addActionListener(this);
        btnList.addActionListener(this);
        btnExit.addActionListener(this);

        // create table
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama Pasien");
        model.addColumn("NIK");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Alamat");
        tblPatients = new JTable(model);

        // add components to form
        JPanel pnlForm = new JPanel(new GridLayout(4, 2));
        pnlForm.add(lblName);
        pnlForm.add(txtName);
        pnlForm.add(lblNIK);
        pnlForm.add(txtNIK);
        pnlForm.add(lblDOB);
        pnlForm.add(txtDOB);
        pnlForm.add(lblAddress);
        pnlForm.add(txtAddress);

        JPanel pnlButtons = new JPanel(new GridLayout(1, 8));
        pnlButtons.add(btnAdd);
        pnlButtons.add(btnUpdate);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnFirst);
        pnlButtons.add(btnPrev);
        pnlButtons.add(btnNext);
        pnlButtons.add(btnLast);
        pnlButtons.add(btnList);

        JPanel pnlTable = new JPanel(new BorderLayout());
        pnlTable.add(new JScrollPane(tblPatients), BorderLayout.CENTER);

        JPanel pnlExit = new JPanel(new FlowLayout());
        pnlExit.add(btnExit);

        add(pnlForm, BorderLayout.NORTH);
        add(pnlButtons, BorderLayout.CENTER);
        add(pnlTable, BorderLayout.SOUTH);
        add(pnlExit, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            // add new patient to table
            String name = txtName.getText();
            String nik = txtNIK.getText();
            String dob = txtDOB.getText();
            String address = txtAddress.getText();
            if (!nikExists(nik)) {
                model.addRow(new Object[]{model.getRowCount() + 1, name, nik, dob, address});
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "NIK sudah digunakan.");
            }
        } else if (e.getSource() == btnUpdate) {
            // update selected patient in table
            int row = tblPatients.getSelectedRow();
            if (row >= 0) {
                String name = txtName.getText();
                String nik = txtNIK.getText();
                String dob = txtDOB.getText();
                String address = txtAddress.getText();
                if (!nikExists(nik) || nik.equals((String) model.getValueAt(row, 2))) {
                    model.setValueAt(name, row, 1);
                    model.setValueAt(nik, row, 2);
                    model.setValueAt(dob, row, 3);
                    model.setValueAt(address, row, 4);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "NIK sudah digunakan.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih pasien yang akan diubah.");
            }
        } else if (e.getSource() == btnDelete) {
            // delete selected patient from table
            int row = tblPatients.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih pasien yang akan dihapus.");
            }
        } else if (e.getSource() == btnFirst) {
            // move to first patient in table
            tblPatients.setRowSelectionInterval(0, 0);
            loadFields();
        } else if (e.getSource() == btnPrev) {
            // move to previous patient in table
            int row = tblPatients.getSelectedRow();
            if (row > 0) {
                tblPatients.setRowSelectionInterval(row - 1, row - 1);
                loadFields();
            }
        } else if (e.getSource() == btnNext) {
            // move to next patient in table
            int row = tblPatients.getSelectedRow();
            if (row < tblPatients.getRowCount() - 1) {
                tblPatients.setRowSelectionInterval(row + 1, row + 1);
                loadFields();
            }
        } else if (e.getSource() == btnLast) {
            // move to last patient in table
            tblPatients.setRowSelectionInterval(tblPatients.getRowCount() - 1, tblPatients.getRowCount() - 1);
            loadFields();
        } else if (e.getSource() == btnList) {
            // show list of patients in new window
            JFrame listFrame = new JFrame("Daftar Pasien");
            listFrame.setSize(600, 400);
            listFrame.setLocationRelativeTo(null);
            listFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JTable listTable = new JTable(model);
            listFrame.add(new JScrollPane(listTable));
            listFrame.setVisible(true);
        } else if (e.getSource() == btnExit) {
            // exit program
            System.exit(0);
        }
    }

    private boolean nikExists(String nik) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (nik.equals((String) model.getValueAt(i, 2))) {
                return true;
            }
        }
        return false;
    }

    private void clearFields() {
        txtName.setText("");
        txtNIK.setText("");
        txtDOB.setText("");
        txtAddress.setText("");
    }

    private void loadFields() {
        int row = tblPatients.getSelectedRow();
        if (row >= 0) {
            txtName.setText((String) model.getValueAt(row, 1));
            txtNIK.setText((String) model.getValueAt(row, 2));
            txtDOB.setText((String) model.getValueAt(row, 3));
            txtAddress.setText((String) model.getValueAt(row, 4));
        }
    }

    public static void main(String[] args) {
        PerpustakaanDavid form = new PerpustakaanDavid();
        form.setVisible(true);
    }
}
       