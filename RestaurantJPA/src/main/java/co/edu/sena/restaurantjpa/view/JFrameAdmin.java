/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.restaurantjpa.view;

import co.edu.sena.restaurantjpa.controllers.IRolesController;
import co.edu.sena.restaurantjpa.controllers.IUsersController;
import co.edu.sena.restaurantjpa.controllers.RolesController;
import co.edu.sena.restaurantjpa.controllers.UsersController;
import co.edu.sena.restaurantjpa.model.Users;
import co.edu.sena.restaurantjpa.util.MessageUtils;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

/**
 * JFrameAdmin: Ventana principal para la administración del restaurante.
 * Contiene paneles para gestionar empleados, menú, mesas, caja y reportes.
 * 
 * @author Sebas
 */
public class JFrameAdmin extends javax.swing.JFrame {
    private IUsersController usersController = new UsersController();
    private IRolesController rolesController = new RolesController();

    private JMenuItem menuEmployees;
    private JMenuItem menuTables;
    private JMenuItem menuMenu;
    private JMenuItem menuBox;
    private JMenuItem menuReports;
    private JMenuItem menuExit;

    private String employeeIcon = "/employee.png";
    private String tableIcon    = "/table.png";
    private String menuIcon     = "/cook.png";
    private String boxIcon      = "/automaticBox.png";
    private String reportIcon   = "/reports.png";
    private String exit         = "/logout_menu.png";

    public JFrameAdmin() {
        initComponents();
        fillCombos();
        fillTableUser();

        menuEmployees = new JMenuItem("Empleados", getIcon(employeeIcon));
        menuTables = new JMenuItem("Mesas", getIcon(tableIcon));
        menuMenu = new JMenuItem("Menu", getIcon(menuIcon));
        menuBox = new JMenuItem("Caja", getIcon(boxIcon));
        menuReports = new JMenuItem("Reportes", getIcon(reportIcon));
        menuExit = new JMenuItem("Cerrar Sesion", getIcon(exit));

        JMenuBarMain.add(menuEmployees);
        JMenuBarMain.add(menuTables);
        JMenuBarMain.add(menuMenu);
        JMenuBarMain.add(menuBox);
        JMenuBarMain.add(menuReports);
        JMenuBarMain.add(menuExit);

        menuEmployees.addActionListener(e -> showPanel(jPanelEmployees));
        menuTables.addActionListener(e -> showPanel(jPanelTables));
        menuMenu.addActionListener(e -> showPanel(jPanelRestaurantMenu));
        menuBox.addActionListener(e -> showPanel(jPanelBox));
        menuReports.addActionListener(e -> showPanel(jPanelReports));
        menuExit.addActionListener(e -> exitToLogin());

    }
    
    public void fillCombos()
    {
        try {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Seleccione una opción...");
            model.addElement("ACTIVO");
            model.addElement("INACTIVO");
            jComboBoxStatusUser.setModel(model);
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }

    private Icon getIcon(String ruta) {
        return new ImageIcon(
            new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)
        );
    }

    private void showPanel(javax.swing.JPanel panel) {
        jPanelEmployees.setVisible(false);
        jPanelRestaurantMenu.setVisible(false);
        jPanelTables.setVisible(false);
        jPanelBox.setVisible(false);
        jPanelReports.setVisible(false);

        panel.setVisible(true);
    }

    private void exitToLogin() {
        JFrameLogin login = new JFrameLogin();
        this.dispose();
        login.setVisible(true);
    }

    private void cleanUserFields() {
        jTextFieldIdUser.setText("");
        jTextFieldFullnameUser.setText("");
        jTextFieldLastnameEmail.setText("");
        jTextFieldRoleUser.setText("");
        jComboBoxStatusUser.setSelectedIndex(0);
        jTableUser.clearSelection();
    }

