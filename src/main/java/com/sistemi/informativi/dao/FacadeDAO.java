package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.CustomerDTO;
import com.sistemi.informativi.dto.CustomerProductDTO;
import com.sistemi.informativi.dto.ProductDTO;
import com.sistemi.informativi.vo.CustomerVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FacadeDAO {

    public Connection getConnection() throws ClassNotFoundException,SQLException;

    public int addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException,SQLException;

    public ArrayList<CustomerVO> getCustomersNameByProduct(int productId) throws ClassNotFoundException,SQLException;

    public int addProduct(ProductDTO productDTO) throws ClassNotFoundException,SQLException;

    public void addCustomerProduct(CustomerProductDTO customerProductDTO) throws ClassNotFoundException,SQLException;

    public void closeConnection() throws ClassNotFoundException,SQLException;
}
