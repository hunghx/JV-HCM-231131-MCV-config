package ra.mvcconfig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.mvcconfig.model.Product;
import ra.mvcconfig.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao {
    @Autowired
    private ConnectDB connectDB;
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        // mở 1 kết nối
        Connection conn = connectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from product where is_deleted = false");
            // thực thi sql
            ResultSet rs = callSt.executeQuery(); // thực trhi câu lệnh select
            while (rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("stock"),
                        rs.getDate("created_at"),
                        rs.getBoolean("is_deleted")
                ) ;
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(conn);
        }

    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> products = new ArrayList<>();
        // mở 1 kết nối
        Connection conn = connectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from product where is_deleted = false and name like ?");
            // truyền tham số
            callSt.setString(1,"%"+keyword+"%");
            // thực thi sql
            ResultSet rs = callSt.executeQuery(); // thực trhi câu lệnh select
            while (rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("stock"),
                        rs.getDate("created_at"),
                        rs.getBoolean("is_deleted")
                ) ;
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(conn);
        }
    }

    @Override
    public Product findById(Integer id) {
        Product product = null;
        // mở 1 kết nối
        Connection conn = connectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from product  where is_deleted = false and id =?");
            callSt.setInt(1, id);
            // thực thi sql
            ResultSet rs = callSt.executeQuery(); // thực trhi câu lệnh select
            if (rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getInt("stock"),
                        rs.getDate("created_at"),
                        rs.getBoolean("is_deleted")
                ) ;
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(conn);
        }
    }

    @Override
    public void save(Product product) {
        // mở 1 kết nối
        Connection conn = connectDB.getConnection();
        CallableStatement callSt = null;
        try {
            if (product.getId()==null){
                callSt = conn.prepareCall("insert into product(name, price, description, image, stock,created_at,is_deleted) value (?,?,?,?,?,?,?)");
                callSt.setString(1,product.getName());
                callSt.setDouble(2,product.getPrice());
                callSt.setString(3,product.getDescription());
                callSt.setString(4,product.getImage());
                callSt.setInt(5,product.getStock());
                callSt.setDate(6, new Date(product.getCreatedAt().getTime()));
                callSt.setBoolean(7,product.getIsDeleted());
            }else {
                callSt = conn.prepareCall("update  product set name =?, price=?, description=?, image=?, stock=? where id = ?");
                callSt.setString(1,product.getName());
                callSt.setDouble(2,product.getPrice());
                callSt.setString(3,product.getDescription());
                callSt.setString(4,product.getImage());
                callSt.setInt(5,product.getStock());
                callSt.setInt(6,product.getId());
            }
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = connectDB.getConnection();

        try {
            CallableStatement callSt = conn.prepareCall("update product set is_deleted = true where id = ?");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectDB.closeConnection(conn);
        }
    }
}
