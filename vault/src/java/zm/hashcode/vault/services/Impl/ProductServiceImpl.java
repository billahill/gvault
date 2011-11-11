/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.vault.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import zm.hashcode.vault.model.product.product;
import zm.hashcode.vault.repository.jpa.product.ProductDAO;
import zm.hashcode.vault.services.product.ProductService;
import org.springframework.stereotype.Service;
/**
 *
 * @author Kraakbeen
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;
   // @Autowired
    //private ProductService productService;

    @Override
    public product find(Long id) {
        if(id!= null){
        return productDAO.find(id);
        }
        return null;
    }

    @Transactional(readOnly= false)
    @Override
    public void persist(product entity) {
        productDAO.persist(entity);
    }

    @Override
    public void merge(product entity) {
        productDAO.merge(entity);
    }

    @Override
    public void remove(product entity) {

        productDAO.remove(entity);
    }

    @Override
    public List<product> findAll() {
         return  productDAO.findAll();
    }

    @Override
    public List<product> findInRange(int firstResult, int maxResults) {
         return productDAO.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
         return  productDAO.count();
    }

    @Override
    public product getByPropertyName(String propertyName, String propertyValue) {
                return productDAO.getByPropertyName(propertyName, propertyValue);
    }

  

    @Override
    public List<product> getEntitiesByProperName(String propertyName, String propertyValue) {
        return productDAO.getEntitiesByProperName(propertyName, propertyValue);
    }

    /**
     * @return the accountDAO
     */
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    /**
     * @param accountDAO the accountDAO to set
     */
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /*@Override
    public product getProductInfo(String description) {
        product pro = new product();
        pro = (product) productService.getByPropertyName("description", description);
        return pro;
    }*/
}
