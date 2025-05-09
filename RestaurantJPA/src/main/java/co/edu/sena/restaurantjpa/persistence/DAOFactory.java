/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.persistence;

/**
 * fecha: 05/07/2025
 * @author Sebastian Rodriguez
 * descripcion: Instanciar los DAO's creados en la persistencia
 */
public class DAOFactory {
    private static IBoxDAO boxDAO = new BoxDAO();
    private static IDishDAO dishDAO = new DishDAO();
    private static IDishCategoryDAO categoryDAO = new DishCategoryDAO();
    private static IKitchenDAO kitchenDAO = new KitchenDAO();
    private static IOrderDAO orderDAO = new OrderDAO();
    private static IOrderDetailsDAO detailsDAO = new OrderDetailsDAO();
    private static IPayDAO payDAO = new PayDAO();
    private static IRolesDAO rolesDAO = new RolesDAO();
    private static IShiftDAO shiftDAO = new ShiftDAO();
    private static ITableDAO tableDAO = new TableDAO();
    private static IUsersDAO usersDAO = new UsersDAO();
    
    public static IBoxDAO getBoxDAO(){
        return boxDAO;
    }
    public static IDishDAO getDishDAO(){
        return dishDAO;
    }
    public static IDishCategoryDAO getCategoryDAO(){
        return categoryDAO;
    }
    public static IKitchenDAO getKitchenDAO(){
        return kitchenDAO;
    }
    public static IOrderDAO getOrderDAO(){
        return orderDAO;
    }
    public static IOrderDetailsDAO getDetailsDAO(){
        return detailsDAO;
    }
    public static IPayDAO getPayDAO(){
        return payDAO;
    }
    public static IRolesDAO getRolesDAO(){
        return rolesDAO;
    }
    public static IShiftDAO getShiftDAO(){
        return shiftDAO;
    }
    public static ITableDAO getTableDAO(){
        return tableDAO;
    }
    public static IUsersDAO getUsersDAO(){
        return usersDAO;
    }
}
