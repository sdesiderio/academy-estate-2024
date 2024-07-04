package com.sistemi.informativi.main;

import com.sistemi.informativi.dao.FacadeDAO;
import com.sistemi.informativi.dao.FacadeDAOImpl;
import com.sistemi.informativi.dto.CustomerDTO;
import com.sistemi.informativi.dto.CustomerProductDTO;
import com.sistemi.informativi.dto.ProductDTO;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        FacadeDAO facadeDAO = new FacadeDAOImpl();

        Connection con = facadeDAO.getConnection();

        // 2 INSERIMENTI NELLA TABELLA customer
       int customerId1 =  facadeDAO.addCustomer(new CustomerDTO("Gioele","gioelemarini@gmail.com"));
       int customerId2 =  facadeDAO.addCustomer(new CustomerDTO("Teresa","teresaproto@libero.it"));

       // 2 INSERIMENTI NELLA TABELLA product
        int productId1 = facadeDAO.addProduct(new ProductDTO("Smartphone",200.76f));
        int productId2 = facadeDAO.addProduct(new ProductDTO("TV",367.89f));

        /*
        CREAZIONE ASSOCIAZIONI NELLA JOIN TABLE (customer_product)
        customerId1, productId1
        customerId1, productId2
        customerId2, productId1
        customerId2, productId2
         */
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerId1,productId1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerId1,productId2));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerId2,productId1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(customerId2,productId2));

        // TEST QUERY DI JOIN
        facadeDAO.getCustomersNameByProduct(productId1).
                forEach(customer->System.out.println(customer.getName()));

        facadeDAO.closeConnection();

    }
}