/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.restaurantjpa.view;

import co.edu.sena.restaurantjpa.controllers.DishCategoryController;
import co.edu.sena.restaurantjpa.controllers.DishController;
import co.edu.sena.restaurantjpa.controllers.IRolesController;
import co.edu.sena.restaurantjpa.controllers.IUsersController;
import co.edu.sena.restaurantjpa.controllers.RolesController;
import co.edu.sena.restaurantjpa.controllers.UsersController;
import co.edu.sena.restaurantjpa.model.Dish;
import co.edu.sena.restaurantjpa.model.DishCategory;
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
    private DishCategoryController dishCategoryController = new DishCategoryController();

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
        fillTableDish();

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

            DefaultComboBoxModel<String> roleModel = new DefaultComboBoxModel<>();
            for (Roles r : rolesController.findAll()) {
                roleModel.addElement(r.getName());
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
    private void cleanDishFields() {
        jTextFieldIdDish.setText("");
        jTextFieldNameDish.setText("");
        jTextFieldCategoryDish.setText("");
        jTextFieldPriceDish.setText("");
        jTextFieldDescriptionDish.setText("");
        jTableUser.clearSelection();
        
        jButtonAddDish.setEnabled(true);
        jButtonUpdateDish.setEnabled(false);
        jButtonDeleteDish.setEnabled(false);
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
    public void fillTableDish(){
    try {
        DefaultTableModel model = new DefaultTableModel();
        jTableDish.setModel(model);
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio");
        model.addColumn("Categoría");

        String [] rows = new String[5];
        DishController dishController = new DishController();
        List<Dish> dishList = dishController.findAll();
        for (Dish d: dishList) {
            rows[0] = String.valueOf(d.getId());
            rows[1] = d.getName();
            rows[2] = d.getDescription();
            rows[3] = String.valueOf(d.getPrice());
            rows[4] = d.getCategoryId().getName();
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
        jLabelTitleDish = new javax.swing.JLabel();
        jButtonUpdateDish = new javax.swing.JButton();
        jButtonAddDish = new javax.swing.JButton();
        jButtonDeleteDish = new javax.swing.JButton();
        jButtonCleanDish = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDish = new javax.swing.JTable();
        jLabelIdDish = new javax.swing.JLabel();
        jTextFieldIdDish = new javax.swing.JTextField();
        jTextFieldNameDish = new javax.swing.JTextField();
        jLabelNameDish = new javax.swing.JLabel();
        jLabelPriceDish = new javax.swing.JLabel();
        jTextFieldDescriptionDish = new javax.swing.JTextField();
        jLabelDescriptionDish = new javax.swing.JLabel();
        jTextFieldPriceDish = new javax.swing.JTextField();
        jLabelCategoryDish = new javax.swing.JLabel();
        jTextFieldCategoryDish = new javax.swing.JTextField();
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
        jLabelTitleUser.setText("GESTOR DE USUARIOS");

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
        jButtonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateUserActionPerformed(evt);
            }
        });

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
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

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
                .addGap(197, 197, 197)
                .addComponent(jTextFieldIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmployeesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitleUser)
                .addGap(262, 262, 262))
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

        jPanelRestaurantMenu.setBackground(new java.awt.Color(153, 204, 255));

        jLabelTitleDish.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitleDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitleDish.setText("GESTOR DE PLATOS");

        jButtonUpdateDish.setBackground(new java.awt.Color(51, 102, 255));
        jButtonUpdateDish.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonUpdateDish.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUpdateDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editBlack.png"))); // NOI18N
        jButtonUpdateDish.setText("Actualizar");
        jButtonUpdateDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUpdateDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateDishActionPerformed(evt);
            }
        });

        jButtonAddDish.setBackground(new java.awt.Color(102, 255, 102));
        jButtonAddDish.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAddDish.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAddDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addBlack.png"))); // NOI18N
        jButtonAddDish.setText("Crear");
        jButtonAddDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDishActionPerformed(evt);
            }
        });

        jButtonDeleteDish.setBackground(new java.awt.Color(255, 51, 51));
        jButtonDeleteDish.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonDeleteDish.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDeleteDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deleteBlack.png"))); // NOI18N
        jButtonDeleteDish.setText("Eliminar");
        jButtonDeleteDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDeleteDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteDishActionPerformed(evt);
            }
        });

        jButtonCleanDish.setBackground(new java.awt.Color(255, 255, 102));
        jButtonCleanDish.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCleanDish.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCleanDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cleanBlack.png"))); // NOI18N
        jButtonCleanDish.setText("Limpiar");
        jButtonCleanDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCleanDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanDishActionPerformed(evt);
            }
        });

        jTableDish.setBackground(new java.awt.Color(255, 255, 255));
        jTableDish.setForeground(new java.awt.Color(0, 0, 0));
        jTableDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableDish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDishMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDish);

        jLabelIdDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelIdDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIdDish.setText("ID:");

        jTextFieldIdDish.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldIdDish.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldIdDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTextFieldNameDish.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNameDish.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldNameDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelNameDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNameDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNameDish.setText("NOMBRE:");

        jLabelPriceDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPriceDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPriceDish.setText("PRECIO:");

        jTextFieldDescriptionDish.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDescriptionDish.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldDescriptionDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelDescriptionDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDescriptionDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDescriptionDish.setText("DESCRIPCION:");

        jTextFieldPriceDish.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPriceDish.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldPriceDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelCategoryDish.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCategoryDish.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCategoryDish.setText("CATEGORIA:");

        jTextFieldCategoryDish.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCategoryDish.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCategoryDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelRestaurantMenuLayout = new javax.swing.GroupLayout(jPanelRestaurantMenu);
        jPanelRestaurantMenu.setLayout(jPanelRestaurantMenuLayout);
        jPanelRestaurantMenuLayout.setHorizontalGroup(
            jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                        .addComponent(jButtonAddDish)
                        .addGap(94, 94, 94)
                        .addComponent(jButtonUpdateDish)
                        .addGap(147, 147, 147)
                        .addComponent(jButtonCleanDish)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeleteDish)
                        .addGap(27, 27, 27))
                    .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                        .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                                .addComponent(jLabelCategoryDish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCategoryDish, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdDish)
                                    .addComponent(jLabelPriceDish))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPriceDish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldIdDish, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                                .addComponent(jLabelNameDish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldNameDish, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                                .addComponent(jLabelDescriptionDish)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldDescriptionDish, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 56, Short.MAX_VALUE))))
            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRestaurantMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabelTitleDish)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRestaurantMenuLayout.setVerticalGroup(
            jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRestaurantMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitleDish)
                .addGap(61, 61, 61)
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdDish)
                    .addComponent(jTextFieldIdDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNameDish)
                    .addComponent(jTextFieldNameDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPriceDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPriceDish)
                    .addComponent(jLabelDescriptionDish)
                    .addComponent(jTextFieldDescriptionDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategoryDish)
                    .addComponent(jTextFieldCategoryDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanelRestaurantMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddDish)
                    .addComponent(jButtonUpdateDish)
                    .addComponent(jButtonCleanDish)
                    .addComponent(jButtonDeleteDish))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelBox.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanelBoxLayout = new javax.swing.GroupLayout(jPanelBox);
        jPanelBox.setLayout(jPanelBoxLayout);
        jPanelBoxLayout.setHorizontalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        jPanelBoxLayout.setVerticalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelTables.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanelTablesLayout = new javax.swing.GroupLayout(jPanelTables);
        jPanelTables.setLayout(jPanelTablesLayout);
        jPanelTablesLayout.setHorizontalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        jPanelTablesLayout.setVerticalGroup(
            jPanelTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelReports.setBackground(new java.awt.Color(255, 255, 204));

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
                    String nombreRolCombo = jComboBoxRoleUser.getItemAt(i);
                    if (nombreRolCombo.equals(rolNombre)) {
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
            String selectedRoleName = (String) jComboBoxRoleUser.getSelectedItem();
            Roles role = null;
            for (Roles r : rolesController.findAll()) {
                if (r.getName().equals(selectedRoleName)) {
                    role = r;
                    break;
                }
            }
            if (role == null) {
                MessageUtils.ShowErrorMessage("Selecciona un rol válido.");
                return;
            }
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
            String selectedRoleName = (String) jComboBoxRoleUser.getSelectedItem();
            Roles role = null;
            for (Roles r : rolesController.findAll()) {
                if (r.getName().equals(selectedRoleName)) {
                    role = r;
                    break;
                }
            }
            if (role == null) {
                MessageUtils.ShowErrorMessage("Selecciona un rol válido.");
                return;
            }
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

    private void jButtonUpdateDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateDishActionPerformed
        try {
            if (jTextFieldIdDish.getText().isEmpty()) {
                MessageUtils.ShowErrorMessage("Selecciona un plato para actualizar.");
                return;
            }
            DishController dishController = new DishController();
            Dish dish = dishController.findById(Long.parseLong(jTextFieldIdDish.getText()));
            if (dish == null) {
                MessageUtils.ShowErrorMessage("El plato no existe.");
                return;
            }
            dish.setName(jTextFieldNameDish.getText());
            dish.setDescription(jTextFieldDescriptionDish.getText());
            dish.setPrice(new java.math.BigDecimal(jTextFieldPriceDish.getText()));

            Long idCategory = Long.parseLong(jTextFieldCategoryDish.getText());
            DishCategoryController dishCategoryController = new DishCategoryController();
            DishCategory category = dishCategoryController.findById(idCategory);
            if (category == null) {
                MessageUtils.ShowErrorMessage("La categoría no existe.");
                return;
            }
            dish.setCategoryId(category);

            dishController.update(dish);
            MessageUtils.ShowInfoMessage("Plato actualizado exitosamente");
            fillTableDish();
            cleanDishFields();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al actualizar plato: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateDishActionPerformed

    private void jButtonDeleteDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteDishActionPerformed
        try {
            if (jTextFieldIdDish.getText().isEmpty()) {
                MessageUtils.ShowErrorMessage("Selecciona un plato para eliminar.");
                return;
            }
            int option = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro de eliminar el plato?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                DishController dishController = new DishController();
                Dish dish = dishController.findById(Long.parseLong(jTextFieldIdDish.getText()));
                if (dish == null) {
                    MessageUtils.ShowErrorMessage("El plato no existe.");
                    return;
                }
                dishController.delete(dish);
                MessageUtils.ShowInfoMessage("Plato eliminado exitosamente.");
                fillTableDish();
                cleanDishFields();
            }
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al eliminar plato: " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteDishActionPerformed

    private void jButtonCleanDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanDishActionPerformed
        cleanDishFields();
    }//GEN-LAST:event_jButtonCleanDishActionPerformed

    private void jTableDishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDishMouseClicked
        int rowSelected = jTableDish.getSelectedRow();
    if (rowSelected != -1) {
        try {
            jTextFieldIdDish.setText(jTableDish.getValueAt(rowSelected, 0).toString());
            jTextFieldNameDish.setText(jTableDish.getValueAt(rowSelected, 1).toString());
            jTextFieldDescriptionDish.setText(jTableDish.getValueAt(rowSelected, 2).toString());
            jTextFieldPriceDish.setText(jTableDish.getValueAt(rowSelected, 3).toString());
            jTextFieldCategoryDish.setText(jTableDish.getValueAt(rowSelected, 4).toString());

            jButtonAddDish.setEnabled(false);
            jButtonUpdateDish.setEnabled(true);
            jButtonDeleteDish.setEnabled(true);
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage("Error al seleccionar el plato: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jTableDishMouseClicked

    private void jButtonAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDishActionPerformed
        try {
        Dish dish = new Dish();
        dish.setId(Long.parseLong(jTextFieldIdDish.getText()));
        dish.setName(jTextFieldNameDish.getText());
        dish.setDescription(jTextFieldDescriptionDish.getText());
        dish.setPrice(new java.math.BigDecimal(jTextFieldPriceDish.getText()));

        // Obtener la categoría por ID
        Long idCategory = Long.parseLong(jTextFieldCategoryDish.getText());
        DishCategory category = new DishCategory();
        category.setId(idCategory);
        dish.setCategoryId(category);

        DishController dishController = new DishController();
        dishController.insert(dish);
        MessageUtils.ShowInfoMessage("Plato creado exitosamente");
        fillTableDish();
        cleanDishFields();
    } catch (Exception e) {
        MessageUtils.ShowErrorMessage("Error al crear plato: " + e.getMessage());
    }
    }//GEN-LAST:event_jButtonAddDishActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JFrameAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenuBarMain;
    private javax.swing.JButton jButtonAddDish;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonCleanDish;
    private javax.swing.JButton jButtonCleanUser;
    private javax.swing.JButton jButtonDeleteDish;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonUpdateDish;
    private javax.swing.JButton jButtonUpdateUser;
    private javax.swing.JComboBox<String> jComboBoxRoleUser;
    private javax.swing.JComboBox<String> jComboBoxStatusUser;
    private javax.swing.JLabel jLabelCategoryDish;
    private javax.swing.JLabel jLabelDescriptionDish;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFullnameUser;
    private javax.swing.JLabel jLabelIdDish;
    private javax.swing.JLabel jLabelIdUser;
    private javax.swing.JLabel jLabelNameDish;
    private javax.swing.JLabel jLabelPriceDish;
    private javax.swing.JLabel jLabelRoleUser;
    private javax.swing.JLabel jLabelStatusUser;
    private javax.swing.JLabel jLabelTitleDish;
    private javax.swing.JLabel jLabelTitleUser;
    private javax.swing.JPanel jPanelBox;
    private javax.swing.JPanel jPanelDesktop;
    private javax.swing.JPanel jPanelEmployees;
    private javax.swing.JPanel jPanelReports;
    private javax.swing.JPanel jPanelRestaurantMenu;
    private javax.swing.JPanel jPanelTables;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneUsers;
    private javax.swing.JTable jTableDish;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField jTextFieldCategoryDish;
    private javax.swing.JTextField jTextFieldDescriptionDish;
    private javax.swing.JTextField jTextFieldEmailUsers;
    private javax.swing.JTextField jTextFieldFullnameUser;
    private javax.swing.JTextField jTextFieldIdDish;
    private javax.swing.JTextField jTextFieldIdUser;
    private javax.swing.JTextField jTextFieldNameDish;
    private javax.swing.JTextField jTextFieldPriceDish;
    // End of variables declaration//GEN-END:variables
}