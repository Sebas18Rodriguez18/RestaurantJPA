/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.restaurantjpa.view;

import co.edu.sena.restaurantjpa.controllers.IRolesController;
import co.edu.sena.restaurantjpa.controllers.IUsersController;
import co.edu.sena.restaurantjpa.controllers.RolesController;
import co.edu.sena.restaurantjpa.controllers.UsersController;
import co.edu.sena.restaurantjpa.model.Roles;
import co.edu.sena.restaurantjpa.model.Users;
import co.edu.sena.restaurantjpa.util.MessageUtils;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
            
            DefaultComboBoxModel<Roles> roleModel = new DefaultComboBoxModel<>();
            for (Roles r : rolesController.findAll()) {
                roleModel.addElement(r);
            }
            jComboBoxRoleUser.setModel(roleModel);
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
        jTextFieldEmailUsers.setText("");
        jComboBoxStatusUser.setSelectedIndex(0);
        jComboBoxRoleUser.setSelectedIndex(0);
        jTableUser.clearSelection();
        
        jButtonAddUser.setEnabled(true);
        jButtonUpdateUser.setEnabled(false);
        jButtonDeleteUser.setEnabled(false);
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
        jTextFieldEmailUsers = new javax.swing.JTextField();
        jLabelIdUser = new javax.swing.JLabel();
        jTextFieldIdUser = new javax.swing.JTextField();
        jLabelStatusUser = new javax.swing.JLabel();
        jLabelRoleUser = new javax.swing.JLabel();
        jScrollPaneUsers = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jButtonAddUser = new javax.swing.JButton();
        jButtonUpdateUser = new javax.swing.JButton();
        jButtonCleanUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jComboBoxStatusUser = new javax.swing.JComboBox<>();
        jComboBoxRoleUser = new javax.swing.JComboBox<>();
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
        jTextFieldFullnameUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEmail.setText("Correo:");

        jTextFieldEmailUsers.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEmailUsers.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldEmailUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelIdUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelIdUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdUser.setText("ID:");

        jTextFieldIdUser.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIdUser.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldIdUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelStatusUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelStatusUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStatusUser.setText("Estado:");

        jLabelRoleUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelRoleUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRoleUser.setText("Rol:");

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
        jTableUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPaneUsers.setViewportView(jTableUser);

        jButtonAddUser.setBackground(new java.awt.Color(102, 255, 102));
        jButtonAddUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAddUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addBlack.png"))); // NOI18N
        jButtonAddUser.setText("Crear");
        jButtonAddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUserActionPerformed(evt);
            }
        });

        jButtonUpdateUser.setBackground(new java.awt.Color(51, 102, 255));
        jButtonUpdateUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpdateUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUpdateUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editBlack.png"))); // NOI18N
        jButtonUpdateUser.setText("Actualizar");
        jButtonUpdateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonCleanUser.setBackground(new java.awt.Color(255, 255, 102));
        jButtonCleanUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCleanUser.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCleanUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleanBlack.png"))); // NOI18N
        jButtonCleanUser.setText("Limpiar");
        jButtonCleanUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButtonDeleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBoxStatusUser.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxStatusUser.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxStatusUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "ACTIVO", "INACTIVO" }));
        jComboBoxStatusUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboBoxRoleUser.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxRoleUser.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxRoleUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelEmployeesLayout = new javax.swing.GroupLayout(jPanelEmployees);
        jPanelEmployees.setLayout(jPanelEmployeesLayout);
        jPanelEmployeesLayout.setHorizontalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jTextFieldIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabelTitleUser)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneUsers)
                            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdUser)
                                    .addComponent(jLabelStatusUser)
                                    .addComponent(jLabelRoleUser)
                                    .addComponent(jLabelEmail))
                                .addGap(406, 406, 406)
                                .addComponent(jButtonCleanUser)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmployeesLayout.createSequentialGroup()
                        .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonDeleteUser))
                            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                                .addComponent(jLabelFullnameUser)
                                .addGap(29, 29, 29)
                                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxRoleUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxStatusUser, 0, 226, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmailUsers)
                                    .addComponent(jTextFieldFullnameUser))
                                .addGap(52, 52, 52)
                                .addComponent(jButtonUpdateUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jButtonAddUser)))
                        .addGap(27, 27, 27))))
        );
        jPanelEmployeesLayout.setVerticalGroup(
            jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmployeesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitleUser)
                .addGap(18, 18, 18)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdUser)
                    .addComponent(jTextFieldIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFullnameUser)
                    .addComponent(jTextFieldFullnameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdateUser)
                    .addComponent(jButtonAddUser))
                .addGap(26, 26, 26)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatusUser)
                    .addComponent(jComboBoxStatusUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelRoleUser)
                        .addComponent(jComboBoxRoleUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCleanUser)
                        .addComponent(jButtonDeleteUser)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        int rowSelected = jTableUser.getSelectedRow();
        if (rowSelected != -1) {
            try {
                jTextFieldIdUser.setText(jTableUser.getValueAt(rowSelected, 0).toString());
                jTextFieldFullnameUser.setText(jTableUser.getValueAt(rowSelected, 1).toString());
                jTextFieldEmailUsers.setText(jTableUser.getValueAt(rowSelected, 2).toString());
                jComboBoxStatusUser.setSelectedItem(jTableUser.getValueAt(rowSelected, 3).toString());

                String rolNombre = jTableUser.getValueAt(rowSelected, 4).toString();
                for (int i = 0; i < jComboBoxRoleUser.getItemCount(); i++) {
                    Roles rol = (Roles) jComboBoxRoleUser.getItemAt(i);
                    if (rol.getName().equals(rolNombre)) {
                        jComboBoxRoleUser.setSelectedIndex(i);
                        break;
                    }
                }

                jButtonAddUser.setEnabled(false);
                jButtonUpdateUser.setEnabled(true);
                jButtonDeleteUser.setEnabled(true);
            } catch (Exception e) {
                MessageUtils.ShowErrorMessage("Error al seleccionar el usuario: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUserActionPerformed
        try {
            Users user = new Users();
            user.setId(Long.parseLong(jTextFieldIdUser.getText()));
            user.setFullName(jTextFieldFullnameUser.getText());
            user.setEmail(jTextFieldEmailUsers.getText());
            user.setStatus(jComboBoxStatusUser.getSelectedItem().toString());
            Roles role = (Roles) jComboBoxRoleUser.getSelectedItem();
            user.setRoleId(role);
            user.setPassword("123456"); // <-- Password Predefinida para los usuarios.

            usersController.insert(user);
            MessageUtils.ShowInfoMessage("Usuario creado exitosamente");
            fillTableUser();
            cleanUserFields();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al crear usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonAddUserActionPerformed

    private void jButtonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateUserActionPerformed
        try {
            if (jTextFieldIdUser.getText().isEmpty()) {
                MessageUtils.ShowErrorMessage("Selecciona un usuario para actualizar.");
                return;
            }
            Users user = usersController.findById(Long.parseLong(jTextFieldIdUser.getText()));
            if (user == null) {
                MessageUtils.ShowErrorMessage("El usuario no existe.");
                return;
            }
            user.setFullName(jTextFieldFullnameUser.getText());
            user.setEmail(jTextFieldEmailUsers.getText());
            user.setStatus(jComboBoxStatusUser.getSelectedItem().toString());
            Roles role = (Roles) jComboBoxRoleUser.getSelectedItem();
            user.setRoleId(role);

            usersController.update(user);
            MessageUtils.ShowInfoMessage("Usuario actualizado exitosamente");
            fillTableUser();
            cleanUserFields();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al actualizar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateUserActionPerformed

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        try {
            if (jTextFieldIdUser.getText().isEmpty()) {
                MessageUtils.ShowErrorMessage("Selecciona un usuario para eliminar.");
                return;
            }
            int option = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro de eliminar el usuario?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                long id = Long.parseLong(jTextFieldIdUser.getText());
                Users user = usersController.findById(id);
                if (user == null) {
                    MessageUtils.ShowErrorMessage("El usuario no existe.");
                    return;
                }
                usersController.delete(user);
                MessageUtils.ShowInfoMessage("Usuario eliminado exitosamente.");
                fillTableUser();
                cleanUserFields();
            }
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al eliminar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JFrameAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuBarMain;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonCleanUser;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<Roles> jComboBoxRoleUser;
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
    private javax.swing.JTextField jTextFieldEmailUsers;
    private javax.swing.JTextField jTextFieldFullnameUser;
    private javax.swing.JTextField jTextFieldIdUser;
    // End of variables declaration//GEN-END:variables
}