    public void fillTableUser(){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jTableUser.setModel(model);
            model.addColumn("Id");
            model.addColumn("Nombre");
            model.addColumn("Correo");
            model.addColumn("Estado");
            model.addColumn("Rol");

            String [] rows = new String[5];
            List<Users> users = usersController.findAll();
            for (Users u: users) {
                rows[0] = String.valueOf(u.getId());
                rows[1] = u.getFullName();
                rows[2] = u.getEmail();
                rows[3] = u.getStatus();
                rows[4] = u.getRoleId().getName();
                
                model.addRow(rows);
            }
        }
        catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDesktop = new javax.swing.JPanel();
        jPanelEmployees = new javax.swing.JPanel();
        jLabelTitleUser = new javax.swing.JLabel();
        jLabelFullnameUser = new javax.swing.JLabel();
        jTextFieldFullnameUser = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldLastnameEmail = new javax.swing.JTextField();
        jLabelIdUser = new javax.swing.JLabel();
        jTextFieldIdUser = new javax.swing.JTextField();
        jLabelStatusUser = new javax.swing.JLabel();
        jLabelRoleUser = new javax.swing.JLabel();
        jTextFieldRoleUser = new javax.swing.JTextField();
        jScrollPaneUsers = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jButtonAddUser = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonCleanUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jComboBoxStatusUser = new javax.swing.JComboBox<>();
        jPanelRestaurantMenu = new javax.swing.JPanel();
        jPanelBox = new javax.swing.JPanel();
        jPanelTables = new javax.swing.JPanel();
        jPanelReports = new javax.swing.JPanel();
        JMenuBarMain = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN");

        jPanelDesktop.setBackground(new java.awt.Color(51, 153, 0));

        jPanelEmployees.setBackground(new java.awt.Color(204, 255, 255));
        jPanelEmployees.setPreferredSize(new java.awt.Dimension(795, 560));

        jLabelTitleUser.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitleUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleUser.setText("ADMINISTRADOR DE USUARIOS");

        jLabelFullnameUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelFullnameUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFullnameUser.setText("Nombre completo:");

        jTextFieldFullnameUser.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldFullnameUser.setForeground(new java.awt.Color(0, 0, 0));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmail.setText("Correo:");

        jTextFieldLastnameEmail.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldLastnameEmail.setForeground(new java.awt.Color(0, 0, 0));

        jLabelIdUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelIdUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdUser.setText("ID:");

        jTextFieldIdUser.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIdUser.setForeground(new java.awt.Color(0, 0, 0));

        jLabelStatusUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelStatusUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStatusUser.setText("Estado:");

        jLabelRoleUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelRoleUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRoleUser.setText("Rol:");

        jTextFieldRoleUser.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldRoleUser.setForeground(new java.awt.Color(0, 0, 0));

        jTableUser.setBackground(new java.awt.Color(255, 255, 255));
        jTableUser.setForeground(new java.awt.Color(0, 0, 0));
        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPaneUsers.setViewportView(jTableUser);

        jButtonAddUser.setBackground(new java.awt.Color(102, 255, 102));
        jButtonAddUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAddUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addBlack.png"))); // NOI18N
        jButtonAddUser.setText("Crear");

        jButtonUpdateUser.setBackground(new java.awt.Color(51, 102, 255));
        jButtonUpdateUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpdateUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUpdateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editBlack.png"))); // NOI18N
        jButtonUpdateUser.setText("Actualizar");

        jButtonCleanUser.setBackground(new java.awt.Color(255, 255, 102));
        jButtonCleanUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCleanUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCleanUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleanBlack.png"))); // NOI18N
        jButtonCleanUser.setText("Limpiar");
        jButtonCleanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setBackground(new java.awt.Color(255, 51, 51));
        jButtonDeleteUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDeleteUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDeleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteBlack.png"))); // NOI18N
        jButtonDeleteUser.setText("Eliminar");

        jComboBoxStatusUser.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxStatusUser.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxStatusUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "ACTIVO", "INACTIVO" }));
        jComboBoxStatusUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelEmployeesLayout = new javax.swing.GroupLayout(jPanelEmployees);
        jPanelEmployees.setLayout(jPanelEmployeesLayout);
        jPanelEmployeesLayout.setHorizontalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addComponent(jScrollPaneUsers)
                        .addContainerGap())
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelIdUser)
                            .addComponent(jLabelStatusUser)
                            .addComponent(jLabelRoleUser))
                        .addGap(105, 105, 105)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldLastnameEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIdUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldRoleUser)
                            .addComponent(jComboBoxStatusUser, javax.swing.GroupLayout.Alignment.LEADING, 0, 220, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabelTitleUser))
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFullnameUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFullnameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                                .addComponent(jButtonCleanUser)
                                .addGap(95, 95, 95)
                                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAddUser)
                                    .addComponent(jButtonDeleteUser)))
                            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                                .addComponent(jButtonUpdateUser)
                                .addGap(190, 190, 190)))))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        jPanelEmployeesLayout.setVerticalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitleUser)
                .addGap(29, 29, 29)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdUser)
                    .addComponent(jTextFieldIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFullnameUser)
                            .addComponent(jTextFieldFullnameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(jTextFieldLastnameEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStatusUser)
                            .addComponent(jComboBoxStatusUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRoleUser)
                            .addComponent(jTextFieldRoleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddUser)
                            .addComponent(jButtonUpdateUser))
                        .addGap(125, 125, 125)
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCleanUser)
                            .addComponent(jButtonDeleteUser))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanelRestaurantMenu.setBackground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout jPanelRestaurantMenuLayout = new javax.swing.GroupLayout(jPanelRestaurantMenu);
        jPanelRestaurantMenu.setLayout(jPanelRestaurantMenuLayout);
        jPanelRestaurantMenuLayout.setHorizontalGroup(
            jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        jPanelRestaurantMenuLayout.setVerticalGroup(
            jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanelBox.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout jPanelBoxLayout = new javax.swing.GroupLayout(jPanelBox);
        jPanelBox.setLayout(jPanelBoxLayout);
        jPanelBoxLayout.setHorizontalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        jPanelBoxLayout.setVerticalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanelTables.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanelReports.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanelReportsLayout = new javax.swing.GroupLayout(jPanelReports);
        jPanelReports.setLayout(jPanelReportsLayout);
        jPanelReportsLayout.setHorizontalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        jPanelReportsLayout.setVerticalGroup(
            jPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelDesktopLayout = new javax.swing.GroupLayout(jPanelDesktop);
        jPanelDesktop.setLayout(jPanelDesktopLayout);
        jPanelDesktopLayout.setHorizontalGroup(
            jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDesktopLayout.createSequentialGroup()
                .addComponent(jPanelEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDesktopLayout.createSequentialGroup()
                    .addComponent(jPanelRestaurantMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDesktopLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDesktopLayout.createSequentialGroup()
                    .addComponent(jPanelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDesktopLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanelDesktopLayout.setVerticalGroup(
            jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDesktopLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelRestaurantMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JMenuBarMain.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMenuBarMain.setPreferredSize(new java.awt.Dimension(0, 55));
        setJMenuBar(JMenuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCleanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanUserActionPerformed
        cleanUserFields();
    }//GEN-LAST:event_jButtonCleanUserActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JFrameAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuBarMain;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonCleanUser;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxStatusUser;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFullnameUser;
    private javax.swing.JLabel jLabelIdUser;
    private javax.swing.JLabel jLabelRoleUser;
    private javax.swing.JLabel jLabelStatusUser;
    private javax.swing.JLabel jLabelTitleUser;
    private javax.swing.JPanel jPanelBox;
    private javax.swing.JPanel jPanelDesktop;
    private javax.swing.JPanel jPanelEmployees;
    private javax.swing.JPanel jPanelReports;
    private javax.swing.JPanel jPanelRestaurantMenu;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JScrollPane jScrollPaneUsers;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextFieldFullnameUser;
    private javax.swing.JTextField jTextFieldIdUser;
    private javax.swing.JTextField jTextFieldLastnameEmail;
    private javax.swing.JTextField jTextFieldRoleUser;
    // End of variables declaration//GEN-END:variables
}
